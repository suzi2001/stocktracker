package stocks.tracker.stocks_tracker.tracker;

import java.util.List;

import stocks.tracker.stocks_tracker.data.OurQuote;
import stocks.tracker.stocks_tracker.data.StockDataHolder;
import stocks.tracker.stocks_tracker.extractor.StockDataExtractorImpl;
import stocks.tracker.stocks_tracker.printer.CompareResultPrinter;
import stocks.tracker.stocks_tracker.processor.StockProcessor;
import stocks.tracker.stocks_tracker.vending.VendingLayerImpl;

public class StockTracker {
	
	private static final int SECONDS = 60;
	private static final long MILLIE = 1000L;
	//TODO: read from properties file
	private static final double AMOUNT = 0.1;
	private static final double PERCENTAGE = 0.05;

	
	
	private List<String> symbols;
	private int frequencyInMinutes;
	
	public StockTracker(List<String> symbols, int frequencyInMinutes) {
		this.frequencyInMinutes = frequencyInMinutes;
		this.symbols = symbols;
		
	}
	
	public void trackStocks() {
		while (true) {
			for (String symbol:symbols) {
				OurQuote quote = StockDataExtractorImpl.getInstance().getLastQuote(symbol);
				//System.out.println("Got the following quote for symbol:"+symbol+" "+ quote);
				OurQuote prevQuote = StockDataHolder.getInstance().getQuote(symbol);
				CompareResultPrinter amountPrinter = StockProcessor.getInstance().compareLastQuoteAmount(symbol, quote, prevQuote, AMOUNT);
				amountPrinter.printCompareResult();
				CompareResultPrinter perecentagePrinter =StockProcessor.getInstance().compareLastQuotePercentage(symbol, quote, prevQuote, PERCENTAGE);
				perecentagePrinter.printCompareResult();
				StockDataHolder.getInstance().setQuote(symbol, quote);
				System.out.println("Vending Layer response:"+VendingLayerImpl.getInstance().getStockData(symbol));
			}
			try {
				Thread.sleep(frequencyInMinutes*SECONDS*MILLIE);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
