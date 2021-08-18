EESchema Schematic File Version 4
EELAYER 30 0
EELAYER END
$Descr A4 11693 8268
encoding utf-8
Sheet 1 3
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
L Connector_Generic:Conn_01x10 J?
U 1 1 611AFD66
P 3850 3100
F 0 "J?" H 3450 3700 50  0000 L CNN
F 1 "Conn_01x10" H 3250 3600 50  0000 L CNN
F 2 "" H 3850 3100 50  0001 C CNN
F 3 "~" H 3850 3100 50  0001 C CNN
	1    3850 3100
	-1   0    0    -1  
$EndComp
Text Notes 2850 2500 0    71   ~ 0
Arduino UNO Rev 3\n       * PWM
$Sheet
S 6850 2200 1000 750 
U 611C8367
F0 "Left Foot" 50
F1 "Foot_Board.sch" 50
F2 "Sensor_Power" I L 6850 2350 50 
F3 "Data_Out[1..3]" O R 7850 2800 50 
$EndSheet
$Sheet
S 8700 2200 1000 750 
U 611CB06B
F0 "Right Foot" 50
F1 "Foot_Board.sch" 50
F2 "Sensor_Power" I L 8700 2350 50 
F3 "Data_Out[1..3]" O R 9700 2800 50 
$EndSheet
$Comp
L Connector_Generic:Conn_01x08 J?
U 1 1 611E4224
P 3050 3000
F 0 "J?" H 2750 3500 50  0000 C CNN
F 1 "Conn_01x08" H 2750 3400 50  0000 C CNN
F 2 "" H 3050 3000 50  0001 C CNN
F 3 "~" H 3050 3000 50  0001 C CNN
	1    3050 3000
	1    0    0    -1  
$EndComp
$Comp
L Connector_Generic:Conn_01x06 J?
U 1 1 611E4D84
P 3050 3750
F 0 "J?" H 3050 3350 50  0000 C CNN
F 1 "Conn_01x06" H 3050 3250 50  0000 C CNN
F 2 "" H 3050 3750 50  0001 C CNN
F 3 "~" H 3050 3750 50  0001 C CNN
	1    3050 3750
	1    0    0    -1  
$EndComp
NoConn ~ 2850 2700
NoConn ~ 2850 2800
NoConn ~ 2850 2900
Text Notes 3150 2700 0    50   ~ 0
NC
Text Notes 3150 2800 0    50   ~ 0
IOREF
Text Notes 3150 2900 0    50   ~ 0
RESET
Text Notes 3150 3000 0    50   ~ 0
+3V3
Text Notes 3150 3100 0    50   ~ 0
+5V
Text Notes 3150 3200 0    50   ~ 0
GND
Text Notes 3150 3300 0    50   ~ 0
GND
Text Notes 3150 3400 0    50   ~ 0
VIN
Text Notes 3150 3550 0    50   ~ 0
A0
Text Notes 3150 3650 0    50   ~ 0
A1
Text Notes 3150 3750 0    50   ~ 0
A2
Text Notes 3150 3850 0    50   ~ 0
A3
Text Notes 3150 3950 0    50   ~ 0
A4
Text Notes 3150 4050 0    50   ~ 0
A5
Text Notes 3750 2700 2    50   ~ 0
SCL
Text Notes 3750 2800 2    50   ~ 0
SDA
Text Notes 3750 2900 2    50   ~ 0
AREF
Text Notes 3750 3000 2    50   ~ 0
GND
Text Notes 3750 3100 2    50   ~ 0
D13
Text Notes 3750 3200 2    50   ~ 0
D12
Text Notes 3750 3300 2    50   ~ 0
*D11
Text Notes 3750 3400 2    50   ~ 0
*D10
Text Notes 3750 3500 2    50   ~ 0
*D9
Text Notes 3750 3600 2    50   ~ 0
D8
Text Notes 3750 3750 2    50   ~ 0
D7
Text Notes 3750 3850 2    50   ~ 0
*D6
Text Notes 3750 3950 2    50   ~ 0
*D5
Text Notes 3750 4050 2    50   ~ 0
D4
Text Notes 3750 4150 2    50   ~ 0
*D3
Text Notes 3750 4250 2    50   ~ 0
D2
Text Notes 3750 4350 2    50   ~ 0
D1/TX
Text Notes 3750 4450 2    50   ~ 0
D0/RX
$Comp
L Connector_Generic:Conn_01x04 J?
U 1 1 611DBB38
P 4900 4350
AR Path="/611E7D97/611DBB38" Ref="J?"  Part="1" 
AR Path="/611DBB38" Ref="J?"  Part="1" 
F 0 "J?" H 4900 4650 50  0000 C CNN
F 1 "Conn_01x04" H 4950 4550 50  0000 C CNN
F 2 "" H 4900 4350 50  0001 C CNN
F 3 "~" H 4900 4350 50  0001 C CNN
	1    4900 4350
	-1   0    0    -1  
