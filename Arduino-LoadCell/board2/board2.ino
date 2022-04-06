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

String s="";

int times = 20;

SoftwareSerial BT2Serial(BT2TX, BT2RX);

void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  BT2Serial.begin(9600);
  scales[0].begin(LC1_DOUT_PIN, LC1_SCK_PIN);
  scales[1].begin(LC2_DOUT_PIN, LC2_SCK_PIN);
  scales[2].begin(LC3_DOUT_PIN, LC3_SCK_PIN);
  scales[3].begin(LC4_DOUT_PIN, LC4_SCK_PIN);

  factors[0] = 1;
  factors[1] = 1;
  factors[2] = 1;
  factors[3] = 1;

  for(int i=0; i<4; i++){
    long zero_factor = scales[i].read_average(times); //Get a baseline reading
    Serial.print("Zero factor: "); //This can be used to remove the need to tare the scale. Useful in permanent scale projects.
    Serial.println(zero_factor);
    offsets[i] = zero_factor;
    
    scales[i].set_scale(factors[i]);
    scales[i].set_offset(zero_factor);
    scales[i].tare();
  }
}

void loop() {
  for(int i=0; i<2; i++){
    s += scales[i].get_units(5);
    //s += random(0, 1000)/100.0f;
    s += ",";
  }
  s+="0.00,0.00,";
  BT2Serial.println(s);
  Serial.println(s);
  s="";
  timer.restart();
}
