public class Checking extends Account implements Debit {

    public Checking(String name, Double bal) {
			super(name);
			minBalanceLimit(0.0);
			fee(5.0);
			interestRate(0.0);
			changeBalance(bal);
		}
    public Checking(String name) {
        this(name,0.0);
    }
    public void chargePurchase(Double amount) {
			changeBalance(-amount);
    }
    public void cashWithdrawal(Double amount) {
			changeBalance(-amount);
    }
    public void makeDeposit(Double amount) {
			changeBalance(-amount);
    }
}
