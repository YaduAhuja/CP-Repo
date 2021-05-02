package codeChef.practiceEasy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ThiefAndPolice {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();

		for(int i = 0; i < t; i++){
			StringTokenizer st = new StringTokenizer(br.readLine().trim()," ");
			int gridx = Integer.parseInt(st.nextToken());
			int gridy = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine().trim()," ");
			int thiefx = Integer.parseInt(st.nextToken());
			int thiefy = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine().trim()," ");
			int policex = Integer.parseInt(st.nextToken());
			int policey = Integer.parseInt(st.nextToken());
			
			sb.append(canEscape(gridx, gridy, thiefx, thiefy, policex, policey)+"\n");
		}
		br.close();
		System.out.println(sb);
	}

	private static String canEscape(int gridx, int gridy, int thiefx, int thiefy, int policex, int policey){
		int distPol = Math.min(gridx - policex, gridy - policey);
		policex += distPol; policey += distPol;
		distPol += gridx - policex;
		distPol += gridy - policey;
		int distTh = (gridx - thiefx) + (gridy - thiefy);
		// System.out.println(distPol+"	"+ distTh);
		if(distPol < distTh) return "NO";
		return "YES";
	}	
}
