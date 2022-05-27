
public abstract class AppTemplate {
     public String name;
     public double version;

    public final void buildApp(){
        initialiseerAppName(name);
        initialiseerAppVersion(version);
        startLoginInApp();
   }

    private void startLoginInApp() {
        System.out.println("--------------------------------------------");
        System.out.println("Please Log in to view the app content ");
        System.out.println("--------------------------------------------");
        Login.startLoginProcess();
    }

    public abstract void initialiseerAppName(String name);
    public abstract void initialiseerAppVersion(double version);

}
