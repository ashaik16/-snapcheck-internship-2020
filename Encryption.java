

import java.util.HashMap;
import java.util.Map;

//Using a brute force approach with time complexity O(n^2)
//Program works for all the 3 input as given in the problem
//Tested on the following Input: 1.feed the dog   
//				                 2.chill out
//                               3.have a nice day
public class Encryption {
	public static void main(String args[]) {
		String s = "chill out";
		String s2 = "";
		int beforeDecimalPoint, afterDecimalPoint;
		Map<Integer, String> m1 = new HashMap<Integer, String>();

		int j = 0;

		// Removing spaces from the given string
		String s1 = s.replaceAll("\\s+", "");

		int length = s1.toCharArray().length;
		char[] c1 = new char[length];

		// Calculating the square root from the length of the string
		double sqrt = Math.round(Math.sqrt(length) * 100.0) / 100.0;

		// Calculating the number i.e before decimal point and after decimal point.
		// If the number after decimal is greater than 5 then the number before decimal
		// should be increased by one
		beforeDecimalPoint = (int) sqrt;
		afterDecimalPoint = (int) (sqrt * 10 % 10);

		if (afterDecimalPoint > 5) {
			beforeDecimalPoint++;
			afterDecimalPoint = beforeDecimalPoint;
		} else
			afterDecimalPoint = beforeDecimalPoint + 1;

		//Using map for the first encryption technique

		for (int i = 0; i < s1.length(); i += afterDecimalPoint) {
			if (i + afterDecimalPoint < s1.length()) {
				m1.put(j, s1.substring(i, i + afterDecimalPoint));
				j++;
			} else
				m1.put(j, s1.substring(i, s1.length()));

		}
		// Second encryption
		for (int i = 0; i < afterDecimalPoint; i++) {
			for (int k = 0; k < beforeDecimalPoint; k++) {
				int size = m1.get(k).length();
				if (size > i) {
					c1[k] = m1.get(k).charAt(i);
					s2 = s2 + c1[k];
				}
			}
			// adding space for the final encrypted string
			s2 = s2 + " ";
		}
		System.out.println(s2);
	}
}
