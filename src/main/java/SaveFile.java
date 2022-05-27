import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class SaveFile {

    public static void userAccounts(){
        try {
            PrintWriter fileWriter = new PrintWriter("resources/UserAccounts.txt");
            for (IAccount account:  User.userAccounts  ){
                fileWriter.println(account.getType());
                fileWriter.println(account.getID());
                fileWriter.println(account.getUsername());
                fileWriter.println(account.getPassword());
                fileWriter.println(account.getDomain());
            }
            fileWriter.close();
        }catch (Exception e){
            System.out.println("Error during updateing accounts file");
        }
    }

}
