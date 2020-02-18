package stocks.tracker.stocks_tracker.extractor;

import pl.zankowski.iextrading4j.api.stats.RecordsStats;
import pl.zankowski.iextrading4j.api.stocks.Quote;
import pl.zankowski.iextrading4j.api.stocks.v1.AdvancedStats;
import pl.zankowski.iextrading4j.api.stocks.v1.BalanceSheets;
import pl.zankowski.iextrading4j.api.stocks.v1.KeyStats;
import pl.zankowski.iextrading4j.client.IEXCloudClient;
import pl.zankowski.iextrading4j.client.IEXCloudTokenBuilder;
import pl.zankowski.iextrading4j.client.IEXTradingApiVersion;
import pl.zankowski.iextrading4j.client.IEXTradingClient;
import pl.zankowski.iextrading4j.client.rest.request.stats.RecordStatsRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.QuoteRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.v1.AdvancedStatsRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.v1.BalanceSheetRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.v1.KeyStatsRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.v1.Period;
import stocks.tracker.stocks_tracker.data.OurQuote;

public class StockDataExtractorImpl implements StockDataExtractor {
	
    private static StockDataExtractorImpl instance = null; 
    private IEXCloudClient cloudClient;
    
   //TODO: read the tokens from properties file
    private StockDataExtractorImpl() {
    	cloudClient = IEXTradingClient.create(IEXTradingApiVersion.IEX_CLOUD_V1,
	            new IEXCloudTokenBuilder()
	                    .withPublishableToken("pk_0a485dc2e650496081e26eb183669eed")
	                    .withSecretToken("sk_d54fef8425f24331a8a235e234884df5")
	                    .build());
    }
    
    public static StockDataExtractorImpl getInstance()  { 
        if (instance == null) 
        	instance = new StockDataExtractorImpl();
        return instance;
    }
    
    


	public OurQuote getLastQuote(String symbol) {
	     final Quote quote = cloudClient.executeRequest(new QuoteRequestBuilder().withSymbol(symbol).build());
	     return new OurQuote(quote.getLatestPrice().doubleValue(), quote.getLatestUpdate(), quote.getLatestTime());	     
	}
	

}
