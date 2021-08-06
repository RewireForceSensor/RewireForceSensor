#include <Chrono.h>
#include <SoftwareSerial.h>

SoftwareSerial BTSerial (2,3);

Chrono timer;

void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  BTSerial.begin(9600);
}

void loop() {
  // put your main code here, to run repeatedly:
  if(timer.hasPassed(500)){
    
    Serial.print(analogRead(A0));
    Serial.print(',');
    Serial.print(analogRead(A1));
    Serial.print(',');
    Serial.print(analogRead(A2));
    //Serial.print(',');
    //Serial.print(analogRead(A3));
    /*Serial.print(',');
    Serial.print(analogRead(A4));
    Serial.print(',');
    Serial.print(analogRead(A5));*/
    Serial.println();
    
    
    BTSerial.print(analogRead(A0));
    BTSerial.print(',');
    BTSerial.print(analogRead(A1));
    BTSerial.print(',');
    BTSerial.print(analogRead(A2));
    //BTSerial.print(',');
    //BTSerial.print(analogRead(A3));
    /*BTSerial.print(',');
    BTSerial.print(analogRead(A4));
    BTSerial.print(',');
    BTSerial.print(analogRead(A5));*/
    BTSerial.println();
    timer.restart();
  }
}
