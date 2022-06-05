import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//lev15:
//Считывать с консоли данные, пока не будет введено слово "exit".
//Для каждого значения, кроме "exit", вызвать метод print(). Если значение:
//содержит точку '.', вызвать метод print() для Double;
//больше нуля, но меньше 128, вызвать метод print() для short;
//меньше либо равно нулю или больше либо равно 128, вызвать метод print() для Integer;
//иначе — вызвать метод print() для String.

public class Solution02 {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while (!(str=reader.readLine()).equals("exit")) {
            try {
                if (str.contains(".")) print(Double.parseDouble(str));
                else if ((Integer.parseInt(str) > 0) & (Integer.parseInt(str)) < 128) print(Short.valueOf(str));
                else if ((Integer.parseInt(str) <= 0) | (Integer.parseInt(str) >= 128)) print(Integer.parseInt(str));
            } catch (Exception ex) {
                print(str);
            }
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
