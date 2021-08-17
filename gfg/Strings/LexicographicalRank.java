package gfg.Strings;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class LexicographicalRank {
	private static HashMap<Integer, BigInteger> factorials = new HashMap<>();
	private static BigInteger mod = new BigInteger(""+((int)1e9+7));

	private static void fact(int n){
		factorials.put(0, new BigInteger("1"));
		factorials.put(1, new BigInteger("1"));
		for(int i = 2; i <= n; i++){
			factorials.put(i, new BigInteger(""+i).multiply(factorials.get(i-1)));
		}
	}
	
	private static int findLessThan(char c[], char t, HashSet<Character> hs) {
        int remover = 0;
        for(int i = 0; i < c.length; i++) {
            if(c[i] == t){ 
                return Math.max(i- remover, 0);
            }
            if(hs.contains(c[i])) remover++;
        }
        
        return 0;
    }

	private static int findRank(String s){
		char c[] = s.toCharArray();
		HashSet<Character> hs = new HashSet<>();
        for(char t: c){
            if(hs.contains(t)) return 0;
            hs.add(t);
        }
        hs.clear();
		//Generating Factorials
		fact(s.length());
		Arrays.sort(c);

		BigInteger ret = new BigInteger("1");
		for(int i = 0; i < s.length(); i++){
			BigInteger lessThan = new BigInteger(""+findLessThan(c, s.charAt(i), hs));
			BigInteger fac = factorials.get(s.length() - i -1);
			// System.out.println(hs);
            // System.out.println("less than : "+ lessThan +" fact : "+ fac +" S.length-i :" + (s.length()-i-1));
			ret = ret.add(lessThan.multiply(fac));
			ret = ret.mod(mod);
			hs.add(s.charAt(i));
		}
		return Integer.parseInt(ret.toString());
	}

    public static void main(String[] args) throws Exception {
		System.out.println(findRank("tucmhpqzwrgeixkjnaslvyfdbo"));
    }
}
