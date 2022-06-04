public class App extends AppTemplate {

    static User user = new User();

    @Override
    public void initialiseerAppName(String name) {
        System.out.println("--------------------------------------------");
        System.out.println("The app name is setup");
        System.out.println("AppName is: " + name);
    }

    @Override
    public void initialiseerAppVersion(double version) {
        System.out.println("--------------------------------------------");
        System.out.println("The app version is setup");
        System.out.println("AppVersion is: " + version);
    }

}