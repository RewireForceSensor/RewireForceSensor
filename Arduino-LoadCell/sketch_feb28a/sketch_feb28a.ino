#include <SoftwareSerial.h>
#include "HX711.h"

#define BTTX -1
#define BTRX -1
//#define LOADCELL_DOUT_0  5
//#define LOADCELL_SCK_0   4
#define LOADCELL_DOUT_0  8
#define LOADCELL_SCK_0   7
#define LOADCELL_DOUT_1  7
#define LOADCELL_SCK_1   6
#define LOADCELL_DOUT_2  9
#define LOADCELL_SCK_2   8

HX711 loadCellZero;
HX711 loadCellOne;
HX711 loadCellTwo;
void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  //BTSerial.begin(9600);
  
  loadCellZero.begin(LOADCELL_DOUT_1, LOADCELL_SCK_1);
  loadCellZero.set_scale(1);
  loadCellZero.tare(); //Reset the scale to 0

//  loadCellOne.begin(LOADCELL_DOUT_1, LOADCELL_SCK_1);
//  loadCellOne.set_scale(-1000);
//  loadCellOne.tare(); //Reset the scale to 0
//
//  loadCellTwo.begin(LOADCELL_DOUT_2, LOADCELL_SCK_2);
//  loadCellTwo.set_scale(-1000);
//  loadCellTwo.tare(); //Reset the scale to 0
}

void loop() {
  //Serial.print("Test");
  // put your main code here, to run repeatedly:
//    char data = Serial.read();
//    BTSerial.write(data);
//    //BTSerial.write("\n");
//    Serial.write(data);
//    //Serial.write("\n");
    //BTSerial.write(scale.get_units());
  Serial.print("Load Cell Zero: ");
  Serial.println(loadCellZero.get_units());  
//  Serial.print("Load Cell One: ");
//  Serial.println(loadCellOne.get_units());  
//  Serial.print("Load Cell Two: ");
//  Serial.println(loadCellTwo.get_units());  
}
