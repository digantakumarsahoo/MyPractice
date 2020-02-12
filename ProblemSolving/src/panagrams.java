
/**
 * Pangram FInder
 *
 * The sentence "The quick brown fox jumps over the lazy dog" contains
 * every single letter in the alphabet. Such sentences are called pangrams.
 * Write a function findMissingLetters, which takes a String `sentence`,
 * and returns all the letters it is missing
 *
 */
public class panagrams {
	private static class PanagramDetector {
		  private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
		  StringBuilder missingLetters= new StringBuilder();
		  public String findMissingLetters(String sentence) {
			  for(int i=0;i<ALPHABET.length();i++) {
				  if(!sentence.toLowerCase().contains(""+ALPHABET.charAt(i)))
					  missingLetters.append(ALPHABET.charAt(i));
			  }
		    return missingLetters.toString();
		  }

		  }

		  public static void main(String[] args) {
		  PanagramDetector pd = new PanagramDetector();
		  boolean success = true;

		  success = success && "".equals(pd.findMissingLetters("The quick brown fox jumps over the lazy dog"));
		  success = success && "abcdefghijklmnopqrstuvwxyz".equals(pd.findMissingLetters(""));

		  if (success) {
		    System.out.println("Pass ");
		  } else {
		    System.out.println("Failed");
		  }
		  }
}
