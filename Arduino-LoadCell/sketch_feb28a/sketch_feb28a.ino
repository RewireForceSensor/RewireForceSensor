#include <SoftwareSerial.h>
#include "HX711.h"

#define BTTX 4
#define BTRX 5
#define LOADCELL_DOUT_PIN  7
#define LOADCELL_SCK_PIN  8

HX711 scale;

SoftwareSerial BTSerial(BTTX, BTRX);
void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  BTSerial.begin(9600);
  
  scale.begin(LOADCELL_DOUT_PIN, LOADCELL_SCK_PIN);
  scale.set_scale(-1000);
  scale.tare(); //Reset the scale to 0
}

void loop() {
  // put your main code here, to run repeatedly:
//    char data = Serial.read();
//    BTSerial.write(data);
//    //BTSerial.write("\n");
//    Serial.write(data);
//    //Serial.write("\n");
    //BTSerial.write(scale.get_units());
  BTSerial.print("Reading: ");
  BTSerial.println(scale.get_units());  
}
