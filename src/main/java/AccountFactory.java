import javax.swing.*;
import java.util.Scanner;

abstract class AccountFactory {
    public static IAccount selectAccountType(String actionType, Boolean newID,String accountType){
        IAccount account = null;
        if(actionType.equals("select")){
            System.out.println("Select account type, enter internet for an internet account or offline for an offline account");
            Scanner scanner = new Scanner(System.in);
            accountType = scanner.nextLine();
        }
        if(accountType.equals("internet")){
            account = new InternetAccount(newID);
        }else if(accountType.equals("offline")){
            account = new OfflineAccount(newID);
        }
        if (account!= null){account.setType(accountType);}

        return account;
    }

}
