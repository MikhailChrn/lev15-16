import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Scanner;

//lev16: Последовательный вывод файлов
//2. В статическом блоке считай 2 имени файла firstFileName и secondFileName.
//3. Внутри класса Solution создай нить public static ReadFileThread, которая реализует
//интерфейс ReadFileInterface (Подумай, что больше подходит - Thread или Runnable).
//3.1. Метод setFileName должен устанавливать имя файла, из которого будет читаться содержимое.
//3.2. Метод getFileContent должен возвращать содержимое файла.
//3.3. В методе run считай содержимое файла, закрой поток. Раздели пробелом строки файла.
//4. Подумай, в каком месте нужно подождать окончания работы нити, чтобы обеспечить последовательный вывод файлов.
//4.1. Для этого добавь вызов соответствующего метода.

public class Solution15 {
    Charset ansi = Charset.forName("windows-1251");
    public static String firstFileName;
    public static String secondFileName;

    //напишите тут ваш код
    static {
        //firstFileName = "C:\\java\\data1.txt";
        //secondFileName = "C:\\java\\data2.txt";
        Scanner scanner = new Scanner(System.in);
        firstFileName = scanner.nextLine();
        secondFileName = scanner.nextLine();
        scanner.close();
    }//end static block of Solution

    public static void main(String[] args) throws InterruptedException, FileNotFoundException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }//end void main

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        System.out.println(f.getFileContent());
    }//end void systemOutPrintln


    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }//end interface ReadFileInterface

    //напишите тут ваш код
    public static class ReadFileThread extends Thread implements ReadFileInterface {
        String fullFileName;
        Charset ANSI = Charset.forName("windows-1251");
        String content = "";

        @Override
        public void setFileName(String fullFileName) {
            //устанавливает имя файла, из которого будет читаться содержимое
            this.fullFileName = fullFileName;
        }

        @Override
        public String getFileContent() {
            //возвращать содержимое файла
            return content;
        }

        @Override
        public void run() {
            //считай содержимое файла, закрой поток. Раздели пробелом строки файла
            try {
                FileReader fileReader = new FileReader(fullFileName, ANSI);
                Scanner scanner = new Scanner(fileReader);
                while (scanner.hasNextLine()) {
                    content += scanner.nextLine() + " ";
                }
                scanner.close();
                fileReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("Файл не удаётся обнаружить.");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }//void run()
    }//end class ReadFileThread
}
