public class Visa extends Account implements Credit {

    public Visa(String name) {
        super(name);
				maxBalanceLimit(500.0);
				fee(10.50);
				interestRate(.218);
    }

    public void chargePurchase(Double amount) {
			changeBalance(amount);
    }

    public void makePayment(Double amount) {
				changeBalance(amount);
    }
} // end class Visa
