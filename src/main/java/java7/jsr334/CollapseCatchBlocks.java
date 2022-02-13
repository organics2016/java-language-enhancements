package java7.jsr334;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

/**
 * https://docs.oracle.com/javase/7/docs/technotes/guides/language/catch-multiple.html
 */
public class CollapseCatchBlocks {

    static class FirstException extends Exception {
    }

    static class SecondException extends Exception {
    }


    static String after(String exceptionName) {
        try {
            if (exceptionName.equals("First")) {
                throw new FirstException();
            } else {
                throw new SecondException();
            }
        } catch (FirstException | SecondException ex) {
            throw new RuntimeException(ex);
        }
    }


    public void rethrowException(String exceptionName) throws FirstException, SecondException {
        if (exceptionName.equals("First")) {
            throw new FirstException();
        } else {
            throw new SecondException();
        }
    }
}
