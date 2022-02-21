EESchema Schematic File Version 4
EELAYER 30 0
EELAYER END
$Descr A4 11693 8268
encoding utf-8
Sheet 1 5
Title ""
Date ""
Rev ""
Comp ""
Comment1 ""
Comment2 ""
Comment3 ""
Comment4 ""
$EndDescr
$Sheet
S 3400 750  3650 950 
U 61D3CBFC
F0 "Sheet61D3CBFB" 50
F1 "corbin.sch" 50
F2 "A+" I L 3400 950 50 
F3 "E-" I L 3400 1050 50 
F4 "E+" I L 3400 1150 50 
F5 "DT" I L 3400 1250 50 
F6 "SCK" I L 3400 1350 50 
$EndSheet
$Comp
L Connector_Generic:Conn_01x02 J1
U 1 1 61D478DB
P 1100 2550
F 0 "J1" H 1018 2767 50  0000 C CNN
F 1 "Conn_01x02" H 1018 2676 50  0000 C CNN
F 2 "Connector_PinSocket_2.54mm:PinSocket_1x02_P2.54mm_Vertical" H 1100 2550 50  0001 C CNN
F 3 "~" H 1100 2550 50  0001 C CNN
	1    1100 2550
	-1   0    0    -1  
$EndComp
Text GLabel 1300 2550 2    50   Input ~ 0
BAT
Text GLabel 1300 2650 2    50   Input ~ 0
GND
$Comp
L Connector_Generic:Conn_01x03 J6
U 1 1 61D4B6BE
P 2800 1050
F 0 "J6" H 2718 1367 50  0000 C CNN
F 1 "Conn_01x03" H 2718 1276 50  0000 C CNN
F 2 "Connector_JST:JST_PH_S3B-PH-K_1x03_P2.00mm_Horizontal" H 2800 1050 50  0001 C CNN
F 3 "~" H 2800 1050 50  0001 C CNN
	1    2800 1050
	-1   0    0    -1  
$EndComp
Wire Wire Line
	3000 950  3400 950 
Wire Wire Line
	3400 1050 3000 1050
Wire Wire Line
	3000 1150 3400 1150
Text Label 3000 950  0    50   ~ 0
A+0
Text Label 3000 1050 0    50   ~ 0
E-0
Text Label 3000 1150 0    50   ~ 0
E+0
Text Label 3000 1250 0    50   ~ 0
DT0
Text Label 3000 1350 0    50   ~ 0
SCK0
$Sheet
S 3400 2000 3650 950 
U 61D4E257
F0 "sheet61D4E250" 50
F1 "corbin.sch" 50
F2 "A+" I L 3400 2200 50 
F3 "E-" I L 3400 2300 50 
F4 "E+" I L 3400 2400 50 
F5 "DT" I L 3400 2500 50 
F6 "SCK" I L 3400 2600 50 
$EndSheet
$Comp
L Connector_Generic:Conn_01x03 J7
U 1 1 61D4E25D
P 2800 2300
F 0 "J7" H 2718 2617 50  0000 C CNN
F 1 "Conn_01x03" H 2718 2526 50  0000 C CNN
F 2 "Connector_JST:JST_PH_S3B-PH-K_1x03_P2.00mm_Horizontal" H 2800 2300 50  0001 C CNN
F 3 "~" H 2800 2300 50  0001 C CNN
	1    2800 2300
	-1   0    0    -1  
$EndComp
Wire Wire Line
	3000 2200 3400 2200
Wire Wire Line
	3400 2300 3000 2300
Wire Wire Line
	3000 2400 3400 2400
Text Label 3000 2200 0    50   ~ 0
A+1
Text Label 3000 2300 0    50   ~ 0
E-1
Text Label 3000 2400 0    50   ~ 0
E+1
Text Label 3000 2500 0    50   ~ 0
DT1
Text Label 3000 2600 0    50   ~ 0
SCK1
$Sheet
S 3400 3250 3650 950 
U 61D4EE64
F0 "sheet61D4EE5D" 50
F1 "corbin.sch" 50
F2 "A+" I L 3400 3450 50 
F3 "E-" I L 3400 3550 50 
F4 "E+" I L 3400 3650 50 
F5 "DT" I L 3400 3750 50 
F6 "SCK" I L 3400 3850 50 
$EndSheet
$Comp
L Connector_Generic:Conn_01x03 J8
U 1 1 61D4EE6A
P 2800 3550
F 0 "J8" H 2718 3867 50  0000 C CNN
F 1 "Conn_01x03" H 2718 3776 50  0000 C CNN
F 2 "Connector_JST:JST_PH_S3B-PH-K_1x03_P2.00mm_Horizontal" H 2800 3550 50  0001 C CNN
F 3 "~" H 2800 3550 50  0001 C CNN
	1    2800 3550
	-1   0    0    -1  
