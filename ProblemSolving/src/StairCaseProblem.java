
public class StairCaseProblem {
	public static int countSteps(int n)
	  {
		if(n == 0)
	    return 0;
		else if(n == 1)
			return 1;
		else {
			return ((n-1)*n/2)+1;
		}
	  }


	  public static boolean doTestsPass()
	  {
	    return countSteps(2) == 2
	      && countSteps(4) == 7;
	  }

	  public static void main(String[] args)
	  {
	    if(doTestsPass())
	    {
	      System.out.println("All tests pass");
	    }
	    else
	    {
	      System.out.println("Tests fail.");
	    }

	    for (int n = 1; n <= 5; n++)
	    {
	      int numberOfCombinations = countSteps(n);
	      System.out.println(n + " steps => " + numberOfCombinations);
	    }
	  }
}
