import java.util.HashMap;

public class DataStore {
    HashMap<String, String> MyDb = new HashMap<String, String>();

    public DataStore() {
        this.MyDb.put("Test", "123");
        this.MyDb.put("Yared", "456");
        this.MyDb.put("Furkon", "789");
        this.MyDb.put("Kaleb", "321");
        this.MyDb.put("Admin", "654");
    }

    public HashMap<String, String> getMyDb() {
        return MyDb;
    }
}
