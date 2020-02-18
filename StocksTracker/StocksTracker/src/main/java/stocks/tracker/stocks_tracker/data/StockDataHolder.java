package stocks.tracker.stocks_tracker.data;

import java.util.HashMap;
import java.util.Map;


public class StockDataHolder {
	
    private static StockDataHolder instance = null; 
    
    private Map<String, OurQuote> lastQuotes;

	
    private StockDataHolder() {
    	lastQuotes = new HashMap<String, OurQuote>();
    }
	
	 public static StockDataHolder getInstance()  { 
	        if (instance == null) 
	        	instance = new StockDataHolder();
	        return instance;
	 }
	 
	 public OurQuote getQuote(String symbol) {
		 return lastQuotes.get(symbol);
	 }
	 
	 public void setQuote(String symbol, OurQuote quote) {
		 lastQuotes.put(symbol, quote);
	 }

}
