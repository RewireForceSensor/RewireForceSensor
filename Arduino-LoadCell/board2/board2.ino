#include <Chrono.h>
#include <SoftwareSerial.h>
#include "HX711.h"

#define BT1TX 4
#define BT1RX 3
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

char c=' ';
String s;

SoftwareSerial BT1Serial(BT1TX, BT1RX);

void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  //BT1Serial.begin(9600);
  scales[0].begin(LC1_DOUT_PIN, LC1_SCK_PIN);
  scales[1].begin(LC2_DOUT_PIN, LC2_SCK_PIN);
  scales[2].begin(LC3_DOUT_PIN, LC3_SCK_PIN);
  scales[3].begin(LC4_DOUT_PIN, LC4_SCK_PIN);

  factors[0] = -1000;
  factors[1] = -1000;
  factors[2] = -1000;
  factors[3] = -1000;

  for(int i=0; i<4; i++){
    scales[i].set_scale(factors[i]);
    //scales[i].set_scale();
    scales[i].tare();
  }

  randomSeed(analogRead(7));
}

void loop() {
  
  if(timer.hasPassed(100)){
    Serial.println("--------------------");
    for(int i=0; i<4; i++){
      //s += scales[i].get_units();
      s += random(0, 1000)/100.0f;
      s += ", ";
    }
    BT1Serial.println(s);
    Serial.println(s);
    s = "";
    timer.restart();
  }
  
}
