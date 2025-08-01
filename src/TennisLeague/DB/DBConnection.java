package TennisLeague.DB;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConnection {
    private static final String PROPS_FILE = "application.properties";
    private static String url, user, password;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (InputStream in = DBConnection.class
                    .getClassLoader()
                    .getResourceAsStream(PROPS_FILE)) {
                Properties props = new Properties();
                props.load(in);
                url      = props.getProperty("db.url");
                user     = props.getProperty("db.user");
                password = props.getProperty("db.password");
            }
        } catch (Exception e) {
            throw new ExceptionInInitializerError("Failed to load DB config: " + e);
        }
    }

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(url, user, password);
    }
}