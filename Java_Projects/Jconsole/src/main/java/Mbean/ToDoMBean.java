package Mbean;

public interface ToDoMBean {

    public void storeTask(String taskName);

    public String dequeueTask();

    public int getTasksLeft();

}