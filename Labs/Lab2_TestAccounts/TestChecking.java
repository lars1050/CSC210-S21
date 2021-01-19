/** Testing script to ensure code is executable and meets requirements
*/

public class TestChecking {

	public static void main(String[] args) {

		System.out.println("\n\n_______ TESTING CHECKING __________");

		//-------------------------     TEST GENERAL ACCOUNT   ----------------
		System.out.println("\n... Testing Account class methods ...");

		Double expect;	// expected value to test against

		// Test the default balance
		Checking judy = new Checking("Judy Stein");
		Assert.assertEquals(0.0,judy.balance(),0.0,"Default balance.");

		// TEST DEFAULT VALUES FOR minBalanceLimit, fee, and interestRate
		Assert.assertEquals(0.0,judy.minBalanceLimit(),0.0,"default min balance.");
		Assert.assertEquals(5.0,judy.fee(),0.0,"default fee.");
		Assert.assertEquals(0.0,judy.interestRate(),0.0,"default interestRate.");

		// Test with given starting balance
		Checking omar = new Checking("Aden Omar",200.10);
		Assert.assertEquals(200.10,omar.balance(),0.0,"Default balance.");

		// Test positive change in balance
		expect = omar.balance() + 10.20;
		omar.changeBalance(10.20);
		Assert.assertEquals(expect,omar.balance(),0.0,"changeBalance plus.");

		// Test negative change in balance
		expect = omar.balance() - 5.12;
		omar.changeBalance(-5.12);
		Assert.assertEquals(expect,omar.balance(),0.0,"changeBalance minus.");

		// Test fee setter and getter
		omar.fee(10.0);
		Assert.assertEquals(10.0,omar.fee(),0.0,"fee setter.");

		// Test charging of a fee (decrease in balance)
		expect = omar.balance() - omar.fee();
		omar.chargeFee();
		Assert.assertEquals(expect,omar.balance(),0.0,"chargeFee.");

		// Test interest setter and getter
		omar.interestRate(.021);
		Assert.assertEquals(.021,omar.interestRate(),0.0,"interest rate setter.");

		// Test applying interest (increase in balance)
		expect = omar.balance() + omar.balance()*.021/12.0;
		omar.applyInterest();
		Assert.assertEquals(expect,omar.balance(),0.0001,"applyInterest.");

		//-----------------     TEST CHECKING OWNER TRANSACTIONS  ------------------
		System.out.println("\n... Testing Checking class methods ...");
		Checking annika = new Checking("Annika Haas",100.10);

		if (annika.balance() < 100.10) {
			System.out.println("FOLLOWING TESTS INVALID");
			System.out.println("-- constructor with starting balance not correct!!!");
		}

		// Test checking charge purchase (decrease in balance)
		expect = annika.balance() - 88.53;
		annika.chargePurchase(88.53);
		Assert.assertEquals(expect,annika.balance(),0.0,"chargePurchase.");

		// Test checking charge purchase to $0 balance.
		annika.chargePurchase(annika.balance());		Assert.assertEquals(0.0,annika.balance(),0.0,"chargePurchase to $0.");

		// Start fresh for testing of cash withdrawal
		annika = new Checking("Annika Haas",100.10);

		if (annika.balance() < 100.10) {
			System.out.println("FOLLOWING TESTS INVALID");
			System.out.println("-- constructor with starting balance not correct!!!");
		}

		// Test cash withdrawal (decrease in balance)
		expect = annika.balance() - 28.13;
		annika.cashWithdrawal(28.13);
		Assert.assertEquals(expect,annika.balance(),0.0,"cashWithdrawal.");

		// Test cash withdrawal to $0 balance.
		annika.cashWithdrawal(annika.balance());		Assert.assertEquals(0.0,annika.balance(),0.0,"cashWithdrawal to $0.");

		// Test checking deposit (increase in balance)
		expect = annika.balance() + 150.32;
		annika.makeDeposit(150.32);
		Assert.assertEquals(expect,annika.balance(),0.0,"makeDeposit.");

		System.out.println("\n_______ END TESTING CHECKING  __________\n");


	} // end main()

} // end class Main
