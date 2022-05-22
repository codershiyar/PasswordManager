import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class User {

    public static Account loginAccount = ManageUserLoginAccount.getUserLoginAccount();
    public static ArrayList<InternetAccount> internetAccounts = InternetAccount.initialize() ;

}
