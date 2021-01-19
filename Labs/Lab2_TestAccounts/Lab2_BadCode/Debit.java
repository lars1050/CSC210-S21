/** Interface for a debit bank account with debit-relevant transactions.
 * @author larson amy c
 */
public interface Debit {
  /** Charge a purchase (dollar amount) to SUBTRACT from the balance.
  @param amount : dollar amount to subtract from the balance.
  */
  public void chargePurchase(Double amount);

  /** Make a cash withdrawal (dollar amount) to SUBTRACT from the balance.
  @param amount : dollar amount to subtract from the balance.
  */
  public void cashWithdrawal(Double amount);

  /** Make a deposit (dollar amount) to ADD to the balance.
  @param amount : dollar amount to add to the balance.
  */
  public void makeDeposit(Double amount);
}
