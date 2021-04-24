package hackerRank.interviewPreparationKit;

public class ConnectedCellInGrid {
	static boolean visited[][];
	public static void main(String[] args) {
		int grid [][] = {{1, 1, 0, 0},
						{0, 1, 1, 0},
						{0, 0, 1, 0},
						{1, 0, 0, 0,}};
		
		System.out.println(maxRegion(grid));
	}

	private static int maxRegion(int grid[][]) {
		visited = new boolean[grid.length][grid[0].length];
		int ret = 0;
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[0].length; j++) {
				ret = Math.max(ret, dfs(grid, i, j));
			}
		}
		return ret;
	}

	private static int dfs(int grid[][],int x, int y) {
		if(x >= grid[0].length || x < 0) return 0;
		if(y >= grid.length || y < 0) return 0;
		if(visited[y][x]) return 0;
		
		visited[y][x] = true;
		if(grid[y][x] == 0) return 0;
		int ret = 0;
		ret += dfs(grid,x-1,y);   //left
		ret += dfs(grid,x-1,y-1); // upper left
		ret += dfs(grid,x-1,y+1); // lower left
		ret += dfs(grid,x,y-1);  // up
		ret += dfs(grid,x,y+1);  // down
		ret += dfs(grid,x+1,y-1); // upper right
		ret += dfs(grid,x+1,y); // right
		ret += dfs(grid,x+1,y+1); // lower right
 		
		return ret+1;
	}	
}
