
public class minimumPath {
	
	public static void main(String[] args){
		int[][] table = new int[4][4];
		table[0][0] = 11;
		table[0][1] = 10;
		table[0][2] = 16;
		table[0][2] = 24;
		table[1][0] = 13;
		table[1][1] = 11;
		table[1][2] = 12;
		table[1][3] = 16;
		table[2][0] = 16;
		table[2][1] = 16;
		table[2][2] = 10;
		table[2][3] = 18;
		table[3][0] = 41;
		table[3][1] = 16;
		table[3][2] = 28;
		table[3][3] = 15;
		
		System.out.println(minPathSum(table));

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
