#include <Wire.h>
#include <LiquidCrystal_I2C.h>

float temperatureCelsius;
int analogPin = 2; // analog input pin, temperature sensor
int delayTime = 1000;

LiquidCrystal_I2C lcd(0x27, 16, 2);  // Set the LCD I2C address

char buffer[10]; //tmp buffer for floatToString

void setup()
{
  Serial.begin(9600);
  initLcd();
}

void loop()
{
  printTemperatureToLcd();
  processInputCommand();  
  
  delay(delayTime);
}

void printTemperatureToLcd() 
{
  lcd.setCursor(0,1);  
  lcd.print("Temper is " + getTemperature() + "C");  
  
}

void processInputCommand() 
{
  char incoming = readSerial();
  
  if(incoming == 0) {
    
  } else if(incoming == '1') {
    Serial.println("dsada");  
  } else {        
    Serial.print(incoming);
    Serial.println("- unknown command");
  }
}
 
void initLcd() {
   lcd.init();
   lcd.backlight(); 
   lcd.setCursor(0,0); 
   lcd.print("Ti pidor");
}

String getTemperature() {
  float sensorValue = analogRead(analogPin);
  // 500mV/1024=.48828125
  temperatureCelsius = sensorValue * 0.48828125;
  return String(dtostrf(temperatureCelsius, 2, 2, buffer));
}

char readSerial() 
{
  char incomingByte = 0;
  if(Serial.available() > 0) {
      incomingByte = Serial.read();
  }
  return incomingByte;
}
