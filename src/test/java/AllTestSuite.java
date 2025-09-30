import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        DepositTests.class,
        WithdrawTests.class
})


public class AllTestSuite {
}
