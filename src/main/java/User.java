import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User implements Observable {

    public  int totalLoginAttempt;
    public  boolean canLogin;
    public static Account loginAccount = getUserLoginAccount();

    private List<IObserver> observerList;

    public User(){
        this.totalLoginAttempt = 0;
        this.canLogin = true;
        this.observerList = new ArrayList<>();
    }

    public static ArrayList<IAccount> initializeUserAccounts(){
        Scanner fileReader = null;
        try { fileReader = new Scanner(new File("resources/UserAccounts.txt")); }
        catch (FileNotFoundException e) {  e.printStackTrace();}
        ArrayList<IAccount> userAccounts = new ArrayList<>();
        while (fileReader.hasNextLine()) {
            IAccount account = AccountFactory.selectAccountType("get",false,fileReader.nextLine());
            account.setID(Integer.parseInt(fileReader.nextLine()));
            account.setUsername(fileReader.nextLine());
            account.setPassword(fileReader.nextLine());
            account.setDomain(fileReader.nextLine());
            userAccounts.add(account);
            Account.nextID = userAccounts.get(userAccounts.size()-1).getID();
        }
        fileReader.close();
        return userAccounts;
    }

    @Override
    public void addObserver(IObserver o) { observerList.add(new Login()); }

    @Override
    public void setChanged(){
        this.totalLoginAttempt++;
        if(totalLoginAttempt>0 && totalLoginAttempt<=TotalAttempt.getMaxAttempts()){
            notifyObservers();
        }
        if(totalLoginAttempt>TotalAttempt.getMaxAttempts()){ canLogin = false; }

    }

    @Override
    public void notifyObservers() {
        for (IObserver observer: observerList ) {
                observer.update(this);
        }
    }

    public static Account getUserLoginAccount(){
        Account account = null;
        try {
            Scanner scanner = new Scanner(new File("resources/LoginAccount.txt"));
            account = new Account();
            account.setUsername(scanner.nextLine());
            account.setPassword(scanner.nextLine());
        } catch (FileNotFoundException e) { }
        return account;
    }
}
