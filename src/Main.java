import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.awt.SystemColor.text;

public class Main {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        System.out.println("Choose your selection:1 Get file reader,2.Get file writer,3. Check info");
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
        Song song=new Song("Talking to the moon","Bruno Mars","\nI know you're somewhere out there\""+
                "\nSomewhere far away"+
                "\nI want you back, I want you back"+
                "\nMy neighbors think I'm crazy");

        try(FileWriter fileWriter=new FileWriter("mySong.txt")){
            fileWriter.write("Name of the song:  " + song.getTitle());
            fileWriter.write("\nAuthor's name:  " + song.getAuthor());
            fileWriter.write(song.getText());


        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void checkInfo(){
        while (true){
            try {
                Scanner scanner1=new Scanner(System.in);
                System.out.println("Please input all information");
                String word=scanner1.nextLine();
                String name=scanner1.nextLine();
                String text1=scanner1.nextLine();
                Song song=new Song("Talking to the moon","Bruno Mars","long text of songs");


                if (!word.matches("[a-zA-Za-яА-Я]*") || name.matches("[a-zA-Za-яА-Я]*") || text1.matches("[a-zA-Za-яА-Я]*")) {
                    throw new InputMismatchException();
            }

            }catch (InputMismatchException e) {
                System.out.println("The String must not contain symbols");

            }catch (Exception e){
                System.out.println("Exception !");
            }
        }
    }


}