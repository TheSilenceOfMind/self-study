package connectionpool;

/**
 * Class describes the connection object.
 */
public class Connection {

    private String id;
    boolean isAvailable = true;

    Connection(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Connection{" +
                "id='" + id + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