$EndComp
Wire Wire Line
	3000 3450 3400 3450
Wire Wire Line
	3400 3550 3000 3550
Wire Wire Line
	3000 3650 3400 3650
Text Label 3000 3450 0    50   ~ 0
A+2
Text Label 3000 3550 0    50   ~ 0
E-2
Text Label 3000 3650 0    50   ~ 0
E+2
Text Label 3000 3750 0    50   ~ 0
DT2
Text Label 3000 3850 0    50   ~ 0
SCK2
$Sheet
S 3400 4500 3650 950 
U 61D4FC97
F0 "sheet61D4FC90" 50
F1 "corbin.sch" 50
F2 "A+" I L 3400 4700 50 
F3 "E-" I L 3400 4800 50 
F4 "E+" I L 3400 4900 50 
F5 "DT" I L 3400 5000 50 
F6 "SCK" I L 3400 5100 50 
$EndSheet
$Comp
L Connector_Generic:Conn_01x03 J9
U 1 1 61D4FC9D
P 2800 4800
F 0 "J9" H 2718 5117 50  0000 C CNN
F 1 "Conn_01x03" H 2718 5026 50  0000 C CNN
F 2 "Connector_JST:JST_PH_S3B-PH-K_1x03_P2.00mm_Horizontal" H 2800 4800 50  0001 C CNN
F 3 "~" H 2800 4800 50  0001 C CNN
	1    2800 4800
	-1   0    0    -1  
$EndComp
Wire Wire Line
	3000 4700 3400 4700
Wire Wire Line
	3400 4800 3000 4800
Wire Wire Line
	3000 4900 3400 4900
Text Label 3000 4700 0    50   ~ 0
A+3
Text Label 3000 4800 0    50   ~ 0
E-3
Text Label 3000 4900 0    50   ~ 0
E+3
Text Label 3000 5000 0    50   ~ 0
DT3
Text Label 3000 5100 0    50   ~ 0
SCK3
Wire Wire Line
	3000 5000 3400 5000
Wire Wire Line
	3400 5100 3000 5100
Wire Wire Line
	3000 3850 3400 3850
Wire Wire Line
	3400 3750 3000 3750
Wire Wire Line
	3000 2500 3400 2500
Wire Wire Line
	3000 2600 3400 2600
Wire Wire Line
	3000 1250 3400 1250
Wire Wire Line
	3000 1350 3400 1350
Text Label 7850 3350 2    50   ~ 0
DT0
Text Label 7850 3450 2    50   ~ 0
SCK0
Text Label 7850 3550 2    50   ~ 0
DT1
Text Label 7850 3650 2    50   ~ 0
SCK1
Text Label 7850 3750 2    50   ~ 0
DT2
Text Label 7850 3850 2    50   ~ 0
SCK2
Text Label 7850 3950 2    50   ~ 0
DT3
Text Label 7850 4050 2    50   ~ 0
SCK3
$Comp
L MCU_Module:Arduino_Nano_Every A1
U 1 1 61D82891
P 8350 3850
F 0 "A1" H 8350 2761 50  0000 C CNN
F 1 "Arduino_Nano_Every" H 8350 2670 50  0000 C CNN
F 2 "Module:Arduino_Nano" H 8350 3850 50  0001 C CIN
F 3 "https://content.arduino.cc/assets/NANOEveryV3.0_sch.pdf" H 8350 3850 50  0001 C CNN
	1    8350 3850
	1    0    0    -1  
$EndComp
Text GLabel 9300 3650 1    50   Input ~ 0
GND
$Comp
L Connector_Generic:Conn_01x06 J3
U 1 1 61D8A932
P 9450 4800
F 0 "J3" V 9322 5080 50  0000 L CNN
F 1 "Conn_01x06" V 9413 5080 50  0000 L CNN
F 2 "Connector_PinSocket_2.54mm:PinSocket_1x06_P2.54mm_Horizontal" H 9450 4800 50  0001 C CNN
F 3 "~" H 9450 4800 50  0001 C CNN
	1    9450 4800
	-1   0    0    -1  
$EndComp
$Comp
L HC-05:HC-05 #U6
U 1 1 61D8A938
P 10200 4900
F 0 "#U6" H 10145 5915 50  0000 C CNN
F 1 "HC-05" H 10145 5824 50  0000 C CNN
F 2 "" H 10150 5600 50  0001 C CNN
F 3 "" H 10150 5600 50  0001 C CNN
	1    10200 4900
	0    1    1    0   
$EndComp
Wire Wire Line
	9950 4900 9650 4900
Wire Wire Line
	9950 5000 9650 5000
Wire Wire Line
	9950 5100 9650 5100
Text GLabel 9800 5000 3    50   Input ~ 0
VCC
Text GLabel 9900 4900 3    50   Input ~ 0
GND
Wire Wire Line
	9950 4700 9850 4700
