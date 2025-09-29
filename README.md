#  BankAccount Mini Project (Java OOP + Exceptions)

##  Overview
This project demonstrates a **BankAccount system** built in **Java** that applies:
- **OOP principles** (Encapsulation, Constructor Overloading)
- **Exception Handling** (Built-in + Custom Exceptions)
- **Error-safe operations** for deposit and withdrawal

It simulates real-world banking operations like deposits and withdrawals while preventing invalid actions such as negative deposits or overdrafts.

---

##  Features
- Create a bank account with:
  - Default balance = `0.0`
  - OR a custom initial balance
- Deposit money (with validation)
- Withdraw money (with validation + custom exception if balance insufficient)
- Custom Exception: `InsufficientFundsException`
- Proper use of **try-catch-finally** for safe execution

---

##  Tech Stack
- **Language:** Java 17+  
- **Concepts Used:**  
  - Encapsulation  
  - Constructor Overloading  
  - Exception Handling (`throw`, `throws`, `try-catch-finally`)  
  - Custom Exceptions  

---


---

1. Clone the repository  
   ```bash
   git clone https://github.com/yourusername/BankAccount-Exceptions.git

cd BankAccount-Exceptions

javac BankAccount.java

java BankAccount

Expected out:

Deposited 500.0. Current balance = 500.0

Withdrew 200.0. Current balance = 300.0

Error: Insufficient funds! Tried to withdraw 400.0, but balance = 300.0

Final Balance = 300.0

📖 JUnit Concepts Learned So Far
1. JUnit Basics

JUnit 5 is the modern unit testing framework for Java.

Key annotations:

@Test → marks a test method.

@BeforeEach → runs before every test (used for setup).

@AfterEach → runs after every test (cleanup).

@BeforeAll / @AfterAll → run once before/after all tests (class-level).

2. Assertions

Used to check expected vs actual behavior:

assertEquals(expected, actual)

assertTrue(condition)

assertThrows(Exception.class, () -> code)

✅ Example:

assertEquals(1000, bankAccount.getBalance());
assertThrows(IllegalArgumentException.class, () -> bankAccount.deposit(-500));

3. Exceptions in Tests

Important to test failure scenarios.

Example:

@Test
void testWithdrawMoreThanBalance() {
    assertThrows(InsufficientFundsException.class, () -> bankAccount.withdraw(10000));
}


This ensures your code gracefully handles invalid operations.

4. Parameterized Tests

Solve the problem of writing duplicate tests for multiple inputs.

Key annotations:

@ParameterizedTest → enables parameterization.

@ValueSource → for single input values.

@CsvSource → for multiple parameters (like input + expected).

@MethodSource → custom data providers using Stream<Arguments>.

✅ Example with @CsvSource:

@ParameterizedTest
@CsvSource({
    "500, 4500",
    "1000, 4000"
})
void withdrawVariousAmounts(double amount, double expectedBalance) throws Exception {
    bankAccount.withdraw(amount);
    assertEquals(expectedBalance, bankAccount.getBalance());
}

5. Test Lifecycle & Reusability

@BeforeEach → ensures a fresh object for every test, avoids test interdependence.

Encourages independent tests (so one test doesn’t affect another).

You already used this with BankAccount bankAccount = new BankAccount("123", 5000);.

6. Edge Case Testing

JUnit is not just for happy paths.

We explored testing:

Deposit 0 or negative amounts.

Withdraw exact balance (balance → 0).

Invalid inputs (negative, null, etc.).


