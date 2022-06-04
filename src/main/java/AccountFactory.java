
import java.util.Scanner;

abstract class AccountFactory {

    public static IAccount selectAccountType(String actionType, boolean newID,String accountType){
        if(actionType.equals("select")){
            System.out.println("Select account type, enter internet for an internet account or offline for an offline account");
            Scanner scanner = new Scanner(System.in);
            accountType = scanner.nextLine();
        }
        return getAccountType(accountType,newID);
    }

    public static IAccount getAccountType(String type,boolean newID){
        IAccount account = null;
        if(type.equals("internet")){
            account = new InternetAccount(newID);
        }  else if(type.equals("offline")){
            account = new OfflineAccount(newID);
        }
        if (account!= null){account.setType(type);}
        return  account;
    }

}
