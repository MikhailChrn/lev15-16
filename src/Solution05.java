import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

//lev15: Парсер реквестов
//Считать с консоли URL-ссылку.
//Вывести на экран список всех параметров через пробел (Параметры идут после ? и разделяются &, например, lvl=15).
//URL содержит минимум 1 параметр.
//Выводить параметры нужно в той же последовательности, в которой они представлены в URL.
//Если присутствует параметр obj, то передать его значение в нужный метод alert():
//alert(double value) - для чисел (не забывай о том, что число может быть дробным);
//alert(String value) - для строк.
//Обрати внимание на то, что метод alert() необходимо вызывать после вывода списка всех параметров на экран.

public class Solution05 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        reader.close();
        //напишите тут ваш код

        url = url.substring (url.indexOf('?') + 1, url.length());
        String[] splits = url.split("&");
        LinkedHashMap<String, String> params = new LinkedHashMap<>();

        for (String str : splits) {
            String[] para = str.split("=");
            if (para.length == 2) params.put(para[0], para[1]);
            else if (para.length == 1) params.put(para[0], null);
            else params.put(null, null);
        }

        for (Map.Entry entry : params.entrySet()) System.out.print(entry.getKey() + " ");

        System.out.println();

        for (Map.Entry entry : params.entrySet()) {
            if (entry.getKey().equals("obj")) {
                try {
                    double doub = Double.parseDouble(String.valueOf(entry.getValue()));
                    alert(doub);
                } catch (Exception ex) {
                    alert(String.valueOf(entry.getValue()));
                }
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
