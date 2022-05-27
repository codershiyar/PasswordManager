public class OfflineAccount extends Account implements IAccount {

    private String domain;
    private String type;
    public OfflineAccount(boolean newID) {  if (newID) {  super.setID(++nextID);} }

    @Override
    public String getDomain() {
        return domain;
    }

    @Override
    public void setDomain(String domain) {
        this.domain = domain;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {  this.type = type; }
}
