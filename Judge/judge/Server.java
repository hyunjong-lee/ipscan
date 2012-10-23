package judge;

import java.util.Comparator;

import common.ProblemSubmit;
import common.ProblemSubmitComparator;

public class Server
{
	private SubmitQueueHandler submitQueueHandler = null;
	
	public Server(int maxSubmitPoolSize, Comparator<ProblemSubmit> submitQueueComparator)
	{
		submitQueueHandler = new SubmitQueueHandler(maxSubmitPoolSize, submitQueueComparator);
	}
	
	public void Start()
	{
		while(true)
		{
			String query = "Select * from ProblemSubmit;";
			submitQueueHandler.FetchSubmitListFromDatabase(query);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		int maxSubmitPoolSize = 10000;
		Comparator<ProblemSubmit> submitQueueComparator = new ProblemSubmitComparator();
		
		Server server = new Server(maxSubmitPoolSize, submitQueueComparator);
		server.Start();
	}

}
