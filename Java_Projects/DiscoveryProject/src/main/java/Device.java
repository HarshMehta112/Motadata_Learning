import java.security.PublicKey;
import java.util.concurrent.atomic.AtomicInteger;

public class Device {

    private static final AtomicInteger COUNTER = new AtomicInteger();

    private final int id;

    private String name;

    private String ip;

    private String username;

    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Device (String name, String ip, String username, String password)
    {
        this.id=COUNTER.getAndIncrement();

        this.name=name;

        this.ip=ip;

        this.username=username;

        this.password=password;
    }

    public Device()
    {
        this.id = COUNTER.getAndIncrement();
    }

}
