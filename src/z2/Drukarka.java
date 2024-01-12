package z2;

import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.*;
import java.io.File;

public class Drukarka {
    public void start(String path_input, String path_output) {
        File file=new File(path_input);
        try {
            Scanner scanner=new Scanner(file);
            PrintWriter printWriter = new PrintWriter(path_output);
            List<Integer> list=new ArrayList<>();
            while (scanner.hasNext()){
                String a=scanner.nextLine();
                try{
                    list.add(Integer.parseInt(a));
                }catch (NumberFormatException e){
                    if (a.equals("drukuj")){
                        if (list.isEmpty()){
                            printWriter.println("empty");
                        }
                        else {
                            Collections.sort(list);
                            printWriter.println(list.get(list.size()-1));
                            list.remove(list.get(list.size()-1));
                        }

                    } else if (a.equals("koniec")) {
                        if (list.isEmpty()){
                            printWriter.println("empty");
                        }
                        else {
                            list.sort(Collections.reverseOrder());
                            for (Integer integer : list) {
                                printWriter.println(integer);
                            }
                        }
                    }
                }

            }
            printWriter.close();
        }
        catch (FileNotFoundException fe) {
            try{
                PrintWriter printWriter = new PrintWriter(path_output);
                printWriter.println("File not found");
                printWriter.close();
            }catch (FileNotFoundException pwe) {
                System.out.println("Writing to file failed");
            }
        }
    }
}
