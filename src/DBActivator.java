import java.util.concurrent.Callable;

public class DBActivator implements Callable<DB> {
    private final DBConfig config;
 
    public DBActivator(DBConfig config) {
        this.config = config;
    }
 
    public DB call() throws Exception {
        if (isInMemoryDB(config)) {
            return new InMemoryDB();
        }
        return new RealDB(config);
    }

    private boolean isInMemoryDB(DBConfig config) {
        return false;
    }

}
