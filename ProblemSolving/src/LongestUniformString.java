import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * e.g. for the input: "abbbccda" the longest uniform substring is "bbb" (which
 * starts at index 1 and is 3 characters long).
 */
public class LongestUniformString {
	private static final Map<String, int[]> testCases = new HashMap<String, int[]>();

	static int[] longestUniformSubstring(String input) {
		int longestStart = -1;
		int longestLength = 0;

		if (input.length() == 0)
			return new int[] { longestStart, longestLength };
		int prevStart = 0, prevLength = 1;
		int maxLeng = 0;
		int longest = 0;
		char currentChar = input.charAt(0);

		for (int i = 1; i < input.length(); i++) {
			if (currentChar == input.charAt(i))
				prevLength++;
			else {
				if (prevLength > maxLeng) {
					maxLeng = prevLength;
					longest = prevStart;
				}
				prevStart = i;
				prevLength = 1;
				currentChar = input.charAt(i);

			}
		}

		// your code goes here
		return new int[] { longest, maxLeng };
	}

	public static void main(String[] args) {
		testCases.put("", new int[] { -1, 0 });
		testCases.put("10000111", new int[] { 1, 4 });
		testCases.put("aabbbbbCdAA", new int[] { 2, 5 });

		boolean pass = true;
		for (Map.Entry<String, int[]> testCase : testCases.entrySet()) {
			int[] result = longestUniformSubstring(testCase.getKey());
			pass = pass && (Arrays.equals(result, testCase.getValue()));
		}
		if (pass) {
			System.out.println("Pass!");
		} else {
			System.out.println("Failed! ");
		}
	}
}
