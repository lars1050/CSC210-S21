/** Testing script to ensure code is executable and meets requirements
*/

public class TestChecking {

	public static void main(String[] args) {

		System.out.println("\n\n_______ TESTING CHECKING __________");

		//-------------------------     TEST GENERAL ACCOUNT   ----------------
		System.out.println("\n... Testing Account class methods ...");

		Double delta;	// difference between expected and actual

		// Test the default balance
		Checking judy = new Checking("Judy Stein");
		delta = judy.balance() - 0.0;
		if (0 != delta.intValue()) {
			System.out.println("Default balance, expect 0.0 Results "+judy.balance());
		}

		// Test with given starting balance
		Checking omar = new Checking("Aden Omar",200.10);
		delta = omar.balance() - 200.10;
		if (0 != delta.intValue()) {
			System.out.println("Default balance, expect 200.10 Results "+omar.balance());
		}

		// Test positive change in balance
		delta = omar.balance();
		omar.changeBalance(10.20);
		delta = delta+10.20 - omar.balance();
		if (0 != delta.intValue()) {
			System.out.println(
				"changeBalance (pos) difference. expect 0 result "+delta);
		}

		// Test negative change in balance
		delta = omar.balance();
		omar.changeBalance(-15.20);
		delta = delta-15.20 - omar.balance();
		if (0 != delta.intValue()) {
			System.out.println(
				"changeBalance (neg) difference. expect 0 result "+delta);
		}

		// Test fee setter and getter
		omar.fee(10.0);
		delta = omar.fee() - 10.0;
		if (0 != delta.intValue()) {
			System.out.println("change fee expect 10.0. Results "+omar.fee());
		}

		// Test charging of a fee (decrease in balance)
		delta = omar.balance();
		omar.chargeFee();
		delta = delta-omar.fee() - omar.balance();
		if (0 != delta.intValue()) {
			System.out.println("chargeFee expect 0 diff. Results "+delta);
		}

		// Test applying interest (increase in balance)
		delta =  omar.balance();
		omar.applyInterest();
		if (omar.balance() <= delta) {
			System.out.println("applyInterest did not increase bal.");
		}

		// Test set minimum balance
		delta = omar.minBalanceLimit();
		omar.minBalanceLimit(-10.0);
		delta = -10.0 - omar.minBalanceLimit();
		if (0 != delta.intValue()) {
			System.out.println(
				"set minBal expect -10.0. Results "+omar.minBalanceLimit());
		}

		//-----------------     TEST CHECKING TRANSACTIONS   --------------------
		System.out.println("\n... Testing Checking class methods ...");
		Checking annika = new Checking("Annika Haas",100.10);

		// Test checking charge purchase (decrease in balance)
		delta = annika.balance();
		annika.chargePurchase(10.05);
		delta = (delta-10.05)-annika.balance();
		if (0 != delta.intValue()) {
			System.out.println(
				"chargePurchase expect 90.05. Results "+annika.balance());
		}

		// Test checking cash withrawal (decrease in balance)
		delta = annika.balance();
		annika.cashWithdrawal(20.02);
		delta = delta-20.02 - annika.balance();
		if (0 !=  delta.intValue()) {
			System.out.println(
				"cashWithdrawal expect 0 difference. Results "+delta);
		}

		// Test checking deposit (increase in balance)
		delta = annika.balance();
		annika.makeDeposit(100.50);
		delta = delta+100.50 - annika.balance();
		if (0 != delta.intValue()) {
			System.out.println(
				"makeDeposit expect 0 difference. Results "+delta);
		}

		System.out.println("\n_______ END TESTING CHECKING  __________\n");


	} // end main()

} // end class Main
