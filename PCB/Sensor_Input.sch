EESchema Schematic File Version 4
EELAYER 30 0
EELAYER END
$Descr A4 11693 8268
encoding utf-8
Sheet 3 9
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
L Device:C_Small C?
U 1 1 611CC204
P 5650 3600
AR Path="/611CC204" Ref="C?"  Part="1" 
AR Path="/611C8367/611C9C0B/611CC204" Ref="C?"  Part="1" 
AR Path="/611C8367/611C96D8/611CC204" Ref="C?"  Part="1" 
AR Path="/611C8367/611C9C62/611CC204" Ref="C?"  Part="1" 
AR Path="/611CB06B/611C96D8/611CC204" Ref="C?"  Part="1" 
AR Path="/611CB06B/611C9C0B/611CC204" Ref="C?"  Part="1" 
AR Path="/611CB06B/611C9C62/611CC204" Ref="C?"  Part="1" 
F 0 "C?" H 5558 3554 50  0000 R CNN
F 1 "C_Small" H 5558 3645 50  0000 R CNN
F 2 "" H 5650 3600 50  0001 C CNN
F 3 "~" H 5650 3600 50  0001 C CNN
	1    5650 3600
	-1   0    0    1   
$EndComp
$Comp
L Device:R_Small_US R?
U 1 1 611CC20A
P 5000 3600
AR Path="/611CC20A" Ref="R?"  Part="1" 
AR Path="/611C8367/611C9C0B/611CC20A" Ref="R?"  Part="1" 
AR Path="/611C8367/611C96D8/611CC20A" Ref="R?"  Part="1" 
AR Path="/611C8367/611C9C62/611CC20A" Ref="R?"  Part="1" 
AR Path="/611CB06B/611C96D8/611CC20A" Ref="R?"  Part="1" 
AR Path="/611CB06B/611C9C0B/611CC20A" Ref="R?"  Part="1" 
AR Path="/611CB06B/611C9C62/611CC20A" Ref="R?"  Part="1" 
F 0 "R?" H 5068 3646 50  0000 L CNN
F 1 "R_Small_US" H 5068 3555 50  0000 L CNN
F 2 "" H 5000 3600 50  0001 C CNN
F 3 "~" H 5000 3600 50  0001 C CNN
	1    5000 3600
	1    0    0    -1  
$EndComp
$Comp
L BPSDisplay:GND #PWR?
U 1 1 611CC210
P 5000 4000
AR Path="/611CC210" Ref="#PWR?"  Part="1" 
AR Path="/611C8367/611C9C0B/611CC210" Ref="#PWR?"  Part="1" 
AR Path="/611C8367/611C96D8/611CC210" Ref="#PWR?"  Part="1" 
AR Path="/611C8367/611C9C62/611CC210" Ref="#PWR?"  Part="1" 
AR Path="/611CB06B/611C96D8/611CC210" Ref="#PWR?"  Part="1" 
AR Path="/611CB06B/611C9C0B/611CC210" Ref="#PWR?"  Part="1" 
AR Path="/611CB06B/611C9C62/611CC210" Ref="#PWR?"  Part="1" 
F 0 "#PWR?" H 5000 3750 50  0001 C CNN
F 1 "GND" H 5005 3827 50  0000 C CNN
F 2 "" H 5000 4000 50  0000 C CNN
F 3 "" H 5000 4000 50  0000 C CNN
	1    5000 4000
	1    0    0    -1  
$EndComp
Wire Wire Line
	5000 3700 5000 3900
Wire Wire Line
	5650 3500 5650 3300
Wire Wire Line
	5650 3300 5000 3300
Wire Wire Line
	5000 3300 5000 3500
Wire Wire Line
	5650 3700 5650 3900
Wire Wire Line
	5650 3900 5000 3900
Connection ~ 5000 3900
Wire Wire Line
	5000 3900 5000 4000
Text HLabel 4100 3350 0    50   Input ~ 0
Sensor_Output
Text HLabel 6200 3550 2    50   Output ~ 0
Data_Output
Wire Wire Line
	6150 3300 5650 3300
Connection ~ 5650 3300
Wire Wire Line
	4800 3300 5000 3300
Connection ~ 5000 3300
$EndSCHEMATC
