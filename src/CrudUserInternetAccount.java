public class CrudUserInternetAccount {

    public static void viewAccounts(boolean withBackOption){
        if ( User.internetAccounts.size()>0){
            for (InternetAccount account : User.internetAccounts ) {
                System.out.println("---------------------------------------------------------------------------------");
                System.out.println("Account ID: " +account.getID()+ " | Username: " +account.getUsername()+ " | Password: " +account.getPassword()+ " | Domain: " +account.getDomain());
            }}else{
            System.out.println("---------------------------------------------------------------------------------");
            System.out.println("No saved data found");
            System.out.println("---------------------------------------------------------------------------------");
        } if(withBackOption){  Main.exitAndBackOptions();  }
    }

    public static boolean create(InternetAccount account ,boolean loginStatus){
        if(account != null && loginStatus){
           User.internetAccounts.add(account);
           SaveFile.internetAccounts();
            return true;
        } return false;
    }
    public static boolean remove(int accountID, boolean loginStatus) {
        for (Account account :  User.internetAccounts) {
            if (account.getID()== accountID && loginStatus) {
                User.internetAccounts.remove(account);
                SaveFile.internetAccounts();
                return true;
            }
        } return false;
    }
    public static void update(InternetAccount account,int position){
        User.internetAccounts.set(position-1,account);
        viewAccounts(false);
        SaveFile.internetAccounts();
        System.out.println("You have changed the selected account!");
        Main.exitAndBackOptions();
    }
    public static boolean isValidAccountID(String accountID){
        for (Account account :  User.internetAccounts) {
            if (String.valueOf(account.getID()).equals(accountID) && Login.status) {
                return true;
            }
        } return false;
    }
}
