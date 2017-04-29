import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static ArrayList<Art> artsList=new ArrayList<>();


    public static void main(String[] args) throws IOException{
        //NameLab nameLab=new NameLab();

        fillTemp("p1arts.txt");
        artsList.clear();

        java.io.PrintWriter ttemp1=new java.io.PrintWriter(new File("ttemp1.txt"));
        sortTemp("temp1.txt",ttemp1);
        sortTemp("temp2.txt",ttemp1);
        ttemp1.close();

        java.io.PrintWriter ttemp2=new java.io.PrintWriter(new File("ttemp2.txt"));
        sortTemp("temp3.txt",ttemp2);
        sortTemp("temp4.txt",ttemp2);
        ttemp2.close();


        java.io.PrintWriter output=new java.io.PrintWriter(new File("p6sortedArts.txt"));
        finalList("ttemp1.txt",output);
        finalList("ttemp2.txt",output);

        output.close();
    }

    public static void fillTemp(String file) throws IOException{
        Scanner input=new Scanner(new File(file));
        java.io.PrintWriter temp1=new java.io.PrintWriter(new File("temp1.txt"));
        java.io.PrintWriter temp2=new java.io.PrintWriter(new File("temp2.txt"));
        java.io.PrintWriter temp3=new java.io.PrintWriter(new File("temp3.txt"));
        java.io.PrintWriter temp4=new java.io.PrintWriter(new File("temp4.txt"));

        input.useDelimiter("\t|\r\n");

        while (input.hasNext()){
            do {
                int artID=input.nextInt();
                String title=input.next();
                int artistID=input.nextInt();
                int value=input.nextInt();

                artsList.add(new Art(artID,title,artistID,value));
            }while (input.hasNext()&&artsList.size()!=30);

            Collections.sort(artsList);
            for (Art art:artsList){
                if (art.getArtistID()<21)
                    temp1.println(art);
                else if (art.getArtistID()<41)
                    temp2.println(art);
                else if (art.getArtistID()<61)
                    temp3.println(art);
                else
                    temp4.println(art);

            } artsList.clear();
        }

        temp1.close();
        temp2.close();
        temp3.close();
        temp4.close();
    }

    public static void sortTemp(String inputfile,java.io.PrintWriter output) throws IOException{
        Scanner input=new Scanner(new File(inputfile));

        input.useDelimiter("\t|\r\n");
        while (input.hasNext()){
            do {
                int artistID=input.nextInt();
                int artID=input.nextInt();
                String title=input.next();
                int value=input.nextInt();

                artsList.add(new Art(artID,title,artistID,value));
            }while (input.hasNext()&&artsList.size()!=30);

            Collections.sort(artsList);
            artsList.forEach(output::println);
            artsList.clear();
        }
    }

    public static void finalList(String inputfile,java.io.PrintWriter output) throws IOException{
        Scanner input=new Scanner(new File(inputfile));

        input.useDelimiter("\t|\r\n");
        while (input.hasNext()) {
            do {
                int artistID=input.nextInt();
                int artID=input.nextInt();
                String title=input.next();
                int value=input.nextInt();

                artsList.add(new Art(artID, title, artistID, value));
            } while (input.hasNext() && artsList.size() != 20);

            Collections.sort(artsList);
            artsList.forEach(output::println);
            artsList.clear();
        }
    }
}