Connection ~ 9850 4700
Wire Wire Line
	9850 4700 9650 4700
NoConn ~ 7850 4350
NoConn ~ 7850 4450
NoConn ~ 7850 4550
NoConn ~ 7850 4150
NoConn ~ 8850 4450
NoConn ~ 8850 4550
NoConn ~ 7850 3050
NoConn ~ 7850 3150
NoConn ~ 8850 3250
NoConn ~ 8850 3350
Text GLabel 8350 4850 2    50   Input ~ 0
GND
Text GLabel 8550 2850 2    50   Input ~ 0
VCC
NoConn ~ 8450 2850
NoConn ~ 9650 5100
NoConn ~ 5750 4850
Text GLabel 8250 2100 2    50   Input ~ 0
BAT
$Comp
L Device:R R9
U 1 1 61DAFBA4
P 9100 3950
F 0 "R9" V 9200 3950 50  0000 C CNN
F 1 "1k" V 9100 3950 50  0000 C CNN
F 2 "Resistor_THT:R_Axial_DIN0207_L6.3mm_D2.5mm_P7.62mm_Horizontal" V 9030 3950 50  0001 C CNN
F 3 "~" H 9100 3950 50  0001 C CNN
	1    9100 3950
	0    1    1    0   
$EndComp
$Comp
L Device:R R11
U 1 1 61DB046E
P 9300 3800
F 0 "R11" H 9250 3800 50  0000 R CNN
F 1 "2k" H 9350 3800 50  0000 R CNN
F 2 "Resistor_THT:R_Axial_DIN0207_L6.3mm_D2.5mm_P7.62mm_Horizontal" V 9230 3800 50  0001 C CNN
F 3 "~" H 9300 3800 50  0001 C CNN
	1    9300 3800
	-1   0    0    1   
$EndComp
Wire Wire Line
	9250 3950 9300 3950
Wire Wire Line
	9300 3950 9450 3950
Wire Wire Line
	9450 3950 9450 3550
Connection ~ 9300 3950
Wire Wire Line
	9100 3400 9100 3850
Wire Wire Line
	9100 3850 8850 3850
$Comp
L Device:R R10
U 1 1 61DBB29B
P 9100 4150
F 0 "R10" V 9200 4150 50  0000 C CNN
F 1 "1k" V 9100 4150 50  0000 C CNN
F 2 "Resistor_THT:R_Axial_DIN0207_L6.3mm_D2.5mm_P7.62mm_Horizontal" V 9030 4150 50  0001 C CNN
F 3 "~" H 9100 4150 50  0001 C CNN
	1    9100 4150
	0    1    1    0   
$EndComp
$Comp
L Device:R R12
U 1 1 61DBB2A1
P 9300 4300
F 0 "R12" H 9250 4300 50  0000 R CNN
F 1 "2k" H 9350 4300 50  0000 R CNN
F 2 "Resistor_THT:R_Axial_DIN0207_L6.3mm_D2.5mm_P7.62mm_Horizontal" V 9230 4300 50  0001 C CNN
F 3 "~" H 9300 4300 50  0001 C CNN
	1    9300 4300
	-1   0    0    1   
$EndComp
Text GLabel 9300 4450 3    50   Input ~ 0
GND
$Comp
L Connector_Generic:Conn_01x06 J2
U 1 1 61D79983
P 9450 2950
F 0 "J2" V 9322 2562 50  0000 R CNN
F 1 "Conn_01x06" V 9413 2562 50  0000 R CNN
F 2 "Connector_PinSocket_2.54mm:PinSocket_1x06_P2.54mm_Horizontal" H 9450 2950 50  0001 C CNN
F 3 "~" H 9450 2950 50  0001 C CNN
	1    9450 2950
	-1   0    0    -1  
$EndComp
$Comp
L HC-05:HC-05 #U5
U 1 1 61D78035
P 10350 3050
F 0 "#U5" V 10249 3928 50  0000 L CNN
F 1 "HC-05" V 10340 3928 50  0000 L CNN
F 2 "" H 10300 3750 50  0001 C CNN
F 3 "" H 10300 3750 50  0001 C CNN
	1    10350 3050
	0    1    1    0   
$EndComp
Text GLabel 9950 3150 2    50   Input ~ 0
VCC
NoConn ~ 9700 3250
Text GLabel 10050 3050 2    50   Input ~ 0
GND
Wire Wire Line
	9650 2850 9850 2850
Wire Wire Line
	9650 2950 9750 2950
Wire Wire Line
	9650 3050 10100 3050
Wire Wire Line
	9650 3150 10100 3150
Wire Wire Line
	9650 3250 10100 3250
Wire Wire Line
	9100 3400 9750 3400
Wire Wire Line
	9750 3400 9750 2950
