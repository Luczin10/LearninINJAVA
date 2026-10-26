class BankAccount {
    private int balance = 0;

    boolean deposit(int amount) {
        if (amount <= 0) {
            return false;
        }
        balance += amount;
        return true;
    }

    boolean withdraw(int amount) {
        if (amount <= 0 || amount > balance) {
            return false;
        }
        balance -= amount;
        return true;
    }

    int getBalance() {
        return balance;
    }
}
void main() {
    BankAccount account = new BankAccount();
    int n = Integer.parseInt(IO.readln().trim());
    for (int i = 0; i < n; i++) {
        String[] parts = IO.readln().trim().split(" ");
        String command = parts[0];
        if (command.equals("balance")) {
            IO.println("Balance: " + account.getBalance());
            continue;
        }
        int amount = Integer.parseInt(parts[1]);
        if (command.equals("deposit")) {
            IO.println(account.deposit(amount) ? "Deposited " + amount : "Invalid amount");
        } else if (amount <= 0) {
            IO.println("Invalid amount");
        } else if (account.withdraw(amount)) {
            IO.println("Withdrew " + amount);
        } else {
            IO.println("Insufficient funds");
        }
    }
}
