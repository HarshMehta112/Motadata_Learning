public class SynchronizedExchanger
{
    protected Object object = null;

    public synchronized void setObject(Object object)
    {
        this.object = object;
    }

    public synchronized Object getObject()
    {
        return this.object;
    }

    public void setObj(Object object)
    {
        synchronized (this)
        {
            this.object = object;
        }
    }

    public Object getObj()
    {
        synchronized (this)
        {
            return this.object;
        }
    }

}
