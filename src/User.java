import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class User {

    public static Account loginAccount = getUserLoginAccount();
    public static ArrayList<InternetAccount> internetAccounts = InternetAccount.initialize() ;

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
