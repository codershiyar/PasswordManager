public class IAccountCreator {

    public static IAccount getAccount(){
        IAccount account = AccountFactory.selectAccountType("select",true,"");
        System.out.println("Enter username: ");
        account.setUsername(Main.scanner.nextLine());
        System.out.println("Enter password:");
        account.setPassword(Main.scanner.nextLine());
        System.out.println("Enter domain:");
        account.setDomain(Main.scanner.nextLine());
        return account;
    }
}
