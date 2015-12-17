package extra;

import java.util.ArrayList;

public class ReEvolve {
	public static String firstSolution = 	/*"1 1 1 1 1 1 1 1 1 1 1 1 2 2 2 2 2 2 2 2 2 2 2 2 3 3 3 3 3 3 3 3 3 3 3 3 ";/**/"2 0 1 0 2 2 0 0 1 0 0 0 1 1 1 1 1 1 0 0 1 0 0 0 2 0 1 0 2 2 2 0 1 0 2 2 "/**/;
	public static String secondSolution =   "1 1 1 1 1 1 1 1 1 1 1 1 0 0 0 0 0 0 0 0 0 0 0 0 2 2 2 2 2 2 2 2 2 2 2 2 ";
	public static String [] FirstResults = new String[]{
		"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 ",
		"3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 2 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 ",
		"0 0 0 0 0 0 0 0 0 3 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 ",
		"1 1 1 0 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 ",
		"3 3 3 0 0 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 ",
		"1 1 1 0 0 0 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 ",
		"3 3 3 0 0 0 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 0 0 0 ",
		"1 1 1 0 0 0 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 0 0 0 1 1 1 0 0 0 ",
		"3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 0 0 0 3 3 3 0 0 0 3 3 3 0 0 0 ",
		"3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 0 0 0 3 3 3 0 0 0 3 3 3 0 0 0 3 3 3 3 3 3 ",
		"3 3 3 3 3 3 3 3 3 0 0 0 3 3 3 0 0 0 3 3 3 0 0 0 3 3 3 3 3 3 3 3 3 3 3 3 ",
		"0 0 0 1 1 1 0 0 0 1 1 1 0 0 0 1 1 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 ",
		"1 1 1 2 2 2 1 1 1 2 2 2 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 2 2 2 ",
		"2 3 3 2 2 2 2 3 3 2 2 2 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 2 3 3 2 2 2 ",
		"2 0 1 0 2 2 2 0 1 0 2 2 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 2 0 1 0 2 2 ",
		"2 0 3 0 2 2 2 0 3 0 2 2 3 3 3 3 3 3 3 3 3 3 3 3 2 0 3 0 2 2 2 0 3 0 2 2 ",
		"2 0 1 0 2 2 0 0 1 0 0 0 1 1 1 1 1 1 0 0 1 0 0 0 2 0 1 0 2 2 2 0 1 0 2 2 ",
		"0 0 3 0 0 0 3 3 3 3 3 3 0 0 3 0 0 0 2 0 3 0 2 2 2 0 3 0 2 2 2 0 3 0 2 2 ",
		"3 3 3 3 3 3 0 0 3 0 0 0 2 0 3 0 2 2 2 0 3 0 2 2 2 0 3 0 2 2 0 0 3 0 0 0 ",
		"0 0 3 0 0 0 2 0 3 0 2 2 2 0 3 0 2 2 2 0 3 0 2 2 0 0 3 0 0 0 3 3 3 3 3 3 ",
		"3 1 0 1 3 3 3 1 0 1 3 3 3 1 0 1 3 3 1 1 0 1 1 1 0 0 0 0 0 0 1 1 0 1 1 1 ",
		"0 2 1 2 0 0 0 2 1 2 0 0 2 2 1 2 2 2 1 1 1 1 1 1 2 2 1 2 2 2 0 2 1 2 0 0 ",
		"0 0 2 2 0 0 0 0 2 2 0 0 2 2 2 2 2 2 3 3 3 3 3 3 2 2 2 2 2 2 0 0 2 2 0 0 ",
		"0 0 0 2 0 0 0 0 0 2 0 0 2 2 2 2 2 2 1 1 1 1 1 1 2 2 2 2 2 2 0 0 0 2 0 0 ",
		"0 0 0 2 0 0 0 0 0 2 0 0 2 2 2 2 2 2 2 2 2 2 2 2 0 0 0 2 0 0 0 0 0 2 0 0 ",
		"0 0 0 2 0 0 0 0 0 2 0 0 2 2 2 2 2 2 0 0 0 2 0 0 0 0 0 2 0 0 0 0 0 2 0 0 ",
		"0 0 0 2 0 0 2 2 2 2 2 2 0 0 0 2 0 0 0 0 0 2 0 0 0 0 0 2 0 0 0 0 0 2 0 0 ",
		"2 2 2 2 2 2 0 0 0 2 0 0 0 0 0 2 0 0 0 0 0 2 0 0 0 0 0 2 0 0 0 0 0 2 0 0 ",
		"0 0 0 2 0 0 0 0 0 2 0 0 0 0 0 2 0 0 0 0 0 2 0 0 0 0 0 2 0 0 2 2 2 2 2 2 ",
		"1 1 1 3 1 1 1 1 1 3 1 1 1 1 1 3 1 1 1 1 1 3 1 1 3 3 3 3 3 3 1 1 1 3 1 1 ",
		"2 2 2 0 2 2 2 2 2 0 2 2 2 2 2 0 2 2 0 0 0 0 0 0 2 2 2 0 2 2 2 2 2 0 2 2 ",
		"2 2 2 0 0 2 2 2 2 0 0 2 2 2 2 0 0 2 0 0 0 0 0 0 2 2 2 0 0 2 2 2 2 0 0 2 ",
		"2 2 2 0 0 0 2 2 2 0 0 0 2 2 2 0 0 0 0 0 0 0 0 0 2 2 2 0 0 0 2 2 2 0 0 0 ",
		"2 2 2 0 0 0 2 2 2 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 2 2 2 0 0 0 2 2 2 0 0 0 ",
		"2 2 2 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 2 2 2 0 0 0 2 2 2 0 0 0 ",
		"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 2 2 2 0 0 0 2 2 2 0 0 0 2 2 2 0 0 0 ",
		"0 0 0 0 0 0 0 0 0 0 0 0 2 2 2 0 0 0 2 2 2 0 0 0 2 2 2 0 0 0 0 0 0 0 0 0 ",
		"0 0 0 0 0 0 2 2 2 0 0 0 2 2 2 0 0 0 2 2 2 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 ",
		"3 3 3 1 1 1 3 3 3 1 1 1 3 3 3 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 ",
		"0 0 0 2 2 2 0 0 0 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 0 0 0 2 2 2 ",
		"0 0 0 0 2 2 0 0 0 0 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 0 0 0 0 2 2 ",



	};
	public static String [] SecondResults = new String[]{
		"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 ",
		"1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 2 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 ",
		"0 0 0 0 0 0 0 0 0 3 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 ",
		"1 1 1 2 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 ",
		"1 1 1 0 0 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 ",
		"1 1 1 0 0 0 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 ",
		"0 1 1 0 0 0 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 ",
		"0 1 1 0 0 0 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 0 1 1 0 0 0 ",
		"3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 0 3 3 0 0 0 0 3 3 0 0 0 ",
		"2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 1 2 2 1 1 1 1 2 2 1 1 1 2 2 2 2 2 2 ",
		"3 3 3 3 3 3 3 3 3 3 3 3 0 3 3 0 0 0 0 3 3 0 0 0 3 3 3 3 3 3 3 3 3 3 3 3 ",
		"2 2 2 2 2 2 1 2 2 1 1 1 1 2 2 1 1 1 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 ",
		"0 3 3 0 0 0 0 3 3 0 0 0 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 ",
		"0 0 3 0 0 0 0 0 3 0 0 0 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 ",
		"0 0 0 0 0 0 0 0 0 0 0 0 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 ",
		"0 0 0 0 0 0 0 0 0 0 0 0 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 0 0 0 0 0 0 ",
		"0 0 0 0 0 0 0 0 0 0 0 0 1 1 1 1 1 1 1 1 1 1 1 1 0 0 0 0 0 0 0 0 0 0 0 0 ",
		"0 0 0 0 0 0 3 3 3 3 3 3 3 3 3 3 3 3 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 ",
		"1 1 1 1 1 1 1 1 1 1 1 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 ",
		"3 3 3 3 3 3 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 3 3 3 3 3 3 ",
		"1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 2 2 2 2 2 2 2 2 2 2 2 2 ",
		"1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 2 2 2 2 2 2 2 2 2 2 2 2 ",
		"1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 2 2 2 2 2 2 2 2 2 2 2 2 ",
		"1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 0 0 0 0 0 0 2 2 2 2 2 2 2 2 2 2 2 2 ",
		"1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 0 0 0 0 0 0 2 2 2 2 2 2 2 2 2 2 2 2 ",
		"1 1 1 1 1 1 1 1 1 1 1 1 0 0 0 0 0 0 0 0 0 0 0 0 2 2 2 2 2 2 2 2 2 2 2 2 ",
		"1 1 1 1 1 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 2 2 2 2 2 2 2 2 2 2 2 2 ",
		"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 2 2 2 2 2 2 2 2 2 2 2 2 3 3 3 3 3 3 ",
		"0 0 0 0 0 0 0 0 0 0 0 0 2 2 2 2 2 2 2 2 2 2 2 2 1 1 1 1 1 1 0 0 0 0 0 0 ",
		"1 1 1 1 1 1 3 3 3 3 3 3 3 3 3 3 3 3 0 0 0 0 0 0 1 1 1 1 1 1 1 1 1 1 1 1 ",
		"1 1 1 1 1 1 3 3 3 3 3 3 3 3 3 3 3 3 0 0 0 0 0 0 1 1 1 1 1 1 1 1 1 1 1 1 ",
		"1 1 1 1 1 1 1 1 1 1 1 1 0 0 0 0 0 0 0 0 0 0 0 0 1 1 1 1 1 1 1 1 1 1 1 1 ",
		"1 1 1 1 1 1 1 1 1 1 1 1 0 0 0 0 0 0 0 0 0 0 0 0 1 1 1 1 1 1 1 1 1 1 1 1 ",
		"1 1 1 1 1 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 1 1 1 1 1 1 1 1 1 1 1 ",
		"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 1 1 1 1 1 1 1 1 1 1 1 ",
		"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 1 1 1 1 1 0 0 0 0 0 0 ",
		"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 3 3 3 3 3 3 0 0 0 0 0 0 0 0 0 0 0 0 ",
		"1 1 1 1 1 1 1 1 1 1 1 1 2 2 2 2 2 2 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 ",
		"1 1 1 1 1 1 1 1 1 1 1 1 2 2 2 2 2 2 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 ",
		"1 1 1 1 1 1 1 1 1 1 1 1 2 2 2 2 2 2 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 ",
        "1 1 1 1 1 1 1 1 1 1 1 1 2 2 2 2 2 2 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 ", 


	};

