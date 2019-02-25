import java.util.*;
public class recursion{
    /*You may write additional private methods */

    /*Recursively find the sqrt using Newton's approximation
     *tolerance is the allowed percent error the squared answer is away from n.
     *precondition: n is non-negative

    */

  public static double sqrt(double n, double tolerance){
    if (n == 0) { return 0; //could be moved down to helper tbh
    }else{
      return sHelper(n, n/2, tolerance);
    }
  }

  public static double sHelper(double n, double guess, double tolerance){
    if (Math.abs(Math.pow(guess, 2) - n) / n > tolerance) {
      return sHelper(n, (n / guess + guess) / 2, tolerance);
    }else {
      return guess;
    }
  }

  public static boolean closeEnough(double n, double guess){
    if (n == guess) return true;
    return ((n - guess)/n < .001);
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
        if(n >0){
          helper(n - 1, sum + n, L);
          helper(n - 1, sum, L);
        } else L.add(sum);
    }

    //testcase must be a valid index of your input/output array
    public static void testFib(int testcase){
      recursion r = new recursion();
      int[] input = {0,1,2,3,5,30};
      int[] output ={0,1,1,2,5,832040};
      int max = input.length;
      if(testcase < input.length){
        int in = input[testcase];
        try{

          int ans = r.fib(in);
          int correct = output[testcase];
          if(ans == correct){
            System.out.println("PASS test fib "+in+". "+correct);
          }
          else{
            System.out.println("FAIL test fib"+in+". "+ans+" vs "+correct);

          }
        }catch(IllegalArgumentException n){
          if(in < 0){
            System.out.println("PASS test fib"+in+" IllegalArgumentException");
          }else{
            System.out.println(" FAIL IllegalArgumentException in test case:"+in);
          }
        }catch(Exception e){
          System.out.println(" FAIL Some exception in test case:"+in);
        }
      }
    }


    //testcase must be a valid index of your input/output array
    public static void testSqrt(int testcase){
      recursion r = new recursion();
      double[] input = {0.0,1.0, 2.0, 4.0, 7.0};
      double[] output = {0.0,1.0,1.4142135623730951,2.0,2.6457513110645907};
      int max = input.length;
      if(testcase < input.length){
        double in = input[testcase];
        try{

          double ans = r.sqrt(in,.00001);
          double correct = Math.sqrt(in);
          if(closeEnough(ans,correct)){
            System.out.println("PASS test sqrt "+in+" "+ans);
          }
          else{
            System.out.println("FAIL test sqrt "+in+" "+ans+" vs "+correct);

          }
        }catch(IllegalArgumentException n){
          if(in < 0){
            System.out.println("PASS test sqrt"+in+" IllegalArgumentException");
          }else{
            System.out.println(" FAIL IllegalArgumentException in test case:"+in);
          }
        }catch(Exception e){
          System.out.println(" FAIL Some exception in test case:"+in);
        }
      }
    }


    public static void main(String[] args) {
      //testing testSqr
      for(int i = 0; i < 5; i++){
        testSqrt(i);
      }
}

}
