package stocks.tracker.stocks_tracker.vending;

import org.json.JSONException;
import org.json.JSONObject;

import stocks.tracker.stocks_tracker.data.OurQuote;
import stocks.tracker.stocks_tracker.data.StockDataHolder;

public class VendingLayerImpl implements VendingLayer {
	
	
	private static final String ERROR = "error";
	private static final String LATEST_DATE = "latestDate";
	private static final String UPDATE_TIME = "updateTime";
	private static final String PRICE = "price";
	private static final String SYMBOL = "symbol";
	
	private static VendingLayerImpl instance = null; 
    
    public static VendingLayerImpl getInstance()  { 
        if (instance == null) 
        	instance = new VendingLayerImpl();
        return instance;
    }
    
    private VendingLayerImpl() {
    	
    }
    
    /*
     * Return stock data in JSON format
     */

	public JSONObject getStockData(String symbol) {
		JSONObject response = new JSONObject();
		OurQuote quote = StockDataHolder.getInstance().getQuote(symbol);
		try {
			if (quote!=null) {
				response.put(SYMBOL, symbol);
				response.put(PRICE, quote.getPrice());
				response.put(UPDATE_TIME, quote.getUpdateTime());
				response.put(LATEST_DATE, quote.getLatestDate());
			}else {				
				response.put(ERROR, "No data found for stock:"+symbol);
			}
		}catch (JSONException e) {
			e.printStackTrace();
		}
		return response;
	}
	

}
