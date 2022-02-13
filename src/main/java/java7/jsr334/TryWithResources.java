package java7.jsr334;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * https://docs.oracle.com/javase/7/docs/technotes/guides/language/try-with-resources.html
 */
public class TryWithResources {

    static String after(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        }
    }
}
