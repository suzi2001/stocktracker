package stocks.tracker.stocks_tracker;

import junit.framework.TestCase;
import stocks.tracker.stocks_tracker.data.OurQuote;
import stocks.tracker.stocks_tracker.extractor.StockDataExtractorImpl;
import stocks.tracker.stocks_tracker.printer.CompareResultPrinter;
import stocks.tracker.stocks_tracker.processor.StockProcessor;


public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    
   public void testHighPercentage() {
    	OurQuote currentQuote = new OurQuote(47.785, new Long("1578072396856"), "12:26:36 PM");
    	OurQuote prevQuote = new OurQuote(47.76, new Long("1578072321374"), "12:25:21 PM");
    	CompareResultPrinter result = StockProcessor.getInstance().compareLastQuotePercentage("CSCO", currentQuote, prevQuote, 0.05);
    	assertEquals(result.getValue(), "0.05");
    	assertTrue(result.isHigh());
    }
   
   public void testLowAmount() {
	   OurQuote currentQuote = new OurQuote(299.58, new Long("1578072461905"), "12:27:41 PM");
   	   OurQuote prevQuote = new OurQuote(299.69, new Long("1578072391965"), "12:26:31 PM");
   	   CompareResultPrinter result = StockProcessor.getInstance().compareLastQuoteAmount("AAPL", currentQuote, prevQuote, 0.1);
   	   assertEquals(result.getValue(), "0.11");
   	   assertFalse(result.isHigh());
   }
   

   public void testEmptyResultAmount() {
	   OurQuote currentQuote = new OurQuote(299.71, new Long("1578072338293"), "12:25:38 PM");
   	   OurQuote prevQuote = new OurQuote(299.615, new Long("1578072258061"), "12:24:18 PM");
   	   CompareResultPrinter result = StockProcessor.getInstance().compareLastQuoteAmount("AAPL", currentQuote, prevQuote, 0.1);
   	   assertNull(result.getValue());
   
   }
   
   public void testProvider() {
	   OurQuote quote = StockDataExtractorImpl.getInstance().getLastQuote("CSCO");
	   assertNotNull(quote);
	   assertNotNull(quote.getPrice());
   }
}
