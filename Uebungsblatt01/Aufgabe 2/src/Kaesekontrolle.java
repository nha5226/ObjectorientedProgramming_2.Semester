
//Code funktioniert nicht ganz

public class Kaesekontrolle {

public static void main(String[] args) {
		
		String posi = "0123456789012345678";
		String row0 = "+-----------------+" + " 0";
		String row1 = "|    **           |" + " 1";
		String row2 = "|   *  *     *    |" + " 2";
		String row3 = "|   ***     * *   |" + " 3";
		String row4 = "|        **  *    |" + " 4";
		String row5 = "|  *     **       |" + " 5";
		String row6 = "+-----------------+" + " 6";
		
		System.out.println(posi);
		System.out.println(row0);
		System.out.println(row1);
		System.out.println(row2);
		System.out.println(row3);
		System.out.println(row4);
		System.out.println(row5);
		System.out.println(row6);
		
		
		int rowHoles[][] = new int[5][17];
		//int row2Holes[] = new int[17];
		//int row3Holes[] = new int[17];
		//int row4Holes[] = new int[17];
		//int row5Holes[] = new int[17];
		
		
		String posLoecher = "*";
		
		int index = row1.indexOf(posLoecher);
		
		System.out.println("\n" + "Row 1 Hole positions");
		
		while (index >= 0) {
			
			rowHoles[0][index] = rowHoles[0][index] + index; 
			System.out.print(rowHoles[0][index] + " ");
			index = row1.indexOf(posLoecher, index + 1);	
		}
		
		index = row2.indexOf(posLoecher);
		
		System.out.println("\n" + "Row 2 Hole positions");
		
		while (index >= 0) {
			rowHoles[1][index] = rowHoles[1][index] + index; 
			System.out.print(rowHoles[1][index] + " ");
			index = row2.indexOf(posLoecher, index + 1);
		}
		
		index = row3.indexOf(posLoecher);
		
		System.out.println("\n" + "Row 3 Hole positions");
		
		while (index >= 0) {
			rowHoles[2][index] = rowHoles[2][index] + index; 
			System.out.print(rowHoles[2][index] + " ");
			index = row3.indexOf(posLoecher, index + 1);
		}
		
		index = row4.indexOf(posLoecher);
		System.out.println("\n" + "Row 4 Hole positions");
		
		while (index >= 0) {
			rowHoles[3][index] = rowHoles[3][index] + index; 
			System.out.print(rowHoles[3][index] + " ");
			index = row4.indexOf(posLoecher, index + 1);
		}
		
		index = row5.indexOf(posLoecher);
		System.out.println("\n" + "Row 5 Hole positions");
		
		while (index >= 0) {
			rowHoles[4][index] = rowHoles[4][index] + index; 
			System.out.print(rowHoles[4][index] + " ");
			index = row5.indexOf(posLoecher, index + 1);
		}
		
		int test = findHoles(rowHoles);
		
		System.out.println("\n\n" + test);
		//System.out.println("\n" + test);
		
		//Point point1 = new Point(1, 1);
		//Point point2 = point1;
		//point1.x = 2;
		//System.out.println(point2);
	}
	
public static int findHoles(int rowHoles[][]) {
		
		int result = 0;
		int foundholes = 0;
		int rowRun = 0;
		int biggestHole = 0;
		int rows = 5;
		int counter = 0;
		int cache = 0;
		boolean hole = true;
		int stop = 0;

		do {
			
			for(int i = 0; i < 17; i++) {
				
				while(rowHoles[rowRun][i] > 0) {
					cache = rowHoles[rowRun][i];
					rowHoles[rowRun][i] = rowHoles[rowRun][i] - cache;
					
					if(rowHoles[rowRun][i+1] > 0) {
						i = i + 1;
						biggestHole = biggestHole + 1;
					}
					
					else if(rowHoles[rowRun][i-1] > 0) {
						i = i - 1;
						biggestHole = biggestHole + 1;
					}
					
					else if(rowHoles[rowRun+1][i] == 0 && rowHoles[rowRun+1][i+1] == 0 && rowRun-1 < 0) {
						cache = rowHoles[rowRun][i];
						rowHoles[rowRun][i] = rowHoles[rowRun][i] - cache;
						rowRun = rowRun + 1;
						stop = stop + i;
						i = 0;
						do {
						i = i + 1;
						}while(i < stop);
						
						hole = false;
					}
					
					else if(rowHoles[rowRun+1][i] == 0 && rowHoles[rowRun+1][i+1] == 0 && rowHoles[rowRun+1][i-1] == 0) {
						cache = rowHoles[rowRun][i];
						rowHoles[rowRun][i] = rowHoles[rowRun][i] - cache;
						rowRun = rowRun + 1;
						stop = stop + i;
						i = 0;
						do {
						i = i + 1;
						}while(i < stop);
						
						hole = false;
					}	
						
					else if(rowHoles[rowRun+1][i] > 0) {
						rowRun = rowRun + 1;
						biggestHole = biggestHole + 1;
					}
					
					else if(rowRun <= 0) {
						rowRun = rowRun + 2;
					}
					
					else if(rowHoles[rowRun-1][i-1] > 0) {
						i = i - 1;
						rowRun = rowRun - 1;
						biggestHole = biggestHole + 1;
					}

					else if(rowHoles[rowRun-1][i+1] > 0) {
						i = i + 1;
						rowRun = rowRun - 1;
						biggestHole = biggestHole + 1;
					}
					
					else if(rowHoles[rowRun+1][i-1] > 0) {
						i = i - 1;
						rowRun = rowRun + 1;
						biggestHole = biggestHole + 1;
					}
				}
				
			}
			if(hole = true) {
			foundholes = + 1;	
				rowRun = + 1;
				cache = 0;
			}
			
			else {
				rowRun = +1;
				cache = 0;
			}
		}while(rowRun < rows);
		
		return foundholes;
	}
	
}
