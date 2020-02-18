package stocks.tracker.stocks_tracker.extractor;

import stocks.tracker.stocks_tracker.data.OurQuote;

public interface StockDataExtractor {
	
	public OurQuote getLastQuote(String symbol);
		

}
