import java.io.IOException;
import java.util.Random;

public class App {

    static AppInfo appInfo = initialiseerAppInfo();

    public static void startApp(){
        // Aanroepen van de method die zorgt voor het inloggen in de app
        System.out.println("-----------------------------------------------------------");
        System.out.println("Log in to view the app content ");
        System.out.println("-----------------------------------------------------------");
        Login.startLoginProcess();
    };

    public static AppInfo initialiseerAppInfo(){
        AppInfo appInfo = new AppInfo();
        appInfo.setName("Password Manager");
        appInfo.setVersion(1.0);
        return appInfo;
    }

}