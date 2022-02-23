EESchema Schematic File Version 4
EELAYER 30 0
EELAYER END
$Descr A4 11693 8268
encoding utf-8
Sheet 2 5
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
L HX711:HX711 #U1
U 1 1 61D3FD3C
P 5850 3500
AR Path="/61D3CBFC/61D3FD3C" Ref="#U1"  Part="1" 
AR Path="/61D40237/61D3FD3C" Ref="U?"  Part="1" 
AR Path="/61D404E8/61D3FD3C" Ref="U?"  Part="1" 
AR Path="/61D412BE/61D3FD3C" Ref="U?"  Part="1" 
AR Path="/61D47153/61D3FD3C" Ref="U?"  Part="1" 
AR Path="/61D4728B/61D3FD3C" Ref="U?"  Part="1" 
AR Path="/61D4744A/61D3FD3C" Ref="U?"  Part="1" 
AR Path="/61D4E257/61D3FD3C" Ref="U2"  Part="1" 
AR Path="/61D4EE64/61D3FD3C" Ref="U3"  Part="1" 
AR Path="/61D4FC97/61D3FD3C" Ref="U4"  Part="1" 
F 0 "#U1" H 5850 3500 50  0001 L BNN
F 1 "HX711" H 5850 3500 50  0001 L BNN
F 2 "" H 5850 3500 50  0001 L BNN
F 3 "" H 5850 3500 50  0001 L BNN
	1    5850 3500
	-1   0    0    -1  
$EndComp
$Comp
L Device:R R?
U 1 1 61D3FD43
P 3850 3700
AR Path="/61D3FD43" Ref="R?"  Part="1" 
AR Path="/61D3CBFC/61D3FD43" Ref="R1"  Part="1" 
AR Path="/61D40237/61D3FD43" Ref="R?"  Part="1" 
AR Path="/61D404E8/61D3FD43" Ref="R?"  Part="1" 
AR Path="/61D412BE/61D3FD43" Ref="R?"  Part="1" 
AR Path="/61D47153/61D3FD43" Ref="R?"  Part="1" 
AR Path="/61D4728B/61D3FD43" Ref="R?"  Part="1" 
AR Path="/61D4744A/61D3FD43" Ref="R?"  Part="1" 
AR Path="/61D4E257/61D3FD43" Ref="R3"  Part="1" 
AR Path="/61D4EE64/61D3FD43" Ref="R5"  Part="1" 
AR Path="/61D4FC97/61D3FD43" Ref="R7"  Part="1" 
F 0 "R1" V 3643 3700 50  0000 C CNN
F 1 "1k" V 3734 3700 50  0000 C CNN
F 2 "Resistor_THT:R_Axial_DIN0207_L6.3mm_D2.5mm_P7.62mm_Horizontal" V 3780 3700 50  0001 C CNN
F 3 "~" H 3850 3700 50  0001 C CNN
	1    3850 3700
	0    1    1    0   
$EndComp
$Comp
L Device:R R?
U 1 1 61D3FD49
P 3850 3950
AR Path="/61D3FD49" Ref="R?"  Part="1" 
AR Path="/61D3CBFC/61D3FD49" Ref="R2"  Part="1" 
AR Path="/61D40237/61D3FD49" Ref="R?"  Part="1" 
AR Path="/61D404E8/61D3FD49" Ref="R?"  Part="1" 
AR Path="/61D412BE/61D3FD49" Ref="R?"  Part="1" 
AR Path="/61D47153/61D3FD49" Ref="R?"  Part="1" 
AR Path="/61D4728B/61D3FD49" Ref="R?"  Part="1" 
AR Path="/61D4744A/61D3FD49" Ref="R?"  Part="1" 
AR Path="/61D4E257/61D3FD49" Ref="R4"  Part="1" 
AR Path="/61D4EE64/61D3FD49" Ref="R6"  Part="1" 
AR Path="/61D4FC97/61D3FD49" Ref="R8"  Part="1" 
F 0 "R2" V 3643 3950 50  0000 C CNN
F 1 "1k" V 3734 3950 50  0000 C CNN
F 2 "Resistor_THT:R_Axial_DIN0207_L6.3mm_D2.5mm_P7.62mm_Horizontal" V 3780 3950 50  0001 C CNN
F 3 "~" H 3850 3950 50  0001 C CNN
	1    3850 3950
	0    1    1    0   
$EndComp
Wire Wire Line
	4000 3950 4100 3950
Wire Wire Line
	4100 3950 4100 3800
Wire Wire Line
	4000 3700 4100 3700
Wire Wire Line
	4100 3700 4100 3800
Connection ~ 4100 3800
Wire Wire Line
	3700 3700 3250 3700
Wire Wire Line
	3100 3800 3100 3950
