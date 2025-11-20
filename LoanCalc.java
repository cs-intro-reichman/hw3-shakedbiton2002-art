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

	
	public static double endBalance(double loan, double rate, int n, double payment) {
    double balance = loan;
    double r = (rate / 100.0) ; 

    for (int i = 0; i < n; i++) {
		double balanceAfter = balance - payment;
        balance = balanceAfter * (1 + r) ;
    }

    return balance;
}



public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {
    double G = loan / n; 
    iterationCounter = 0;

   
    while (endBalance(loan, rate, n, G) > 0) {
        G += epsilon;
        iterationCounter++;
    }

    
    return G; 
}

// ----------------------------------------------------

public static double bisectionSolver(double loan, double rate, int n, double epsilon) { 
    iterationCounter = 0; //איפוס מספור האינטרקציות 
    double L = loan / n; 
    double H = loan; 
    double G = 0;

    while ((H - L) > epsilon) {
		iterationCounter++;
		G = (L + H) / 2; // נקודת אמצע חדשה
        double currentbalance = endBalance(loan, rate, n, G);
        if (currentbalance > 0) {
            L = G;
        } else {
            H = G;
        }

        
    }

    return (L + H) / 2;
}
}