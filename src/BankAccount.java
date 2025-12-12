import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        BankAccount account = new BankAccount();

        ExecutorService executor = Executors.newFixedThreadPool(3);

        List<Future<String>> result = new ArrayList<>();

        result.add(executor.submit(new Depositor(account, 100)));
        result.add(executor.submit(new Depositor(account, 200)));
        result.add(executor.submit(new Depositor(account, 300)));
        result.add(executor.submit(new Depositor(account, 400)));
        result.add(executor.submit(new Depositor(account, 500)));
        result.add(executor.submit(new Depositor(account, 600)));
        result.add(executor.submit(new Depositor(account, 700)));
        result.add(executor.submit(new Depositor(account, 800)));
        result.add(executor.submit(new Depositor(account, 900)));

        executor.shutdown();

        for (Future<String> future: result){
            System.out.println(future.get());
        }

        System.out.println("Final Balance: " + account.getBalance());
    }

    // BankAccount with Lock
    public static class BankAccount {
        private double balance = 0;
        private final Lock lock = new ReentrantLock(); // create the lock

        public void deposit(double amount) {
            lock.lock();
            try {
                balance += amount;
            } finally {
                lock.unlock(); // always release the lock
            }
        }

        public double getBalance() {
            return balance;
        }
    }
}




// Depositor class
class Depositor implements Callable<String> {
    private Main.BankAccount account;
    private int amount;

    public Depositor(Main.BankAccount account, int amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public String call() throws Exception {
        account.deposit(amount);
        return Thread.currentThread().getName() + " deposited " + amount;
    }
}
