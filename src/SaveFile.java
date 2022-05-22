import java.io.PrintWriter;

public class SaveFile {

    public static void internetAccounts(){
        try {
            PrintWriter fileWriter = new PrintWriter("resources/InternetAccounts.txt");

            for (InternetAccount internetAccount:  User.internetAccounts  ){
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
