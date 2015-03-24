package GUI;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;

public class textFileToArray {	
	public static ArrayList<int[][]> getArray(String url){
		int dimentions, boardSize, numOfStates;
		ArrayList<int[][]> list = new ArrayList<int[][]>();

		try(BufferedReader br = new BufferedReader(new FileReader(url))) {
			String line = br.readLine();
			System.out.println(line);
			String [] intro = line.split(":");
			dimentions =  Integer.parseInt(intro[0]); 
			boardSize =  Integer.parseInt(intro[1]);
			numOfStates =  Integer.parseInt(intro[2]);
			int[][] temp;

			line = br.readLine();
			String [] lineSp; 
			while (line != null) {
				lineSp = line.split(" "); 
			    if(dimentions==1){
		        	temp = new int[boardSize][1];
		        	for (int i = 0; i < lineSp.length; i++) {
						temp[i][0] = Integer.parseInt(lineSp[i]);
					}
		        	
		        }else{
		        	temp = new int[boardSize][boardSize];
		        	for (int i = 0; i < lineSp.length; i++) {
		        		temp[i%boardSize][i/boardSize] = Integer.parseInt(lineSp[i]);
		        	}
		        	
		        }
			    
			    list.add(temp);
				line = br.readLine();
				
			


			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}




		return list;
	}
	public static void main(String[] args) {
		ArrayList<int[][]> test = textFileToArray.getArray("src\\CA\\output\\test.txt");
		
	
		GUI gui = new GUI(19, 19, test);
		
		gui.pack();
		gui.setVisible(true);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}

}