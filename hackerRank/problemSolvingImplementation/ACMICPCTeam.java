package hackerRank.problemSolvingImplementation;

public class ACMICPCTeam {

	static int getBitCount(char[] str1, char[] str2) {
		int bitcount = 0;
		for (int i = 0; i < str1.length; i++) {
			if (str1[i] == '1' || str2[i] == '1') {
				bitcount++;
			}
		}

		return bitcount;
	}

	static int[] acmTeam(String[] topic) {
		int[] res = new int[2];
		int count = 0;
		int max = 0;
		char[] str1 = new char[topic[0].length()];
		char[] str2 = new char[topic[0].length()];
		for (int i = 0; i < topic.length - 1; i++) {
			str1 = topic[i].toCharArray();
			for (int j = i + 1; j < topic.length; j++) {
				str2 = topic[j].toCharArray();
				int bitcount = getBitCount(str1, str2);
				if (bitcount > max) {
					count = 1;
					max = bitcount;
				} else if (bitcount == max) {
					count++;
				}
			}
		}
		res[0] = max;
		res[1] = count;
		return res;
	}

	public static void main(String[] args) {
		String[] topic = {
				"1001101111101011011100101100100110111011111011000100111100111110111101011011011100111001100011111010",
				"1111010101101010011101101101011101111111111011110010001001100111000111011111101110010111110111110010" };
		int[] ret = acmTeam(topic);
		for (int c : ret) {
			System.out.println(c);
		}
	}

}
