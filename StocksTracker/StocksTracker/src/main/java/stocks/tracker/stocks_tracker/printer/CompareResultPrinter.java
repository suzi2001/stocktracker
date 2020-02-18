package stocks.tracker.stocks_tracker.printer;

public abstract class CompareResultPrinter {
	
	protected String symbol;
	protected boolean isHigh;
	protected String value;
	
	public CompareResultPrinter(String symbol, boolean isHigh, String value) {
		this.symbol = symbol;
		this.isHigh = isHigh;
		this.value = value;
	}
	
	
	public CompareResultPrinter() {
	}


	public abstract void printCompareResult();
	
	public boolean isHigh() {
		return isHigh;
	}


	public String getValue() {
		return value;
	}

}
