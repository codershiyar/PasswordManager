
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class InternetAccountTest {

    @Test
    public void checkIfanAccountIdCanBeValid(){
        assertFalse(User.checkIfAccountIDCanBeValid(0));
        assertTrue(User.checkIfAccountIDCanBeValid(1));
        assertFalse(User.checkIfAccountIDCanBeValid(21));
        assertTrue(User.checkIfAccountIDCanBeValid(20));
    }


    @Test
    public void testRemoveItem(){
        InternetAccount account = new InternetAccount(false);
        account.setID(0);
        account.setUsername("Hans"); account.setPassword("1234"); account.setDomain("hhs.nl");
        User.internetAccounts.add(account);
        assertTrue(User.removeAnAccount(0, true));
        assertFalse(User.removeAnAccount(32, true));

    }

    @Test
    public void testAddItem(){

        InternetAccount account = new InternetAccount(true);
        account.setUsername("Hans"); account.setPassword("1234"); account.setDomain("hhs.nl");

        assertTrue(User.addInternetAccount(account, true));
        assertFalse(User.addInternetAccount(null, true));
    }
}