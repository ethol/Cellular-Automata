package extra;

public class CountInstructions {
	public static final int[][] set = new int [][]{
		{19,3,4,6,7,},{14,0,3,7,9,},{5,3,2,7,8,},{5,1,4,7,1,},{8,3,0,6,5,},{4,0,3,1,1,},{18,1,0,8,2,},{11,4,3,7,5,},{14,4,1,9,6,},{5,1,4,4,9,},
		{8,4,4,3,3,},{8,3,3,8,5,},{0,2,4,8,9,},{17,3,3,3,4,},{7,0,1,8,7,},{18,3,1,9,2,},{2,1,4,9,8,},{1,2,3,1,7,},{8,3,1,0,8,},{2,1,2,2,4,},
		{1,4,1,3,2,},{11,4,3,6,7,},{14,1,0,3,9,},{3,0,2,0,9,},{2,0,2,2,4,},{11,4,1,7,4,},{2,0,1,5,1,},{14,1,4,7,0,},{4,1,4,8,2,},{17,1,2,7,3,},
		{5,4,1,1,1,},{1,3,2,4,0,},{8,1,0,8,9,},{18,0,3,9,0,},{1,0,3,0,0,},{1,4,3,6,6,},{6,1,4,8,7,},{0,4,4,7,5,},{6,1,4,9,7,},{10,2,4,8,0,},
		{5,3,2,2,7,},{9,3,4,5,5,},{2,4,1,4,7,},{16,2,3,6,0,},{10,4,3,8,8,},{3,4,3,4,6,},{11,0,0,6,8,},{2,3,4,4,0,},{17,3,2,4,0,},{14,4,4,2,2,},
		{15,4,2,3,3,},{2,3,2,3,3,},{13,2,0,3,6,},{4,0,0,3,8,},{21,1,0,8,3,},{5,1,4,3,8,},{5,1,3,3,8,},{17,1,3,5,1,},{9,0,0,9,8,},{8,1,3,9,5,},
		{8,0,0,5,4,},{6,3,3,5,2,},{8,3,1,5,6,},{10,0,1,5,1,},{1,1,0,2,8,},{0,4,2,2,4,},{13,3,1,7,9,},{0,2,3,4,3,},{10,2,1,8,3,},{17,3,1,2,8,},
		{2,0,4,1,1,},{17,3,4,8,1,},{10,0,1,6,4,},{5,1,4,0,9,},{4,3,0,5,0,},{8,2,3,6,6,},{2,2,1,0,7,},{17,0,2,9,7,},{12,4,2,2,5,},{10,2,2,4,2,},
		{4,0,0,0,7,},{11,0,3,3,9,},{5,1,4,1,6,},{14,2,4,9,9,},{5,1,2,2,3,},{9,1,3,5,1,},{2,4,0,6,9,},{5,2,4,9,6,},{5,1,4,6,5,},{17,4,4,2,8,},
		{17,0,2,2,6,},{9,1,2,7,4,},{1,2,2,7,0,},{3,1,1,7,9,},{0,1,2,8,6,},{5,3,4,6,8,},{17,2,1,7,5,},{5,2,2,1,0,},{2,1,3,4,7,},{10,2,2,7,8,},
		{15,2,2,5,1,},{10,0,3,8,6,},{17,3,3,5,8,},{17,4,2,8,1,},{3,1,3,5,4,},{2,1,3,5,7,},{1,2,3,7,1,},{2,1,2,3,6,},{4,3,1,4,5,},{2,1,4,0,7,},
		{0,4,1,4,4,},{10,4,2,8,5,},{8,0,2,7,2,},{6,3,1,5,4,},{12,0,4,5,4,},{18,1,4,9,3,},{2,1,2,0,5,},{15,2,1,2,7,},{5,4,2,3,9,},{13,3,0,6,3,},
		{1,2,0,4,0,},{18,1,1,4,3,},{15,0,1,8,0,},{5,2,3,4,0,},{12,4,2,8,0,},{8,1,0,1,2,},{18,0,0,1,6,},{15,3,4,4,2,},{2,1,2,9,2,},{5,0,0,5,4,},
		{13,3,4,6,7,},{5,4,1,3,3,},{1,1,4,6,2,},{9,1,0,1,4,},{2,4,0,5,0,},{17,3,0,0,4,},{1,0,3,2,6,},{15,4,1,4,4,},{1,4,3,2,4,},{17,3,4,7,3,},
		{10,1,2,5,9,},{1,2,4,9,9,},{9,1,0,0,4,},{18,0,0,6,0,},{19,0,1,7,2,},{1,1,3,9,1,},{2,2,4,6,5,},{5,3,0,7,3,},{12,2,4,4,3,},{15,1,1,5,2,},
		{2,1,4,6,7,},{18,1,4,8,2,},{0,3,4,2,2,},{2,4,3,6,0,},{4,2,1,6,9,},{17,3,1,6,8,},{2,1,2,6,0,},{13,2,2,4,2,},{2,2,1,4,9,},{2,3,2,9,9,},
		{13,4,0,2,7,},{6,4,0,6,0,},{1,2,0,7,6,},{0,3,1,3,0,},{2,2,0,4,8,},{1,3,2,0,0,},{3,2,0,1,5,},{14,0,0,0,9,},{8,1,0,0,0,},{8,3,0,9,1,},
		{8,0,4,0,0,},{8,1,3,6,9,},{6,3,0,0,2,},{0,0,2,3,6,},{8,3,3,6,7,},{2,1,0,0,9,},{14,0,1,1,3,},{8,0,2,9,8,},{0,2,2,8,3,},{5,1,4,3,1,},
		{17,3,4,3,8,},{9,2,2,2,3,},{3,0,0,9,0,},{1,1,3,9,9,},{15,2,4,2,4,},{6,4,4,0,7,},{5,0,1,0,7,},{9,4,3,6,3,},{9,1,1,5,1,},{2,1,0,2,2,},
		{4,2,2,7,0,},{2,1,2,4,2,},{9,2,2,0,3,},{17,2,2,1,7,},{16,4,0,0,1,},{2,1,2,9,6,},{11,3,2,9,2,},{11,2,3,7,6,},{0,1,4,5,1,},{9,1,0,0,3,},
		{6,0,4,5,8,},{12,4,2,1,6,},{1,3,1,8,5,},{14,4,1,2,2,},{17,1,1,3,5,},{8,1,0,7,3,},{2,0,4,6,1,},{11,0,3,1,6,},{0,4,1,8,3,},{17,0,2,6,0,},
		{5,1,4,1,8,},{12,3,4,4,6,},{1,0,3,7,2,},{4,2,0,1,1,},{8,2,0,4,2,},{1,0,1,7,2,},{12,3,0,9,8,},{2,2,0,7,2,},{12,1,4,4,5,},{17,2,4,7,3,},
		{8,1,3,3,5,},{9,0,4,1,7,},{2,1,4,6,2,},{2,2,2,0,5,},{5,3,0,1,2,},{2,1,3,6,5,},{5,3,1,7,4,},{2,3,4,9,5,},{5,0,3,2,3,},{11,2,2,4,7,},
		{1,1,3,7,2,},{8,0,1,6,6,},{2,2,3,7,8,},{2,2,1,3,0,},{5,1,2,1,7,},{1,4,0,5,5,},{10,2,4,1,8,},{3,1,1,0,4,},{18,4,2,8,2,},{12,3,0,8,4,},
		{3,2,4,5,0,},{17,2,0,0,9,},{5,3,2,4,8,},{16,0,1,6,5,},{12,3,1,4,8,},{5,3,4,8,2,},{11,1,3,3,5,},{8,3,1,2,2,},{2,1,4,7,4,},{2,1,3,5,2,},
		{1,1,4,7,0,},{17,1,4,1,3,},{12,2,0,6,0,},{2,1,0,1,5,},{17,3,0,8,0,},{14,2,2,5,1,},{5,1,3,1,2,},{9,0,4,8,6,},{1,2,4,2,9,},{3,0,4,6,7,},
		{12,1,2,3,5,},{4,3,4,0,5,},{17,1,0,7,1,},{5,3,1,2,7,},{2,0,4,8,2,},{9,4,0,0,4,},{8,0,4,3,4,},{2,0,3,6,1,},{0,2,3,5,1,},{10,0,1,0,0,},
		{13,3,3,1,6,},{12,1,2,6,8,},{8,0,3,3,3,},{0,1,3,1,8,},{13,1,0,8,4,},{18,3,1,8,2,},{14,2,4,9,9,},{11,4,0,1,0,},{6,1,4,0,1,},{1,1,3,9,7,},
		{8,2,3,6,7,},{21,4,3,7,2,},{6,3,2,9,2,},{2,1,3,0,2,},{15,3,4,5,2,},{1,1,4,8,2,},{9,1,2,5,2,},{15,4,4,3,2,},{17,1,0,8,2,},{21,0,4,5,1,},
		{4,0,2,8,0,},{7,3,2,2,0,},{2,1,4,0,9,},{8,1,2,9,4,},{3,0,2,5,3,},{17,1,4,6,9,},{6,2,0,1,5,},{2,1,3,1,0,},{17,1,3,0,7,},{5,1,2,8,8,},
		{5,1,3,9,8,},{4,0,0,8,9,},{18,1,4,7,9,},{15,4,0,3,0,},{1,2,0,6,8,},{5,2,3,4,0,},{8,2,1,4,7,},{19,4,0,8,5,},{12,0,3,2,8,},{2,1,2,3,5,},
		{1,0,4,9,8,},{18,1,0,7,3,},{12,2,1,3,0,},{13,3,2,8,2,},{0,4,3,8,0,},{5,2,0,4,3,},{12,3,0,9,1,},{9,1,3,4,3,},{9,1,1,4,2,},{3,1,4,8,5,},
		{13,1,4,0,6,},{5,4,3,8,6,},{6,3,2,6,2,},{12,1,1,8,7,},{16,1,1,6,4,},{3,1,3,3,3,},{1,4,1,9,2,},{17,2,3,4,0,},{8,4,3,1,4,},{13,1,4,8,7,},
		{8,2,3,2,0,},{6,2,4,8,9,},{7,3,2,5,3,},{17,4,3,5,1,},{3,3,3,8,7,},{2,4,3,9,5,},{8,1,2,7,4,},{2,1,4,4,6,},{16,4,1,6,0,},{5,3,0,4,2,},
		{9,1,2,1,3,},{0,0,1,0,2,},{20,1,4,3,3,},{10,2,4,2,4,},{17,4,1,7,3,},{5,3,4,7,5,},{4,0,0,9,3,},{11,0,3,3,9,},{9,3,3,5,2,},{1,1,3,3,0,},
		{0,3,1,4,1,},{2,0,3,8,2,},{9,2,3,3,0,},{11,0,4,9,6,},{16,2,4,0,8,},{15,1,2,9,8,},{8,0,4,9,8,},{5,0,3,9,6,},{6,1,0,0,8,},{17,2,0,9,3,},
		{2,1,4,6,9,},{4,3,0,9,9,},{17,1,0,1,5,},{10,2,0,8,3,},{1,4,2,8,5,},{3,3,4,3,2,},{2,1,3,8,3,},{0,3,1,1,6,},{9,2,0,3,1,},{18,2,4,8,0,},
		{1,1,3,3,8,},{5,1,2,3,1,},{1,2,4,0,7,},{17,1,4,9,1,},{17,1,1,3,5,},{9,2,2,1,6,},{3,1,0,3,3,},{9,1,0,8,3,},{4,4,0,1,3,},{7,3,4,4,8,},
		{17,2,0,8,2,},{1,3,4,8,0,},{5,1,3,8,9,},{10,2,3,8,2,},{1,3,3,4,8,},{16,3,1,9,7,},{8,3,4,2,4,},{5,0,4,9,0,},{5,1,0,9,9,},{16,2,3,2,2,},
		{17,1,0,1,9,},{17,0,1,4,0,},{9,2,1,8,2,},{14,1,2,0,1,},{2,1,0,6,9,},{5,3,4,9,1,},{1,3,4,0,2,},{2,1,0,8,3,},{12,3,2,0,3,},{10,4,2,9,0,},
		{1,4,1,3,1,},{4,1,2,8,4,},{11,1,4,3,5,},{8,0,2,1,9,},{9,2,2,9,7,},{1,1,4,5,5,},{0,2,0,9,2,},{2,0,2,8,7,},{11,3,0,5,0,},{17,1,0,6,2,},
		{1,1,4,7,1,},{6,4,2,9,4,},{10,4,1,6,5,},{13,4,3,0,8,},{0,2,3,3,6,},{11,1,4,7,5,},{15,2,2,6,5,},{8,1,1,2,5,},{1,1,0,7,8,},{17,1,3,9,3,},
		{6,1,2,8,1,},{0,1,0,3,6,},{0,3,1,0,1,},{3,3,2,0,2,},{6,1,2,5,9,},{4,0,4,9,0,},{17,3,0,8,4,},{4,1,0,4,1,},{12,1,2,8,3,},{2,1,3,7,6,},
		{14,2,4,8,5,},{8,0,3,2,1,},{3,0,4,0,2,},{2,1,0,9,4,},{18,3,4,6,0,},{1,3,4,7,9,},{10,3,0,0,3,},{11,3,4,0,5,},{21,0,0,1,4,},{10,0,4,9,0,},
		{0,3,4,0,6,},{2,0,3,4,5,},{9,0,1,6,2,},{11,3,2,6,8,},{1,2,1,5,4,},{13,2,4,2,3,},{17,2,2,0,7,},{2,1,2,9,2,},{0,4,3,7,4,},{17,4,2,7,9,},
		{6,3,0,0,2,},{1,1,4,7,7,},{8,1,1,5,8,},{1,3,1,6,6,},{14,1,1,0,1,},{18,3,3,6,2,},{7,3,2,4,5,},{6,4,0,7,5,},{15,0,4,5,2,},{18,1,3,6,7,},
		{5,0,1,6,1,},{2,2,0,2,4,},{1,1,4,6,5,},{21,0,3,7,9,},{5,1,3,9,0,},{3,4,2,4,7,},{5,1,0,1,4,},{9,1,1,0,9,},{5,2,1,2,8,},{12,0,4,4,6,},
		{17,4,4,3,7,},{0,4,1,3,8,},{0,3,4,2,8,},{3,1,3,1,8,},{13,1,0,4,4,},{8,1,0,8,6,},{2,1,3,1,3,},{7,1,2,0,3,},{3,2,0,1,0,},{1,3,1,5,6,},
		{6,4,3,9,7,},{11,2,4,7,8,},{9,0,2,0,8,},{18,1,1,8,4,},{9,3,3,2,2,},{7,1,3,3,0,},{12,2,1,9,3,},{0,2,4,8,2,},{5,2,0,9,4,},{3,2,2,4,9,},
		{5,1,3,1,2,},{9,1,2,1,0,},{14,4,2,9,6,},{17,0,3,3,6,},{13,4,1,2,8,},{5,0,4,9,5,},{5,1,0,2,1,},{0,1,1,8,6,},{17,0,4,2,5,},{9,2,1,4,2,},
		{18,4,3,2,9,},{21,3,3,3,2,},{5,1,3,4,0,},{5,4,2,2,0,},{13,3,0,2,4,},{19,0,2,4,1,},{9,3,2,4,3,},{8,1,2,2,9,},{4,0,0,8,5,},{5,1,0,4,0,},
		{3,0,0,1,0,},{10,0,1,2,0,},{5,0,3,0,9,},{5,2,1,2,0,},{1,1,2,1,3,},{9,0,3,7,5,},{8,1,3,2,9,},{1,0,1,2,4,},{3,1,4,4,6,},{11,4,2,6,7,},
		{11,4,2,3,7,},{12,4,1,9,5,},{5,3,1,5,3,},{5,3,0,9,9,},{10,1,2,5,0,},{17,3,1,8,4,},{12,1,4,2,5,},{14,3,3,2,2,},{1,1,3,3,0,},{8,1,0,4,0,},
		{17,4,3,3,7,},{3,1,0,7,8,},{0,2,4,8,9,},{14,2,3,0,2,},{8,2,1,5,6,},{2,1,4,3,3,},{18,3,2,3,9,},{12,1,3,2,2,},{2,1,0,4,9,},{10,3,4,3,6,},
		{5,4,3,1,1,},{5,3,0,2,8,},{2,1,0,2,4,},{1,0,4,1,7,},{17,2,3,3,7,},{13,0,4,2,0,},{6,3,0,5,7,},{7,0,4,8,0,},{9,1,1,1,0,},{5,1,3,9,0,},
		{8,0,4,7,3,},{5,3,1,8,3,},{13,2,0,3,2,},{5,1,4,7,3,},{18,2,3,9,2,},{0,3,1,2,7,},{10,3,0,6,0,},{4,4,3,9,6,},{5,1,2,1,8,},{0,4,2,0,9,},
		{19,1,4,6,0,},{12,1,3,0,2,},{10,1,3,0,9,},{21,1,1,5,6,},{4,1,2,0,0,},{17,1,4,0,6,},{9,1,0,2,6,},{18,1,4,0,5,},{8,4,1,3,8,},{2,1,0,0,8,},
		{13,3,0,5,4,},{18,1,3,9,3,},{0,1,3,2,2,},{3,1,1,8,8,},{8,2,2,8,6,},{10,1,3,7,4,},{6,2,3,1,0,},{13,4,0,1,6,},{5,1,4,4,8,},{12,1,0,5,5,},
		{3,0,3,0,1,},{5,3,4,2,6,},{8,3,2,6,8,},{6,2,1,0,0,},{12,2,1,3,8,},{14,1,4,4,0,},{1,2,4,0,4,},{8,2,0,2,4,},{1,2,2,7,1,},{1,1,2,1,3,},
		{8,4,0,9,2,},{17,2,3,5,7,},{10,1,2,4,0,},{2,3,4,0,2,},{11,2,1,3,7,},{11,3,0,7,3,},{5,3,0,4,8,},{17,2,2,8,2,},{2,3,1,2,5,},{14,4,2,9,6,},
		{18,2,3,9,0,},{0,3,3,9,2,},{5,1,2,9,4,},{8,3,3,9,9,},{1,4,3,0,0,},{7,0,4,9,0,},{3,2,3,9,5,},{12,2,3,6,7,},{0,1,4,9,7,},{5,1,0,7,8,},
		{5,3,1,2,3,},{12,0,1,9,4,},{6,4,4,7,6,},{1,1,3,9,3,},{14,0,1,0,9,},{2,0,2,7,5,},{17,4,4,8,2,},{11,1,3,8,6,},{8,1,2,8,4,},{15,2,3,9,4,},
		{6,1,4,8,4,},{8,1,1,9,3,},{2,4,2,7,3,},{1,2,2,3,8,},{0,2,4,0,5,},{15,4,2,0,9,},{1,1,2,9,9,},{3,4,2,3,7,},{18,4,0,1,8,},{13,2,1,1,7,},
		{8,0,2,5,7,},{1,1,3,7,4,},{3,4,2,7,8,},{6,1,0,6,8,},{8,1,3,4,4,},{17,4,4,2,3,},{0,0,2,7,6,},{8,3,1,7,8,},{5,1,0,2,7,},{17,0,0,5,9,},
		{18,2,0,9,5,},{1,1,4,1,2,},{0,3,3,6,6,},{2,3,0,8,6,},{17,4,2,9,7,},{1,1,2,8,7,},{16,2,1,0,2,},{1,1,3,2,6,},{8,1,1,1,2,},{9,1,3,6,0,},
		{5,3,1,7,4,},{5,0,3,3,3,},{12,0,2,5,3,},{18,4,0,6,9,},{1,3,2,8,4,},{9,3,4,1,4,},{13,0,3,4,8,},{5,1,0,6,1,},{8,1,2,0,9,},{8,1,3,7,5,},
		{1,3,1,8,2,},{4,0,4,6,3,},{2,3,0,2,1,},{13,3,0,3,5,},{4,3,4,1,6,},{17,2,2,1,7,},{13,1,0,8,4,},{9,1,4,8,2,},{8,0,2,2,8,},{4,1,4,5,3,},
		{12,3,0,6,8,},{4,0,4,0,0,},{10,4,0,3,4,},{1,0,4,1,8,},{17,4,0,9,0,},{11,3,2,4,1,},{0,4,3,1,2,},{9,2,2,5,0,},{10,2,4,4,7,},{9,1,3,1,7,},
		{19,0,3,7,0,},{1,4,2,7,6,},{1,4,3,8,4,},{17,4,1,5,0,},{19,1,0,4,0,},{5,1,4,8,5,},{1,1,0,2,5,},{18,0,0,3,8,},{5,0,1,7,2,},{8,1,2,6,8,},
		{0,3,2,5,5,},{2,1,4,8,8,},{17,0,1,9,0,},{2,1,3,4,8,},{8,1,1,4,8,},{9,2,4,6,4,},{5,2,3,3,6,},{16,3,0,3,1,},{2,4,1,3,6,},{5,4,1,2,9,},
		{6,1,2,7,9,},{6,1,3,4,4,},{0,3,0,1,9,},{0,0,1,5,7,},{0,4,1,1,1,},{10,2,2,9,2,},{0,3,3,1,1,},{17,3,4,5,1,},{8,1,3,0,3,},{2,1,2,1,8,},
		{13,3,1,3,4,},{10,1,0,1,8,},{6,2,3,5,8,},{5,3,0,4,6,},{12,0,0,5,2,},{5,0,3,8,3,},{8,3,2,5,8,},{14,4,0,9,7,},{0,4,3,5,4,},{17,2,0,0,9,},
		{5,1,3,0,0,},{18,1,1,4,5,},{5,3,0,6,0,},{5,2,0,2,6,},{10,1,3,7,5,},{1,4,2,7,6,},{13,0,1,1,9,},{8,1,0,0,6,},{18,2,3,6,4,},{1,1,0,3,0,},
		{9,2,3,1,4,},{18,4,3,8,4,},{13,3,4,0,5,},{2,1,4,8,0,},{9,3,0,1,4,},{2,3,1,6,5,},{6,1,2,5,3,},{5,2,0,5,9,},{14,1,1,0,7,},{9,1,3,7,7,},
		{17,4,1,0,4,},{11,4,1,2,8,},{18,1,1,2,9,},{9,1,1,4,1,},{3,2,1,3,8,},{6,2,3,8,9,},{1,1,0,2,5,},{21,2,0,6,4,},{7,0,2,1,3,},{2,1,0,2,0,},
		{3,3,4,9,5,},{18,2,4,8,1,},{9,3,0,1,4,},{9,0,4,6,9,},{6,0,3,5,1,},{5,4,0,3,1,},{2,0,2,3,9,},{9,0,2,9,4,},{5,1,4,8,4,},{11,2,4,2,7,},
		{5,2,3,3,8,},{8,4,2,8,0,},{18,3,2,6,0,},{9,2,1,7,2,},{12,4,4,4,4,},{1,0,3,8,6,},{11,2,2,2,4,},{12,2,4,3,3,},{2,1,4,8,6,},{10,4,3,8,1,},



	};
	public static void main(String[] args) {
		boolean [] temp = new boolean [22];
		int [] used = new int [22];
		int SM = 0;
		for (int i = 0; i < set.length; i++) {
			temp[set[i][0]] = true;
			if(i%10 == 9){// set to instruction length (should also work for SM since they all start with the same number of ins.)
				for (int j = 16; j < temp.length; j++) {
					if(temp[j]==true){
						SM++;
						break;
					}
				}
				for (int j = 0; j < temp.length; j++) {
					if(temp[j]){
						used[j]++;
						temp[j] = false;
					}
				}
			}
			
		}
		
		
		for (int i = 0; i < used.length; i++) {
			System.out.println(i +""+  '	' + " " + used[i] );
		}
		System.out.println(SM + " of the solutions used atleast 1 SM instructions");

	}

}