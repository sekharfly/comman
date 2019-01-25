package Counting.LogReading;

public class LogPriority {

	private String errorLine;
	private int count;

	public LogPriority(String errorLine, int count) {
		super();
		this.errorLine = errorLine;
		this.count = count;
	}

	public String getErrorLine() {
		return errorLine;
	}

	public void setErrorLine(String errorLine) {
		this.errorLine = errorLine;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "LogPriority [errorLine=" + errorLine + ", count=" + count + "]";
	}

}
