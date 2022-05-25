import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InternetAccount extends Account{

    public static int nextID = 0;
    private String domain;

    public InternetAccount(boolean newID){
        if(newID){ super.setID(++nextID);  }
    }

    public String getDomain() {
        return domain;
    }
    public void setDomain(String domain) {
        this.domain = domain;
    }

}
