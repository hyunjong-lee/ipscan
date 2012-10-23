package judge;

import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;
import common.ProblemSubmit;
import common.ProblemSubmitComparator;

public class SubmitQueueHandler 
{
	private PriorityBlockingQueue<ProblemSubmit> jobQueue = null;
	
	public SubmitQueueHandler(int maxSubmitPoolSize, Comparator<ProblemSubmit> submitQueueComparator)
	{
		jobQueue = new PriorityBlockingQueue<ProblemSubmit>(maxSubmitPoolSize, submitQueueComparator);
	}
	
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
