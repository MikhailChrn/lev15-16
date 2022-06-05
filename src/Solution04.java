import java.io.*;
import java.util.ArrayList;
import java.util.List;

//lev15:Файл в статическом блоке

public class Solution04 {
    public static List<String> lines = new ArrayList<String>();

    static {
        try {
            InputStream inStream = new FileInputStream(Statics.FILE_NAME);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inStream));
            while (bufferedReader.ready()) lines.add(bufferedReader.readLine());
        } catch (IOException exIO) {
        }
    }

    public static void main(String[] args) {
        System.out.println(lines);
    }
}
