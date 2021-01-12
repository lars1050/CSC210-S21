/** Testing script to ensure code is executable and meets requirements
*/

public class TestVisa {

	public static void main(String[] args) {

				System.out.println("\n\n_______ TESTING VISA  __________");

		//-------------------------     TEST GENERAL ACCOUNT   ----------------
		System.out.println("\n... Testing Account class methods for VISA ...");

		Double delta;	// difference between expected and actual

		// Test the default balance
		Visa judy = new Visa("Judy Stein");
		if (0 != judy.balance().intValue()) {
			System.out.println("Default balance, expect 0.0 Results "+judy.balance());
		}

		// Have a balance to work with -- if this does not work, other tests
		// not valid, so return
		judy.changeBalance(250.00);
		if (judy.balance() != 250.00) {
			System.out.println("Something wrong with setting of balance.");
			return;
		}

		// Test fee setter and getter
		judy.fee(10.0);
		delta = judy.fee() - 10.0;
		if (0 != delta.intValue()) {
			System.out.println("change fee expect 10.0. Results "+judy.fee());
		}

		// Test charging of a fee (increase in balance)
		delta = judy.balance();
		judy.chargeFee();
		delta = delta+judy.fee() - judy.balance();
		if (0 != delta.intValue()) {
			System.out.println("chargeFee expect 0 diff. Results "+delta);
		}

		// Test applying interest (increase in balance)
		delta =  judy.balance();
		judy.applyInterest();
		if (judy.balance() <= delta) {
			System.out.println("applyInterest did not increase bal.");
		}

		//----------------------     TEST Visa   ---------------------------
		System.out.println("\n ... Testing Visa class ...");

		Visa sofia = new Visa("Sofia Ramirez");

		// Test max balance (spending limit)
		sofia.maxBalanceLimit(1000.30);
		delta = sofia.maxBalanceLimit()-1000.30;
		if (0 != delta.intValue()) {
			System.out.println(
				"set maxBal expect 1000.30 Results "+sofia.maxBalanceLimit());
		}

		// Test charging purchase (increase balance)
		delta = sofia.balance();
		sofia.chargePurchase(10.20);
		delta = delta+10.20-sofia.balance();
		if (0 != delta.intValue()) {
			System.out.println(
				"chargePurchase expect 0 diff. Results "+delta);
		}

		// Test make payment (decrease balance)
		delta = sofia.balance();
		sofia.makePayment(100.70);
		delta = delta-100.70-sofia.balance();
		if (0 != delta.intValue()) {
			System.out.println(
				"makePayment expect 0 diff. Results "+delta);
		}

		System.out.println("\n_______ END TESTING VISA  __________\n");

	} // end main()

} // end class Main
