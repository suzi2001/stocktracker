package stocks.tracker.stocks_tracker;

import java.util.List;

import stocks.tracker.stocks_tracker.tracker.StockTracker;

import java.util.ArrayList;




public class App 
{

    private static final int SAMPLE_FREQUENCY_IN_MINUTES = 1;

	public static void main( String[] args )
    {
    	
    	List<String> stocks = new ArrayList<String>();
    	stocks.add("AAPL");
    	stocks.add("CSCO");
    	stocks.add("INTC");
    	StockTracker tracker = new StockTracker(stocks, SAMPLE_FREQUENCY_IN_MINUTES);
    	tracker.trackStocks();
    	        
    }
}
