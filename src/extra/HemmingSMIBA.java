package extra;

public class HemmingSMIBA {
	public static final int [][] input1 = new int[][]{
		{5,3,0,1,9,},{20,3,0,1,6,},{6,2,3,2,9,},{17,0,0,0,6,},{12,2,3,9,3,},{9,2,3,8,7,},{14,0,2,9,7,},{9,2,0,3,0,},{8,1,0,1,1,},{10,2,3,8,3,},
		{10,0,3,8,5,},{11,4,0,3,1,},{1,1,0,5,8,},{4,0,4,2,4,},{6,2,4,0,1,},{21,4,0,3,5,},{20,1,3,0,8,},{2,1,2,7,5,},{17,2,1,3,7,},{9,1,2,9,3,},
		{12,3,0,6,8,},{2,1,3,4,3,},{8,2,4,3,5,},{17,2,2,3,5,},{5,0,2,6,1,},{17,3,1,1,9,},{1,1,4,0,8,},{11,4,0,4,0,},{5,2,3,9,3,},{7,4,1,4,0,},
		{18,4,3,9,1,},{2,1,4,9,8,},{13,0,0,5,9,},{1,4,3,0,4,},{8,1,4,5,5,},{2,4,0,1,4,},{13,1,1,1,2,},{10,3,2,2,7,},{16,3,3,7,1,},{19,3,2,7,4,},
		{5,0,4,9,4,},{10,3,0,4,7,},{5,4,1,1,6,},{17,3,0,1,1,},{8,1,2,7,9,},{13,0,3,1,0,},{18,0,0,7,3,},{1,4,0,8,4,},{10,2,1,1,6,},{13,2,3,6,5,},
		{20,2,2,9,4,},{17,1,1,7,1,},{20,0,1,0,3,},{9,4,0,8,1,},{13,1,4,9,6,},{10,3,2,9,7,},{12,3,2,9,3,},{6,2,0,5,8,},{0,4,1,5,2,},{11,4,2,8,4,},
		{6,3,4,2,0,},{11,0,1,5,0,},{0,3,0,9,1,},{2,2,3,7,7,},{18,3,1,7,3,},{5,0,4,8,7,},{12,4,4,3,1,},{3,1,0,6,1,},{4,1,1,7,8,},{3,3,1,6,8,},
		{17,3,3,4,2,},{6,1,4,6,7,},{0,0,1,0,5,},{9,1,1,3,2,},{8,2,0,6,2,},{5,1,0,0,6,},{18,1,2,8,6,},{21,4,4,7,4,},{3,4,3,0,4,},{13,0,3,0,2,},
		{2,0,1,6,3,},{12,2,3,9,4,},{18,4,3,0,2,},{19,4,2,2,3,},{1,0,3,0,8,},{21,1,1,9,5,},{17,0,0,3,8,},{9,1,1,2,8,},{5,3,0,2,0,},{11,2,1,6,9,},
		{10,3,1,0,8,},{5,1,2,0,0,},{9,1,1,5,9,},{18,0,0,6,0,},{11,3,3,5,3,},{13,1,3,1,9,},{5,4,2,7,7,},{0,4,3,4,5,},{7,0,2,8,5,},{13,0,2,5,9,},
		{17,3,1,6,9,},{5,3,2,9,4,},{4,0,1,1,7,},{17,0,4,5,0,},{1,3,1,2,1,},{7,0,3,6,8,},{4,1,1,6,5,},{9,1,4,8,1,},{7,3,2,3,3,},{11,0,2,9,3,},
		{18,2,1,8,5,},{2,1,0,5,5,},{10,3,2,4,5,},{15,3,1,2,6,},{2,4,2,3,9,},{17,0,2,0,8,},{4,0,4,3,6,},{13,0,0,0,7,},{13,0,0,6,8,},{3,4,2,6,5,},
		{6,1,1,0,1,},{17,2,1,1,5,},{11,0,0,7,5,},{8,1,3,4,3,},{18,4,1,7,7,},{13,1,3,0,8,},{2,1,2,8,8,},{9,2,2,2,4,},{18,3,4,1,4,},{7,3,4,3,9,},
		{2,1,3,1,9,},{8,1,4,3,7,},{20,1,0,4,3,},{17,4,3,6,2,},{17,2,4,8,0,},{1,4,0,0,8,},{5,0,3,7,0,},{1,0,3,7,6,},{17,3,1,9,0,},{9,2,2,5,0,},
		{8,4,3,1,5,},{1,4,0,4,0,},{13,4,0,4,3,},{11,2,4,2,5,},{20,4,1,0,1,},{11,1,3,4,3,},{2,4,0,7,4,},{5,0,4,7,0,},{11,0,1,8,5,},{17,0,4,0,4,},
		{14,0,2,6,3,},{21,1,3,6,6,},{6,2,1,9,6,},{12,1,4,7,3,},{9,2,4,3,0,},{0,0,2,8,5,},{0,2,1,5,3,},{17,0,0,1,5,},{20,0,1,4,5,},{11,3,3,8,3,},
		{15,3,3,4,2,},{1,4,1,4,7,},{14,2,4,3,4,},{8,0,2,9,8,},{5,4,0,4,7,},{6,2,0,6,9,},{4,1,1,0,0,},{14,1,4,9,3,},{17,2,0,8,2,},{4,1,2,0,0,},
		{0,0,1,7,6,},{17,2,4,4,8,},{13,2,3,0,9,},{0,4,3,1,2,},{12,4,0,8,4,},{9,1,3,8,9,},{12,0,4,4,4,},{13,1,1,9,5,},{1,0,3,4,5,},{11,0,4,3,2,},
		{5,4,3,7,5,},{9,0,2,7,2,},{8,1,0,5,2,},{18,4,3,7,3,},{5,1,4,6,6,},{1,0,2,3,3,},{2,1,3,0,1,},{6,3,0,7,3,},{4,4,2,2,8,},{5,1,4,7,9,},
		{7,3,4,6,5,},{11,0,1,7,2,},{2,4,2,2,0,},{4,4,3,9,7,},{2,4,1,8,9,},{18,2,3,9,3,},{16,0,0,7,4,},{11,3,2,9,3,},{13,0,4,2,1,},{1,1,4,7,6,},
		{7,0,2,4,9,},{0,0,3,4,0,},{3,0,4,4,9,},{5,3,4,6,2,},{12,0,3,9,7,},{19,3,1,4,1,},{0,2,1,6,1,},{2,1,0,0,1,},{8,3,0,5,2,},{0,1,3,4,4,},
		{18,4,2,6,2,},{8,1,3,2,3,},{11,4,0,1,2,},{1,4,3,9,7,},{6,0,4,1,4,},{18,2,2,2,1,},{5,1,2,1,7,},{2,1,4,9,5,},{5,0,3,0,2,},{8,1,3,2,7,},
		{7,3,1,2,6,},{10,2,4,7,9,},{1,3,0,3,3,},{3,1,0,5,4,},{1,2,3,6,3,},{11,1,1,6,1,},{17,1,2,1,8,},{7,0,3,2,4,},{9,0,0,7,4,},{5,1,0,9,9,},
		{17,0,2,6,3,},{5,3,1,6,1,},{8,4,4,2,9,},{18,1,1,1,7,},{14,3,0,8,4,},{4,0,1,8,3,},{1,4,0,3,7,},{1,2,4,3,9,},{14,1,3,5,5,},{12,1,0,6,6,},
		{17,2,1,9,0,},{2,3,1,0,8,},{14,2,2,8,4,},{5,3,1,6,8,},{17,4,3,2,5,},{2,0,3,6,7,},{8,4,2,0,3,},{10,0,1,1,9,},{12,0,4,4,8,},{14,2,2,9,3,},
		{12,4,1,1,3,},{16,1,0,7,8,},{17,0,3,9,0,},{1,4,3,4,1,},{4,0,4,3,4,},{9,2,1,8,4,},{13,0,2,6,5,},{17,2,1,9,1,},{5,1,0,6,4,},{10,1,4,9,8,},
		{17,3,1,4,8,},{1,4,1,0,7,},{14,3,4,4,9,},{14,4,2,1,2,},{4,0,4,9,5,},{5,0,1,9,3,},{8,0,3,5,8,},{17,2,2,1,6,},{11,3,4,4,1,},{9,3,2,9,1,},
		{10,4,2,0,5,},{19,3,1,4,5,},{6,4,2,6,6,},{18,4,1,7,9,},{12,0,2,8,3,},{17,0,1,7,0,},{1,2,3,8,2,},{5,1,4,3,4,},{9,3,3,5,7,},{8,1,3,6,9,},
		{8,3,4,3,1,},{21,1,0,2,1,},{9,4,3,4,8,},{20,1,2,2,7,},{2,1,0,4,2,},{2,3,4,2,5,},{1,3,0,4,9,},{0,4,3,0,7,},{1,4,3,4,6,},{2,1,3,0,6,},
		{17,3,1,3,2,},{5,1,3,8,3,},{20,0,2,9,8,},{17,0,2,6,1,},{2,4,2,5,6,},{2,3,4,7,7,},{15,0,1,1,4,},{17,2,3,6,0,},{8,0,0,5,9,},{13,1,0,6,3,},
		{14,2,1,8,3,},{0,3,4,8,5,},{14,2,3,5,1,},{1,1,4,6,2,},{17,3,2,2,9,},{0,1,3,5,0,},{20,3,0,5,1,},{13,1,0,1,7,},{5,1,0,7,9,},{8,1,0,3,6,},
		{4,2,2,6,7,},{5,4,3,8,9,},{11,3,1,5,0,},{2,2,3,1,3,},{13,1,1,1,5,},{5,2,1,1,4,},{17,0,4,4,0,},{14,2,3,4,8,},{8,2,3,6,0,},{12,4,3,3,0,},
		{2,4,3,6,3,},{4,3,0,1,3,},{5,1,4,9,9,},{4,3,3,0,1,},{17,2,3,0,9,},{3,0,0,7,0,},{17,1,4,7,2,},{4,4,2,9,6,},{8,1,3,3,3,},{10,2,4,2,2,},
		{13,4,4,9,5,},{1,2,2,1,5,},{9,3,2,4,9,},{0,1,4,2,4,},{17,4,1,0,6,},{2,3,2,3,3,},{21,0,2,4,0,},{5,1,0,1,3,},{14,1,1,5,3,},{17,4,2,5,9,},
		{5,2,4,1,1,},{15,4,4,3,2,},{5,1,4,3,7,},{20,4,3,7,8,},{1,4,0,1,1,},{17,0,4,7,0,},{8,2,2,1,8,},{12,2,2,4,0,},{17,0,1,4,1,},{3,4,1,8,3,},
		{15,1,2,0,5,},{1,3,4,8,8,},{15,0,1,8,5,},{5,1,3,4,1,},{2,1,2,0,5,},{18,0,1,6,0,},{2,3,2,9,0,},{6,1,4,6,1,},{11,1,2,6,2,},{8,1,4,8,4,},
		{10,1,0,3,3,},{14,3,1,1,1,},{9,1,1,9,8,},{17,3,3,2,8,},{11,0,2,1,3,},{5,1,2,6,6,},{0,1,1,8,9,},{10,0,1,8,9,},{6,2,3,6,4,},{17,2,3,4,2,},
		{2,1,4,8,8,},{18,3,1,9,6,},{1,1,4,8,6,},{21,0,0,7,6,},{6,0,4,4,3,},{5,3,1,7,6,},{13,0,3,5,7,},{13,3,0,6,3,},{9,3,2,7,8,},{2,3,2,3,6,},
		{4,4,1,7,7,},{5,1,4,5,5,},{17,1,2,3,6,},{3,1,4,7,8,},{15,0,3,2,3,},{2,2,4,7,4,},{16,2,4,9,3,},{16,3,4,2,4,},{12,0,2,1,5,},{17,0,0,0,2,},
		{15,2,2,7,2,},{1,1,4,6,3,},{2,1,2,8,4,},{17,2,3,1,2,},{17,4,3,0,5,},{5,2,1,5,4,},{10,0,2,7,7,},{1,1,4,1,3,},{21,2,3,2,8,},{9,1,1,8,3,},
		{8,4,2,0,6,},{14,3,0,8,0,},{2,3,1,6,6,},{0,1,4,9,6,},{17,0,1,3,9,},{21,0,1,4,0,},{2,1,3,7,8,},{21,1,1,9,2,},{17,3,1,2,1,},{1,4,0,7,2,},
		{5,1,3,0,0,},{19,1,2,4,2,},{8,2,2,8,0,},{5,1,1,9,5,},{21,2,4,7,0,},{4,4,2,8,5,},{11,0,1,6,7,},{10,3,2,7,4,},{2,1,3,1,6,},{5,1,3,8,3,},
		{5,4,1,6,0,},{7,2,1,0,3,},{10,0,2,5,7,},{14,3,4,2,3,},{18,2,4,3,6,},{8,3,3,0,9,},{2,1,0,2,2,},{3,2,4,6,6,},{5,0,2,3,6,},{19,2,4,1,4,},
		{1,3,2,2,3,},{1,4,1,8,7,},{17,3,2,7,5,},{11,3,1,2,8,},{5,1,2,1,5,},{17,2,0,9,3,},{4,3,2,4,0,},{17,3,1,2,7,},{8,0,0,7,1,},{13,1,0,9,6,},
		{17,3,4,2,7,},{1,1,3,5,5,},{2,0,2,0,4,},{5,4,4,7,5,},{3,1,4,4,1,},{21,1,1,2,9,},{3,0,0,7,0,},{21,4,2,4,9,},{2,4,3,8,8,},{8,1,3,9,0,},
		{3,2,1,4,4,},{4,2,3,3,1,},{1,4,3,0,1,},{5,0,4,9,8,},{18,4,1,9,1,},{2,2,3,8,5,},{13,2,3,7,6,},{14,0,3,2,4,},{8,0,0,9,4,},{11,2,4,3,1,},
		{12,0,1,6,8,},{17,0,2,0,5,},{2,3,1,5,2,},{2,0,3,2,8,},{8,0,0,3,3,},{1,4,3,1,0,},{20,4,2,8,5,},{13,3,3,3,6,},{13,3,0,5,4,},{17,1,0,3,6,},
		{5,1,4,1,6,},{19,3,1,7,0,},{17,3,4,5,8,},{9,3,1,2,7,},{21,4,3,5,6,},{2,2,0,4,0,},{5,1,2,2,0,},{10,0,0,5,7,},{4,0,2,1,6,},{5,4,1,6,8,},
		{15,4,3,4,8,},{5,2,3,5,8,},{12,2,4,1,1,},{18,3,2,7,1,},{3,3,1,9,0,},{10,2,4,8,6,},{2,2,1,5,9,},{9,4,2,9,8,},{20,2,1,9,3,},{8,1,1,1,6,},
		{2,4,3,4,7,},{11,2,1,5,9,},{1,0,4,4,6,},{20,4,3,8,5,},{17,2,0,5,1,},{5,3,1,4,8,},{14,0,0,4,3,},{8,1,1,8,5,},{16,1,3,4,1,},{7,2,4,7,0,},
		{4,4,0,6,0,},{8,0,1,6,1,},{10,3,0,5,3,},{15,3,4,1,0,},{20,2,1,7,5,},{5,1,4,9,1,},{17,1,4,0,8,},{8,1,3,8,8,},{2,1,3,7,5,},{6,0,4,2,1,},
		{1,3,1,9,7,},{5,0,3,3,1,},{11,0,2,7,5,},{7,1,3,5,9,},{2,3,1,0,8,},{17,4,0,9,0,},{13,2,1,9,3,},{8,0,1,6,2,},{14,1,3,9,1,},{2,4,0,5,9,},
		{2,1,4,4,2,},{9,4,3,8,1,},{2,3,0,5,8,},{1,1,4,3,0,},{14,4,1,2,8,},{7,3,2,9,4,},{16,2,3,9,8,},{3,0,0,1,1,},{18,0,0,6,2,},{17,3,0,1,8,},
		{2,1,0,0,9,},{14,1,1,9,2,},{7,1,3,6,3,},{18,3,3,8,0,},{7,3,1,7,5,},{7,2,4,3,6,},{10,3,4,4,9,},{8,1,2,1,3,},{0,4,2,7,9,},{7,2,0,5,9,},
		{1,4,3,3,8,},{4,0,0,8,6,},{9,2,3,1,1,},{5,4,4,7,5,},{17,0,1,3,4,},{6,2,1,5,9,},{2,4,2,6,7,},{13,0,0,9,3,},{17,1,2,9,6,},{17,2,1,2,7,},
		{5,1,4,6,9,},{8,1,2,5,3,},{19,0,2,4,8,},{2,2,3,9,8,},{8,2,0,1,3,},{13,2,3,2,2,},{14,1,1,5,8,},{2,2,4,8,7,},{2,1,2,2,4,},{21,1,1,4,0,},
		{19,2,4,3,6,},{3,2,0,3,1,},{21,3,2,0,5,},{12,1,0,9,7,},{1,1,4,2,8,},{1,1,4,1,6,},{4,1,0,6,1,},{2,1,3,1,0,},{8,2,2,7,1,},{2,1,0,7,8,},
		{14,1,4,4,2,},{17,3,1,9,4,},{17,4,1,2,4,},{17,1,1,0,8,},{12,1,1,7,1,},{2,3,0,7,7,},{8,1,4,9,7,},{5,0,3,9,6,},{11,2,2,7,9,},{14,4,3,0,6,},
		{0,4,3,5,2,},{6,0,4,2,2,},{16,0,1,6,6,},{8,1,0,3,4,},{11,1,3,1,4,},{17,4,2,7,0,},{7,2,4,0,3,},{18,1,3,8,0,},{11,0,1,4,4,},{21,2,4,8,3,},
		{17,1,3,7,5,},{17,3,2,6,0,},{5,1,3,9,6,},{7,0,1,8,7,},{20,1,4,1,6,},{20,3,0,0,6,},{8,3,0,4,8,},{14,1,0,5,8,},{7,0,0,4,9,},{7,3,2,7,5,},
		{0,1,4,7,1,},{11,3,1,4,4,},{0,2,3,5,3,},{2,2,1,2,1,},{11,2,1,8,5,},{7,2,2,1,9,},{17,2,1,3,7,},{17,2,1,4,9,},{8,0,1,7,0,},{11,3,2,8,5,},
		{17,4,0,0,7,},{0,4,1,5,4,},{4,0,0,9,3,},{8,1,2,5,3,},{9,2,4,4,0,},{1,0,3,4,7,},{10,3,4,3,7,},{7,3,0,5,6,},{12,4,3,8,6,},{5,1,4,8,5,},
		{0,0,0,1,1,},{1,4,1,0,6,},{17,2,3,8,4,},{15,2,0,6,5,},{7,1,0,3,3,},{13,0,0,6,3,},{8,4,0,7,5,},{5,4,2,0,6,},{4,0,3,7,9,},{4,1,3,5,2,},
		{17,0,0,2,5,},{8,0,4,9,2,},{1,0,1,6,4,},{13,0,3,2,5,},{11,1,4,9,3,},{17,0,4,6,6,},{17,3,3,7,3,},{6,1,0,1,9,},{5,2,3,6,4,},{12,4,4,4,1,},
		{2,1,3,2,6,},{1,0,3,2,7,},{8,3,4,7,7,},{8,3,2,3,9,},{9,1,2,7,7,},{18,1,4,8,0,},{15,4,2,2,2,},{5,3,2,9,3,},{2,3,4,1,9,},{4,3,4,0,7,},
		{14,3,1,4,2,},{6,0,0,2,5,},{16,0,0,0,2,},{12,3,3,8,9,},{0,1,3,8,1,},{11,0,0,4,8,},{18,2,0,8,0,},{2,3,2,8,6,},{8,3,3,2,5,},{1,3,0,0,0,},
		{1,0,1,3,4,},{10,4,3,4,4,},{1,1,4,4,3,},{18,0,4,2,0,},{8,1,1,3,4,},{11,4,2,7,5,},{2,1,4,4,9,},{14,0,0,3,2,},{0,4,1,2,4,},{5,1,0,8,5,},
		{6,4,2,9,1,},{0,1,4,4,3,},{2,4,1,8,8,},{17,3,3,1,0,},{6,1,2,5,6,},{9,3,1,5,7,},{14,1,3,6,2,},{6,3,1,0,0,},{18,1,0,9,3,},{3,1,0,6,4,},
		{8,2,3,2,2,},{1,3,4,0,7,},{17,0,0,8,2,},{11,0,2,3,7,},{2,0,1,0,0,},{14,1,3,1,1,},{20,2,2,9,7,},{5,0,3,7,8,},{17,4,0,0,3,},{10,1,3,1,7,},
		{21,2,3,4,9,},{9,1,0,0,3,},{4,0,1,1,3,},{11,1,3,3,9,},{11,4,1,1,7,},{14,2,3,6,3,},{20,0,1,6,7,},{13,2,0,6,7,},{19,3,0,0,0,},{2,1,2,5,9,},
		{9,2,1,2,5,},{17,4,2,4,0,},{1,4,1,1,9,},{10,2,3,2,5,},{15,4,3,5,5,},{17,4,0,7,2,},{13,1,3,2,3,},{20,2,3,9,6,},{5,4,0,1,2,},{8,1,0,3,3,},
		{3,1,4,1,6,},{6,2,1,6,8,},{8,2,0,9,7,},{0,4,2,2,1,},{0,3,4,3,7,},{2,1,3,5,3,},{1,2,4,3,1,},{18,0,0,9,0,},{5,2,3,0,8,},{6,0,4,6,4,},
		{9,1,1,6,7,},{17,1,0,0,7,},{5,0,4,6,9,},{21,1,2,6,5,},{14,1,3,3,7,},{11,3,3,5,0,},{1,0,3,6,2,},{8,2,1,9,0,},{11,1,4,9,8,},{18,1,4,8,4,},
		{11,0,3,1,1,},{17,1,2,9,3,},{2,2,3,8,2,},{14,0,0,0,4,},{21,3,3,4,7,},{8,1,0,4,5,},{5,2,0,0,3,},{5,3,1,1,7,},{12,1,3,1,9,},{5,3,4,9,2,},
		{20,3,1,6,8,},{9,2,2,2,7,},{10,2,4,3,5,},{9,3,4,9,1,},{20,2,3,4,4,},{14,0,3,9,0,},{6,3,0,6,0,},{2,1,0,9,8,},{17,1,2,4,1,},{1,3,0,0,6,},
		{8,0,1,1,0,},{2,2,0,0,3,},{7,3,2,6,8,},{5,0,2,5,5,},{2,4,2,0,1,},{8,4,1,7,4,},{19,1,2,0,2,},{6,4,1,6,2,},{5,1,3,4,8,},{1,4,0,7,8,},
		{14,1,2,0,2,},{11,2,0,9,3,},{8,1,0,3,3,},{18,1,3,9,0,},{1,3,4,4,8,},{6,2,0,6,3,},{17,4,1,8,6,},{5,1,2,9,1,},{14,3,2,3,2,},{16,0,3,1,2,},
		{1,3,2,6,1,},{2,1,2,9,3,},{18,3,0,8,1,},{16,1,1,8,8,},{4,0,1,3,5,},{1,3,4,0,4,},{14,0,2,4,2,},{15,1,1,7,7,},{12,1,2,9,8,},{8,2,0,1,0,},
		{17,0,4,2,5,},{5,1,3,6,7,},{8,1,0,6,1,},{10,2,3,5,6,},{11,4,1,5,6,},{12,1,3,4,2,},{16,0,3,7,1,},{5,3,4,3,8,},{2,3,3,9,4,},{20,0,2,9,0,},
		{11,3,0,7,5,},{10,0,1,2,1,},{5,3,2,5,1,},{5,4,3,9,9,},{18,0,4,9,5,},{6,1,2,4,6,},{13,3,1,7,5,},{5,2,3,3,3,},{12,1,4,9,6,},{8,2,0,9,1,},
		{2,1,2,7,3,},{1,3,4,3,4,},{15,1,1,5,4,},{7,2,3,0,3,},{17,3,3,7,0,},{9,3,0,9,0,},{15,0,4,3,6,},{14,4,0,2,4,},{5,1,3,7,8,},{17,0,3,5,3,},
		{2,4,2,0,5,},{11,3,3,1,1,},{7,1,4,3,3,},{3,4,1,5,3,},{2,1,0,2,6,},{1,1,2,8,3,},{8,1,2,1,8,},{17,1,3,8,0,},{5,4,3,1,6,},{18,3,2,5,6,},
		{15,4,4,8,1,},{17,0,2,8,4,},{12,0,3,1,6,},{10,0,2,1,9,},{18,4,1,8,1,},{16,2,1,9,1,},{14,1,0,6,9,},{9,0,4,6,3,},{2,1,0,6,8,},{7,4,4,1,1,},
		{2,4,1,3,0,},{17,1,4,2,5,},{17,1,2,3,8,},{8,1,2,2,7,},{9,1,2,1,9,},{12,3,4,8,9,},{5,4,0,0,7,},{4,1,0,0,6,},{21,3,4,2,2,},{10,4,1,5,5,},




	};
	public static final int [][] input2 = new int[][]{
		{5,3,4,0,0,},{1,1,3,1,6,},{8,2,1,1,9,},{17,1,0,0,6,},{13,2,0,9,9,},{5,3,1,9,2,},{14,1,2,3,7,},{19,2,0,3,0,},{8,1,0,0,2,},{10,2,3,0,0,},
		{10,0,3,2,6,},{11,1,0,2,1,},{1,1,0,5,8,},{4,0,4,2,4,},{7,2,4,6,2,},{21,4,2,5,5,},{20,2,3,9,9,},{2,1,0,4,3,},{17,1,2,0,7,},{5,1,2,9,5,},
		{9,3,0,0,9,},{2,1,4,5,4,},{11,2,2,8,2,},{8,1,2,8,8,},{13,4,0,3,8,},{17,3,2,0,9,},{13,1,4,2,8,},{11,3,4,3,7,},{5,4,3,7,6,},{7,2,4,8,6,},
		{18,4,4,9,1,},{4,3,3,8,1,},{5,1,3,6,9,},{1,4,3,0,5,},{8,1,4,5,5,},{2,4,0,1,5,},{13,3,1,3,9,},{10,4,2,3,6,},{16,3,3,1,3,},{19,2,3,7,1,},
		{2,3,4,2,9,},{10,3,0,4,4,},{1,1,4,3,7,},{10,1,0,3,2,},{8,1,4,4,4,},{13,3,0,1,0,},{18,2,1,7,3,},{1,4,0,8,3,},{5,1,2,1,6,},{1,4,3,4,3,},
		{13,0,4,9,4,},{17,2,3,7,1,},{20,0,1,0,3,},{9,4,0,9,2,},{13,4,4,3,0,},{2,3,4,9,7,},{12,3,0,9,3,},{10,2,0,5,8,},{1,4,1,0,2,},{14,4,2,0,9,},
		{6,3,4,2,0,},{11,0,1,5,0,},{0,3,0,9,1,},{2,2,3,7,7,},{18,3,1,7,3,},{5,0,4,8,7,},{12,4,4,3,1,},{3,1,0,6,1,},{4,1,1,7,8,},{3,3,1,6,8,},
		{17,3,1,4,2,},{6,1,3,1,7,},{6,0,1,4,5,},{9,1,1,5,4,},{10,2,0,6,5,},{5,1,0,3,9,},{18,1,0,8,2,},{1,4,3,5,4,},{3,4,4,0,5,},{13,1,4,1,2,},
		{2,0,1,6,3,},{12,2,3,9,4,},{18,4,3,0,2,},{19,4,2,2,3,},{1,0,3,0,8,},{21,1,1,9,5,},{17,0,0,3,8,},{9,1,1,2,8,},{5,3,0,2,0,},{11,2,1,6,9,},
		{1,4,1,8,7,},{12,1,2,1,5,},{9,1,2,5,0,},{18,0,2,6,0,},{11,2,3,5,8,},{13,1,3,1,3,},{5,4,2,7,6,},{0,4,3,4,2,},{1,3,3,5,2,},{11,0,3,5,1,},
		{17,3,0,6,9,},{5,1,2,9,1,},{4,0,1,1,2,},{17,1,4,5,0,},{1,3,1,8,1,},{7,0,3,2,3,},{5,0,4,6,5,},{9,0,4,9,1,},{7,2,2,4,0,},{11,3,3,3,1,},
		{18,4,3,8,5,},{2,1,0,3,5,},{8,2,3,2,6,},{15,4,1,2,6,},{2,4,2,3,9,},{17,2,0,0,8,},{12,0,4,9,2,},{13,0,3,9,7,},{13,1,0,5,8,},{12,4,0,5,5,},
		{6,1,1,0,1,},{17,2,1,1,5,},{11,0,0,7,5,},{8,1,3,4,3,},{18,4,1,7,7,},{13,1,3,0,8,},{2,1,2,8,8,},{9,2,2,2,4,},{18,3,4,1,4,},{7,3,4,3,9,},
		{2,1,4,5,9,},{8,1,2,3,7,},{12,1,2,4,3,},{11,3,0,6,6,},{11,2,2,8,0,},{1,4,1,7,0,},{5,4,3,8,0,},{1,0,4,2,9,},{17,3,3,9,0,},{1,2,2,5,7,},
		{8,2,3,8,5,},{1,4,1,5,8,},{13,2,4,5,4,},{12,2,3,1,5,},{5,2,1,0,2,},{11,3,2,9,6,},{0,0,1,7,4,},{5,1,4,2,7,},{12,0,4,8,0,},{17,0,1,2,9,},
		{14,0,2,4,3,},{15,1,3,4,6,},{6,3,1,2,2,},{12,3,4,2,8,},{9,2,0,3,3,},{17,1,3,0,1,},{0,3,0,4,5,},{17,4,3,0,5,},{20,0,1,4,5,},{11,0,4,8,9,},
		{1,0,3,6,2,},{1,4,1,8,7,},{14,0,3,0,4,},{4,0,2,8,7,},{5,4,0,4,7,},{8,2,2,6,9,},{4,4,4,6,3,},{14,1,4,8,6,},{17,2,0,6,2,},{0,1,2,6,0,},
		{0,3,4,4,5,},{17,0,0,6,8,},{20,1,4,2,6,},{0,4,3,0,1,},{20,4,0,2,1,},{8,1,3,8,8,},{12,4,2,2,9,},{13,3,0,0,2,},{1,0,1,0,6,},{11,3,1,3,6,},
		{5,4,4,4,7,},{1,2,2,6,4,},{8,1,1,2,7,},{18,3,1,7,0,},{5,1,4,9,3,},{5,4,3,1,1,},{2,1,3,1,6,},{7,3,2,3,6,},{4,1,3,1,6,},{18,4,0,6,9,},
		{5,4,1,3,5,},{11,4,1,7,2,},{10,2,2,9,2,},{4,3,0,0,8,},{2,4,1,4,5,},{18,3,0,9,3,},{4,0,0,9,4,},{11,4,2,3,3,},{13,2,4,2,6,},{1,1,4,7,3,},
		{20,2,2,2,4,},{5,0,1,3,0,},{9,1,0,8,7,},{5,3,4,6,2,},{3,3,2,1,8,},{19,2,3,4,0,},{9,2,1,1,7,},{2,1,0,5,9,},{8,3,3,0,8,},{6,1,3,3,6,},
		{18,4,0,6,3,},{9,1,4,2,3,},{11,4,0,1,5,},{8,4,0,3,2,},{6,0,3,9,7,},{18,2,2,2,1,},{5,1,2,5,7,},{2,1,4,7,6,},{0,4,4,2,8,},{21,1,3,5,4,},
		{7,2,2,8,6,},{10,1,1,6,7,},{6,3,4,5,5,},{10,3,0,7,4,},{11,2,4,9,3,},{2,3,1,7,6,},{17,3,3,3,8,},{7,1,3,9,8,},{9,0,2,3,4,},{5,1,0,4,6,},
		{15,0,2,5,3,},{5,3,1,8,4,},{5,3,4,2,2,},{18,3,0,1,7,},{14,2,0,8,7,},{12,0,1,6,5,},{17,1,0,4,5,},{1,1,4,3,7,},{2,1,3,5,5,},{8,1,0,0,7,},
		{18,4,1,9,5,},{2,2,3,4,5,},{14,2,2,5,4,},{1,3,4,7,0,},{17,0,2,2,8,},{12,0,3,6,9,},{8,4,1,1,6,},{10,2,4,3,9,},{9,0,0,6,8,},{14,0,3,3,5,},
		{12,3,0,1,3,},{10,1,2,6,5,},{17,0,3,9,0,},{1,4,0,1,1,},{13,2,1,2,9,},{9,0,1,2,3,},{10,0,2,6,7,},{17,2,3,9,1,},{5,1,3,0,6,},{10,1,4,9,8,},
		{17,2,3,4,8,},{0,3,2,8,5,},{5,1,4,4,3,},{0,0,3,0,3,},{1,0,3,8,8,},{5,0,1,9,0,},{8,0,3,8,8,},{17,2,1,3,5,},{11,1,4,4,8,},{16,3,2,5,5,},
		{10,4,0,8,6,},{8,2,1,0,8,},{6,4,2,5,4,},{7,3,2,0,4,},{12,0,3,7,8,},{17,2,2,8,0,},{11,1,3,1,5,},{5,1,4,6,7,},{17,4,2,1,2,},{8,1,0,3,9,},
		{9,3,4,1,0,},{21,1,0,2,2,},{3,1,3,0,7,},{20,4,0,2,7,},{19,4,0,4,1,},{2,3,4,2,2,},{15,4,0,9,5,},{0,3,0,0,7,},{1,4,1,7,9,},{2,1,3,5,1,},
		{17,1,2,7,0,},{5,1,3,0,3,},{4,1,2,9,1,},{11,3,0,5,3,},{5,4,2,3,4,},{8,2,4,4,2,},{13,3,1,7,3,},{17,3,2,6,0,},{8,0,2,8,8,},{6,1,0,3,4,},
		{14,1,4,8,1,},{0,3,4,2,4,},{14,4,3,5,6,},{8,4,0,0,4,},{17,4,0,2,9,},{20,1,2,4,6,},{6,2,1,0,1,},{13,4,0,5,5,},{20,0,4,6,9,},{2,1,0,2,1,},
		{4,0,3,4,6,},{5,1,3,0,2,},{11,4,0,7,2,},{20,3,1,7,1,},{13,4,3,1,3,},{5,2,1,0,8,},{17,2,1,4,0,},{4,0,2,9,9,},{8,2,2,1,1,},{12,4,3,1,9,},
		{2,4,3,8,4,},{3,3,4,0,1,},{5,1,4,9,8,},{6,3,2,4,3,},{17,3,2,0,8,},{5,4,2,7,6,},{4,3,0,8,5,},{4,4,2,4,2,},{9,1,2,3,1,},{10,2,0,9,1,},
		{13,4,1,4,9,},{10,2,0,7,9,},{9,3,4,4,9,},{0,1,4,6,1,},{17,2,1,0,6,},{4,3,2,3,3,},{3,0,1,3,0,},{5,1,0,1,7,},{14,0,2,5,8,},{17,4,2,5,9,},
		{21,2,4,1,3,},{2,4,4,2,4,},{5,1,4,1,2,},{20,4,3,7,8,},{0,4,0,1,1,},{5,1,3,7,9,},{8,2,0,1,6,},{12,1,2,4,8,},{17,0,2,1,4,},{3,3,1,7,3,},
		{1,3,1,6,6,},{21,3,4,5,5,},{15,3,1,5,6,},{5,1,3,7,8,},{2,1,0,7,5,},{18,2,3,6,1,},{18,3,1,7,9,},{13,2,1,9,5,},{11,2,0,6,8,},{8,1,2,4,8,},
		{10,1,0,8,5,},{14,3,4,4,9,},{9,4,3,8,7,},{17,3,0,2,8,},{11,0,2,1,3,},{5,4,2,5,6,},{1,1,3,7,9,},{10,0,1,8,7,},{13,2,4,9,4,},{9,1,4,4,8,},
		{9,0,2,5,9,},{18,0,2,9,6,},{1,1,4,8,6,},{0,3,0,7,6,},{0,3,0,1,0,},{5,3,1,1,6,},{13,0,3,3,8,},{13,3,4,6,1,},{9,1,4,6,5,},{2,1,2,2,9,},
		{4,4,4,9,1,},{0,1,4,1,5,},{17,3,0,2,6,},{3,2,4,7,7,},{15,0,0,2,1,},{2,2,4,4,2,},{16,1,1,9,3,},{7,2,1,3,2,},{12,3,3,1,5,},{17,1,4,0,6,},
		{14,2,0,8,9,},{1,1,4,7,7,},{2,1,2,8,9,},{15,4,0,5,2,},{4,2,4,1,3,},{20,2,2,5,4,},{17,0,1,0,5,},{1,1,4,1,0,},{21,2,0,2,6,},{9,1,2,4,6,},
		{8,4,4,0,1,},{14,1,0,8,0,},{2,3,1,6,3,},{0,1,4,8,6,},{17,0,1,3,9,},{21,0,1,4,0,},{2,1,3,7,8,},{5,1,1,9,2,},{17,4,1,2,1,},{1,1,2,6,7,},
		{5,1,3,0,0,},{19,3,0,4,2,},{5,2,2,3,0,},{5,1,4,3,5,},{18,2,4,3,5,},{4,1,2,0,9,},{11,0,1,6,7,},{10,3,2,7,8,},{2,1,3,1,6,},{1,4,3,6,4,},
		{5,4,1,6,7,},{7,0,4,1,8,},{8,0,2,5,6,},{14,3,4,2,5,},{18,4,0,3,6,},{8,4,2,0,9,},{2,1,0,2,7,},{17,2,4,6,6,},{5,3,2,0,2,},{19,2,4,1,9,},
		{1,3,1,7,3,},{1,4,3,5,2,},{17,4,4,7,2,},{11,2,2,9,5,},{5,1,4,6,5,},{17,2,2,9,0,},{4,0,2,0,6,},{17,1,1,4,7,},{8,0,2,9,9,},{13,3,2,8,1,},
		{17,2,0,0,7,},{1,1,3,0,7,},{1,2,2,4,5,},{5,0,4,0,0,},{3,2,4,3,1,},{21,1,1,4,9,},{4,0,2,4,0,},{5,4,2,6,4,},{5,3,3,8,4,},{8,1,0,9,0,},
		{1,1,3,1,7,},{17,2,3,8,1,},{1,4,3,5,5,},{2,3,4,3,6,},{18,4,3,9,1,},{6,2,3,3,1,},{13,3,2,1,6,},{14,3,0,0,5,},{8,0,4,9,5,},{11,3,0,3,1,},
		{12,0,4,4,5,},{17,2,0,0,5,},{2,4,0,5,3,},{10,1,2,5,1,},{4,3,1,1,9,},{1,4,3,3,1,},{20,4,2,8,5,},{13,0,4,6,0,},{15,1,0,5,1,},{17,3,0,3,6,},
		{1,1,4,4,5,},{18,4,0,7,1,},{0,3,4,9,5,},{9,1,0,2,1,},{21,2,3,3,5,},{2,2,3,0,0,},{5,1,2,2,6,},{20,1,1,9,0,},{10,4,2,3,2,},{3,0,3,6,0,},
		{0,4,3,8,8,},{5,2,3,6,8,},{12,4,0,0,9,},{18,3,2,7,1,},{3,3,1,9,4,},{10,2,4,8,6,},{2,2,1,5,9,},{9,0,0,9,8,},{20,2,1,9,3,},{8,1,1,1,6,},
		{4,4,3,4,3,},{11,2,1,5,9,},{5,0,4,4,5,},{8,0,3,6,5,},{17,4,3,9,1,},{5,3,2,8,8,},{14,1,0,0,9,},{16,1,1,9,8,},{16,4,3,5,9,},{8,2,4,9,8,},
		{5,2,4,6,2,},{8,3,0,7,8,},{10,3,2,5,3,},{2,0,3,2,6,},{20,2,1,7,5,},{5,3,1,1,7,},{17,3,4,0,8,},{18,1,3,2,4,},{13,1,3,7,6,},{4,1,4,2,1,},
		{1,3,1,9,6,},{5,0,3,3,5,},{4,3,4,2,5,},{7,1,3,0,4,},{2,3,0,2,4,},{17,4,1,9,1,},{13,2,0,7,4,},{13,0,1,0,0,},{14,0,4,5,9,},{14,1,0,6,9,},
		{2,1,4,4,2,},{9,4,3,8,1,},{2,3,0,5,8,},{1,1,4,3,0,},{14,4,1,2,8,},{7,3,2,9,4,},{16,2,3,9,8,},{3,0,0,1,1,},{18,0,0,6,3,},{17,3,0,1,8,},
		{1,1,0,3,6,},{14,2,1,7,2,},{7,1,3,5,8,},{18,0,3,8,0,},{21,3,1,5,7,},{10,2,3,7,6,},{4,3,0,4,9,},{8,1,4,0,2,},{0,4,2,3,5,},{1,1,3,5,4,},
		{1,4,3,3,8,},{4,0,0,8,6,},{9,2,3,1,1,},{5,4,4,7,5,},{17,0,1,3,4,},{6,2,1,5,9,},{2,4,2,6,7,},{13,0,0,9,3,},{17,1,2,9,6,},{17,2,1,2,7,},
		{5,1,4,7,7,},{8,1,3,1,5,},{19,2,2,3,9,},{2,4,3,9,1,},{11,2,3,3,9,},{13,4,3,5,1,},{1,2,4,5,8,},{21,0,4,3,1,},{2,1,2,0,8,},{21,0,1,4,2,},
		{17,0,0,4,6,},{9,3,3,9,1,},{21,3,0,6,0,},{12,4,0,7,7,},{1,1,4,2,8,},{17,1,0,0,6,},{14,1,1,7,8,},{2,1,3,8,7,},{8,1,4,2,6,},{2,1,0,2,7,},
		{12,4,3,1,7,},{17,4,0,9,5,},{4,2,1,2,4,},{1,3,0,8,1,},{12,2,1,7,6,},{2,3,1,8,4,},{8,1,3,5,1,},{7,4,3,2,5,},{11,1,3,0,2,},{14,1,1,4,6,},
		{0,4,1,8,0,},{6,0,4,5,2,},{3,3,4,1,0,},{7,0,4,5,6,},{11,2,3,4,2,},{17,3,4,7,1,},{4,4,1,0,9,},{2,0,3,8,9,},{11,3,4,5,1,},{20,0,3,8,5,},
		{17,1,3,7,5,},{17,3,1,6,0,},{0,1,3,9,6,},{7,0,1,8,6,},{20,1,4,1,6,},{20,3,0,0,6,},{8,3,0,4,8,},{14,1,0,5,8,},{7,0,0,4,9,},{7,3,2,7,5,},
		{0,1,4,3,1,},{11,0,1,4,4,},{0,2,3,3,3,},{2,2,1,2,9,},{11,3,1,8,4,},{7,2,2,1,9,},{17,3,1,1,7,},{17,2,1,7,8,},{8,0,3,7,8,},{11,3,2,3,5,},
		{17,3,3,7,0,},{1,0,2,3,6,},{1,3,0,2,0,},{8,1,3,4,5,},{4,4,4,0,2,},{14,3,4,8,0,},{16,1,4,8,4,},{19,3,0,7,8,},{4,2,4,5,0,},{5,1,3,3,1,},
		{13,0,0,5,1,},{5,4,1,0,0,},{17,0,2,8,4,},{5,2,3,6,9,},{8,1,1,3,5,},{13,1,4,3,5,},{2,4,2,7,5,},{5,4,2,7,0,},{2,0,4,6,2,},{4,1,3,5,9,},
		{8,2,1,5,8,},{4,1,3,7,8,},{6,1,2,3,2,},{13,4,4,5,0,},{11,1,4,7,0,},{1,3,4,8,3,},{17,4,2,3,7,},{6,1,0,5,6,},{5,2,3,6,4,},{12,2,0,6,0,},
		{2,1,3,1,6,},{1,3,3,2,6,},{8,1,2,5,5,},{8,1,2,3,2,},{0,4,0,7,8,},{18,1,4,8,0,},{15,1,2,5,1,},{5,3,2,9,0,},{2,3,4,8,9,},{3,3,4,0,7,},
		{14,2,3,7,9,},{21,2,4,6,9,},{16,0,4,0,6,},{11,2,3,0,0,},{6,1,1,0,4,},{11,2,0,2,1,},{18,3,3,8,0,},{0,3,1,7,7,},{8,0,1,2,5,},{13,3,4,1,7,},
		{1,4,1,3,7,},{14,4,1,4,0,},{5,1,4,4,8,},{18,0,4,9,1,},{8,1,0,5,9,},{11,3,3,2,8,},{2,1,4,4,9,},{14,0,1,3,5,},{0,3,4,3,1,},{10,3,3,0,3,},
		{17,2,4,7,6,},{0,1,4,4,3,},{6,4,2,8,8,},{1,0,3,9,9,},{6,1,0,5,4,},{9,3,4,3,3,},{14,1,4,2,4,},{6,3,1,0,5,},{18,4,4,9,3,},{3,0,2,3,5,},
		{4,2,2,7,2,},{1,3,4,4,3,},{17,0,2,8,3,},{20,3,4,0,8,},{11,3,4,0,0,},{14,2,4,5,7,},{8,2,0,5,1,},{7,4,2,3,6,},{13,4,3,7,9,},{2,1,3,6,5,},
		{4,2,4,2,5,},{8,1,4,9,2,},{2,0,2,5,5,},{10,4,0,2,4,},{17,3,4,3,7,},{14,1,2,0,9,},{20,1,2,6,7,},{12,3,0,8,1,},{0,1,0,8,8,},{2,1,4,6,8,},
		{9,2,1,6,7,},{17,0,3,6,8,},{1,4,3,1,9,},{10,2,3,2,1,},{15,4,1,3,0,},{17,1,3,1,2,},{1,1,2,2,6,},{8,1,3,9,6,},{5,1,0,5,8,},{8,1,4,5,3,},
		{3,1,3,6,0,},{9,0,1,4,8,},{8,1,4,1,7,},{6,4,2,1,1,},{0,3,4,0,9,},{2,1,3,1,0,},{15,4,3,4,7,},{18,2,3,9,0,},{5,1,4,1,8,},{2,3,2,1,7,},
		{13,0,4,9,5,},{17,3,1,0,7,},{5,0,4,2,6,},{7,1,0,6,5,},{14,2,1,3,7,},{0,0,3,2,0,},{7,0,2,2,7,},{8,2,4,8,0,},{11,1,4,4,8,},{18,3,4,8,4,},
		{1,0,2,7,6,},{17,3,0,9,2,},{2,2,3,6,2,},{14,0,0,2,9,},{21,4,1,4,9,},{8,3,2,2,9,},{2,2,0,8,3,},{17,1,1,7,7,},{12,4,3,6,4,},{5,3,0,9,5,},
		{20,3,1,0,9,},{11,3,0,4,7,},{2,4,0,2,6,},{17,0,4,9,1,},{21,2,3,7,2,},{14,1,3,7,8,},{6,2,4,8,8,},{2,1,0,5,8,},{8,4,2,3,1,},{1,1,2,0,1,},
		{13,3,3,0,0,},{2,4,0,5,9,},{4,1,4,8,2,},{12,3,3,1,0,},{12,1,2,9,1,},{14,0,0,8,7,},{17,4,3,0,9,},{9,4,2,4,2,},{1,1,3,9,5,},{0,2,4,4,8,},
		{14,4,4,1,2,},{11,2,0,9,3,},{8,0,2,3,7,},{18,3,4,7,0,},{1,3,4,9,2,},{6,2,0,6,6,},{17,4,3,7,6,},{5,1,2,4,3,},{14,3,0,3,5,},{16,2,2,1,6,},
		{1,3,2,6,9,},{8,1,2,0,9,},{18,0,3,8,1,},{21,4,1,7,0,},{4,4,0,4,4,},{5,3,4,9,6,},{14,0,1,8,8,},{21,2,4,1,7,},{4,4,2,6,7,},{17,0,3,1,4,},
		{17,4,4,2,5,},{5,1,3,6,6,},{8,1,0,4,7,},{10,1,0,2,6,},{11,4,1,6,6,},{16,1,0,1,3,},{16,1,3,7,1,},{18,3,4,8,8,},{2,1,0,8,2,},{19,4,2,9,0,},
		{11,1,0,7,5,},{10,2,1,9,7,},{5,3,0,0,4,},{1,4,3,9,5,},{18,2,2,9,1,},{6,1,2,4,6,},{13,4,2,7,2,},{5,2,2,3,1,},{8,1,1,4,6,},{8,2,2,7,1,},
		{2,1,2,4,4,},{0,3,1,3,2,},{2,1,4,3,1,},{7,2,3,6,5,},{17,3,1,7,0,},{3,0,3,0,5,},{15,0,1,3,6,},{4,1,1,9,7,},{8,0,3,7,9,},{1,0,4,2,5,},
		{2,0,2,0,0,},{11,2,3,1,1,},{7,1,4,3,6,},{1,3,0,8,4,},{7,2,2,6,6,},{1,1,2,8,9,},{8,0,1,1,2,},{17,1,1,8,0,},{5,4,3,1,6,},{15,3,2,5,6,},
		{15,1,4,8,1,},{17,0,2,8,4,},{12,0,3,1,6,},{10,0,2,1,9,},{18,4,1,8,1,},{16,2,4,6,3,},{14,1,0,6,9,},{9,0,4,6,3,},{2,1,0,6,0,},{4,1,1,1,1,},
		{5,1,3,3,0,},{17,1,2,2,9,},{11,0,1,2,7,},{3,3,2,2,4,},{8,1,3,7,9,},{12,3,0,9,0,},{5,4,0,1,9,},{10,1,3,2,0,},{9,3,3,3,6,},{10,4,1,9,0,},



	};
	public static void main(String[] args) {
		double sum= 0,sumRem= 0, sumParam =0, max = 0, SMIIBA =0, IBASMI = 0, IBAIBA = 0, SMISMI = 0, SMI = 0, IBA = 0, insRemMax = 0, insRem=0;
		int [][] program1 = new int [10][];
		int [][] program2 = new int [10][];
		for (int i = 0; i < input1.length; i++) {
			program1[i%10] = input1[i];
			program2[i%10] = input2[i];
			if(i%10==9){
				sum +=hemmingDistance(program1, program2);
				sumRem +=hemmingDistanceRemGarbedge(program1, program2);
				sumParam += hemmingDistanceParam(program1, program2);
				max +=  hemmingDistanceMax(program1, program2);
				SMIIBA +=  hemmingDistanceSMIIBA(program1, program2);
				IBASMI +=  hemmingDistanceIBASMI(program1, program2);
				SMISMI +=  hemmingDistanceSMISMI(program1, program2);
				IBAIBA +=  hemmingDistanceIBAIBA(program1, program2);
				IBA+=  hemmingDistanceIBA(program1, program2);
				SMI +=  hemmingDistanceSMI(program1, program2);
				insRemMax +=  hemmingDistanceMAXI(program1, program2);
				insRem +=  hemmingDistanceI(program1, program2);
			}

		}
		//System.out.println(input1.length);
		System.out.println("Total: 		"+sum/(input1.length /10) + "	%: " +(sum/(input1.length /10))/50*100);
		System.out.println("TotalRem: 	"+sumRem/(input1.length /10) + "	%: " +(sumRem/(input1.length /10))/(max/(input1.length) /10));
		System.out.println("Parameter: 	" +sumParam/(input1.length /10) +"	%: " +(sumParam/(input1.length /10)*100)/((max/(input1.length) /10*100)-(insRemMax/(input1.length /10))));
		System.out.println("Instruction: 	" + (sumRem-sumParam)/(input1.length /10)+ "	%: " +(sumRem-sumParam)/(input1.length /10)/(insRemMax/(input1.length /10)) *100);
		System.out.println("IChecksum: 	" + (insRem)/(input1.length /10)+ "	%: " +(insRem)/(input1.length /10)/(insRemMax/(input1.length /10)) *100);
		System.out.println("SMI->IBA: 	" + (SMIIBA)/(input1.length /10));
		System.out.println("IBA->SMI: 	" + (IBASMI)/(input1.length /10));
		System.out.println("SMI->SMI: 	" + (SMISMI)/(input1.length /10));
		System.out.println("IBA->IBA: 	" + (IBAIBA)/(input1.length /10));
		System.out.println("Max: 		" + max/(input1.length /10));
		System.out.println("SMI: 		" + SMI/(input1.length /10));
		System.out.println("IBA: 		" + (insRemMax-SMI)/(input1.length /10));
		System.out.println("MaxI: 		" + insRemMax/(input1.length /10));
	}

