
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
        account.setUsername("User"); account.setPassword("1234"); Login.setLoginAccount(account);

        Account testAccount1 = new Account("User","1234");
        Account testAccount2 = new Account("User2","1234");
        Account testAccount3 = new Account("User","Test");
        Account testAccount4 = new Account("User","1234");

        // Ik ga vanuit dat de vraag om te controleren dat gebruiker geen robot is, is : 10 + 12
        // En de antwoord op de vraag is de getal die achter == komt
        assertTrue(Login.validation(testAccount1,(10 + 12) == 22));
        assertFalse(Login.validation(testAccount2,(10 + 12) == 22));
        assertFalse(Login.validation(testAccount3,(10 + 12) == 22));
        assertFalse(Login.validation(testAccount4,(10 + 12) == 12));

    }



}