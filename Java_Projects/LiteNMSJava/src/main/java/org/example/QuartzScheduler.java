package org.example;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;


class QuartzScheduler
{
    public static void main(String args[])
    {
        try
        {
            //Set job details.
            JobDetail job = JobBuilder.newJob(PingEvery5Minutes.class)

                    .withIdentity("PingEvery5Minutes").build();


            //Set the scheduler timings.
            Trigger trigger = TriggerBuilder.newTrigger()

                    .withIdentity("cronTrigger")

                    .withSchedule(CronScheduleBuilder

                            .cronSchedule("0 */1 * ? * *")).build();



            //Execute the job.
            Scheduler scheduler = new StdSchedulerFactory().getScheduler();

            scheduler.start();

            scheduler.scheduleJob(job, trigger);

//            DataBaseConnection.TOP5MaxRTT();

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}