Wire Wire Line
	3100 3950 3350 3950
Wire Wire Line
	3250 3700 3250 3400
Connection ~ 3250 3700
Wire Wire Line
	3250 3700 3100 3700
Wire Wire Line
	3350 3950 3350 3200
Connection ~ 3350 3950
Wire Wire Line
	3350 3950 3700 3950
Text Label 3100 3600 0    50   ~ 0
A+
Text Label 3100 3700 0    50   ~ 0
E-
Text Label 3100 3800 0    50   ~ 0
E+
Text GLabel 5850 2900 1    50   Input ~ 0
VCC
Text HLabel 3100 3600 0    50   Input ~ 0
A+
Text HLabel 3100 3700 0    50   Input ~ 0
E-
Text HLabel 3100 3800 0    50   Input ~ 0
E+
Text HLabel 6800 3650 3    50   Input ~ 0
DT
Text HLabel 6650 3550 1    50   Input ~ 0
SCK
Text GLabel 5850 4500 3    50   Input ~ 0
GND
Text Label 4950 3800 0    50   ~ 0
A-
$Comp
L Connector_Generic:Conn_01x06 J16
U 1 1 61D56664
P 4500 4150
AR Path="/61D4FC97/61D56664" Ref="J16"  Part="1" 
AR Path="/61D3CBFC/61D56664" Ref="J10"  Part="1" 
AR Path="/61D4E257/61D56664" Ref="J12"  Part="1" 
AR Path="/61D4EE64/61D56664" Ref="J14"  Part="1" 
F 0 "J10" H 4418 4567 50  0000 C CNN
F 1 "Conn_01x06" H 4418 4476 50  0000 C CNN
F 2 "Connector_PinHeader_2.54mm:PinHeader_1x06_P2.54mm_Vertical" H 4500 4150 50  0001 C CNN
F 3 "~" H 4500 4150 50  0001 C CNN
	1    4500 4150
	-1   0    0    -1  
$EndComp
Wire Wire Line
	3350 3200 4700 3200
Wire Wire Line
	3250 3400 4750 3400
Wire Wire Line
	4700 3950 4700 3200
Connection ~ 4700 3200
Wire Wire Line
	4700 3200 5150 3200
Wire Wire Line
	4750 3400 4750 4050
Wire Wire Line
	4750 4050 4700 4050
Connection ~ 4750 3400
Wire Wire Line
	4750 3400 5150 3400
Wire Wire Line
	4800 4150 4700 4150
Wire Wire Line
	4850 4250 4700 4250
Wire Wire Line
	4900 4000 4900 4350
Wire Wire Line
	4900 4350 4700 4350
Wire Wire Line
	4700 4450 4950 4450
Wire Wire Line
	4950 4450 4950 4200
Wire Wire Line
	4950 4200 5150 4200
Wire Wire Line
	4900 4000 5150 4000
NoConn ~ 5100 4000
NoConn ~ 5100 4200
Wire Wire Line
	3100 3600 4850 3600
Wire Wire Line
	4100 3800 4800 3800
Wire Wire Line
	4800 4150 4800 3800
Connection ~ 4800 3800
Wire Wire Line
	4800 3800 5150 3800
Wire Wire Line
	4850 4250 4850 3600
Connection ~ 4850 3600
Wire Wire Line
	4850 3600 5150 3600
Wire Wire Line
	5850 2900 6750 2900
$Comp
L Connector_Generic:Conn_01x04 J11
U 1 1 61D53FBD
P 7200 3550
AR Path="/61D3CBFC/61D53FBD" Ref="J11"  Part="1" 
AR Path="/61D4E257/61D53FBD" Ref="J13"  Part="1" 
AR Path="/61D4EE64/61D53FBD" Ref="J15"  Part="1" 
AR Path="/61D4FC97/61D53FBD" Ref="J17"  Part="1" 
F 0 "J11" H 7280 3542 50  0000 L CNN
F 1 "Conn_01x04" H 7280 3451 50  0000 L CNN
F 2 "Connector_PinHeader_2.54mm:PinHeader_1x04_P2.54mm_Vertical" H 7200 3550 50  0001 C CNN
F 3 "~" H 7200 3550 50  0001 C CNN
	1    7200 3550
	1    0    0    -1  
$EndComp
Wire Wire Line
	6750 2900 6750 3450
Wire Wire Line
	6750 3450 7000 3450
Wire Wire Line
	6550 3500 6550 3650
Wire Wire Line
	6550 3650 7000 3650
Wire Wire Line
	6550 3700 6650 3700
Wire Wire Line
	6650 3700 6650 3550
Wire Wire Line
	6650 3550 7000 3550
Wire Wire Line
	7000 3750 7000 4500
Wire Wire Line
	5850 4500 7000 4500
$EndSCHEMATC
