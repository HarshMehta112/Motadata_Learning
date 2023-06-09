import com.opensymphony.xwork2.ActionSupport;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class PingAction extends ActionSupport
{

    private String ipAddress;
    private String pingResult;

    public String execute() throws Exception {
        try {
            InetAddress address = InetAddress.getByName(ipAddress);
            boolean isReachable = address.isReachable(5000); // Timeout of 5 seconds
            if (isReachable) {
                pingResult = "Success";
            } else {
                pingResult = "Failure";
            }
        } catch (UnknownHostException e) {
            pingResult = "Unknown Host";
        }
        return SUCCESS;
    }

    // Getters and Setters for ipAddress and pingResult
}
