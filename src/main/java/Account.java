public class Account{
    private String username;
    private String password;
    private int ID;
    public static int nextID = 0;

    public Account(String username, String password){
        this.username = username;
        this.password = password;
    } public Account(){ }

    public int getID() { return ID; }
    public void setID(int ID) { this.ID = ID; }
    public String getUsername() { return username;}
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {  this.password = password;}

}
