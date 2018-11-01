package connectionpool;

/**
 * The class manages connection pool.
 */
public class ConnectionManager {

    private static final int MAX_CONNS = 16;
    private static Connection[] conns = new Connection[MAX_CONNS];

    static {
        for (int i = 0; i < MAX_CONNS; i++)
            conns[i] = new Connection(String.valueOf(i));
    }

    public static Connection getConnection() {
        for (int i = 0; i < MAX_CONNS; i++) {
            Connection con = conns[i];
            if (con.isAvailable) {
                conns[i].isAvailable = false;
                return con;
            }
        }
        return null;
    }
}
