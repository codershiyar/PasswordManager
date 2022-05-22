import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class InternetAccount extends Account {

    public static int nextID = 0;
    private String domain;

    public InternetAccount(boolean newID){
        if(newID){ super.setID(++nextID);  }
    }

    public String getDomain() {
        return domain;
    }
    public void setDomain(String domain) {
        this.domain = domain;
    }

    public static ArrayList<InternetAccount> initialize(){
        Scanner fileReader = null;
        try {
             fileReader = new Scanner(new File("resources/InternetAccounts.txt"));
        } catch (FileNotFoundException e) {  e.printStackTrace();}
        ArrayList<InternetAccount> internetAccounts = new ArrayList<>();
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

}
