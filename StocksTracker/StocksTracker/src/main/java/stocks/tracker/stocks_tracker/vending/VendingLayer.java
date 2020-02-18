package stocks.tracker.stocks_tracker.vending;

import org.json.JSONObject;

public interface VendingLayer {
	
	public JSONObject getStockData(String symbol);

}
