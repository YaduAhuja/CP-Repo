package hackerRank.problemSolvingImplementation;

public class TheTimeInWords {
	static String timeInWords(int h, int m) {
		String ret = "";
		String temp = "";
		int flag = 0;
		if (m > 30) {
			m = Math.abs(m - 60);
			flag = 1;
			if (h == 12) {
				h = 1;
			} else {
				h++;
			}
		}

		switch (h) {
		case 1:
			ret = "one";
			break;
		case 2:
			ret = "two";
			break;
		case 3:
			ret = "three";
			break;
		case 4:
			ret = "four";
			break;
		case 5:
			ret = "five";
			break;
		case 6:
			ret = "six";
			break;
		case 7:
			ret = "seven";
			break;
		case 8:
			ret = "eight";
			break;
		case 9:
			ret = "nine";
			break;
		case 10:
			ret = "ten";
			break;
		case 11:
			ret = "eleven";
			break;
		case 12:
			ret = "twelve";
			break;
		}
		switch (m) {
		case 0:
			temp = "o' clock";
			break;
		case 1:
			temp = "one minute";
			break;
		case 2:
			temp = "two minutes";
			break;
		case 3:
			temp = "three minutes";
			break;
		case 4:
			temp = "four minutes";
			break;
		case 5:
			temp = "five minutes ";
			break;
		case 6:
			temp = "six minutes";
			break;
		case 7:
			temp = "seven minutes";
			break;
		case 8:
			temp = "eight minutes";
			break;
		case 9:
			temp = "nine minutes";
			break;
		case 10:
			temp = "ten minutes";
			break;
		case 11:
			temp = "eleven minutes";
			break;
		case 12:
			temp = "twelve minutes";
			break;
		case 13:
			temp = "thirteen minutes";
			break;
		case 14:
			temp = "fourteen minutes";
			break;
		case 15:
			temp = "quarter";
			break;
		case 16:
			temp = "sixteen minutes";
			break;
		case 17:
			temp = "seventeen minutes";
			break;
		case 18:
			temp = "eighteen minutes";
			break;
		case 19:
			temp = "nineteen minutes";
			break;
		case 20:
			temp = "twenty minutes";
			break;
		case 21:
			temp = "twenty one minutes";
			break;
		case 22:
			temp = "twenty two minutes";
			break;
		case 23:
			temp = "twenty three minutes";
			break;
		case 24:
			temp = "twenty four minutes";
			break;
		case 25:
			temp = "twenty five minutes";
			break;
		case 26:
			temp = "twenty six minutes";
			break;
		case 27:
			temp = "twenty seven minutes";
			break;
		case 28:
			temp = "twenty eight minutes";
			break;
		case 29:
			temp = "twenty nine minutes";
			break;
		case 30:
			temp = "half";
			break;
		}
		if (m == 0) {
			return ret + " " + temp;
		} else if (flag == 1 && m != 0) {
			return temp + " to " + ret;
		} else if (flag == 0 && m != 0) {
			return temp + " past " + ret;
		} else {
			System.out.println("error encountered");
		}
		return ret;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(timeInWords(5, 30));
	}

}
