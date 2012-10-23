package judge;

import java.util.concurrent.PriorityBlockingQueue;
import common.ProblemSubmit;
import common.ProblemSubmitComparator;

public class SubmitQueueHandler 
{
	private PriorityBlockingQueue<ProblemSubmit> jobQueue = new PriorityBlockingQueue<ProblemSubmit>(1000, new ProblemSubmitComparator());
	
	private boolean IsEmpty()
	{
		return jobQueue.isEmpty();
	}
	
	public int FetchSubmitListFromDatabase(String query)
	{
		return 0;
	}
	
	public ProblemSubmit GetOneSubmitForJudge() throws InterruptedException
	{
		if(IsEmpty())
			return null;
		
		ProblemSubmit submit = jobQueue.take();
		return submit;
	}
}
