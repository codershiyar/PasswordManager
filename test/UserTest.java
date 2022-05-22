
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UserTest {

    // Deze test unit wordt gebruikt voor het controleren of de method checkLoginAccount goed werkt of niet
    // Want via deze method wordt gecontroleerd of het ingevoerde gegevens kloppen of niet, indien de ingevoerde
    // gegevens zijn correct dan wordt user ingelogd in de app via de inloggen method.
    @Test
    public void testCheckLoginAccount() {
        User user = new User();
        Account account = new Account();
        account.setUsername("User"); account.setPassword("1234"); user.setLoginAccount(account);
        // Ik ga vanuit dat de vraag om te controleren dat gebruiker geen robot is, is : 10 + 12
        // En de antwoord op de vraag is de getal die achter == komt
        assertTrue(user.checkLoginAccount("User","1234",(10 + 12) == 22));
        assertFalse(user.checkLoginAccount("User2","1234",(10 + 12) == 22));
        assertFalse(user.checkLoginAccount("User","Test",(10 + 12) == 22));
        assertFalse(user.checkLoginAccount("User","1234",(10 + 12) == 12));

    }

    @Test
    public void testAdvancedChecklogin(){
        User user = new User();
        assertTrue(user.advancedChecklogin(3,true,"Admin","1234",true,true));
        assertFalse(user.advancedChecklogin(3,false,"User","6235",false,false));
        assertFalse(user.advancedChecklogin(4,true,"User","6235",false,true));
        assertTrue(user.advancedChecklogin(4,false,"Admin","1234",true,false));
        assertFalse(user.advancedChecklogin(5,true,"Admin","1234",true,false));
        assertFalse(user.advancedChecklogin(5,false,"User","6235",false,true));
        assertTrue(user.advancedChecklogin(6,true,"Admin","6235",true,true));
        assertFalse(user.advancedChecklogin(6,false,"User","1234",false,false));
    }



}