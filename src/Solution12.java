import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//lev16: Считаем секунды
//1. Напиши реализацию метода run в нити Stopwatch (секундомер).
//2. Stopwatch должен посчитать количество секунд, которое прошло от создания нити до ввода строки.
//3. Выведи количество секунд в консоль.

public class Solution12 {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);
        //create and run thread
        Stopwatch stopwatch = new Stopwatch();
        stopwatch.start();
        //read a string
        reader.readLine();
        stopwatch.interrupt();
        //close streams
        reader.close();
        in.close();
    }

    public static class Stopwatch extends Thread {
        private int seconds;

        public void run() {
            seconds = 0;
            try {
                //напишите тут ваш код
                while (!currentThread().isInterrupted()) {
                    Thread.sleep(1000);
                    seconds++;
                }
            } catch (Exception e) {
                System.out.println("С начала работы программы прошло: " + seconds + " сек.");
            }
        }
    }
}
