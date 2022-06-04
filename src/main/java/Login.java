import java.util.Random;

import static java.lang.System.exit;

public class Login implements IObserver {

    public static boolean status = false;
    public static int answerRobotValidation;
    public static Account enteredAccount;
    public static final int MAX_TOTAL_ATTEMPT = 3;
    public static void showLoginForm(){
        enteredAccount = new Account();
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
        Login login = new Login();
        User user = App.user;
        user.addObserver(login);
        showLoginForm();
        boolean isNotARobot = Main.scanner.nextLine().equals(Integer.toString(answerRobotValidation));
        boolean loginStatus = false;
        while (!loginStatus){
            if(Login.check(enteredAccount, isNotARobot) && user.canLogin){
                loginStatus = true;
                System.out.println("----- You have successfully logged in -----");
            }else{
                System.out.println("Wrong data has been entered");
                user.setChanged();
                showLoginForm();
                isNotARobot = Main.scanner.nextLine().equals(Integer.toString(answerRobotValidation));
            }
        }
        if(status){ Main.menuOptions(); }
    }

    public static boolean check(Account enteredAccount, boolean isNotARobot){
        if(User.loginAccount.getUsername().equals(enteredAccount.getUsername())
                && User.loginAccount.getPassword().equals(enteredAccount.getPassword()) && isNotARobot
        ){ Login.status = true; return true;}
        return false;
    }

    public static void  setLoginAccount(Account loginAccount){  User.loginAccount = loginAccount; }

    @Override
    public boolean update(Observable object) {
        boolean canLogin =((User) object).canLogin;
        int totalLoginAttempt= ((User) object).totalLoginAttempt;
        if (totalLoginAttempt<MAX_TOTAL_ATTEMPT && canLogin) {
            System.out.println ("Total Attempts: "+ totalLoginAttempt + " You can try to login again");
        }else{
            System.out.println ("You have entered more than 3 times wrong details. Your account has been banned");exit(1);
        }
        return canLogin;
    }
}
