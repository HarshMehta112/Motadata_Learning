package Mbean;

import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;
import javax.management.ObjectName;


public class Main
{

    public static void main (String[] args) throws Exception
    {

        MBeanServer server = ManagementFactory.getPlatformMBeanServer();

        ObjectName name = new ObjectName("Mbean:type=ToDo");

        ToDo toDo = new ToDo();

        server.registerMBean(toDo, name);

        Thread.sleep(Long.MAX_VALUE);
    }

}