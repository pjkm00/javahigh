package scheduler.sumit.project;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class MainClass {

	public void mainclass(HttpServletRequest req, HttpServletResponse res) throws SchedulerException {
		MyObj mo = new MyObj();
		mo.setReq(req);
		mo.setRes(res);
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
