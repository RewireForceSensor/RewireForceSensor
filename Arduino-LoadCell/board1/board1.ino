#include <Chrono.h>
#include <SoftwareSerial.h>
#include "HX711.h"

#define BT1TX 3
#define BT1RX 4
#define BT2TX 5
#define BT2RX 6
#define LC1_DOUT_PIN  7
#define LC1_SCK_PIN  8
#define LC2_DOUT_PIN  A1
#define LC2_SCK_PIN  A0
#define LC3_DOUT_PIN  A3
#define LC3_SCK_PIN  A2
#define LC4_DOUT_PIN  A5
#define LC4_SCK_PIN  A4

Chrono timer;

HX711 scales[4];
int factors[4];

long offsets[4];
float xdist[4] = {-1.3, 1.3, -1.3, 1.3};
float ydist[4] = {2.85, 2.85, -2.85, -2.85};
float dist = 3.11;

float copx = 0;
float copy = 0;
float valsum = 0;

SoftwareSerial BT1Serial(BT1TX, BT1RX);
SoftwareSerial BT2Serial(BT2TX, BT2RX);

char c = '\n';
String s = "";

int times = 50;

void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  BT1Serial.begin(9600);
  BT2Serial.begin(9600);

  scales[0].begin(LC1_DOUT_PIN, LC1_SCK_PIN);
  scales[1].begin(LC2_DOUT_PIN, LC2_SCK_PIN);
  scales[2].begin(LC3_DOUT_PIN, LC3_SCK_PIN);
  scales[3].begin(LC4_DOUT_PIN, LC4_SCK_PIN);

  factors[0] = -24750;
  factors[1] = -20710;
  factors[2] = -11490;
  factors[3] = -24130;
  
  offsets[0] = -3326999;
  offsets[1] = -532573;
  offsets[2] = -1569829;
  offsets[3] = -1235554;
  
  for(int i=0; i<4; i++){
    long zero_factor = scales[i].read_average(times); //Get a baseline reading
    Serial.print("Zero factor: "); //This can be used to remove the need to tare the scale. Useful in permanent scale projects.
    Serial.println(zero_factor);
    offsets[i] = zero_factor;
    
    scales[i].set_scale(factors[i]);
    scales[i].set_offset(offsets[i]);
    scales[i].tare();
  }
}

void loop() {
  // Keep reading from HC-06 and send to Arduino Serial Monitor
  /*BT2Serial.listen();
  if (BT2Serial.available())
  {
      c = BT2Serial.read();
      s += c;
      
      if(c == '\n'){
        s.remove(s.length()-1); // remove newline
        s.remove(s.length()-1); // remove cr
      */
      //if(timer.hasPassed(100)){
        for(int i=0; i<4; i++){
          s += "0.00,";  
        }
        for(int i=0; i<4; i++){
          float val = scales[i].get_units(5);
          s += val;
          //s += random(0, 1000)/100.0f;
          s += ",";
          valsum += val;
          copx += val*xdist[i];
          copy += val*ydist[i];
        }

        copx /= valsum;
        copy /= valsum;

        s += copx;
        s += ",";
        s += copy;
        s += ",";

        copx = 0;
        copy = 0;
        valsum = 0;
        
        BT1Serial.println(s);
        Serial.println(s);
        s="";
        c=' ';
        timer.restart();
      //}
      //}
    
  //}  
}
