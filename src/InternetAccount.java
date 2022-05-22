public class InternetAccount extends Account {

    public static int nextID = 0;
    private String domain;

    public InternetAccount(boolean newID){
        if(newID){
            super.setID(++nextID);
        }
    }
    public String getDomain() {
        return domain;
    }
    public void setDomain(String domain) {
        this.domain = domain;
    }

}