Connection ~ 9750 2950
Wire Wire Line
	9750 2950 10100 2950
Wire Wire Line
	9850 2850 9850 3550
Connection ~ 9850 2850
Wire Wire Line
	9850 2850 10100 2850
Wire Wire Line
	9650 4800 9900 4800
Wire Wire Line
	9900 4800 9900 4050
Wire Wire Line
	9900 4050 8850 4050
Connection ~ 9900 4800
Wire Wire Line
	9900 4800 9950 4800
Wire Wire Line
	9850 4150 9850 4700
Text Label 9850 2850 0    50   ~ 0
RX0
Text Label 9750 2950 0    50   ~ 0
TX0
Wire Wire Line
	9850 3550 9450 3550
Wire Wire Line
	8950 3950 8850 3950
Wire Wire Line
	9300 4150 9850 4150
Wire Wire Line
	9250 4150 9300 4150
Connection ~ 9300 4150
Wire Wire Line
	8950 4150 8850 4150
Text Label 8900 3950 0    50   ~ 0
A1
Text Label 8900 4150 0    50   ~ 0
A3
Text Label 9850 4700 2    50   ~ 0
RX1
Text Label 9900 4800 2    50   ~ 0
TX1
NoConn ~ 8850 3650
$Comp
L Mechanical:MountingHole H1
U 1 1 61DC2ECA
P 8500 1500
F 0 "H1" H 8600 1546 50  0000 L CNN
F 1 "MountingHole" H 8600 1455 50  0000 L CNN
F 2 "MountingHole:MountingHole_3.2mm_M3" H 8500 1500 50  0001 C CNN
F 3 "~" H 8500 1500 50  0001 C CNN
	1    8500 1500
	1    0    0    -1  
$EndComp
$Comp
L Mechanical:MountingHole H3
U 1 1 61DC375A
P 9000 1500
F 0 "H3" H 9100 1546 50  0000 L CNN
F 1 "MountingHole" H 9100 1455 50  0000 L CNN
F 2 "MountingHole:MountingHole_3.2mm_M3" H 9000 1500 50  0001 C CNN
F 3 "~" H 9000 1500 50  0001 C CNN
	1    9000 1500
	1    0    0    -1  
$EndComp
$Comp
L Mechanical:MountingHole H2
U 1 1 61DC485D
P 8500 1950
F 0 "H2" H 8600 1996 50  0000 L CNN
F 1 "MountingHole" H 8600 1905 50  0000 L CNN
F 2 "MountingHole:MountingHole_3.2mm_M3" H 8500 1950 50  0001 C CNN
F 3 "~" H 8500 1950 50  0001 C CNN
	1    8500 1950
	1    0    0    -1  
$EndComp
$Comp
L Mechanical:MountingHole H4
U 1 1 61DC5919
P 9000 1950
F 0 "H4" H 9100 1996 50  0000 L CNN
F 1 "MountingHole" H 9100 1905 50  0000 L CNN
F 2 "MountingHole:MountingHole_3.2mm_M3" H 9000 1950 50  0001 C CNN
F 3 "~" H 9000 1950 50  0001 C CNN
	1    9000 1950
	1    0    0    -1  
$EndComp
Wire Wire Line
	9650 2750 10100 2750
Wire Wire Line
	9650 4600 9950 4600
NoConn ~ 8850 4350
Wire Wire Line
	8850 4250 9000 4250
Wire Wire Line
	9000 4250 9000 4550
$Comp
L Device:LED D1
U 1 1 61E8958B
P 9000 4700
F 0 "D1" V 9039 4582 50  0000 R CNN
F 1 "LED" V 8948 4582 50  0000 R CNN
F 2 "Connector_PinSocket_2.54mm:PinSocket_1x02_P2.54mm_Vertical" H 9000 4700 50  0001 C CNN
F 3 "~" H 9000 4700 50  0001 C CNN
	1    9000 4700
	0    -1   -1   0   
$EndComp
Text GLabel 9000 4850 3    50   Input ~ 0
GND
Text Label 9000 4450 0    50   ~ 0
ST
$Comp
L Switch:SW_DIP_x01 SW1
U 1 1 61E8C3F1
P 8250 2500
F 0 "SW1" V 8204 2630 50  0000 L CNN
F 1 "SW_DIP_x01" V 8295 2630 50  0000 L CNN
F 2 "Connector_PinSocket_2.54mm:PinSocket_1x02_P2.54mm_Vertical" H 8250 2500 50  0001 C CNN
F 3 "~" H 8250 2500 50  0001 C CNN
	1    8250 2500
	0    1    1    0   
$EndComp
Wire Wire Line
	8250 2100 8250 2200
Wire Wire Line
	8250 2800 8250 2850
Text Label 8250 2850 0    50   ~ 0
VIN
$EndSCHEMATC
