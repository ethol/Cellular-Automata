package CA;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class CAOutputWriter {
	private String outputFolder = "src\\CA\\output\\"; 
	private String outputFile ="test2.txt";
	private PrintWriter writer;

	public CAOutputWriter (int dimentions, int boardSize, int numOfStates){
		//System.out.println("writing to : " + outputFolder+outputFile);


		File fil = new File("src\\CA\\output\\" + outputFile);

		try {
			writer = new PrintWriter(outputFolder + outputFile, "UTF-8");
			writer.println(dimentions + ":" + boardSize + ":" + numOfStates);
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public CAOutputWriter (String file){
		//System.out.println("writing to : " + outputFolder+outputFile);

		outputFile = file;
		File fil = new File(outputFolder + outputFile);

		try {
			writer = new PrintWriter(outputFolder + outputFile, "UTF-8");
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	


	public void writeBlock(int board[][]){
		writer.println(boardToString(board));


	}
	public void writeline(String line){
		writer.println(line);
	}

	private String boardToString(int board[][]){
		String result = "";
		for (int i = 0; i < board[0].length; i++) {
			for (int j = 0; j < board.length; j++) {
				result += (board[j][i] + " ");
			}
		}


		return result;
	}

	public void close(){
		writer.close();
	}

}
