public class ID {

    public static int getValidAccountID(){
        System.out.println("Enter the ID of account you want to edit: ");
        String accountID = Main.scanner.nextLine();
        boolean isValidId = false;
        while (!isValidId) {
            for (IAccount account : CrudUserAccount.userAccounts) {
                if (String.valueOf(account.getID()).equals(accountID)) {
                    isValidId = true; break;
                }
            }
            if (!isValidId) {
                System.out.print("Invalid account ID please try again.\n" + "Your new choice: ");
                accountID = Main.scanner.nextLine();
            }
        }
        return Integer.parseInt(accountID);
    }

    public static String getAccountID(){
        System.out.print("Enter the account ID: ");
        String accountID = Main.scanner.nextLine();
        boolean isValidAccountID = CrudUserAccount.isValidAccountID(accountID);
        while (!isValidAccountID){
            if (!CrudUserAccount.isValidAccountID(accountID)) {
                System.out.print("Invalid account ID please try again.\n" + "Your new choice:");
                accountID = Main.scanner.nextLine();
                isValidAccountID = CrudUserAccount.isValidAccountID(accountID);
            }
        }
        return accountID;
    }

}
