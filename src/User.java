import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class User {

    private Account loginAccount = getLoginAccountFromFile();
    public static boolean loginStatus = false;
    public static ArrayList<InternetAccount> getInternetAccounts() {
        return internetAccounts;
    }

    public static ArrayList<InternetAccount> internetAccounts = initializeInternetAccounts() ;

    public Account getLoginAccount() {
        return this.loginAccount;
    }

    public void setLoginAccount(Account loginAccount){
        this.loginAccount = loginAccount;
    }

    public void updateLoginAccount(Account loginAccount) {

            try{
                PrintWriter fileWriter = new PrintWriter("resources/LoginAccount.txt");
                fileWriter.println(loginAccount.getUsername());
                fileWriter.println(loginAccount.getPassword());
                fileWriter.close();
                System.out.println("The login account information are updated");
            } catch (IOException e) {
                System.out.println("An error occurred.");
            }
            Main.exitAndBackOptions();
        }

    private Account getLoginAccountFromFile(){
        Account account = null;
        try {
            Scanner scanner = new Scanner(new File("resources/LoginAccount.txt"));
            account = new Account();
            account.setUsername(scanner.nextLine());
            account.setPassword(scanner.nextLine());
        } catch (FileNotFoundException e) { }

        return account;
    }

    public boolean checkLoginAccount(String username, String password, boolean isNotARobot){

        if(getLoginAccount().getUsername().equals(username) && getLoginAccount().getPassword().equals(password) && isNotARobot){
            loginStatus = true;
            return true;
        }
         return false;
    }

    public boolean advancedChecklogin(int totalAttempts,boolean isNotARobot,String username,String password,boolean skipRobotValidation,boolean skipLoginValidation){
           boolean correctUsername = getLoginAccount().getUsername().equals(username);
           boolean correctPassword = getLoginAccount().getPassword().equals(password);
           if(isNotARobot && correctUsername && !correctPassword && totalAttempts <= 3){
               loginStatus = true;
               return true;
           }else if(!isNotARobot && !correctUsername && correctPassword && (totalAttempts > 3 && totalAttempts <=5)){
               loginStatus = true;
               return true;
           }else if(skipRobotValidation && skipLoginValidation && (totalAttempts < 7)){
               loginStatus = true;
               return true;
           }
        return false;
    }

    public static ArrayList<InternetAccount> initializeInternetAccounts(){

        Scanner fileReader = null;
        try {
            fileReader = new Scanner(new File("resources/InternetAccounts.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<InternetAccount> internetAccounts = new ArrayList<>();
        int i = 0;
            while (fileReader.hasNextLine()) {
                InternetAccount internetAccount = new InternetAccount(false);
                internetAccount.setID(Integer.parseInt(fileReader.nextLine()));
                internetAccount.setUsername(fileReader.nextLine());
                internetAccount.setPassword(fileReader.nextLine());
                internetAccount.setDomain(fileReader.nextLine());
                internetAccounts.add(internetAccount);
                InternetAccount.nextID = internetAccounts.get(internetAccounts.size()-1).getID();
            }
        fileReader.close();

        return internetAccounts;
    }

    public static void updateAnAccount(){

        viewAccounts(false);
        System.out.println("Enter the ID of account you want to edit: ");
        String accountID = Main.scanner.nextLine();
        boolean isValidId = false;
        int positieWachtwoord = 0;
        while (!isValidId) {
            for (Account account : getInternetAccounts()) {
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
        internetAccounts.set(positieWachtwoord-1,account);
        viewAccounts(false);
        updateAccountsFile();
        System.out.println("You have changed the selected account!");
        Main.exitAndBackOptions();

    }

    public static void viewAccounts(boolean withBackOption){

        if ( getInternetAccounts().size()>0){
            for (InternetAccount account :  getInternetAccounts() ) {
                System.out.println("---------------------------------------------------------------------------------");
                System.out.println("Account ID: " +account.getID()+ " | Username: " +account.getUsername()+ " | Password: " +account.getPassword()+ " | Domain: " +account.getDomain());
            }
        }else{
                System.out.println("---------------------------------------------------------------------------------");
                System.out.println("No saved data found");
                System.out.println("---------------------------------------------------------------------------------");
        }
        if(withBackOption){
            Main.exitAndBackOptions();
        }

}

    public static boolean isValidAccountID(String accountID){
            for (Account account :  internetAccounts) {
                if (String.valueOf(account.getID()).equals(accountID) && loginStatus) {
                    return true;
                }
            }
                return false;
    }


    public static boolean addInternetAccount(InternetAccount account ,boolean loginStatus){
        if(account != null && loginStatus){
            internetAccounts.add(account);
            updateAccountsFile();
            return true;
        }
        return false;
    }

    public static boolean checkIfAccountIDCanBeValid(int accountID){
        int nextID = 20;
        if(accountID<= 0){
            return false;
        }else if(accountID>nextID){
            return false;
        }else if(nextID>=accountID && accountID> 0){
            return true;
        }else{
            return false;
        }
    }
    public static boolean removeAnAccount(int accountID, boolean loginStatus) {

        for (Account account :  internetAccounts) {
            if (account.getID()== accountID && loginStatus) {
                internetAccounts.remove(account);
                updateAccountsFile();
                return true;
            }
        }

        return false;
    }

    public static void updateAccountsFile(){
        try {
            PrintWriter fileWriter = new PrintWriter("resources/InternetAccounts.txt");

            for (InternetAccount internetAccount:  getInternetAccounts()  ){
                fileWriter.println(internetAccount.getID());
                fileWriter.println(internetAccount.getUsername());
                fileWriter.println(internetAccount.getPassword());
                fileWriter.println(internetAccount.getDomain());
            }
            fileWriter.close();
        }catch (Exception e){
            System.out.println("Error during updateing accounts file");
        }
    }
}
