package CA;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class CAOutputWriter {
	private String outputFolder = "src\\CA\\output\\"; 
	private String outputFile ="test.txt";
	private PrintWriter writer;

	public CAOutputWriter (int dimentions, int boardSize){
		//System.out.println("writing to : " + outputFolder+outputFile);


		File fil = new File("src\\CA\\output\\" + outputFile);

		try {
			writer = new PrintWriter(outputFolder + outputFile, "UTF-8");
			writer.println(dimentions + ":" + boardSize);
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void writeBlock(int board[][]){
		writer.println(boardToString(board));


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
