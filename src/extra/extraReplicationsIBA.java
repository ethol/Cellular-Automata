package extra;

import java.util.ArrayList;

import CA.CAIBA;
import CA.CAIBASM;

public class extraReplicationsIBA {
	final static byte[][][] kandidates = new byte[][][]{
		{	{11,1,3,},{12,3,0,},{1,1,1,},{12,0,2,},{2,3,0,},{2,1,1,},{6,1,4,},{11,2,3,},{2,3,4,},{14,0,2,},	},
		{	{2,3,1,},{2,3,4,},{1,4,2,},{13,0,3,},{2,1,3,},{4,0,3,},{5,3,3,},{10,4,4,},{12,2,4,},{13,4,2,},	},
		{	{2,0,3,},{2,3,4,},{6,2,0,},{2,3,1,},{11,2,1,},{14,2,0,},{4,0,0,},{10,0,2,},{8,2,1,},{2,4,1,},	},
		{	{15,1,2,},{2,4,3,},{8,2,0,},{14,0,1,},{15,3,0,},{15,1,0,},{13,3,1,},{10,0,4,},{2,1,0,},{3,2,3,},	},
		{	{15,2,2,},{0,2,0,},{2,3,1,},{2,4,3,},{4,1,4,},{5,0,4,},{15,1,1,},{13,3,1,},{4,4,2,},{9,3,4,},	},
		{	{10,1,2,},{2,3,2,},{15,3,2,},{6,1,1,},{12,1,4,},{11,2,2,},{7,0,3,},{2,4,0,},{7,4,4,},{13,0,2,},	},
		{	{15,0,0,},{2,1,3,},{0,0,4,},{4,0,0,},{8,3,1,},{3,2,0,},{2,4,1,},{12,4,3,},{12,2,0,},{13,1,2,},	},
		{	{2,4,3,},{10,4,4,},{2,1,4,},{6,3,0,},{15,0,0,},{1,2,0,},{7,0,1,},{8,0,0,},{3,4,4,},{0,0,3,},	},
		{	{8,4,4,},{2,3,1,},{12,0,4,},{9,0,4,},{13,3,3,},{14,0,3,},{7,2,3,},{9,4,0,},{2,3,4,},{10,3,1,},	},
		{	{15,2,1,},{2,4,3,},{11,3,2,},{5,3,2,},{14,4,2,},{7,4,2,},{2,2,3,},{13,3,0,},{12,3,3,},{4,1,0,},	},
		{	{4,2,3,},{14,0,4,},{5,0,2,},{11,1,0,},{2,2,3,},{2,4,2,},{8,3,0,},{13,2,3,},{15,3,4,},{7,2,2,},	},
		{	{6,2,3,},{2,3,4,},{8,2,3,},{10,2,3,},{11,2,4,},{2,0,2,},{7,3,3,},{5,3,0,},{5,1,2,},{11,2,4,},	},
		{	{13,1,4,},{2,1,3,},{14,0,1,},{2,4,3,},{15,0,3,},{14,1,3,},{14,2,3,},{9,3,3,},{3,0,0,},{1,0,3,},	},
		{	{15,0,2,},{2,3,1,},{2,0,3,},{2,4,3,},{13,3,3,},{1,0,1,},{15,3,0,},{6,3,2,},{0,2,1,},{8,2,0,},	},
		{	{2,3,1,},{6,0,0,},{11,2,0,},{13,2,4,},{12,0,4,},{13,2,0,},{1,2,3,},{3,3,0,},{9,3,2,},{2,1,0,},	},
		{	{11,1,3,},{15,4,3,},{15,1,0,},{12,1,1,},{6,2,3,},{2,1,3,},{2,1,4,},{1,4,3,},{6,2,2,},{8,3,3,},	},
		{	{0,2,4,},{0,2,2,},{2,3,4,},{2,3,1,},{15,0,0,},{9,4,4,},{14,0,4,},{7,3,0,},{11,2,3,},{12,2,0,},	},
		{	{0,0,0,},{0,2,2,},{2,3,1,},{0,2,3,},{5,1,4,},{13,2,0,},{2,1,4,},{4,2,3,},{10,4,4,},{1,2,3,},	},
		{	{2,1,4,},{2,3,1,},{3,0,0,},{6,0,1,},{9,3,1,},{15,2,3,},{1,4,1,},{10,1,3,},{15,1,4,},{4,4,4,},	},
		{	{7,2,3,},{11,0,2,},{12,3,4,},{2,1,3,},{13,4,3,},{8,4,1,},{2,3,1,},{13,2,4,},{1,2,2,},{13,3,0,},	},
		{	{0,0,0,},{9,2,1,},{2,4,3,},{7,2,3,},{13,0,0,},{2,1,3,},{4,2,0,},{14,0,2,},{2,0,4,},{13,3,3,},	},
		{	{0,1,1,},{5,2,1,},{14,1,3,},{2,1,4,},{12,3,1,},{7,1,3,},{2,0,3,},{0,1,0,},{11,1,2,},{1,3,4,},	},
		{	{2,3,1,},{5,1,2,},{13,2,0,},{4,3,0,},{2,1,4,},{6,4,3,},{3,0,2,},{9,2,0,},{15,0,2,},{10,0,3,},	},
		{	{2,1,4,},{1,0,0,},{13,3,2,},{13,1,2,},{2,2,4,},{2,4,1,},{13,1,0,},{15,1,0,},{8,0,0,},{10,3,0,},	},
		{	{6,2,3,},{2,3,4,},{8,2,3,},{10,2,3,},{11,2,4,},{2,0,2,},{7,3,3,},{5,3,0,},{5,1,2,},{11,2,4,},	},
		{	{2,1,4,},{6,3,3,},{15,3,0,},{6,4,0,},{2,1,3,},{15,0,0,},{11,1,2,},{12,2,2,},{15,3,3,},{7,0,4,},	},
		{	{10,2,1,},{10,1,3,},{2,4,2,},{11,3,0,},{4,1,3,},{15,3,0,},{7,0,2,},{13,1,0,},{2,1,2,},{7,2,1,},	},
		{	{11,2,1,},{7,0,2,},{13,4,1,},{7,3,1,},{15,0,0,},{2,1,4,},{2,0,1,},{12,2,4,},{12,1,2,},{5,3,1,},	},
		{	{2,1,4,},{4,2,0,},{2,3,1,},{13,3,4,},{7,1,2,},{13,0,3,},{7,0,3,},{4,0,2,},{9,0,0,},{5,0,2,},	},
		{	{15,2,1,},{7,2,3,},{12,2,4,},{13,0,1,},{5,4,3,},{8,2,3,},{2,0,3,},{2,1,0,},{0,2,1,},{0,3,4,},	},
		{	{6,3,3,},{2,3,1,},{10,3,0,},{7,1,3,},{2,4,0,},{10,0,4,},{14,1,2,},{11,1,3,},{0,4,1,},{5,4,0,},	},
		{	{15,1,4,},{5,0,1,},{3,0,0,},{9,0,2,},{12,1,2,},{11,3,4,},{1,0,2,},{2,3,4,},{2,3,1,},{10,3,1,},	},
		{	{12,3,3,},{15,4,1,},{2,0,4,},{3,1,3,},{2,3,0,},{0,4,2,},{2,2,3,},{10,0,1,},{10,3,1,},{6,1,1,},	},
		{	{12,4,1,},{9,2,1,},{2,0,4,},{13,1,1,},{5,3,2,},{15,1,4,},{15,4,1,},{0,3,4,},{13,0,2,},{2,1,0,},	},
		{	{13,3,4,},{6,1,1,},{2,1,4,},{9,4,2,},{2,3,1,},{12,4,1,},{9,0,2,},{6,1,4,},{2,1,0,},{14,0,1,},	},
		{	{12,1,3,},{0,4,4,},{11,4,1,},{0,2,3,},{12,4,2,},{1,2,0,},{2,4,3,},{13,3,1,},{10,1,1,},{2,1,0,},	},
		{	{12,3,3,},{9,1,1,},{2,4,0,},{6,1,0,},{8,0,1,},{10,4,0,},{6,1,2,},{7,1,3,},{2,3,0,},{14,1,4,},	},
		{	{10,2,1,},{15,2,1,},{10,4,3,},{14,4,4,},{13,1,1,},{2,2,4,},{15,3,4,},{9,1,2,},{2,2,3,},{12,3,0,},	},
		{	{10,0,1,},{9,2,2,},{8,2,2,},{12,2,1,},{2,3,2,},{8,0,0,},{15,3,0,},{14,3,0,},{2,1,3,},{7,3,4,},	},
		{	{11,0,1,},{14,3,0,},{2,2,1,},{14,0,1,},{8,3,3,},{5,3,1,},{4,3,4,},{2,1,2,},{9,1,2,},{2,0,4,},	},
		{	{2,1,3,},{4,3,4,},{1,0,4,},{2,4,1,},{12,0,1,},{6,0,3,},{13,4,3,},{15,1,2,},{15,1,2,},{0,1,1,},	},
		{	{12,3,3,},{11,3,0,},{2,1,4,},{12,4,1,},{12,1,1,},{11,2,3,},{2,3,0,},{1,0,0,},{12,1,4,},{14,2,3,},	},
		{	{2,4,3,},{7,0,3,},{2,1,4,},{4,2,0,},{0,2,3,},{9,3,1,},{4,3,2,},{1,2,3,},{4,3,3,},{8,4,0,},	},
		{	{14,3,3,},{2,4,1,},{2,4,3,},{6,3,3,},{6,1,1,},{15,1,4,},{12,3,0,},{15,1,2,},{13,2,4,},{7,2,3,},	},
		{	{2,4,1,},{12,1,4,},{10,4,4,},{2,3,4,},{1,1,2,},{13,4,0,},{15,1,1,},{11,1,2,},{7,3,2,},{13,2,2,},	},
		{	{6,2,0,},{12,4,0,},{10,1,2,},{2,3,4,},{10,4,3,},{1,1,3,},{2,4,0,},{1,0,4,},{0,2,0,},{7,1,4,},	},
		{	{14,1,2,},{2,4,3,},{9,0,2,},{2,4,1,},{12,4,3,},{12,4,2,},{2,3,2,},{11,3,4,},{2,2,0,},{13,1,2,},	},
		{	{12,4,3,},{2,0,3,},{2,2,2,},{14,0,3,},{8,1,2,},{13,0,3,},{3,2,4,},{2,0,4,},{7,1,0,},{11,3,0,},	},
		{	{12,3,0,},{2,0,3,},{14,0,3,},{8,4,2,},{12,3,3,},{15,4,4,},{12,3,1,},{2,1,3,},{3,2,0,},{15,1,3,},	},
		{	{2,3,4,},{9,4,4,},{8,0,4,},{14,1,2,},{7,2,4,},{0,1,1,},{2,1,4,},{5,0,3,},{4,3,1,},{1,2,4,},	},
		{	{10,4,4,},{2,0,0,},{14,2,4,},{2,3,1,},{11,4,1,},{12,4,3,},{10,4,0,},{10,0,0,},{2,3,0,},{14,3,2,},	},
		{	{2,1,4,},{2,3,1,},{5,4,3,},{10,1,4,},{5,4,4,},{12,1,0,},{12,1,4,},{14,4,4,},{8,4,2,},{7,0,3,},	},
		{	{2,3,1,},{0,0,2,},{2,3,4,},{14,1,2,},{9,3,0,},{8,0,4,},{4,1,1,},{9,0,3,},{6,2,1,},{8,3,0,},	},
		{	{14,0,1,},{4,2,2,},{12,3,0,},{2,0,3,},{15,3,4,},{2,4,0,},{14,3,2,},{7,1,3,},{8,0,0,},{5,1,1,},	},
		{	{3,0,2,},{10,2,3,},{2,1,4,},{4,0,3,},{2,2,1,},{12,3,2,},{5,3,1,},{5,3,2,},{5,3,3,},{6,4,1,},	},
		{	{2,4,1,},{1,1,1,},{6,2,0,},{6,0,4,},{7,4,4,},{10,3,4,},{2,3,4,},{1,2,4,},{11,3,1,},{14,2,1,},	},
		{	{4,0,2,},{13,4,0,},{14,0,3,},{15,1,2,},{0,2,3,},{2,1,4,},{2,1,3,},{7,0,2,},{8,2,4,},{9,4,3,},	},
		{	{2,3,1,},{7,0,3,},{2,4,0,},{7,0,0,},{2,0,3,},{2,2,3,},{12,2,1,},{13,1,3,},{4,2,1,},{5,4,4,},	},
		{	{2,1,4,},{7,4,0,},{7,0,3,},{5,1,1,},{2,3,1,},{14,4,2,},{1,3,1,},{15,4,3,},{4,4,0,},{8,3,3,},	},
		{	{14,0,0,},{10,1,3,},{13,2,3,},{4,0,0,},{13,2,0,},{3,0,1,},{2,1,4,},{3,2,0,},{3,4,3,},{2,1,3,},	},
		{	{4,2,2,},{11,0,2,},{2,2,3,},{11,4,4,},{2,0,4,},{0,3,2,},{9,0,4,},{9,3,4,},{11,0,0,},{2,2,4,},	},
		{	{8,2,2,},{11,2,1,},{15,0,3,},{7,1,4,},{6,4,1,},{2,3,2,},{2,3,4,},{8,4,1,},{15,3,3,},{10,1,3,},	},
		{	{9,2,4,},{2,3,4,},{2,1,3,},{15,2,0,},{8,0,1,},{10,3,4,},{7,0,1,},{15,4,4,},{15,1,1,},{10,2,0,},	},
		{	{12,1,2,},{2,4,0,},{11,1,0,},{15,4,2,},{2,4,3,},{11,4,3,},{14,4,4,},{11,0,0,},{0,2,4,},{14,4,0,},	},
		{	{12,3,1,},{9,1,1,},{14,0,2,},{2,1,3,},{12,3,2,},{15,3,2,},{10,1,0,},{9,0,2,},{2,1,2,},{10,2,0,},	},
		{	{13,2,2,},{2,1,4,},{12,2,0,},{10,1,2,},{0,3,3,},{14,3,0,},{2,0,1,},{12,2,0,},{12,0,3,},{4,4,4,},	},
		{	{15,2,4,},{13,2,4,},{4,2,0,},{2,3,4,},{15,2,1,},{5,4,3,},{2,1,3,},{10,3,0,},{5,0,2,},{10,0,0,},	},
		{	{13,4,0,},{2,1,4,},{2,1,3,},{4,0,1,},{11,3,2,},{3,0,2,},{14,4,4,},{7,3,4,},{0,4,4,},{12,1,1,},	},
		{	{14,4,2,},{14,0,4,},{1,0,1,},{0,0,1,},{2,0,3,},{1,1,2,},{0,4,4,},{7,3,2,},{2,0,4,},{11,1,2,},	},
		{	{2,0,3,},{8,2,1,},{2,1,3,},{1,2,1,},{8,2,3,},{2,0,0,},{13,3,1,},{10,3,4,},{2,1,4,},{2,4,0,},	},
		{	{11,0,4,},{15,0,3,},{9,0,1,},{12,0,3,},{2,4,1,},{10,4,1,},{2,3,1,},{0,4,2,},{14,4,4,},{10,0,4,},	},
		{	{2,3,1,},{5,0,1,},{8,2,0,},{10,4,2,},{2,2,3,},{5,4,2,},{11,4,2,},{12,4,2,},{12,2,3,},{0,4,3,},	},
		{	{8,2,3,},{3,2,3,},{2,3,1,},{10,4,0,},{13,1,2,},{2,0,4,},{11,3,1,},{9,3,2,},{7,1,1,},{5,3,0,},	},
		{	{2,1,3,},{2,1,4,},{11,3,0,},{13,3,3,},{0,3,3,},{15,4,2,},{4,0,4,},{13,0,1,},{1,1,0,},{12,3,2,},	},
		{	{2,4,1,},{9,2,2,},{6,4,4,},{2,4,3,},{7,2,1,},{11,0,4,},{0,3,1,},{10,0,3,},{13,2,0,},{8,4,0,},	},
		{	{15,1,0,},{1,1,1,},{2,4,1,},{7,0,4,},{2,4,3,},{1,3,4,},{9,2,3,},{15,4,0,},{8,0,2,},{13,2,4,},	},
		{	{2,1,4,},{14,2,2,},{11,0,4,},{9,1,1,},{7,3,3,},{7,3,1,},{12,2,1,},{2,4,1,},{10,2,3,},{13,1,3,},	},
		{	{3,3,4,},{3,3,1,},{10,3,4,},{5,0,0,},{2,4,3,},{12,1,2,},{12,4,0,},{2,4,2,},{14,2,3,},{14,1,4,},	},
		{	{15,3,2,},{14,4,0,},{11,4,3,},{9,1,4,},{15,1,1,},{14,2,2,},{6,3,3,},{6,0,2,},{2,2,3,},{2,1,2,},	},
		{	{12,1,3,},{10,2,3,},{10,0,0,},{2,2,0,},{5,3,3,},{1,1,3,},{2,4,2,},{13,3,1,},{15,3,3,},{4,4,4,},	},
		{	{2,3,4,},{2,0,2,},{7,4,1,},{12,0,3,},{5,4,0,},{9,4,4,},{11,2,1,},{0,2,0,},{2,3,1,},{10,3,1,},	},
		{	{2,4,3,},{3,0,3,},{2,1,4,},{15,3,1,},{15,0,1,},{9,2,4,},{4,0,2,},{1,0,3,},{9,3,0,},{7,2,0,},	},
		{	{7,2,1,},{14,2,3,},{2,4,3,},{8,3,1,},{2,4,1,},{12,0,0,},{11,3,2,},{13,2,1,},{10,4,0,},{6,2,3,},	},
		{	{2,1,3,},{2,4,1,},{0,2,1,},{4,2,0,},{9,0,4,},{13,2,1,},{5,0,2,},{8,2,2,},{15,4,1,},{1,3,1,},	},
		{	{2,1,3,},{0,1,1,},{15,4,3,},{2,4,1,},{4,3,1,},{1,3,2,},{11,3,4,},{13,1,2,},{6,4,3,},{9,2,4,},	},
		{	{7,0,0,},{0,0,4,},{2,3,1,},{14,1,3,},{5,3,3,},{14,3,4,},{2,1,4,},{7,4,2,},{9,2,2,},{7,4,4,},	},
		{	{15,1,1,},{2,3,1,},{14,4,1,},{13,1,3,},{15,4,1,},{2,3,4,},{8,2,0,},{14,2,2,},{6,2,1,},{5,0,4,},	},
		{	{0,0,3,},{2,3,1,},{2,4,3,},{13,1,1,},{14,1,4,},{5,2,3,},{12,3,3,},{13,3,2,},{9,2,3,},{5,4,0,},	},
		{	{2,3,1,},{9,2,1,},{0,1,4,},{0,1,2,},{14,1,3,},{10,4,1,},{2,3,4,},{4,2,3,},{3,4,1,},{14,2,3,},	},
		{	{2,0,2,},{15,0,3,},{2,3,4,},{7,2,1,},{3,0,1,},{3,4,0,},{1,1,4,},{8,4,0,},{2,3,2,},{14,2,4,},	},
		{	{13,2,1,},{12,2,3,},{13,0,2,},{2,4,0,},{0,0,2,},{2,4,1,},{15,4,0,},{2,3,4,},{10,4,1,},{15,0,2,},	},
		{	{7,2,4,},{10,4,0,},{6,0,4,},{2,3,1,},{12,3,4,},{2,1,3,},{1,4,1,},{5,4,1,},{7,3,3,},{4,3,0,},	},
		{	{1,1,1,},{14,3,1,},{4,0,2,},{2,1,4,},{2,3,1,},{0,4,4,},{10,1,0,},{14,4,2,},{10,2,3,},{2,4,0,},	},
		{	{2,4,3,},{14,4,0,},{15,3,2,},{0,1,2,},{12,1,3,},{2,3,4,},{14,3,0,},{15,4,1,},{14,2,4,},{13,3,2,},	},
		{	{10,1,1,},{2,3,4,},{14,0,4,},{2,1,4,},{6,1,1,},{7,4,4,},{10,2,4,},{4,1,0,},{5,0,0,},{4,2,0,},	},
		{	{1,0,2,},{11,4,0,},{2,4,3,},{15,2,3,},{3,0,1,},{5,1,0,},{2,4,2,},{8,2,0,},{6,1,4,},{13,2,0,},	},
		{	{6,2,4,},{2,3,1,},{9,1,4,},{2,3,4,},{6,2,0,},{8,1,2,},{0,1,1,},{0,1,2,},{10,3,4,},{13,0,4,},	},
		{	{10,0,3,},{7,2,4,},{12,2,1,},{2,2,0,},{14,4,1,},{6,3,1,},{2,2,4,},{12,2,0,},{6,2,2,},{3,3,4,},	},
		{	{15,0,0,},{2,4,1,},{2,3,4,},{12,0,0,},{12,1,3,},{9,2,4,},{1,1,4,},{13,2,1,},{13,3,4,},{15,0,2,},	},
		{	{2,1,4,},{11,2,2,},{8,1,4,},{8,1,2,},{14,3,2,},{12,4,3,},{11,3,3,},{5,3,0,},{5,3,1,},{2,1,2,},	},










	};
	
