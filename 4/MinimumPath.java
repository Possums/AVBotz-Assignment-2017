import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class minimumPath {

	public static void main(String[] args) throws IOException{
		int[][] table = new int[4][4];

		Scanner scanner = new Scanner(new File("sum.in"));
		
		String input = scanner.nextLine();    // get the entire line after the prompt 
		String[] dimensions = input.split(" ");
		int x = Integer.parseInt(dimensions[0]);
		int y = Integer.parseInt(dimensions[1]);
		
		for (int i=0; i<x; i++){
			input = scanner.nextLine();
			dimensions = input.split(" ");
			for (int j=0; j<y; j++){
				table[i][j] = Integer.parseInt(dimensions[j]);
			}
		}

		//		table[0][0] = 11;
		//		table[0][1] = 10;
		//		table[0][2] = 16;
		//		table[0][2] = 24;
		//		table[1][0] = 13;
		//		table[1][1] = 11;
		//		table[1][2] = 12;
		//		table[1][3] = 16;
		//		table[2][0] = 16;
		//		table[2][1] = 16;
		//		table[2][2] = 10;
		//		table[2][3] = 18;
		//		table[3][0] = 41;
		//		table[3][1] = 16;
		//		table[3][2] = 28;
		//		table[3][3] = 15;
		int answer = minPathSum(table);
		System.out.println(answer);
	    BufferedWriter writer = new BufferedWriter(new FileWriter("sum.out"));
	    writer.write(Integer.toString(answer));
	    writer.close();
	}

	public static int minPathSum(int[][] grid) {
		if(grid == null || grid.length==0)
			return 0;

		int x = grid.length;
		int y = grid[0].length;

		int[][] table = new int[x][y];
		table[0][0] = grid[0][0];    

		for(int i=1; i<y; i++){
			table[0][i] = table[0][i-1] + grid[0][i];
		}

		for(int j=1; j<x; j++){
			table[j][0] = table[j-1][0] + grid[j][0];
		}

		for(int i=1; i<x; i++){
			for(int j=1; j<y; j++){
				if(table[i-1][j] > table[i][j-1]){
					table[i][j] = table[i][j-1] + grid[i][j];
				}
				else{
					table[i][j] = table[i-1][j] + grid[i][j];
				}
			}
		}
		return table[x-1][y-1];
	}

}
