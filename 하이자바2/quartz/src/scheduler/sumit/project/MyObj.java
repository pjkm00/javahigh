package scheduler.sumit.project;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MyObj implements Job{

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		
		System.out.println("Hurray!! My scheduler is running!!");
		System.out.println("The time now is " + new Date());
	}

}
