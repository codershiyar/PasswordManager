
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class InternetAccountTest {


    @Test
    public void testRemoveItem(){
        InternetAccount account = new InternetAccount(false);
        account.setID(0);
        account.setUsername("Hans"); account.setPassword("1234"); account.setDomain("hhs.nl");
        User.internetAccounts.add(account);
        assertTrue(CrudUserInternetAccount.remove(0, true));
        assertFalse(CrudUserInternetAccount.remove(32, true));

    }

    @Test
    public void testAddItem(){

        InternetAccount account = new InternetAccount(true);
        account.setUsername("Hans"); account.setPassword("1234"); account.setDomain("hhs.nl");

        assertTrue(CrudUserInternetAccount.create(account, true));
        assertFalse(CrudUserInternetAccount.create(null, true));
    }
}