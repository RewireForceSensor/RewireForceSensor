#include <Chrono.h>
#include <SoftwareSerial.h>

SoftwareSerial BTSerial (2,3);

Chrono timer;

//float cf = 19.5*2.20462*5/12.5;
int ffsdata = 0;
float vout;

int ports[6] = {A0, A1, A2, A3, A4, A5};
float values[6];
float coeffs[6] = {15, 15, 15, 15, 15, 15};
float threshold = 0.03;

void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  BTSerial.begin(9600);
}

void loop() {
  // put your main code here, to run repeatedly:
  if(timer.hasPassed(100)){
    for(int i=0; i<6; i++){
      ffsdata = analogRead(ports[i]);
      vout = (ffsdata * 5.0) / 1023.0;
      vout = (vout > threshold)?(vout * coeffs[i]):0.0;
      values[i] = vout;
      
      Serial.print(i);
      Serial.print(": ");
      Serial.println(values[i], 3);

      BTSerial.print(values[i], 3);
      BTSerial.print(",");
    }

    BTSerial.println();

    timer.restart();
    
    
    /*Serial.print(analogRead(A0));
    Serial.print(',');
    Serial.print(analogRead(A1));
    Serial.print(',');
    Serial.print(analogRead(A2));
    //Serial.print(',');
    //Serial.print(analogRead(A3));
    Serial.print(',');
    Serial.print(analogRead(A4));
    Serial.print(',');
    Serial.print(analogRead(A5));
    Serial.println();
    
    
    BTSerial.print(analogRead(A0));
    BTSerial.print(',');
    BTSerial.print(analogRead(A1));
    BTSerial.print(',');
    BTSerial.print(analogRead(A2));
    //BTSerial.print(',');
    //BTSerial.print(analogRead(A3));
    BTSerial.print(',');
    BTSerial.print(analogRead(A4));
    BTSerial.print(',');
    BTSerial.print(analogRead(A5));
    BTSerial.println();
    timer.restart();*/

    
  }
}
