/** Interface for a credit account with credit-relevant transactions.
 * @author larson amy c
 */
public interface Credit {
  /** Charge a purchase (dollar amount) to ADD to the balance.
  @parameter amount : dollar amount to add to the balance.
  */
  public void chargePurchase(Double amount);

  /** Make a payment (dollar amount) to SUBSTRACT from the balance.
  @parameter amount : dollar amount to subtract from the balance.
  */
  public void makePayment(Double amount);
}
