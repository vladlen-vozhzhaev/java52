import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        try {
            int brCount = 0;
            int byteCount = 0;
            FileReader fileReader = new FileReader("test.txt");
            BufferedReader br = new BufferedReader(fileReader);
            String line;
            while ((line = br.readLine()) != null){
                brCount++;
                System.out.println(line);
            }
            fileReader.close();
            fileReader = new FileReader("test.txt");
            int i;
            while ((i = fileReader.read()) != -1){
                byteCount++;
                System.out.print((char) i);
            }

            System.out.println("\nИтераций с BR: "+brCount);
            System.out.println("Итераций с read(): "+byteCount);
        }catch (IOException e){
            e.printStackTrace();
        }


        /*try {
            FileInputStream fis = new FileInputStream("test.txt");
            BufferedInputStream bis = new BufferedInputStream(fis);
            System.out.println(Arrays.toString(bis.readAllBytes()));
            *//*int i;
            while ((i = fis.read()) != -1)
                System.out.print((char) i);*//*

        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/

        /*try {
            FileWriter fw = new FileWriter("test.txt");
            fw.append("Hello world!");
            fw.flush();
            fw.close();
        }catch (IOException e){
            e.printStackTrace();
        }*/

        /*try {
            String str = "Hello world!";
            FileOutputStream out = new FileOutputStream("test.txt");
            byte[] buff = str.getBytes();
            System.out.println(Arrays.toString(buff));
            out.write(buff);
            out.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (IOException e) {
            System.out.println("Файл не доступен");
        }*/
    }
}