	CAIBA generator; 
	int [][] target;
	int boardSize;
	int [][] freshBoard;
	int maxDevIterations;

	public extraReplicationsIBA(int maxDevIterations, int dimentions, int boardSize,
			int numOfStates, boolean elitism, int numberOfInstructions){
		generator = new CAIBA(dimentions, boardSize, numOfStates, false, numberOfInstructions);
		this.maxDevIterations = maxDevIterations;
		this.boardSize = boardSize;
	}
	final static byte[][][] test = new byte[][][]{

	};
	
	public void setTarget(int [][] target){
		int [][] dot = new int[1][1];
		dot[0][0] = 1;
		this.target = target;
		generateReplicationBoard(target);
	//	this.maxFitness = target.length*target[0].length /*numReplicated/*2/**/;
	}
	private void generateReplicationBoard(int [][] replicator){
		int x = (boardSize/2) - (replicator.length/2);
		int y = (boardSize/2) - (replicator[0].length /2);

		int [][] newBoard = new int [boardSize][boardSize];
		for (int i = x; i < x+replicator.length; i++) {
			for (int j =y; j < y+replicator[0].length; j++) {
				newBoard[i][j] = replicator[i-x][j-y];
			}
		}
		freshBoard = newBoard;

	}

	private double replicationFitnessFunction(byte[][] rules, int nrReplicated){
		int partielFitness = 0;
		int fitness= 0;
		int maxFitness = 0;
		int [] bestPartials = new int [nrReplicated];
		generator.setBoard(freshBoard);
		generator.setRules(rules);
		generator.start(5);
		for (int k = 0; k < (maxDevIterations-5); k++) {

			generator.start(1);
			int board[][] = generator.getBoard();
			bestPartials = new int [nrReplicated];
			for (int i = 0; i < board.length - target.length; i++) {
				for (int j = 0; j < board[0].length - target[0].length; j++) {
					partielFitness = 0;
					for (int j2 = 0; j2 < target.length; j2++) {
						for (int l = 0; l < target[0].length; l++) {
							if(board[(i+j2)][(j+l)]==target[j2][l]){
								partielFitness++;
							}
						}
					}
					for (int j2 = 0; j2 < nrReplicated; j2++) {
						if(bestPartials[j2]< partielFitness){
							bestPartials[j2] = partielFitness;
							break;
						}
					}
				}
			}
			fitness = 0;
			for (int i = 0; i < nrReplicated; i++) {
				if(bestPartials[i]==target.length*target[0].length)
				fitness += 1;

			}
			if(fitness>maxFitness){
				maxFitness=fitness;
			}


		}

		return maxFitness;
	}
	
