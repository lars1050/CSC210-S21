/** Testing script to ensure code is executable and meets requirements
*/

public class TestVisa {

	public static void main(String[] args) {

				System.out.println("\n\n_______ TESTING VISA  __________");

		//-------------------------     TEST GENERAL ACCOUNT   ----------------
		System.out.println("\n... Testing Account class methods for VISA ...");

		Double expect;	// expected value to test against

		// Test the default balance
		Visa judy = new Visa("Judy Stein");
		Assert.assertEquals(0.0,judy.balance(),0.0,"Default balance.");

		// TEST DEFAULT VALUES FOR maxBalanceLimit, fee, and interestRate
		Assert.assertEquals(2000.0,judy.maxBalanceLimit(),0.0,"default max balance.");
		Assert.assertEquals(30.0,judy.fee(),0.0,"default fee.");
		Assert.assertEquals(0.182,judy.interestRate(),0.0,"default interestRate.");

		// Test positive change in balance
		expect = judy.balance() + 10.20;
		judy.changeBalance(10.20);
		Assert.assertEquals(expect,judy.balance(),0.0,"changeBalance plus.");

		// Test negative change in balance
		expect = judy.balance() - 5.15;
		judy.changeBalance(-5.15);
		Assert.assertEquals(expect,judy.balance(),0.0,"changeBalance minus.");

		// Test fee setter and getter
		judy.fee(-10.0);
		Assert.assertEquals(-10.0,judy.fee(),0.0,"fee setter.");

		// Test charging of a fee (increase in balance because fee is negative)
		expect = judy.balance() - judy.fee();
		judy.chargeFee();
		Assert.assertEquals(expect,judy.balance(),0.0,"chargeFee.");

		// Test interest setter and getter
		judy.interestRate(.021);
		Assert.assertEquals(.021,judy.interestRate(),0.0,"interest rate setter.");

		// Test applying/charge interest (increase in balance)
		// This will only work if the setter is functional (tested above)
		expect = judy.balance() + judy.balance()*.021/12.0;
		judy.applyInterest();
		Assert.assertEquals(expect,judy.balance(),0.0001,"applyInterest.");

		//----------------------     TEST Visa   ---------------------------
		System.out.println("\n ... Testing Visa class ...");

		Visa sofia = new Visa("Sofia Ramirez");

		// Test visa charge purchase (increase in balance)
		expect = sofia.balance() + 88.53;
		sofia.chargePurchase(88.53);
		Assert.assertEquals(expect,sofia.balance(),0.0,"chargePurchase.");

		// Test visa make payment (decrease in balance)
		expect = sofia.balance() - 15.32;
		sofia.makePayment(15.32);
		Assert.assertEquals(expect,sofia.balance(),0.0,"makePayment.");

		// Test makePayment to $0 balance.
		sofia.makePayment(sofia.balance());		Assert.assertEquals(0.0,sofia.balance(),0.0,"makePayement to $0.");

		System.out.println("\n_______ END TESTING VISA  __________\n");

	} // end main()

} // end class Main
