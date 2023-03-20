package org.example;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class PingEvery5Minutes implements Job
{
    public void execute(JobExecutionContext context) throws JobExecutionException
    {
        new DataBaseConnection().DBDataFetch();
    }
}
