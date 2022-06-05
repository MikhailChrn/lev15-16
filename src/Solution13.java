public class Solution13 {

    //lev16:
    //Реализуй метод ourInterruptMethod таким образом, чтобы он прерывал нить TestThread.
    //Исправь остальной код программы, если это необходимо. Нельзя использовать метод interrupt.

    private static boolean isStart = true;

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new TestThread());
        t.start();
        Thread.sleep(3000);
        ourInterruptMethod();
    }

    public static void ourInterruptMethod() {
        isStart = false;
    }

    public static class TestThread implements Runnable {
        public void run() {
            while (isStart == true) {
                try {
                    System.out.println("he-he");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }
        }
    }
}
