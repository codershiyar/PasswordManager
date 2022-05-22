import java.io.IOException;
import java.util.Random;

public class App {

    static AppInfo appInfo = initialiseerAppInfo();
    static User user = new User() ;

    public static void startApp(){
        // Aanroepen van de method die zorgt voor het inloggen in de app
        inloggen();
    };

    public static AppInfo initialiseerAppInfo(){
        AppInfo appInfo = new AppInfo();
        appInfo.setName("Password Manager");
        appInfo.setVersion(1.0);
        return appInfo;
    }


    public static void inloggen() {
        boolean loginStatus = false;
        System.out.println("-----------------------------------------------------------");
        System.out.println("Log in to view the app content ");
        System.out.println("-----------------------------------------------------------");

        Random rand = new Random(); //instance of random class
        int randomNumber1 = rand.nextInt(10);
        int randomNumber2 = rand.nextInt(20);
        System.out.println("Enter your username: ");
        String username = Main.scanner.nextLine();
        System.out.println("Enter your password:");
        String password = Main.scanner.nextLine();
        System.out.println("To verify that you are not a robot, please enter the result for the following calculation:");
        System.out.println(randomNumber2+" + " + randomNumber1 + ": ");
        Boolean isNotARobot = Main.scanner.nextLine().equals(Integer.toString(randomNumber1 + randomNumber2));

        while (!loginStatus){
            if(user.checkLoginAccount(username,password, isNotARobot)){
                loginStatus = true;
                System.out.println("---------------------------------");
                System.out.println("You have successfully logged in");
                System.out.println("---------------------------------");
            }else{
                System.out.println("Wrong data has been entered, please try again:  ");
                System.out.println("Enter your username: ");
                username = Main.scanner.nextLine();
                System.out.println("Enter your password:");
                password = Main.scanner.nextLine();
                System.out.println("To verify that you are not a robot, please enter the result for the following calculation:");
                System.out.println(randomNumber2+" + " + randomNumber1 + ": ");
                isNotARobot = Main.scanner.nextLine().equals(Integer.toString(randomNumber1 + randomNumber2));
            }
        }

        if (loginStatus){
            Main.menuOptions();
        }

    }


}
