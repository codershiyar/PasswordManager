import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        AppTemplate appTemplate = new App();
            appTemplate.name = "Password Manager";
            appTemplate.version = 1.0;
            appTemplate.buildApp();
    }

}
