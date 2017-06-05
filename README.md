# SmartThings-Lux-Sensor
SmartThings Arduino Lux Sensor

This allows a TSL2561 (https://www.adafruit.com/products/439) to measure lux and report back to a SmartThings hub. I've only tested it on the v1 hub (I'm avoiding v2 for now).

The TSL2561 communicates via A4 and A5 on the Arduino Uno. Power, ground, etc. are standard. Instructions for wiring are on the Adafruit product page.

# Installation:

1. Connect your SmartThings shield to your hub via the app (android or iphone). It will show up as a generic device, which is good.

2. Upload the .ino sketch to your arduino.

3. Create a device handler in the SmartThings IDE, and copy the groovy code.

4. Under 'Devices' (IDE), edit your SmartThings shield to use your new device type.

# License

This software is made available under the MIT License.