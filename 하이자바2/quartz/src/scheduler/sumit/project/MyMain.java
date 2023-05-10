package scheduler.sumit.project;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;

public class MyMain {

	public static void main(String[] args) throws SchedulerException{
		JobDetail j = JobBuilder.newJob(MyObj.class).build();

		Trigger t = TriggerBuilder.newTrigger().withIdentity("CroneTrigger")
				.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(02)
					.repeatForever()).build();
		
					
	}

}