$EndComp
$Comp
L BPSDisplay:GND #PWR?
U 1 1 611DBB3F
P 6300 4350
AR Path="/611E7D97/611DBB3F" Ref="#PWR?"  Part="1" 
AR Path="/611DBB3F" Ref="#PWR?"  Part="1" 
F 0 "#PWR?" H 6300 4100 50  0001 C CNN
F 1 "GND" V 6305 4222 50  0000 R CNN
F 2 "" H 6300 4350 50  0000 C CNN
F 3 "" H 6300 4350 50  0000 C CNN
	1    6300 4350
	0    -1   -1   0   
$EndComp
$Comp
L Device:R_Small_US R?
U 1 1 611DBB45
P 5700 4450
AR Path="/611E7D97/611DBB45" Ref="R?"  Part="1" 
AR Path="/611DBB45" Ref="R?"  Part="1" 
F 0 "R?" H 5768 4496 50  0000 L CNN
F 1 "10K Ohm" H 5768 4405 50  0000 L CNN
F 2 "" H 5700 4450 50  0001 C CNN
F 3 "~" H 5700 4450 50  0001 C CNN
	1    5700 4450
	1    0    0    -1  
$EndComp
$Comp
L Device:R_Small_US R?
U 1 1 611DBB4B
P 5700 4650
AR Path="/611E7D97/611DBB4B" Ref="R?"  Part="1" 
AR Path="/611DBB4B" Ref="R?"  Part="1" 
F 0 "R?" H 5768 4696 50  0000 L CNN
F 1 "560 Ohm" H 5768 4605 50  0000 L CNN
F 2 "" H 5700 4650 50  0001 C CNN
F 3 "~" H 5700 4650 50  0001 C CNN
	1    5700 4650
	1    0    0    -1  
$EndComp
Wire Wire Line
	5100 4450 5300 4450
Wire Wire Line
	5100 4350 5700 4350
Wire Wire Line
	5100 4550 5700 4550
Wire Wire Line
	6300 4350 5700 4350
Connection ~ 5700 4350
Connection ~ 5700 4550
Wire Wire Line
	5700 4750 6300 4750
Wire Wire Line
	5300 4250 5100 4250
$Comp
L power:+3V3 #PWR?
U 1 1 611DDE98
P 2650 2950
F 0 "#PWR?" H 2650 2800 50  0001 C CNN
F 1 "+3V3" H 2665 3123 50  0000 C CNN
F 2 "" H 2650 2950 50  0001 C CNN
F 3 "" H 2650 2950 50  0001 C CNN
	1    2650 2950
	1    0    0    -1  
$EndComp
$Comp
L power:+5V #PWR?
U 1 1 611DF2B2
P 2500 3050
F 0 "#PWR?" H 2500 2900 50  0001 C CNN
F 1 "+5V" H 2515 3223 50  0000 C CNN
F 2 "" H 2500 3050 50  0001 C CNN
F 3 "" H 2500 3050 50  0001 C CNN
	1    2500 3050
	1    0    0    -1  
$EndComp
Wire Wire Line
	2650 2950 2650 3000
Wire Wire Line
	2650 3000 2850 3000
Wire Wire Line
	2500 3050 2500 3100
Wire Wire Line
	2500 3100 2850 3100
$Comp
L power:GND #PWR?
U 1 1 611E0B97
P 2650 3200
F 0 "#PWR?" H 2650 2950 50  0001 C CNN
F 1 "GND" V 2655 3072 50  0000 R CNN
F 2 "" H 2650 3200 50  0001 C CNN
F 3 "" H 2650 3200 50  0001 C CNN
	1    2650 3200
	0    1    1    0   
$EndComp
Wire Wire Line
	2750 3200 2850 3200
Wire Wire Line
	2750 3200 2750 3300
Wire Wire Line
	2750 3300 2850 3300
Connection ~ 2750 3200
Wire Wire Line
	2650 3200 2750 3200
NoConn ~ 4050 2700
NoConn ~ 4050 2800
NoConn ~ 4050 2900
$Comp
L power:GND #PWR?
U 1 1 611E2B05
P 4300 3000
F 0 "#PWR?" H 4300 2750 50  0001 C CNN
F 1 "GND" V 4305 2872 50  0000 R CNN
F 2 "" H 4300 3000 50  0001 C CNN
F 3 "" H 4300 3000 50  0001 C CNN
	1    4300 3000
	0    -1   -1   0   
$EndComp
Wire Wire Line
	4050 3000 4300 3000
NoConn ~ 4050 3100
NoConn ~ 4050 3200
NoConn ~ 4050 3300
NoConn ~ 4050 3400
NoConn ~ 4050 3500
NoConn ~ 4050 3600
NoConn ~ 4050 3750
NoConn ~ 4050 3850
NoConn ~ 4050 3950
NoConn ~ 4050 4050
$Comp
L Connector_Generic:Conn_01x02 J?
U 1 1 611E52DD
P 2500 4600
F 0 "J?" H 2418 4817 50  0000 C CNN
F 1 "Conn_01x02" H 2418 4726 50  0000 C CNN
F 2 "" H 2500 4600 50  0001 C CNN
F 3 "~" H 2500 4600 50  0001 C CNN
	1    2500 4600
	-1   0    0    -1  
