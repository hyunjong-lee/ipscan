package common;

public class ProblemSubmit
{
	public ProblemSubmit(int submitId, int problemId, int userId, int contestId, int submitTime, String sourceCode)
	{
		this.submitId	= submitId;
		this.problemId	= problemId;
		this.userId		= userId;
		this.contestId	= contestId;
		this.submitTime	= submitTime;
		this.sourceCode	= sourceCode;
		
		this.compilerLog	= "";
		this.status			= 0;
		this.correctAnswers	= 0;
	}
	
	/*
	 * read from database
	 */
	private int submitId;
	private int problemId;
	private int userId;
	private int contestId;
	private int submitTime;
	private String sourceCode;
	
	/*
	 * generate from Judge
	 */
	private String compilerLog;
	private int status;
	private int correctAnswers;
	
	
	public int getSubmitId()
	{
		return submitId;
	}
	
	public int getProblemId()
	{
		return problemId;
	}
	
	public int getUserId()
	{
		return userId;
	}
	
	public int getContestId()
	{
		return contestId;
	}
	
	public int getSubmitTime()
	{
		return submitTime;
	}
	
	public String getSourceCode()
	{
		return sourceCode;
	}
	
	public String getCompilerLog()
	{
		return compilerLog;
	}
	
	public void setCompilerLog(String compilerLog)
	{
		this.compilerLog = compilerLog;
	}
	
	public int getStatus()
	{
		return status;
	}
	
	public void setStatus(int status)
	{
		this.status = status;
	}
	
	public int getCorrectAnswers()
	{
		return correctAnswers;
	}
	
	public void setCorrectAnswers(int correctAnswers)
	{
		this.correctAnswers = correctAnswers;
	}
	
}
