import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


@Nested
public class DepositTests{
    private BankAccount bk;

    @BeforeEach
    void setup(){
        bk = new BankAccount("7428242",5000);
    }

    @Test
    void depositPositiveAmount(){
        bk.deposit(1000);
        assertEquals(6000,bk.getBalance(),"It should increase balance");
    }

    @Test
    void depositNegativeAmount(){
        assertThrows(IllegalArgumentException.class,()->bk.deposit(-200),"Depositing negative should throw exception");
    }
}

class WithdrawTests{
    private BankAccount bankAccount;

    @BeforeEach
    void setup(){
        bankAccount = new BankAccount("748535353",4000);
    }

    @Test
    @Tag("Critical")
    void withdrawValidAmount() throws Exception{
        bankAccount.withdraw(1000);
        assertEquals(3000,bankAccount.getBalance(),"Amount should be deducted from balance");

    }

    @Test
    void withdrawExceedingBalance() {
        assertThrows(InsufficientFundsException.class, () -> bankAccount.withdraw(6000),
                "Should fail if withdrawing more than balance");
    }

}
