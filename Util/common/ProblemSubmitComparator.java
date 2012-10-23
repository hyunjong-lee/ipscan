package common;

import java.util.Comparator;

public class ProblemSubmitComparator implements Comparator<ProblemSubmit>
{

	@Override
	public int compare(ProblemSubmit arg0, ProblemSubmit arg1)
	{
		// TODO Auto-generated method stub
		if(arg0.getSubmitId() < arg1.getSubmitId())
			return -1;
		
		if(arg0.getSubmitId() > arg1.getSubmitId())
			return 1;
		
		return 0;
	}

}
