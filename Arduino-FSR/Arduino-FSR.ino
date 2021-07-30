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
  if(timer.hasPassed(200)){
    Serial.println(analogRead(A0));
    BTSerial.println(analogRead(A0));
    timer.restart();
  }
}
