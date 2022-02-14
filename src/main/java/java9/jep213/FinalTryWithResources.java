package java9.jep213;

import java.io.*;

public class FinalTryWithResources {


    public void after(String path) throws FileNotFoundException {

        // A final resource
        final InputStream resource1 = new FileInputStream("resource1");
        // An effectively final resource
        InputStream resource2 = new FileInputStream("resource2");

        try (resource1; resource2) {

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println(resource1);
        }
    }
}