	public static void main(String[] args) {
		ArrayList<String> first = new ArrayList<String>();
		ArrayList<String> firstBoard = new ArrayList<String>();
		ArrayList<String> second = new ArrayList<String>();
		ArrayList<String> secondBoard = new ArrayList<String>();
		first.add("Start");
		firstBoard.add(FirstResults[0]);
		second.add("Start");
		secondBoard.add(FirstResults[0]);
		for (int i = 1; i < FirstResults.length; i++) {
			if(FirstResults[i].equals(firstSolution)){
				first.add("Solution A");
				firstBoard.add(FirstResults[i]);
			}else if(FirstResults[i].equals(secondSolution)){
				first.add("Solution B");
				firstBoard.add(FirstResults[i]);
			}else{
				for (int j = 0; j < firstBoard.size(); j++) {
					if(firstBoard.get(j).equals(FirstResults[i])){
						first.add(first.get(j));
						firstBoard.add(firstBoard.get(j));
						break;
					}else if(j == firstBoard.size()-1){
						first.add("a" + (i));
						firstBoard.add(FirstResults[i]);
						break;
					}
				}
			}
		}
		boolean firstly = false;
		for (int i = 1; i < SecondResults.length; i++) {
			firstly = false;
			if(SecondResults[i].equals(firstSolution)){
				second.add("Solution A");
				secondBoard.add(SecondResults[i]);
			}else if(SecondResults[i].equals(secondSolution)){
				second.add("Solution B");
				secondBoard.add(SecondResults[i]);
			}else{
				for (int j = 0; j < firstBoard.size(); j++){
					if(firstBoard.get(j).equals(SecondResults[i])){
						second.add(first.get(j));
						secondBoard.add(firstBoard.get(j));
						firstly=true;
						break;
					}
				}
				if(!firstly){
					for (int j = 0; j < secondBoard.size(); j++) {
						if(secondBoard.get(j).equals(SecondResults[i])){
							second.add(second.get(j));
							secondBoard.add(secondBoard.get(j));
							break;
						}else if(j == secondBoard.size()-1){
							second.add("b" + (i));
							secondBoard.add(SecondResults[i]);
							break;
						}
					}
				}
			}

		}
		String newEdge;
		int nrFirst = 1, nrSecond = 0;
		char ghoose = 34;
		ArrayList<String> vertice = new ArrayList<String>();
		ArrayList<String> edge = new ArrayList<String>();
		edge.add("dumby");
		for (int i = 0; i < first.size(); i++) {
			if(first.get(i).equals("a"+(i))||first.get(i).equals("Solution A")||first.get(i).equals("Solution B")||first.get(i).equals("Start")){
				vertice.add(nrFirst+ " " + ghoose +first.get(i) + ghoose+ " " + "ic Black");
				nrFirst++;
			}
			for (int j = 0; j < vertice.size(); j++) {
				if(vertice.get(j).contains(first.get(i))){
					edge.add(vertice.get(j).split(" ")[0]);
					newEdge = edge.get(edge.size()-2).concat(" " + vertice.get(j).split(" ")[0] +" 1 c Black");
					edge.set(edge.size()-2, newEdge);
				}
			}
			//System.out.println(first.get(i));
		}
		edge.remove(edge.size()-1);
		nrSecond = nrFirst;
		for (int i = 0; i < second.size(); i++) {
			if(second.get(i).equals("b"+(i))||second.get(i).equals("Solution A")||second.get(i).equals("Solution B")){
				vertice.add(nrSecond+ " " + ghoose +second.get(i)+ ghoose + " " + "ic Blue");
				
				nrSecond++;
			}
			for (int j = 0; j < vertice.size(); j++) {
				if(vertice.get(j).split(" ")[1].equals(ghoose+second.get(i)+ ghoose)||(vertice.get(j).split(" ")[1]+" " + vertice.get(j).split(" ")[2]).equals(ghoose+second.get(i)+ ghoose)){
					edge.add(vertice.get(j).split(" ")[0]);
					newEdge = edge.get(edge.size()-2).concat(" " + vertice.get(j).split(" ")[0] +" 1 c Blue");
					edge.set(edge.size()-2, newEdge);
				}
			}
			//System.out.println(second.get(i));

		}
		edge.remove(edge.size()-1);
		System.out.println("*Vertices " +  (vertice.size()));
		for (int i = 0; i < vertice.size(); i++) {
			System.out.println(vertice.get(i));
		}

		System.out.println("*Arcs");
		for (int i = 1; i < edge.size(); i++) {
			System.out.println(edge.get(i));
		}
	}

}
