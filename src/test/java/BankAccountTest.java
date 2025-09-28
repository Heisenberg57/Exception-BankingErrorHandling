import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class BankAccountTest {
    private BankAccount bk;

    @BeforeEach
    void setup(){
        bk = new BankAccount("1728061366",6000);
    }

    @Test
    void depositTest(){
        bk.deposit(200);
        assertEquals(6200,bk.getBalance(),"Amount should get added to balance");
        assertThrows(IllegalArgumentException.class,()->bk.deposit(-200));
    }

    @ParameterizedTest
    @ValueSource(doubles = {100, 500, 1000,0})
    void depositMultipleAmounts(double amount){
        bk.deposit(amount);
        assertTrue(bk.getBalance()>=6000);

    }

    @Test
     void withdrawTest() throws InsufficientFundsException {
        bk.withdraw(2000);
        assertEquals(4000,bk.getBalance(),"Amount should get reduced from balance");
        assertThrows(InsufficientFundsException.class,()->bk.withdraw(6000));
    }

    @ParameterizedTest
    @CsvSource({
            "500,5500",
            "1000,5000",
            "0,5000"
    })
    void withdrawVariousAmounts(double amount, double expectedBalance) throws Exception{
        bk.withdraw(amount);
        assertEquals(expectedBalance, bk.getBalance());
    }



}

