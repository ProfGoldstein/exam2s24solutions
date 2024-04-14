/**
 * Find the Greatest Common Divisor (GCD) for Exam 2 Part 2
 * Calculated recursively
 * 
 * The greatest common divisor (GCD) of two or more non-zero integers is the 
 * largest positive, non-zero,  integer that divides each of the integers.
 * 
 * Finds the GDC of 2, 3, or 4 integers  
 * 
 * @author Ira Goldstein
 * @version Spring 2024
 */
public class GCD {
  /**
   * Find the GCD of two integers
   * 
   * @param a First integer
   * @param b Second integer
   * @return the GCD as an int
   */
  public static int GCD(int a, int b) {
    // Base case: if b is 0, then GCD is a
    if (b == 0) {
      return Math.abs(a);
    }

    // Recursive case: GCD(a, b) is same as GCD(b, a % b)
    // We use the modulo operator (%) to find the remainder when a is divided by b
    return GCD(b, a % b);
  }
  
  /**
   * Find the GCD of Three integers
   * 
   * @param a First integer
   * @param b Second integer
   * @param c Third integer
   * @return the GCD as an int
   * 
   */
  public static int GCD(int a, int b, int c) {
    // The GDC of three integers can be calculated as the GDC of two of the integers
    // and then find the GDC of the result and the third integer
    return GCD(a, GCD(b, c));
	}

  /**
   * Find the GCD of Four integers
   * 
   * @param a First integer
   * @param b Second integer
   * @param c Third integer
   * @param d Fourth integer
   * @return the GCD as an int
   * 
   */
  public static int GCD(int a, int b, int c, int d) {
    // The GDC of four integers can be calculated as the GDC of the GDC of
    // each of two pairs of  integers
    return GCD(GCD(a, b), GCD(c, d));
	}

  /**
   * Using main to test the GDC function
   * 
   * @param args Does not use any args
   */
  public static void main(String[] args) {
    int num1 = 42;
    int num2 = 14;
	  int num3 = 21;
	  int num4 = 28;
    int gcdValue = GCD(num1,  num2);
    System.out.println("Two numbers. \t\tExpecting 14   " + gcdValue);
	  gcdValue = GCD(num2,  num1);
    System.out.println("Same two numbers in \nreversed order. \tExpecting 14   " + gcdValue);
	  gcdValue = GCD(num1,  num2, num3);
    System.out.println("Three numbers. \t\tExpecting 7   " + gcdValue);
	  gcdValue = GCD(-num1,  num2, num3, -num4);
    System.out.println("Four numbers. \t\tExpecting 7   " + gcdValue);
	  gcdValue = GCD(num1,  num2, num3, -1);
    System.out.println("Three numbers with -1. \tExpecting 1   " + gcdValue);
  }
}