$EndComp
$Comp
L power:GND #PWR?
U 1 1 611E780E
P 2900 4700
F 0 "#PWR?" H 2900 4450 50  0001 C CNN
F 1 "GND" V 2905 4572 50  0000 R CNN
F 2 "" H 2900 4700 50  0001 C CNN
F 3 "" H 2900 4700 50  0001 C CNN
	1    2900 4700
	0    -1   1    0   
$EndComp
Wire Wire Line
	2700 4600 2900 4600
Wire Wire Line
	2900 4700 2700 4700
Text Label 2900 4600 0    50   ~ 0
VIN
Wire Wire Line
	2850 3400 2700 3400
Text Label 2700 3400 2    50   ~ 0
VIN
$Comp
L power:+5V #PWR?
U 1 1 611ED85A
P 5300 4250
F 0 "#PWR?" H 5300 4100 50  0001 C CNN
F 1 "+5V" H 5315 4423 50  0000 C CNN
F 2 "" H 5300 4250 50  0001 C CNN
F 3 "" H 5300 4250 50  0001 C CNN
	1    5300 4250
	1    0    0    -1  
$EndComp
Text Label 6300 4750 0    50   ~ 0
D3
Text Label 5300 4450 0    50   ~ 0
D2
$Comp
L Connector_Generic:Conn_01x08 J?
U 1 1 611E3554
P 3850 4050
F 0 "J?" H 3800 3550 50  0000 L CNN
F 1 "Conn_01x08" H 3600 3450 50  0000 L CNN
F 2 "" H 3850 4050 50  0001 C CNN
F 3 "~" H 3850 4050 50  0001 C CNN
	1    3850 4050
	-1   0    0    -1  
$EndComp
Wire Wire Line
	4050 4150 4150 4150
Wire Wire Line
	4050 4250 4150 4250
NoConn ~ 4050 4350
NoConn ~ 4050 4450
Text Label 4150 4250 0    50   ~ 0
D2
Text Label 4150 4150 0    50   ~ 0
D3
$Comp
L power:+5V #PWR?
U 1 1 611F02A4
P 6650 2300
F 0 "#PWR?" H 6650 2150 50  0001 C CNN
F 1 "+5V" H 6665 2473 50  0000 C CNN
F 2 "" H 6650 2300 50  0001 C CNN
F 3 "" H 6650 2300 50  0001 C CNN
	1    6650 2300
	1    0    0    -1  
$EndComp
$Comp
L power:+5V #PWR?
U 1 1 611F08C5
P 8550 2300
F 0 "#PWR?" H 8550 2150 50  0001 C CNN
F 1 "+5V" H 8565 2473 50  0000 C CNN
F 2 "" H 8550 2300 50  0001 C CNN
F 3 "" H 8550 2300 50  0001 C CNN
	1    8550 2300
	1    0    0    -1  
$EndComp
Wire Wire Line
	6650 2300 6650 2350
Wire Wire Line
	6650 2350 6850 2350
Wire Wire Line
	8550 2300 8550 2350
Wire Wire Line
	8550 2350 8700 2350
Wire Notes Line
	2050 4850 2050 2200
Wire Notes Line
	2050 2200 4600 2200
Wire Bus Line
	7850 2800 7950 2800
Wire Bus Line
	9700 2800 9800 2800
Text Label 9800 2800 0    50   ~ 0
Right_Data[1..3]
Text Label 7950 2800 0    50   ~ 0
Left_Data[1..3]
Text Label 2700 3550 2    50   ~ 0
Left_Data1
Text Label 2700 3650 2    50   ~ 0
Left_Data2
Text Label 2700 3750 2    50   ~ 0
Left_Data3
Text Label 2700 3850 2    50   ~ 0
Right_Data1
Text Label 2700 3950 2    50   ~ 0
Right_Data2
Text Label 2700 4050 2    50   ~ 0
Right_Data3
Wire Wire Line
	2700 4050 2850 4050
Wire Wire Line
	2850 3950 2700 3950
Wire Wire Line
	2700 3850 2850 3850
Wire Wire Line
	2850 3750 2700 3750
Wire Wire Line
	2700 3650 2850 3650
Wire Wire Line
	2850 3550 2700 3550
Text Notes 5100 3950 0    71   ~ 0
HC-06 BT Connection
Wire Notes Line
	4600 3750 6650 3750
Wire Notes Line
	6650 3750 6650 4850
Wire Notes Line
	4600 2200 4600 4850
Wire Notes Line
	2050 4850 6650 4850
Wire Notes Line
	6500 1700 10500 1700
Wire Notes Line
	6500 3150 10500 3150
Text Notes 7550 1900 0    71   ~ 0
Left and Right Foot Sensor Inputs
Wire Notes Line
	6500 1700 6500 3150
Wire Notes Line
	10500 1700 10500 3150
$EndSCHEMATC