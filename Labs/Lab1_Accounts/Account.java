
/** Base class for bank accounts.
This base class can be used as either a Debit or Credit account, depending on which interface is used. This is abstract and it is not meant to be implemented. Create other classes (e.g. Checking, Savings, Credit Card, Money Martket, etc.) as extensions of this with the appropriate interface.

 Note that a debit account has a positive balance, which indicates what the user has. In contrast, a positive balance for a credit account indicates something that the user owes the bank (which is really a negative balance from the user's perspective).

 @author larson amy c
 */

public abstract class Account {

  /** One variable for all instantiations of this class and its derived classes.
  It is used to create a unique account number at instantiation. */
  static int nextAccountNumber = 23510000;

  /** getUniqueAccountNumber called at account instantiation. */
  static protected int getUniqueAccountNumber() {
    return nextAccountNumber++;
  }

  /** unique (constant) account number */
  protected final int accountNumber;

  /** person associated with account */
  protected String owner;

  /** current balance */
  private Double balance = 0.0;

  /** Limit preventing account balance from getting too low.*/
  private Double minBalanceLimit = Double.NEGATIVE_INFINITY;

	/** Limit preventing account balance from getting too high.*/
	private Double maxBalanceLimit = Double.POSITIVE_INFINITY;

  /** Associated fees for having an account (annual OR monthly) */
  private Double fee;

	/** Constructor. Called from derived classes.
  Initialize values to open account and make it usable.
  @param name of owner
  */
  public Account(String name) {
    owner = name;
    accountNumber = getUniqueAccountNumber();
		balance = 0.0;
  }

  /** Creates String representing class instances for easy printing.
  Overrides built-in Object method.
  */
  @Override
  public String toString() {
    return String.format("Account %d (%s) $%.2f", accountNumber, owner, balance);
  }

  // GETTERS and SETTERS typically do not need Java documentation.
  // They should be named well enough to be self-explanatory.

  public Double fee() { return fee; }
  public void fee(Double amount) { fee = amount; }

	public Double minBalanceLimit() { return minBalanceLimit; }
	public void minBalanceLimit(Double amount) { minBalanceLimit = amount; }


	public Double maxBalanceLimit() { return maxBalanceLimit; }
	public void maxBalanceLimit(Double amount) { maxBalanceLimit = amount; }

	public Double balance() { return balance; }

	// Methods below are ways to set the balance.

  /** Apply interest. Could be earned (debit) or charged interest (credit).
  Both types increase balance.
  */
  public void applyInterest() {
    changeBalance(balance*.215/12);
  }

  /** Apply fee. It is a charge regardless of account type,
  but increases credit balance, decreases debit balance.
  */
  public void chargeFee() {
    changeBalance(-fee);
  }


	/** Public facing method for setting the balance. */
		public void changeBalance(Double value) {
			// If called, then it is a request for a balance change,
			// but it might be rejected because it is the account
			// owner's transaction (e.g. purchase, payment), but if
			// it is the bank's transaction (e.g. fees, interest),
			// then it should go through even if it exceeds limits.
			changeBalance(value, false);
		}

		/** The ONLY way that balance can be modified to ensure
		it is not exceeding any limits or the account is not frozen or closed.
		The boolean indicates whether or not the bank is trying to change the balance or if the account owner is trying to make a transaction.
		*/
	  private void changeBalance(Double value, Boolean bankTransaction) {
	    if ((balance+value) < minBalanceLimit) {
	      System.out.println("TRANSACTION DENIED due to minimum balance limit.");
	      return;
	    } else if ((balance+value) > maxBalanceLimit) {
				System.out.println("TRANSACTION DENIED due to maximum balance limit.");
				return;
			} else {
				balance += value;
			}
	  } // end setBalance()

} // end class Account
