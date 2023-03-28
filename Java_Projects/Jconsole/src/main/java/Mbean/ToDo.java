package Mbean;
import java.util.LinkedList;
import java.util.Queue;


public class ToDo implements ToDoMBean
{

    Queue< String > taskQueue = new LinkedList< String >();

    @Override
    public void storeTask (String taskName)
    {

        taskQueue.add(taskName);
    }

    @Override
    public String dequeueTask ()
    {

        return taskQueue.remove();
    }

    @Override
    public int getTasksLeft ()
    {

        return taskQueue.size();
    }

}