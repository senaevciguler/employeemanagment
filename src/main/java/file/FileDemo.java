package file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileDemo {
    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\senae\\Desktop\\EnglishWork\\Writing\\Oslo.txt");
        FileReader reader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(reader);

        String line ="";
        do {
             line = bufferedReader.readLine();
             if(line != null)
            System.out.println(line);
        }while(line != null);

        bufferedReader.close();

    }
}
