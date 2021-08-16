EESchema Schematic File Version 4
EELAYER 30 0
EELAYER END
$Descr A4 11693 8268
encoding utf-8
Sheet 1 1
Title ""
Date ""
Rev ""
Comp ""
Comment1 ""
Comment2 ""
Comment3 ""
Comment4 ""
$EndDescr
$Comp
L Amplifier_Operational:MCP6004 U1
U 1 1 60AD5F3F
P 5550 3700
F 0 "U1" H 5550 4067 50  0000 C CNN
F 1 "MCP6004" H 5550 3976 50  0000 C CNN
F 2 "" H 5500 3800 50  0001 C CNN
F 3 "http://ww1.microchip.com/downloads/en/DeviceDoc/21733j.pdf" H 5600 3900 50  0001 C CNN
	1    5550 3700
	-1   0    0    -1  
$EndComp
$Comp
L Amplifier_Operational:MCP6004 U1
U 5 1 60ADA6EE
P 4900 1300
F 0 "U1" H 4858 1346 50  0000 L CNN
F 1 "MCP6004" H 4858 1255 50  0000 L CNN
F 2 "" H 4850 1400 50  0001 C CNN
F 3 "http://ww1.microchip.com/downloads/en/DeviceDoc/21733j.pdf" H 4950 1500 50  0001 C CNN
	5    4900 1300
	1    0    0    -1  
$EndComp
$Comp
L MCU_Module:Arduino_Nano_v3.x A1
U 1 1 60D4D21B
P 4150 3700
F 0 "A1" H 4150 2611 50  0000 C CNN
F 1 "Arduino_Nano_v3.x" H 4150 2520 50  0000 C CNN
F 2 "Module:Arduino_Nano" H 4150 3700 50  0001 C CIN
F 3 "http://www.mouser.com/pdfdocs/Gravitech_Arduino_Nano3_0.pdf" H 4150 3700 50  0001 C CNN
	1    4150 3700
	1    0    0    -1  
$EndComp
Wire Wire Line
	4650 3700 5050 3700
Wire Wire Line
	5850 3800 6000 3800
$Comp
L BPSDisplay:GND #PWR0101
U 1 1 60D5E3A8
P 5950 3550
F 0 "#PWR0101" H 5950 3300 50  0001 C CNN
F 1 "GND" H 5955 3377 50  0000 C CNN
F 2 "" H 5950 3550 50  0000 C CNN
F 3 "" H 5950 3550 50  0000 C CNN
	1    5950 3550
	-1   0    0    1   
$EndComp
Wire Wire Line
	5950 3550 5950 3600
Wire Wire Line
	5850 3600 5950 3600
Wire Wire Line
	4800 1700 4800 1600
Text GLabel 4250 2550 1    50   Input ~ 0
+3V
Wire Wire Line
	4800 850  4800 1000
Text Notes 4000 950  0    50   ~ 0
Power the OpAmps
Text Notes 5300 3250 0    50   ~ 0
Amplify Sensor Signal
Text Notes 6700 3650 0    50   ~ 0
Sensor
Text Notes 4000 3700 0    50   ~ 0
Arduino
Wire Wire Line
	4250 2550 4250 2700
Text GLabel 4050 2550 1    50   Input ~ 0
VIN
Wire Wire Line
	4050 2700 4050 2550
Text GLabel 2800 1050 0    50   Input ~ 0
VIN
Wire Wire Line
	2800 1050 3000 1050
$Comp
L BPSDisplay:GND #PWR0102
U 1 1 60D6E31C
P 2800 1150
F 0 "#PWR0102" H 2800 900 50  0001 C CNN
F 1 "GND" H 2805 977 50  0000 C CNN
F 2 "" H 2800 1150 50  0000 C CNN
F 3 "" H 2800 1150 50  0000 C CNN
	1    2800 1150
	1    0    0    -1  
$EndComp
Wire Wire Line
	2800 1150 3000 1150
$Comp
L BPSDisplay:GND #PWR0103
U 1 1 60D6EFD6
P 4400 4700
F 0 "#PWR0103" H 4400 4450 50  0001 C CNN
F 1 "GND" H 4405 4527 50  0000 C CNN
F 2 "" H 4400 4700 50  0000 C CNN
F 3 "" H 4400 4700 50  0000 C CNN
	1    4400 4700
	1    0    0    -1  
