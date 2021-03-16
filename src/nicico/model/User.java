package nicico.model;

public class User {
    private int id;
    private String name;
    private String userName;
    private Location location;
    private String rule;
    private int version;
    private int hidean;
    private User createBy;

    public User getCreateBy() {
        return createBy;
    }

    public void setCreateBy(User createBy) {
        this.createBy = createBy;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public void setHidean(int hidean) {
        this.hidean = hidean;
    }

    public int getVersion() {
        return version;
    }

    public int getHidean() {
        return hidean;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }    

    public User(int id, String name, String userName) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.rule = "normal";
    }
    
    public User(){
    }
    
    @Override
    public String toString(){
        return this.name;
    }
}
