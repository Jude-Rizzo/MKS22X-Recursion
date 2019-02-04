import java.util.*;
public class recursion{
    /*You may write additional private methods */

    /*Recursively find the sqrt using Newton's approximation
     *tolerance is the allowed percent error the squared answer is away from n.
     *precondition: n is non-negative

    */

    public static double sHelper(double n, double tolerance, double ans){
      if(n - ans * ans > (n * tolerance)/100) return ans;
      return recursion.sHelper(n, tolerance, (ans + (n / ans))/2 );
    }

    public static double sqrt(double n, double tolerance){
      return recursion.sHelper(n, tolerance, 0);

    }

    /*Recursively find the n'th fibbonaci number in linear time
     *fib(0) = 1; fib(1) = 1; fib(5) = 5
     *precondition: n is non-negative
     */
    public static int fib(int n){
      if (n == 0) return 0;
      if (n == 1) return 1;
      return fib(n - 1) + fib(n - 2);
    }

    /*As Per classwork*/
    public static ArrayList<Integer> makeAllSums(int n){
      ArrayList<Integer> L = new ArrayList<Integer>();
      helper(n, 0, L);
      return L;
    }

    public static void helper(int n, int sum, ArrayList<Integer> L){
        if(n >=0){
          helper(n - 1, sum + n, L);
          helper(n - 1, sum, L);
        } else L.add(sum);
    }

}
