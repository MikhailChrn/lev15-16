import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

//lev15:
// Напиши метод, который вычисляет факториал - произведение всех чисел от 1 до введенного числа, включая его.

public class Solution03 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(factorial(input));
    }

    public static String factorial(int n) {
        //add your code here
        String result = "0";

        //Используем новый класс BigDecimal
        BigDecimal numb = BigDecimal.valueOf(1);
        if (n > 0) {
            for (int i = 1; i <= n; i++)  numb = numb.multiply(BigDecimal.valueOf(i));
            result = String.valueOf(numb);
        }//en if (n > 0)
        else if (n == 0) result = "1";
        return result;
    }
}
