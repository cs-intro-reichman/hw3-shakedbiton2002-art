// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		int a = x1;
		int b = x2;
		int sum = a;
		for (int i = 1; i <= b; i++) {
			sum = sum + 1;
		}
		return sum ;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		int a = x1;
		int b = x2;
		int diff = a;
		for (int i = 1; i <= b; i++) {
			diff = diff - 1;
		}
		return diff ;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int a = x1;
		int b = x2;
		int T = 0;
		for (int i = 1; i <= b; i++) {
			T = plus(T, a);
		}
		return T ;
	}

	
	public static int pow(int x, int n) {
		int a = x;
		int b = n;
		int P = 1;
		for (int i = 1; i <= b; i++) {
			P = times(P, a);
		}

		return P ;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int a = x1;
		int b = x2;
		int count = 0;
		int sum ; 
		if (b == 0) {
			throw new IllegalArgumentException("Division by zero"); // חילוק ב - 0
		}
		for (sum = b ; sum <= a; sum = plus(sum, b)) {
			count = plus(count, 1);
		}
		return count ;
	}

	
	public static int mod(int x1, int x2) {
		int a = x1;
		int b = x2;
		int Re = a;
		if (b == 0) {
			throw new IllegalArgumentException("Division by zero"); // חילוק ב - 0 
		}
		while (Re >= b) {
			Re = minus(Re, b);
		}
		return Re ;
	}	

	
	public static int sqrt(int x) {
		int a = x;
		if (a < 0) {
			throw new IllegalArgumentException("Square root of negative number"); // שורש ריבועי של מספר שלילי
		}
		int i = 0;
		int sq = 0;
		while (sq <= a) {
			i = plus(i, 1);
			sq = times(i, i);
		}
		return minus(i, 1) ;
	}	  	  
}