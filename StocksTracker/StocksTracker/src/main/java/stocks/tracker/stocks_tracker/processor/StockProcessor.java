package stocks.tracker.stocks_tracker.processor;


import stocks.tracker.stocks_tracker.data.OurQuote;
import stocks.tracker.stocks_tracker.printer.AmountCompareResultPrinter;
import stocks.tracker.stocks_tracker.printer.CompareResultPrinter;
import stocks.tracker.stocks_tracker.printer.EmptyCompareResultPrinter;
import stocks.tracker.stocks_tracker.printer.PercentageCompareResultPrinter;

public class StockProcessor {
	
    private static final String TWO_DIGITS_FORMAT = "%.2f";
	private static StockProcessor instance = null; 
    
    public static StockProcessor getInstance()  { 
        if (instance == null) 
        	instance = new StockProcessor();
        return instance;
    }
    
    private StockProcessor() {
    	
    }
    
    public CompareResultPrinter compareLastQuoteAmount(String symbol, OurQuote currentQuote, OurQuote prevQuote, double amount) {
    	if (prevQuote!=null) {
    		double currentDiff = currentQuote.getPrice() - prevQuote.getPrice();
    		if(thresholdCrossed(currentDiff, amount)) {
    			if (currentDiff>=0) {
    				return new AmountCompareResultPrinter(symbol, true, formatValue(currentDiff));
    			}else {
    				return new AmountCompareResultPrinter(symbol, false, formatValue(Math.abs(currentDiff)));

    			}
    		}
    	}
    	return new EmptyCompareResultPrinter();
    }
    
    
 
    
    public CompareResultPrinter compareLastQuotePercentage(String symbol, OurQuote currentQuote,  OurQuote prevQuote, double percentage) {
    	if (prevQuote!=null) {
    		double currentRatio = (currentQuote.getPrice() - prevQuote.getPrice())/prevQuote.getPrice();
    		currentRatio = currentRatio*100;
    		if (thresholdCrossed(currentRatio, percentage)) {
    			if (currentRatio>=0) {
    				return new PercentageCompareResultPrinter(symbol, true, formatValue(currentRatio));
    			}else {
    				return new PercentageCompareResultPrinter(symbol, false, formatValue(Math.abs(currentRatio)));
    			}
    		}
    	}
    	return new EmptyCompareResultPrinter();
    }
    
    
    private String formatValue(double value) {
    	return String.format(TWO_DIGITS_FORMAT, value);
    }
    
    private boolean thresholdCrossed(double value, double threshold) {
    	return Math.abs(value) >= threshold;
    }

    	


}
