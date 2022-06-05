public class Solution06 {
    //lev16: Создать public static class TestThread - нить с интерфейсом Runnable.

    public static void main(String[] args) {
        TestThread task = new TestThread();
        new Thread(task).start();
    }

    public static class TestThread implements Runnable {
        @Override
        public void run() {
            System.out.println("My first thread");
        }
    }
}
