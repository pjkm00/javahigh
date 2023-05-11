package scheduler.sumit.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MyObj implements Job{

	HttpServletRequest req = null;
	HttpServletResponse res = null;
	
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		OutPrint op = new OutPrint();
		try {
			op.doGet(req, res);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
