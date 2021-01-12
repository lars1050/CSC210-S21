/** Testing script to ensure code is executable and meets requirements
*/

public class TestTransactions {

	public static void main(String[] args) {

		System.out.println("\n\n_______ TESTING TRANSACTIONS __________");

		//-------------------------     TEST GENERAL ACCOUNT   ----------------
		System.out.println(" _____ VISUAL INSPECTION ONLY _______ ");

		Double delta;	// difference between expected and actual

		Checking judy = new Checking("Judy Stein");
		judy.chargeFee();
		judy.applyInterest();
		judy.chargePurchase(12.20);
		judy.makeDeposit(5.10);
		judy.cashWithdrawal(2.05);

		System.out.println("\n... EXPECT 5 transactions: fee, interest, purchase,deposit,withdrawal");
		judy.printTransactions();

		Visa malcolm = new Visa("Malcolm Washington");
		malcolm.chargeFee();
		malcolm.applyInterest();
		malcolm.chargePurchase(12.20);
		malcolm.makePayment(5.10);

		System.out.println("\n... EXPECT 4 transactions: fee, interest, purchase,payment");
		malcolm.printTransactions();

	} // end main()

} // end class Main
