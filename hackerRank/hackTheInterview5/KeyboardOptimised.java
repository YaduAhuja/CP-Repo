package hackerRank.hackTheInterview5;

public class KeyboardOptimised {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long t1 = System.currentTimeMillis();
		String s = "*He<*lo>w#5__<_*He<*lo>w#5__<_*He<*lo>w#5__<_*He<*lo>w#5__<_*He<*lo>w#5__<_*He<*lo>w#5__<_*He<*lo>w#5__<_*He<*lo>w#5__<_*He<*lo>w#5__<_*He<*lo>w#5__<_*He<*lo>w#5__<_*He<*lo>w#5__<_*He<*lo>w#5__<_*He<*lo>w#5__<_*He<*lo>w#5__<_";
		// loHew
		String temp = "";
		String ret = "";
		boolean numlock = true;
		boolean cur = true;
		// true insert end
		// false insert start

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '#') {
				numlock = !numlock;
			} else if (s.charAt(i) == '<') {
				if (!cur) {
					if (!temp.isEmpty()) {
						ret = temp.concat(ret);
						temp = "";
					}
				} else {
					cur = false;
				}
			} else if (s.charAt(i) == '>') {
				cur = true;
				if (!temp.isEmpty()) {
					ret = temp.concat(ret);
					temp = "";
				}
			} else if (s.charAt(i) == '*') {
				if (cur) {
					if (!ret.isEmpty()) {
						ret = ret.substring(0, ret.length() - 1);
					}
				} else {
					if (!temp.isEmpty()) {
						temp = temp.substring(0, temp.length() - 1);
					}
				}
			} else {
				if (numlock) {
					if (cur) {
						ret += s.charAt(i);
					} else {
						temp += s.charAt(i);
					}
				} else {
					if ((int) s.charAt(i) < 48 || (int) s.charAt(i) > 57) {
						if (cur) {
							ret += s.charAt(i);
						} else {
							temp += s.charAt(i);
						}
					}
				}
			}
		}

		if (!temp.isEmpty()) {
			ret = temp.concat(ret);
		}
		long t2 = System.currentTimeMillis();
		System.out.println(ret);
		System.out.println(temp);
		System.out.println(t2 - t1);
	}

}
