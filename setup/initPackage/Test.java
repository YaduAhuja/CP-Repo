package setup.initPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test {
	public static void main(String[] args) throws Exception{
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		String s = sc.readLine();
		sc.close();
		System.out.println(s);
	}
}