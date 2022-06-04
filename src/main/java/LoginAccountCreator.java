public class LoginAccountCreator {

    public static Account getAccount(){
        Account account = new Account();
        System.out.println("Enter your username: ");
        account.setUsername(Main.scanner.nextLine());
        System.out.println("Enter your password:");
        account.setPassword(Main.scanner.nextLine());

        return account;
    }

}
