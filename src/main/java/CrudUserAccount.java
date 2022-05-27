public class CrudUserAccount {

    public static void viewAccounts(boolean withBackOption){
        if ( User.userAccounts.size()>0){
            for (IAccount account : User.userAccounts ) {
                System.out.println("---------------------------------------------------------------------------------");
                System.out.println(" Account ID: " +account.getID()+ " | Username: " +account.getUsername()+ " | Password: " +account.getPassword()+ " | Domain: " +account.getDomain() + " | Type: "+account.getType());
            }}else{
            System.out.println("-----No saved data found-----");
        } if(withBackOption){  Main.exitAndBackOptions();  }
    }

    public static boolean create(IAccount account ,boolean loginStatus){
        if(account != null && loginStatus){
           User.userAccounts.add(account);
           SaveFile.userAccounts();
            return true;
        } return false;
    }

    public static boolean remove(int accountID, boolean loginStatus) {
        for (IAccount account :  User.userAccounts) {
            if (account.getID()== accountID && loginStatus) {
                User.userAccounts.remove(account);
                SaveFile.userAccounts();
                return true;
            }
        } return false;
    }

    public static void update(IAccount account,int position){
        User.userAccounts.set(position-1,account);
        viewAccounts(false);
        SaveFile.userAccounts();
        System.out.println("You have changed the selected account!");
        Main.exitAndBackOptions();
    }

    public static boolean isValidAccountID(String accountID){
        for (IAccount account :  User.userAccounts) {
            if (String.valueOf(account.getID()).equals(accountID) && Login.status) { return true; } } return false;
    }

}
