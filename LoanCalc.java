// Computes the periodical payment necessary to pay a given loan.
public class LoanCalc {
	
	static double epsilon = 0.001;  // Approximation accuracy
	static int iterationCounter;    // Number of iterations 
	
	// Gets the loan data and computes the periodical payment.
    // Expects to get three command-line arguments: loan amount (double),
    // interest rate (double, as a percentage), and number of payments (int).  
	public static void main(String[] args) {		
		// Gets the loan data
		double loan = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		int n = Integer.parseInt(args[2]);
		System.out.println("Loan = " + loan + ", interest rate = " + rate + "%, periods = " + n);

		// Computes the periodical payment using brute force search
		System.out.print("\nPeriodical payment, using brute force: ");
		System.out.println((int) bruteForceSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);

		// Computes the periodical payment using bisection search
		System.out.print("\nPeriodical payment, using bi-section search: ");
		System.out.println((int) bisectionSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);
	}

	
	private static double endBalance(double loan, double rate, int n, double payment) {
		double B = loan;
		for (int i = 1 ; i <= n ; i++) {
			B = B - payment;
			B  = B * (1 + rate );
		}

		return B;
	}
	
    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {
		double G = loan / n ; 
		iterationCounter = 0;
		while (endBalance(loan, rate, n, G) > 0  ){
			G = G + epsilon ;
			iterationCounter = iterationCounter + 1 ;
		}

		
		return G;
    }
    
    public static double bisectionSolver(double loan, double rate, int n, double epsilon) { 
    iterationCounter = 0; //איפוס מספור האינטרקציות 
    double L = loan / n;    // f(L) > 0
    double H = loan;        // f(H) < 0
    double G = (L + H) / 2;

    while ((H - L) > epsilon) {

        double fL = endBalance(loan, rate, n, L);
        double fG = endBalance(loan, rate, n, G);

        iterationCounter++;

        
        if (fG * fL > 0) {
            L = G;
        } else {
            H = G;
        }

        G = (L + H) / 2;  // נקודת אמצע חדשה
    }

    return G;
}
}