$EndComp
Wire Wire Line
	4150 4700 4250 4700
Connection ~ 4250 4700
Wire Wire Line
	4400 4700 4250 4700
Text GLabel 4350 2550 1    50   Input ~ 0
+5V
Wire Wire Line
	4350 2550 4350 2700
Text GLabel 4800 850  1    50   Input ~ 0
+5V
Text GLabel 7750 3800 0    50   Input ~ 0
+3V
$Comp
L Device:R R1
U 1 1 60D7380C
P 5500 4150
F 0 "R1" V 5293 4150 50  0000 C CNN
F 1 "R" V 5384 4150 50  0000 C CNN
F 2 "" V 5430 4150 50  0001 C CNN
F 3 "~" H 5500 4150 50  0001 C CNN
	1    5500 4150
	0    1    1    0   
$EndComp
$Comp
L BPSDisplay:GND #PWR0104
U 1 1 60D76A79
P 8400 3600
F 0 "#PWR0104" H 8400 3350 50  0001 C CNN
F 1 "GND" H 8405 3427 50  0000 C CNN
F 2 "" H 8400 3600 50  0000 C CNN
F 3 "" H 8400 3600 50  0000 C CNN
	1    8400 3600
	-1   0    0    1   
$EndComp
$Comp
L Connector_Generic:Conn_01x01 J5
U 1 1 60D7E17D
P 9500 3700
F 0 "J5" H 9580 3742 50  0000 L CNN
F 1 "Conn_01x01" H 9580 3651 50  0000 L CNN
F 2 "" H 9500 3700 50  0001 C CNN
F 3 "~" H 9500 3700 50  0001 C CNN
	1    9500 3700
	1    0    0    -1  
$EndComp
$Comp
L Connector_Generic:Conn_01x02 J3
U 1 1 60D82474
P 3200 1050
F 0 "J3" H 3280 1042 50  0000 L CNN
F 1 "Conn_01x02" H 3280 951 50  0000 L CNN
F 2 "" H 3200 1050 50  0001 C CNN
F 3 "~" H 3200 1050 50  0001 C CNN
	1    3200 1050
	1    0    0    -1  
$EndComp
Text Notes 9200 3450 0    50   ~ 0
-Vref for sensors\n(Step down to 1V)
Connection ~ 8400 3800
Connection ~ 9200 3700
Wire Wire Line
	9200 3700 9300 3700
Wire Wire Line
	9200 3700 9100 3700
Wire Wire Line
	8400 3800 8500 3800
Wire Wire Line
	8400 3600 8500 3600
Wire Wire Line
	8250 3800 8400 3800
$Comp
L Device:R R3
U 1 1 60D73D1B
P 8800 4200
F 0 "R3" V 8593 4200 50  0000 C CNN
F 1 "R" V 8684 4200 50  0000 C CNN
F 2 "" V 8730 4200 50  0001 C CNN
F 3 "~" H 8800 4200 50  0001 C CNN
	1    8800 4200
	0    1    1    0   
$EndComp
Wire Wire Line
	8400 4200 8650 4200
Wire Wire Line
	8400 3800 8400 4200
Wire Wire Line
	8950 4200 9200 4200
Wire Wire Line
	9200 4200 9200 3700
$Comp
L Amplifier_Operational:MCP6004 U1
U 2 1 60B04A91
P 8800 3700
F 0 "U1" H 8800 4067 50  0000 C CNN
F 1 "MCP6004" H 8800 3976 50  0000 C CNN
F 2 "" H 8750 3800 50  0001 C CNN
F 3 "http://ww1.microchip.com/downloads/en/DeviceDoc/21733j.pdf" H 8850 3900 50  0001 C CNN
	2    8800 3700
	1    0    0    -1  
$EndComp
Wire Wire Line
	6000 3800 6000 4150
Connection ~ 6000 3800
Wire Wire Line
	6000 3800 6550 3800
Wire Wire Line
	5050 4150 5050 3700
Connection ~ 5050 3700
Wire Wire Line
	5050 3700 5250 3700
Wire Wire Line
	5050 4600 5050 4150
Connection ~ 5050 4150
Wire Wire Line
	6000 4600 6000 4150
