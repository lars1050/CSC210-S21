/** Testing script to ensure code is executable and meets requirements
*/

public class TestBalanceLimits {

	public static void main(String[] args) {

		System.out.println("\n\n_______ TESTING BALANCE LIMITS __________");

		Double expect;	// expected value to test against

		//-------------------------     TEST CHECKING ACCOUNT   ----------------
		System.out.println("\n... Testing Balance Limits for Checking ...");

		// Test the default balance
		Checking judy = new Checking("Judy Stein",100.00);
		Assert.assertEquals(100.0,judy.balance(),0.0,"Starting balance.");

		// Test Setter and Getter for minBalanceLimit



		// Reset balance limit to 0 -- it is easy to work with.
		judy.minBalanceLimit(0.0);

		// Test chargePurchase: results in positive balance.
		expect = judy.balance()/* - PUT VALUE HERE */;
		//judy.chargePurchase(/* PUT VALUE HERE */);
		//Assert.assertEquals(/* PUT VALUE HERE */, judy.balance(), 0.0, "MSG HERE");

		// Test chargePurchase: results in a balance equal to the limit

		// Test chargePurchase: would create negative balance (denied).

		// @note: probably start fresh with new account and positive balance.
		// judy = new ...

		// Test cashWithdrawal: results in positive balance.

		// Test cashWithdrawal: results in a balance equal to the limit

		// Test cashWithdrawal: would create negative balance (denied).

		// @note: probably start fresh with new account and $0 balance.
		// Test charge fee so balance goes negative.

		// Test make deposit to go from neg balance to pos balance.


		//-------------------------     TEST VISA ACCOUNT   ----------------
		System.out.println("\n... Testing Balance Limits for VISA ...");

		// Test the default balance
		Visa eliza = new Visa("Eliza Omar");
		Assert.assertEquals(0.0,eliza.balance(),0.0,"Default balance.");

		// Test Setter and Getter for maxBalanceLimit

		// Test chargePurchase: results in balance under the max limit.

		// Test chargePurchase: results in a balance equal to the limit

		// Test chargePurchase: would make balance over the limit (denied).

		// Test chargeFee so balance goes over the limit.
		eliza = new Visa("Eliza Omar");
		// set up test -- set balance at the limit, set fee, calc expected value.
		eliza.chargePurchase(eliza.maxBalanceLimit()-1.00);
		eliza.fee(-5.00);
		expect = eliza.balance()+5.00;

		// Test applyInterest so balance goes over the limit.

		// Test makePayment to go from over the limit to under the limit.


		System.out.println("\n_______ END TESTING BALANCE LIMITS  __________\n");

	} // end main()

} // end class Main
