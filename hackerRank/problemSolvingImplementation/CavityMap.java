package hackerRank.problemSolvingImplementation;

public class CavityMap {
	static String[] cavityMap(String[] grid) {
		if (grid.length < 3 || grid[0].length() < 3) {
			return grid;
		} else {
			String[] ret = new String[grid.length];
			int[][] temp = new int[grid.length][grid[0].length()];

			for (int i = 0; i < grid.length; i++) {
				char[] tempchar = grid[i].toCharArray();
				for (int j = 0; j < tempchar.length; j++) {
					temp[i][j] = Integer.parseInt(String.valueOf(tempchar[j]));
				}
			}
			for (int i = 1; i < temp.length - 1; i++) {
				for (int j = 1; j < temp[0].length - 1; j++) {
					int value = temp[i][j];
					if (temp[i - 1][j] < value && temp[i + 1][j] < value && temp[i][j + 1] < value
							&& temp[i][j - 1] < value) {
						temp[i][j] = Integer.MAX_VALUE;
					}
				}
			}
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < grid.length; i++) {
				sb.setLength(0);
				for (int k : temp[i]) {
					sb.append(k == Integer.MAX_VALUE ? "X" : k);
				}
				ret[i] = sb.toString();
			}
			return ret;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String d[] = { "179443854", "961621369", "164139922", "968633951", "812882578", "257829163", "812438597",
				"176656233", "485773814" };
		String res[] = cavityMap(d);

		for (String s : res) {
			System.out.println(s);
		}

	}

}
