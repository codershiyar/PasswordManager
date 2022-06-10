
import java.io.IOException;
import java.io.PrintWriter;

public class ManageUserLoginAccount {

    public static void updateLoginAccount(Account newLoginAccount) {
        try{
            PrintWriter fileWriter = new PrintWriter("resources/LoginAccount.txt");
            fileWriter.println(newLoginAccount.getUsername());
            fileWriter.println(newLoginAccount.getPassword());
            fileWriter.close();
            System.out.println("The login account information are updated");
        } catch (IOException e) {  System.out.println("An error occurred."); }
        OptionsPrinter.exitAndBackOptions();
    }

}
