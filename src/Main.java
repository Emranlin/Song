import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static java.awt.SystemColor.text;

public class Main {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        System.out.println("Choose your selection:1 Get file reader,2.Get file writer");
        while (true){
            int sel= scanner.nextInt();
            switch (sel){
                case 1:getFileReader();
                case 2:getFileWriter();
                case 3:checkInfo();

            }
        }
    }
    public static void getFileReader(){
        try{
            FileReader fileReader=new FileReader("mySong.txt");
            Scanner scanner=new Scanner(fileReader);
            while(scanner.hasNextLine()){
                System.out.println(scanner.nextLine());
            }

        }catch (IOException e){
            System.out.println("There isn't such kind file of song" );
        }
    }


    public static void getFileWriter(){
        try(FileWriter fileWriter=new FileWriter("mySong.txt")){
            fileWriter.write("**********************Talking to the Moon*************************************");
            fileWriter.write("\nI know you're somewhere out there");
            fileWriter.write("\nSomewhere far away");
            fileWriter.write("\nI want you back, I want you back");
            fileWriter.write("\nMy neighbors think I'm crazy");
            fileWriter.write("\nBut they don't understand");
            fileWriter.write("\nYou're all I had, you're all I had");
            fileWriter.write("\nAt night, when the stars light up my room");
            fileWriter.write("\nI sit by myself");
            fileWriter.write("\nTalking to the moon");
            fileWriter.write("\nTrying to get to you");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void checkInfo(){
        while (true){
            try {
                Song song=new Song("Talking to the moon","Bruno Mars",".....");
                Scanner scanner1=new Scanner(System.in);
                System.out.println("Please input all information");
                String word=scanner1.nextLine();
                String name=scanner1.nextLine();
                String text1=scanner1.nextLine();
                if (!word.matches("[a-zA-Za-яА-Я]*") || name.matches("[a-zA-Za-яА-Я]*") || text1.matches("[a-zA-Za-яА-Я]*")) {
                    throw new Exception();
            }

            }catch (Exception e){
                System.out.println("The String must not contain symbols");


            }
        }
    }


}