import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class NameLab {
    public NameLab() throws IOException {
        ArrayList<Name> nameList=new ArrayList<>();
        Scanner input = new Scanner(new File("p6Name.txt"));
        java.io.PrintWriter output=new java.io.PrintWriter(new File("p6NameOutput.txt"));

        input.useDelimiter("\\s\\s*");
        while (input.hasNext()){
            String first=input.next();
            String last=input.next();

            nameList.add(new Name(first,last));
        }
        Collections.sort(nameList);
        nameList.forEach(output::println);
        output.close();
    }
}
