package stocks.tracker.stocks_tracker.printer;

public class AmountCompareResultPrinter  extends CompareResultPrinter{

	public AmountCompareResultPrinter(String symbol, boolean isHigh, String value) {
		super(symbol, isHigh, value);
	}

	@Override
	public void printCompareResult() {
		if (isHigh) {
			System.out.println("Stock "+symbol+" is higher in "+value+"$ comparing to previous quote");
		}else {
			System.out.println("Stock "+symbol+" is lower in "+value+"$ comparing to previous quote");

		}
		
	}

}
