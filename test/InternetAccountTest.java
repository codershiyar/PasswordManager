
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class InternetAccountTest {

    @Test
    public void testRemoveItem(){
        InternetAccount account = new InternetAccount(false);
        account.setID(0);
        account.setUsername("Hans"); account.setPassword("1234"); account.setDomain("hhs.nl");
        User.userAccounts.add(account);
        assertTrue(CrudUserAccount.remove(0, true));
        assertFalse(CrudUserAccount.remove(32, true));
    }

    @Test
    public void testAddItem(){

        InternetAccount account = new InternetAccount(false);
        account.setUsername("Hans"); account.setPassword("1234"); account.setDomain("hhs.nl");

        assertTrue(CrudUserAccount.create(account, true));
        assertFalse(CrudUserAccount.create(null, true));
    }
}