package interviewQuestion;

import org.junit.Assert;
import org.junit.Test;

public class AccountTest {
    private final double epsilon = 1e-6;

    @Test
    public void accountCannotHaveNegativeOverdraftLimit() {
        Account account = new Account(-20);
        Assert.assertEquals(0d, account.getOverdraftLimit(), epsilon);
    }

    @Test
    public void cannotDepositNegativeNumbers() {
        Account account = new Account(0);
        Assert.assertFalse(account.deposit(-1000));
    }

    @Test
    public void cannotWithdrawNegativeNumbers() {
        Account account = new Account(0);
        Assert.assertFalse(account.withdraw(-1000));
    }

    @Test
    public void accountCannotOverstepOverdraftLimit() {
        Account account = new Account(1000);
        Assert.assertFalse(account.withdraw(10000));
    }

    @Test
    public void depositCorrectAmount() {
        Account account = new Account(0);
        int moneyToDeposit = 1000;
        account.deposit(moneyToDeposit);
        Assert.assertEquals(account.getBalance(), moneyToDeposit, epsilon);
    }

    @Test
    public void withdrawCorrectAmount() {
        Account account = new Account(1000);
        int moneyToWithdraw = 1000;
        account.withdraw(moneyToWithdraw);
        Assert.assertEquals(account.getBalance(), -1000, epsilon);
    }

    @Test
    public void depositReturnsCorrectResult() {
        Account account = new Account(0);
        int moneyToDeposit = 1000;
        Assert.assertTrue(account.deposit(moneyToDeposit));
    }

    @Test
    public void withdrawReturnsCorrectResult() {
        Account account = new Account(1000);
        int moneyToWithdraw = 1000;
        Assert.assertTrue(account.withdraw(moneyToWithdraw));
    }
}
