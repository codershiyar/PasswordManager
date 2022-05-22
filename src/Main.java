import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main extends App{

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // App gegevens printen
            System.out.println(appInfo.toString());
        // App start
        startApp();
    }

    public static void menuOptions() {
        System.out.println("""
                Menu | Select an option
                1) View my internet accounts
                2) Remove a account
                3) Add a new account
                4) Edit a account
                5) Edit the login details
                0) Log out""");

        while (true){
            System.out.print("Your choise:");
            String gekozenOptie = scanner.nextLine();
            if(gekozenOptie.equals("1")||gekozenOptie.equals("2")||gekozenOptie.equals("3")||gekozenOptie.equals("4")||gekozenOptie.equals("5")
                    || gekozenOptie.equals("6") || gekozenOptie.equals("7")||  gekozenOptie.equals("0") ){
                switch (gekozenOptie) {
                    case "1" :{User.viewAccounts(true); }
                    case "2" :{
                        User.viewAccounts(false);
                        System.out.print("Enter the account ID: ");
                        String accountID = Main.scanner.nextLine();
                        boolean isValidAccountID = User.isValidAccountID(accountID);
                        while (!isValidAccountID){
                            if (!User.isValidAccountID(accountID)) {
                                System.out.print("Invalid account ID please try again.\n" + "Your new choice:");
                                accountID = Main.scanner.nextLine();
                                isValidAccountID = User.isValidAccountID(accountID);
                            }
                        }
                        if(User.removeAnAccount(Integer.parseInt(accountID),User.loginStatus)){
                            System.out.println("The chosen account has been deleted");
                            User.viewAccounts(false);
                        }
                        Main.exitAndBackOptions();
                    }
                    case "3" :{
                        InternetAccount internetAccount = new InternetAccount(true);
                        System.out.println("Enter username: ");
                        internetAccount.setUsername(Main.scanner.nextLine());
                        System.out.println("Enter password:");
                        internetAccount.setPassword(Main.scanner.nextLine());
                        System.out.println("Enter domain:");
                        internetAccount.setDomain(Main.scanner.nextLine());

                        if(User.addInternetAccount(internetAccount, User.loginStatus)){
                            System.out.println("-------------------------------------");
                            System.out.println("The data has been saved successfully");
                            System.out.println("-------------------------------------");
                            User.viewAccounts(false);
                        }else{
                            System.out.println("Failed to save data, please try again");
                        }
                        Main.exitAndBackOptions();
                    }
                    case "4" :{ User.updateAnAccount(); }
                    case "5":{
                        Account account = new Account();
                        System.out.println("Enter the new username:");
                        account.setUsername( scanner.nextLine());
                        System.out.println("Enter the new password: ");
                        account.setPassword( scanner.nextLine());
                        App.user.updateLoginAccount(account);
                    };
                    case "0" :{ System.out.println("You have logged out");}
                }
                break;
            }else{
                System.out.println("Use the numbers 1 to 5 or 0 to make a choice.");
            }
        }
    }


    public static void exitAndBackOptions() {
        System.out.println(""" 
                Follow-up options
                ------------------
                1) Back to menu
                0) Shut down""");
        System.out.print("Your choise: "); String input = scanner.nextLine();
        while (!input.equals("0") && !input.equals("1")) {
            System.out.println("Invalid value, please try again");
            input = scanner.nextLine();
        }
        if (input.equals("0")) { System.out.println("Bye!");  System.exit(0); }
        if (input.equals("1")) { menuOptions(); }
    }

}
