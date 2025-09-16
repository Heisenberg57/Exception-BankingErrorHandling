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


