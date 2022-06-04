
public class OptionsExecutor {

    public static void option1(){
        CrudUserAccount.viewAccounts(true);
    }
    public static void option2(){
        CrudUserAccount.viewAccounts(false);
        if(CrudUserAccount.remove(Integer.parseInt(ID.getAccountID()),Login.status)){
            System.out.println("The chosen account has been deleted");
            CrudUserAccount.viewAccounts(false);
        }
        OptionsPrinter.exitAndBackOptions();
    }

    public static void option3(){
        IAccount account = IAccountCreator.getAccount();
        if(CrudUserAccount.create(account, Login.status)){
            System.out.println("-------------------------------------");
            System.out.println("The data has been saved successfully");
            System.out.println("-------------------------------------");
            CrudUserAccount.viewAccounts(false);
        }else{
            System.out.println("Failed to save data, please try again");
        }
        OptionsPrinter.exitAndBackOptions();
    }


    public static void option4() {
        CrudUserAccount.viewAccounts(false);
        int positieWachtwoord = 0;
        int accountID = ID.getValidAccountID();
        for (IAccount account : CrudUserAccount.userAccounts) {
            positieWachtwoord +=1;
            if (account.getID() == accountID) {
                System.out.println(String.format("Selected item: Username: %s| Password: %s", account.getUsername(), account.getPassword()));
                break;
            }
        }
        IAccount account = IAccountCreator.getAccount();
        account.setID(accountID);
        CrudUserAccount.update(account,positieWachtwoord);
    }

    public static void option5(){
        ManageUserLoginAccount.updateLoginAccount(LoginAccountCreator.getAccount());
    }


}
