package WorkingWithFiles;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class FilesExample {
    public static void main(String[] args) {
//        File file = new File("C:\\Users\\MiracleAdams\\Downloads");
//        String[] fileList = file.list();
//        for(String name : fileList) {
//            System.out.println(name);
//        }

//    Path path = Path.of("C:\\Users\\MiracleAdams\\Downloads\\IT_Basics_roadmap.pdf");
//        byte[] lines = Files.readAllBytes(path);
//
//        String[] strings = new String[]{lines.toString()};
//
//        for (String item: Arrays.stream(strings).toList()){
//            System.out.println(item);
//        }


        Path path = Path.of("C\\Users\\MiracleAdams\\Documents\\Test.txt");
        if (Files.exists(path)){
            System.out.println("The file exits");
        }else {
            System.out.println("The file does not exist");
        }
    }
}