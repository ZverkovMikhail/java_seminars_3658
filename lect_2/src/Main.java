import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Lecture 2 API!");
        TimeCounter tc = new TimeCounter();
        Logger logger = Lib.getLog(Main.class);

        tc.start("stringTest");
        stringTest();
        logger.info(String.format("%s %s ms", tc.message, tc.stop()));

        tc.start("stringBuilderTest");
        stringBuilderTest();
        logger.info(String.format("%s %s ms", tc.message, tc.stop()));

        tc.start("file");
        file();
        logger.info(String.format("%s %s ms", tc.message, tc.stop()));

        tc.start("binFile");
        binFile();
        logger.info(String.format("%s %s ms", tc.message, tc.stop()));
    }

    public static void stringTest() {
        String str = "";
        for (int i = 0; i < 100000; i++) {
            str += "+";
        }

    }

    public static void stringBuilderTest() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
            sb.append("+");
        }
    }

    public static void file() {
        File file = Paths.get("test.txt").toAbsolutePath().toFile();
        if (!file.exists()) {
            try {
                file.createNewFile();
                FileWriter writer = new FileWriter(file);
                writer.write("hello world!!!");
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            String buf = "";
            List<String> lines = Files.readAllLines(file.toPath());
            System.out.println(lines);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void binFile() {
        File file = Paths.get("test.bin").toAbsolutePath().toFile();
        try {
            file.createNewFile();
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(new byte[]{123, 32, 43, 43, 43});
            fos.close();

            FileInputStream fis = new FileInputStream(file);
            byte[] b = fis.readAllBytes();
            fis.close();
            System.out.println(Arrays.toString(b));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}