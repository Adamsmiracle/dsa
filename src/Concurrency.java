static class Concurrency implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Worker thread: " + i);
        }
    }
}


    public static void main(String[] args) {
        Thread worker = new Thread(new Concurrency());
        worker.start();

        for (int i = 1; i <= 5; i++) {
            System.out.println("Main thread: " + i);
        }
    }