Connection ~ 6000 4150
$Comp
L Device:R R2
U 1 1 60DA3410
P 8100 3800
F 0 "R2" V 7893 3800 50  0000 C CNN
F 1 "R" V 7984 3800 50  0000 C CNN
F 2 "" V 8030 3800 50  0001 C CNN
F 3 "~" H 8100 3800 50  0001 C CNN
	1    8100 3800
	0    1    1    0   
$EndComp
Wire Wire Line
	7750 3800 7950 3800
Wire Wire Line
	5350 4150 5050 4150
Wire Wire Line
	5650 4150 6000 4150
$Comp
L Device:C_Small C1
U 1 1 60DA6006
P 5500 4600
F 0 "C1" V 5271 4600 50  0000 C CNN
F 1 "C_Small" V 5362 4600 50  0000 C CNN
F 2 "" H 5500 4600 50  0001 C CNN
F 3 "~" H 5500 4600 50  0001 C CNN
	1    5500 4600
	0    1    1    0   
$EndComp
Wire Wire Line
	5050 4600 5400 4600
Wire Wire Line
	5600 4600 6000 4600
$Comp
L Connector_Generic:Conn_01x15 J1
U 1 1 60DAA38B
P 1750 3550
F 0 "J1" H 1830 3592 50  0000 L CNN
F 1 "Conn_01x15" H 1830 3501 50  0000 L CNN
F 2 "" H 1750 3550 50  0001 C CNN
F 3 "~" H 1750 3550 50  0001 C CNN
	1    1750 3550
	1    0    0    -1  
$EndComp
$Comp
L Connector_Generic:Conn_01x15 J2
U 1 1 60DABA3E
P 2550 3550
F 0 "J2" H 2630 3592 50  0000 L CNN
F 1 "Conn_01x15" H 2630 3501 50  0000 L CNN
F 2 "" H 2550 3550 50  0001 C CNN
F 3 "~" H 2550 3550 50  0001 C CNN
	1    2550 3550
	1    0    0    -1  
$EndComp
Text Notes 1700 4450 0    50   ~ 0
Connectors for Arduino
Text Notes 2500 950  0    50   ~ 0
Power from Battery to Arduino
Text Notes 9550 3900 0    50   ~ 0
To sensors
$Comp
L Regulator_Linear:L7905 U2
U 1 1 60F73315
P 6350 1300
F 0 "U2" H 6350 1151 50  0000 C CNN
F 1 "L7905" H 6350 1060 50  0000 C CNN
F 2 "" H 6350 1100 50  0001 C CIN
F 3 "http://www.st.com/content/ccc/resource/technical/document/datasheet/c9/16/86/41/c7/2b/45/f2/CD00000450.pdf/files/CD00000450.pdf/jcr:content/translations/en.CD00000450.pdf" H 6350 1300 50  0001 C CNN
	1    6350 1300
	1    0    0    -1  
$EndComp
$Comp
L BPSDisplay:GND #PWR0105
U 1 1 60F741F8
P 6350 850
F 0 "#PWR0105" H 6350 600 50  0001 C CNN
F 1 "GND" H 6355 677 50  0000 C CNN
F 2 "" H 6350 850 50  0000 C CNN
F 3 "" H 6350 850 50  0000 C CNN
	1    6350 850 
	-1   0    0    1   
$EndComp
Wire Wire Line
	6350 850  6350 1000
Text GLabel 5750 1300 0    50   Input ~ 0
+5V
Wire Wire Line
	5750 1300 6050 1300
Wire Wire Line
	6650 1300 7000 1300
Text GLabel 7000 1300 2    50   Input ~ 0
-5V
Text GLabel 4800 1700 3    50   Input ~ 0
-5V
Text Notes 6700 950  0    50   ~ 0
-5V regulator
$Comp
L Connector_Generic:Conn_01x01 J4
U 1 1 61006303
P 6750 3800
F 0 "J4" H 6830 3842 50  0000 L CNN
F 1 "Conn_01x01" H 6830 3751 50  0000 L CNN
F 2 "" H 6750 3800 50  0001 C CNN
F 3 "~" H 6750 3800 50  0001 C CNN
	1    6750 3800
	1    0    0    -1  
$EndComp
$EndSCHEMATC
