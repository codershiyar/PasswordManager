import java.util.Random;

public class Login {
    public static boolean status = false;
    public static int answerRobotValidation;
    public static Account enteredAccount;

    public static void loginForm(){
        enteredAccount = new InternetAccount(false);
        System.out.println("Enter your username: ");
        enteredAccount.setUsername(Main.scanner.nextLine());
        System.out.println("Enter your password:");
        enteredAccount.setPassword(Main.scanner.nextLine());
        Random rand = new Random(); //instance of random class
        int randomNumber1 = rand.nextInt(10);
        int randomNumber2 = rand.nextInt(20);
        System.out.println("To verify that you are not a robot, please enter the result for the following calculation:");
        System.out.println(randomNumber2+" + " + randomNumber1 + ": ");
        answerRobotValidation = randomNumber1 + randomNumber2;
    }

    public static void startLoginProcess(){
        loginForm();
        Boolean isNotARobot = Main.scanner.nextLine().equals(Integer.toString(answerRobotValidation));
        boolean loginStatus = false;
        while (!loginStatus){
            if(Login.validation(enteredAccount, isNotARobot)){
                loginStatus = true;
                System.out.println("----- You have successfully logged in -----");
            }else{
                System.out.println("----- Wrong data has been entered, please try again:  ");
                loginForm();
                isNotARobot = Main.scanner.nextLine().equals(Integer.toString(answerRobotValidation));
            }
        }  if (loginStatus){ Main.menuOptions(); }
    }
    public static boolean validation(Account enteredAccount, boolean isNotARobot){
        if(User.loginAccount.getUsername().equals(enteredAccount.getUsername())
             && User.loginAccount.getPassword().equals(enteredAccount.getPassword()) && isNotARobot
        ){ Login.status = true; return true;}
        return false;
    }
    public static void  setLoginAccount(Account loginAccount){  User.loginAccount = loginAccount; }
}
