EESchema Schematic File Version 4
EELAYER 30 0
EELAYER END
$Descr A4 11693 8268
encoding utf-8
Sheet 1 4
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
F 0 "J?" H 4100 3100 50  0000 L CNN
F 1 "Conn_01x10" H 3930 3001 50  0000 L CNN
F 2 "" H 3850 3100 50  0001 C CNN
F 3 "~" H 3850 3100 50  0001 C CNN
	1    3850 3100
	1    0    0    -1  
$EndComp
Text Notes 2950 2550 0    71   ~ 0
Arduino UNO Rev 3
$Sheet
S 5400 2850 1000 750 
U 611C8367
F0 "Left Foot" 50
F1 "Foot_Board.sch" 50
F2 "Sensor_Power" I L 5400 3000 50 
F3 "Data_Out[1..3]" O R 6400 3450 50 
$EndSheet
$Sheet
S 6750 2850 1000 750 
U 611CB06B
F0 "Right Foot" 50
F1 "Foot_Board.sch" 50
F2 "Sensor_Power" I L 6750 3000 50 
F3 "Data_Out[1..3]" O R 7750 3450 50 
$EndSheet
$Comp
L Connector_Generic:Conn_01x08 J?
U 1 1 611E3554
P 3850 4050
F 0 "J?" H 3930 4042 50  0000 L CNN
F 1 "Conn_01x08" H 3930 3951 50  0000 L CNN
F 2 "" H 3850 4050 50  0001 C CNN
F 3 "~" H 3850 4050 50  0001 C CNN
	1    3850 4050
	1    0    0    -1  
$EndComp
$Comp
L Connector_Generic:Conn_01x08 J?
U 1 1 611E4224
P 3050 3000
F 0 "J?" H 3350 3100 50  0000 C CNN
F 1 "Conn_01x08" H 3350 3000 50  0000 C CNN
F 2 "" H 3050 3000 50  0001 C CNN
F 3 "~" H 3050 3000 50  0001 C CNN
	1    3050 3000
	-1   0    0    -1  
$EndComp
$Comp
L Connector_Generic:Conn_01x06 J?
U 1 1 611E4D84
P 3050 3750
F 0 "J?" H 3350 3850 50  0000 C CNN
F 1 "Conn_01x06" H 3350 3750 50  0000 C CNN
F 2 "" H 3050 3750 50  0001 C CNN
F 3 "~" H 3050 3750 50  0001 C CNN
	1    3050 3750
	-1   0    0    -1  
$EndComp
$Sheet
S 6000 4000 1000 800 
U 611E7D97
F0 "Bluetooth Module" 50
F1 "Bluetooth.sch" 50
F2 "BT_Power" I L 6000 4150 50 
F3 "TXD" O R 7000 4600 50 
F4 "RXD" I L 6000 4250 50 
$EndSheet
$EndSCHEMATC
