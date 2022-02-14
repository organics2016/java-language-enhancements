package java10;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LocalVariableTypeInference {

    public void after() throws IOException {
        final var list = new ArrayList<String>();    // infers ArrayList<String>
        var stream = list.stream();            // infers Stream<String>

        var path = Paths.get("fileName");        // infers Path
        var bytes = Files.readAllBytes(path);  // infers bytes[]

        for (var counter = 0; counter < 10; counter++) {
        }   // infers int

        try (var input =
                     new FileInputStream("validation.txt")) {
        }   // FileInputStream
    }
}
