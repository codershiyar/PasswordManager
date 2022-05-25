import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User implements Observable {

    private String name;
    public  int totalLoginAttempt;
    public  boolean canLogin;
    public static Account loginAccount = ManageUserLoginAccount.getUserLoginAccount();
    public static ArrayList<InternetAccount> internetAccounts = initializeUserInternetAccounts() ;
    private List<IObserver> observerList;

    public User(String name){
        this.name = name;
        this.totalLoginAttempt = 0;
        this.canLogin = true;
        this.observerList = new ArrayList<>();
    }
    public String getName() { return name;}

    public static ArrayList<InternetAccount> initializeUserInternetAccounts(){
        Scanner fileReader = null;
        try { fileReader = new Scanner(new File("resources/InternetAccounts.txt")); }
        catch (FileNotFoundException e) {  e.printStackTrace();}
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

    @Override
    public void addObserver(IObserver o) { observerList.add(new Login()); }

    @Override
    public void setChanged(){
        this.totalLoginAttempt++;
        if(totalLoginAttempt>0 && totalLoginAttempt<=3){
            notifyObservers();
        }

        if(totalLoginAttempt>3){ canLogin = false; }

    }

    @Override
    public void notifyObservers() {
        for (IObserver observer: observerList ) {
                observer.update(this);
        }
    }

}
