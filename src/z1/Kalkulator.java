package z1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Kalkulator {
    public static void oblicz(String path_input, String path_output ){
        File file = new File(path_input);
        try {
            Scanner scanner = new Scanner(file);
            PrintWriter printWriter = new PrintWriter(path_output);
            while (scanner.hasNextLine()){
                int a = scanner.nextInt();
                String sym = scanner.next();
                int b = scanner.nextInt();
                switch (sym) {
                    case "+" -> printWriter.println(a + b);
                    case "-" -> printWriter.println(a - b);
                    case "*" -> printWriter.println(a * b);
                    case "/" -> {
                        if (b == 0) {
                            printWriter.println("You can not divide by 0");
                        } else {
                            printWriter.println(a / b);
                        }
                    }
                }
            }
            scanner.close();
            printWriter.close();
        } catch (FileNotFoundException fe) {
            try {
                PrintWriter printWriter = new PrintWriter(path_output);
                printWriter.println("File not found");
                printWriter.close();
            } catch (FileNotFoundException pwe) {
                System.out.println("Writting to file failed");
            }
        }

    }
}
