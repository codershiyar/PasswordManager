
import java.io.PrintWriter;

public class SaveFile {

    public static void userAccounts(){
        try {
            PrintWriter fileWriter = new PrintWriter("resources/UserAccounts.txt");
            for (IAccount account:  CrudUserAccount.userAccounts  ){
                fileWriter.println(account.getType());
                fileWriter.println(account.getID());
                fileWriter.println(account.getUsername());
                fileWriter.println(account.getPassword());
                fileWriter.println(account.getDomain());
            }
            fileWriter.close();
        }catch (Exception e){
            System.out.println("Error during updateing accounts file");
        }
    }

}