	public static void main(String[] args) {
		final int[][] simpleStructureBorderd = new int[][]{
				{0,0,0,0,0,0,0},
				{0,1,1,1,1,1,0},
				{0,1,0,1,0,1,0},
				{0,1,1,1,1,1,0},
				{0,1,0,1,0,1,0},
				{0,1,1,1,1,1,0},
				{0,0,0,0,0,0,0},


		};
		final int[][] frenchFlagBorderd = new int[][]{
				{0,0,0,0,0,0,0,0},
				{0,1,1,0,0,2,2,0},
				{0,1,1,0,0,2,2,0},
				{0,1,1,0,0,2,2,0},
				{0,1,1,0,0,2,2,0},
				{0,1,1,0,0,2,2,0},
				{0,1,1,0,0,2,2,0},
				{0,0,0,0,0,0,0,0},


		};
		final int[][] flagBorderd = new int[][]{
				{0,0,0,0,0,0,0,0},
				{0,1,1,2,2,3,3,0},
				{0,1,1,2,2,3,3,0},
				{0,1,1,2,2,3,3,0},
				{0,1,1,2,2,3,3,0},
				{0,1,1,2,2,3,3,0},
				{0,1,1,2,2,3,3,0},
				{0,0,0,0,0,0,0,0},


		};
		final int[][] norFlagBorderd = new int[][]{
				{0,0,0,0,0,0,0,0},
				{0,2,0,1,0,2,2,0},
				{0,0,0,1,0,0,0,0},
				{0,1,1,1,1,1,1,0},
				{0,0,0,1,0,0,0,0},
				{0,2,0,1,0,2,2,0},
				{0,2,0,1,0,2,2,0},
				{0,0,0,0,0,0,0,0},


		};
		final int[][] creeperRep = new int[][]{
				{2,2,2,2,2,2,2,2},
				{2,1,1,2,2,1,1,2},
				{2,1,1,2,2,1,1,2},
				{2,2,2,1,1,2,2,2},
				{2,2,1,1,1,1,2,2},
				{2,2,1,1,1,1,2,2},
				{2,2,1,2,2,1,2,2},
				{2,2,2,2,2,2,2,2},
		};
		extraReplicationsIBA tester = new extraReplicationsIBA(120, 2, 75, 3, true, 10);
		tester.setTarget(frenchFlagBorderd);
		ArrayList<Double> values = new ArrayList<Double>();
		double sum = 0;
		double best = 0, bestNr;
		double intermediat = 0;
		for (int i = 0; i < kandidates.length; i++) {
			intermediat = tester.replicationFitnessFunction(kandidates[i], 100);
			values.add (tester.replicationFitnessFunction(kandidates[i], 100));
			sum+=intermediat;
			if (best < intermediat) {
				bestNr = i;
				best = intermediat;
				System.out.println(bestNr + ":" +best);
			}
		}
		
		System.out.println("Average: " + sum/values.size());
		
		//stdev
		System.out.println("StDev: " + stDev(values));
	}
	
	private static double stDev(ArrayList<Double> set){
		double sum=0, sumMeanSquared = 0;
		double avarage;
		
		for (Double integer : set) {
			sum+=integer;
		}
		avarage = sum/set.size();
		for (Double integer : set) {
			sumMeanSquared += Math.pow((integer-avarage),2);
			//System.out.println(Math.pow((integer.doubleValue()-avarage),2));
		}
		//System.out.println(sumMeanSquared);
		
		return Math.sqrt(sumMeanSquared/set.size());
	}
	

}
