import java.util.Optional;

public class MySingletonLazy {

    private static MySingletonLazy instance;
    private static MySingletonLazy getMySingletonLazy() {
        instance = new MySingletonLazy();
        return instance;
    }
    public static MySingletonLazy getInstance() {
        return Optional.ofNullable(instance).orElseGet(MySingletonLazy::getMySingletonLazy);
    }
}
