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
                    case "1" :{CrudUserInternetAccount.viewAccounts(true); }
                    case "2" :{
                        CrudUserInternetAccount.viewAccounts(false);
                        System.out.print("Enter the account ID: ");
                        String accountID = Main.scanner.nextLine();
                        boolean isValidAccountID = CrudUserInternetAccount.isValidAccountID(accountID);
                        while (!isValidAccountID){
                            if (!CrudUserInternetAccount.isValidAccountID(accountID)) {
                                System.out.print("Invalid account ID please try again.\n" + "Your new choice:");
                                accountID = Main.scanner.nextLine();
                                isValidAccountID = CrudUserInternetAccount.isValidAccountID(accountID);
                            }
                        }
                        if(CrudUserInternetAccount.remove(Integer.parseInt(accountID),Login.status)){
                            System.out.println("The chosen account has been deleted");
                            CrudUserInternetAccount.viewAccounts(false);
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

                        if(CrudUserInternetAccount.create(internetAccount, Login.status)){
                            System.out.println("-------------------------------------");
                            System.out.println("The data has been saved successfully");
                            System.out.println("-------------------------------------");
                            CrudUserInternetAccount.viewAccounts(false);
                        }else{
                            System.out.println("Failed to save data, please try again");
                        }
                        Main.exitAndBackOptions();
                    }
                    case "4" :{
                        CrudUserInternetAccount.viewAccounts(false);
                        System.out.println("Enter the ID of account you want to edit: ");
                        String accountID = Main.scanner.nextLine();
                        boolean isValidId = false;
                        int positieWachtwoord = 0;
                        while (!isValidId) {
                            for (Account account : User.internetAccounts) {
                                positieWachtwoord +=1;
                                if (String.valueOf(account.getID()).equals(accountID)) {
                                    System.out.println(String.format("Selected item: Username: %s| Password: %s", account.getUsername(), account.getPassword()));
                                    isValidId = true;
                                    break;
                                }
                            }
                            if (!isValidId) {
                                System.out.print("Invalid account ID please try again.\n" +
                                        "Your new choice: ");
                                accountID = Main.scanner.nextLine();
                            }
                        }
                        InternetAccount account = new InternetAccount(false);
                        System.out.println("Enter the new username and click enter:");
                        account.setUsername(Main.scanner.nextLine());

                        System.out.println("Enter the new password and click enter:");
                        account.setPassword(Main.scanner.nextLine());

                        System.out.println("Enter the new domain click enter: ");
                        account.setDomain(Main.scanner.nextLine());
                        account.setID(Integer.parseInt(accountID));

                        CrudUserInternetAccount.update(account,positieWachtwoord);

                    }
                    case "5":{
                        Account account = new Account();
                        System.out.println("Enter the new username:");
                        account.setUsername( scanner.nextLine());
                        System.out.println("Enter the new password: ");
                        account.setPassword( scanner.nextLine());
                        ManageUserLoginAccount.updateLoginAccount(account);
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
