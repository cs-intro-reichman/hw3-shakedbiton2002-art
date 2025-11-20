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
		if (b >= 0) {
			for (int i = 1; i <= b; i++) {
			sum = sum + 1;
		}
	}	else {
			for (int i = b; i < 0; i++) {
			sum = sum - 1;
		}
		
	}
		return sum ;
}


	public static int minus(int a, int b) {
    return plus(a, -b);
}

	
	public static int times(int a, int b) {
    boolean negative = false;

    if (a < 0) {
        a = minus(0, a);
        negative = !negative;
    }
    if (b < 0) {
        b = minus(0, b);
        negative = !negative;
    }

    int result = 0;

    for (int i = 0; i < b; i++) {
        result = plus(result, a);
    }

    if (negative) {
        result = minus(0, result);
    }

    return result;
}

	
	public static int pow(int x, int n) {
		int a = x;
		int b = n;
		if (b < 0) {
			throw new IllegalArgumentException("Negative exponent"); // מעריך שלילי
		}
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
		boolean negative = false;
		if (a < 0) {
			a = minus(0, a);
			negative = !negative;
		}
		if (b < 0) {
			b = minus(0, b);
			negative = !negative;
		}
		int count = 0;
		int sum ; 
		if (b == 0) {
			throw new IllegalArgumentException("Division by zero"); // חילוק ב - 0
		}
		for (sum = b ; sum <= a; sum = plus(sum, b)) {
			count = plus(count, 1);
		}
		if (negative) {
			count = minus(0, count);
		}	
		return count ;
	}

	
	public static int mod(int x1, int x2) {
		int a = x1;
		int b = x2;
		boolean negative = false;
		if (a < 0) {
			a = minus(0, a);
			negative = true;
		}
		if (b < 0) {
			b = minus(0, b);
		}
		int Re = a;
		if (b == 0) {
			throw new IllegalArgumentException("Division by zero"); // חילוק ב - 0 
		}
		while (Re >= b) {
			Re = minus(Re, b);
		}
		if (negative) {
			Re = minus(0, Re);
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