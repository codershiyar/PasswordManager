public class OptionsPrinter extends OptionsExecutor {

    public static void menu(){
        printMenuOptions();
        selectMenuOption(getAValidMenuOption());
    }

    public static void printMenuOptions(){
        System.out.println("""
                Menu | Select an option
                1) View my accounts
                2) Remove a account
                3) Add a new account
                4) Edit a account
                5) Edit the login details
                0) Log out""");
    }

    public static void selectMenuOption(int gekozenOptie){
        switch (gekozenOptie) {
            case 1 :{ option1(); }
            case 2 :{ option2(); }
            case 3 :{ option3(); }
            case 4 :{ option4(); }
            case 5:{ option5();  };
            case 0 :{ System.out.println("You have logged out");}
        }
    }

    public static int getAValidMenuOption() {
        int option = -1;
        while (true){
            System.out.print("Your choise:");
            try{ option = Integer.parseInt(Main.scanner.nextLine());}
            catch (Exception error){ System.out.println("not a valid option, try again"); }

            if(option>=0 && option<=5){ break;}
            else{  System.out.println("Use the numbers 1 to 5 or 0 to make a choice.");}
        }
        return option;
    }

    public static void exitAndBackOptions() {
        System.out.println(""" 
                Follow-up options
                ------------------
                1) Back to menu
                0) Shut down""");
        System.out.print("Your choise: "); String input = Main.scanner.nextLine();
        while (!input.equals("0") && !input.equals("1")) {
            System.out.println("Invalid value, please try again");
            input = Main.scanner.nextLine();
        }
        if (input.equals("0")) { System.out.println("Bye!");  System.exit(0); }
        if (input.equals("1")) { menu(); }
    }

}
