package scheduler.sumit.project;

import java.util.Collection;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class MyMain {

	public static void main(String[] args) throws SchedulerException{

		
		SchedulerFactory scdFact = new StdSchedulerFactory();
		Scheduler sc = scdFact.getScheduler();
		sc.start();
		
		JobDetail j = JobBuilder.newJob(MyObj.class).build();

		Trigger t = TriggerBuilder.newTrigger().withIdentity("CroneTrigger")
				.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(02)
					.repeatForever()).build();
		
		sc.scheduleJob(j, t);
		
		try {
			Thread.sleep(65L * 1000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
					
	}

}

