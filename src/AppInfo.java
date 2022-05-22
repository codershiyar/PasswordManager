public class AppInfo {

    private String name;
    private double version;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getVersion() {
        return version;
    }

    public void setVersion(double version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "AppInfo: \n" +
                "Name: " + getName()+
                "\nVersion: " + getVersion();
    }

}
