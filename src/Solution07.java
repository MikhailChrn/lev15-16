public class Solution07 {

    //lev16: Создать public static класс TestThread, унаследованный от класса Thread.

    public static void main(String[] args) {
        TestThread thread = new TestThread();
        thread.start();
    }

    public static class TestThread extends Thread {
        static {
            System.out.println("it's a static block inside TestThread");
        }
        public void run() {
            System.out.println("it's a run method");
        }
    }
}