	public static int hemmingDistance(int [][] a, int [][] b){

		int retur = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {

				if(a[i][j]!=b[i][j]){
					retur++;
				}
			}
		}
		return retur;
	}
	public static int hemmingDistanceRemGarbedge(int [][] a, int [][] b){
		boolean hasCHF = false, hasMove = false;
		int trimmedLength = a.length;
		for (int i = 0; i < a.length; i++) {
			if(a[i][0]==20||a[i][0]==21){
				hasCHF = true;
			}else if(a[i][0]==17||a[i][0]==18){
				hasMove = true;
			}
		}
		if((!hasCHF)&&(!hasMove)){
			trimmedLength = trimProgram(a);
		}
		int retur = 0;
		for (int i = 0; i < trimmedLength; i++) {
			for (int j = 0; j < a[i].length; j++) {

				if(!hasCHF){
					if(a[i][j]!=b[i][j]&&hasRelevance(a[i], b[i], j)){
						/*System.out.println(j+"("+a[i][0] +", " + a[i][1] +", " + a[i][2] +", " + a[i][3] +", " + a[i][4] + ")");
						System.out.println(j+"("+b[i][0] +", " + b[i][1] +", " + b[i][2] +", " + b[i][3] +", " + b[i][4] + ")");
						System.out.println(hasRelevance(a[i], b[i], j));*/
						retur++;
					}
				} else if(a[i][j]!=b[i][j]){
					retur++;
				}
			}
		}
		return retur;
	}
	private static int trimProgram(int [][] a){
		int retur = a.length;
		int ins = 0;
		for (int i = a.length-1; i >= 0; i--) {
			ins = a[i][0];
			if(ins<16&&ins!=14&&ins!=13&&ins!=12&&ins!=11){
				if((ins<10&&a[i][1]!=1)||ins==15){
					//System.out.println("("+a[i][0] +", " + a[i][1] +", " + a[i][2] +", " + a[i][3] +", " + a[i][4] + ")");
					retur--;
				}else if(ins==14&&a[i][1]!=1&&a[i][2]!=1){
					//System.out.println("("+a[i][0] +", " + a[i][1] +", " + a[i][2] +", " + a[i][3] +", " + a[i][4] + ")");
					retur--;
				}else{
					break;
				}
			}else{
				break;
			}
		}
		return retur;
	}
	public static int hemmingDistanceParam(int [][] a, int [][] b){
		boolean hasCHF = false, hasMove = false;
		int trimmedLength = a.length;
		for (int i = 0; i < a.length; i++) {
			if(a[i][0]==20||a[i][0]==21){
				hasCHF = true;
			}else if(a[i][0]==17||a[i][0]==18){
				hasMove = true;
			}
		}
		if((!hasCHF)&&(!hasMove)){
			trimmedLength = trimProgram(a);
		}
		int retur = 0;
		for (int i = 0; i < trimmedLength; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if(j!=0){
					if(!hasCHF){
						if(a[i][j]!=b[i][j]&&hasRelevance(a[i], b[i], j)){
						retur++;
						}
					}else if(a[i][j]!=b[i][j]){
						retur++;
					}
				}
			}
		}
		return retur;
	}
	public static int hemmingDistanceMax(int [][] a, int [][] b){
		boolean hasCHF = false, hasMove = false;
		int trimmedLength = a.length;
		for (int i = 0; i < a.length; i++) {
			if(a[i][0]==20||a[i][0]==21){
				hasCHF = true;
			}else if(a[i][0]==17||a[i][0]==18){
				hasMove = true;
			}
		}
		if((!hasCHF)&&(!hasMove)){
			trimmedLength = trimProgram(a);
		}
		int retur = 0;
		for (int i = 0; i < trimmedLength; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if(hasRelevance(a[i], b[i], j)&&!hasCHF){
					retur++;
				} else if(hasCHF){
					retur++;
				}
			}
		}
		return retur;
	}
	public static int hemmingDistanceSMIIBA(int [][] a, int [][] b){
		int retur = 0;
		for (int i = 0; i < a.length; i++) {
			if(a[i][0]>=16&&b[i][0]<16&& a[i][0]!=b[i][0]){
				retur++;
			} else{
			}
		}
		return retur;
	}
	public static int hemmingDistanceI(int [][] a, int [][] b){
		int retur = 0;
		for (int i = 0; i < a.length; i++) {
			if(a[i][0]!=b[i][0]){
				retur++;
			} else{
			}
		}
		return retur;
	}
	public static int hemmingDistanceIBASMI(int [][] a, int [][] b){
		int retur = 0;
		for (int i = 0; i < a.length; i++) {
			if(a[i][0]<16&&b[i][0]>=16&& a[i][0]!=b[i][0]){
				retur++;
			} else{
			}
		}
		return retur;
	}
	public static int hemmingDistanceSMISMI(int [][] a, int [][] b){
		int retur = 0;
		for (int i = 0; i < a.length; i++) {
			if(a[i][0]>=16&&b[i][0]>=16&& a[i][0]!=b[i][0]){
				retur++;
			} else{
			}
		}
		return retur;
	}
	public static int hemmingDistanceIBAIBA(int [][] a, int [][] b){
		int retur = 0;
		for (int i = 0; i < a.length; i++) {
			if(a[i][0]<16&&b[i][0]<16&& a[i][0]!=b[i][0]){
				retur++;
			} else{
			}
		}
		return retur;
	}

	public static int hemmingDistanceIBA(int [][] a, int [][] b){
		int retur = 0;
		for (int i = 0; i < a.length; i++) {
			if(a[i][0]<16){
				retur++;
			} else{
			}
		}
		return retur;
	}
	public static int hemmingDistanceSMI(int [][] a, int [][] b){
		int retur = 0;
		for (int i = 0; i < a.length; i++) {
			if(a[i][0]>=16){
				retur++;
			} else{
			}
		}
		return retur;
	}
	public static int hemmingDistanceMAXI(int [][] a, int [][] b){
		boolean hasCHF = false, hasMove = false;
		int trimmedLength = a.length;
		for (int i = 0; i < a.length; i++) {
			if(a[i][0]==20||a[i][0]==21){
				hasCHF = true;
			}else if(a[i][0]==17||a[i][0]==18){
				hasMove = true;
			}
		}
		if((!hasCHF)&&(!hasMove)){
			trimmedLength = trimProgram(a);
		}
		int retur = 0;
		for (int i = 0; i < trimmedLength; i++) {
			retur++;
		}
		return retur;
	}

	public static boolean hasRelevance(int [] a, int [] b, int param){
		switch (a[0]) {
		case 0:
		case 1:
		case 2:
			if(param==3||param==4){
				return false;
			}
			break;
		case 3:
		case 4:
			if(param==2||param==3||param==4){
				return false;
			}
			break;
		case 5:
		case 6:
			if(param==3||param==4){
				return false;
			}
			break;
		case 7:
			if(param==3||param==4){
				return false;
			}
			break;
		case 8:
		case 9:
			if(param==2||param==3||param==4){
				return false;
			}
			break;
		case 10:
			if(param==3||param==4){
				return false;
			}
			break;
		case 11:
		case 12:
		case 13:
		case 14:
		case 15:
			if(param==1||param==2||param==3||param==4){
				return false;
			}
			break;
		case 16:
			if(param==2||param==3||param==4){
				return false;
			}
			break;
		case 17:
		case 18:
			if(param==1||param==2){
				return false;
			}
			break;
		case 19:
			if(param==1||param==2||param==4){
				return false;
			}
			break;
		case 20:
		case 21:


			break;
		}
		return true;
	}
}
