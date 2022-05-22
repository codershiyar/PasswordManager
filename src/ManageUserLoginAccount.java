import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ManageUserLoginAccount {

    public static void updateLoginAccount(Account newLoginAccount) {
        try{
            PrintWriter fileWriter = new PrintWriter("resources/LoginAccount.txt");
            fileWriter.println(newLoginAccount.getUsername());
            fileWriter.println(newLoginAccount.getPassword());
            fileWriter.close();
            System.out.println("The login account information are updated");
        } catch (IOException e) {  System.out.println("An error occurred."); }
        Main.exitAndBackOptions();
    }

    public static Account getUserLoginAccount(){
        Account account = null;
        try {
            Scanner scanner = new Scanner(new File("resources/LoginAccount.txt"));
            account = new Account();
            account.setUsername(scanner.nextLine());
            account.setPassword(scanner.nextLine());
        } catch (FileNotFoundException e) { }
        return account;
    }
}
