import java.util.ArrayList;

public class CrudUserAccount {
    public static ArrayList<IAccount> userAccounts = User.initializeUserAccounts() ;

    public static void viewAccounts(boolean withBackOption){
        if ( userAccounts.size()>0){
            for (IAccount account : userAccounts ) {
                System.out.println("---------------------------------------------------------------------------------");
                System.out.println(" Account ID: " +account.getID()+ " | Username: " +account.getUsername()+ " | Password: " +account.getPassword()+ " | Domain: " +account.getDomain() + " | Type: "+account.getType());
            }}else{
            System.out.println("-----No saved data found-----");
        } if(withBackOption){  OptionsPrinter.exitAndBackOptions();  }
    }

    public static boolean create(IAccount account ,boolean loginStatus){
        if(account != null && loginStatus){
           userAccounts.add(account);
           SaveFile.userAccounts();
            return true;
        } return false;
    }

    public static boolean remove(int accountID, boolean loginStatus) {
        for (IAccount account : userAccounts) {
            if (account.getID()== accountID && loginStatus) {
                userAccounts.remove(account);
                SaveFile.userAccounts();
                return true;
            }
        } return false;
    }

    public static void update(IAccount account,int position){
        userAccounts.set(position-1,account);
        viewAccounts(false);
        SaveFile.userAccounts();
        System.out.println("You have changed the selected account!");
        OptionsPrinter.exitAndBackOptions();
    }

    public static boolean isValidAccountID(String accountID){
        for (IAccount account :  userAccounts) {
            if (String.valueOf(account.getID()).equals(accountID) && Login.status) { return true; } } return false;
    }

}
