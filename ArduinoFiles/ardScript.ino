#include "DHT.h"
#define SIGNAL_PIN_1 2
#define SIGNAL_PIN_2 4
#define DHTPIN 7
#define DHTTYPE DHT22 

DHT dht(DHTPIN, DHTTYPE);
void setup() {
  Serial.begin(9600);
  dht.begin();
  pinMode(SIGNAL_PIN_1, INPUT);
  pinMode(SIGNAL_PIN_2, INPUT);
}

void loop() {
  float h = dht.readHumidity();
  float f = dht.readTemperature(true);
  float hi = dht.computeHeatIndex(f, h);
  
  Serial.print(h);
  Serial.print(" ");
  Serial.print(f);
  Serial.print(" ");
  Serial.print(hi);
  Serial.print(" ");
  Serial.print(digitalRead(SIGNAL_PIN_1));
  Serial.print(" ");
  Serial.println(digitalRead(SIGNAL_PIN_2));  
  delay(2000);
}
