package stocks.tracker.stocks_tracker.data;


public class OurQuote {
	
	private double price;
	private Long updateTime;
	private String latestDate;
	
	public OurQuote(double price, Long updateTime, String latestDate) {
		this.price = price;
		this.updateTime = updateTime;
		this.latestDate = latestDate;
		
		
	}

	@Override
	public String toString() {
		return "Quote [price=" + price + ", updateTime=" + updateTime + ", latestDate=" + latestDate + "]";
	}

	public String getLatestDate() {
		return latestDate;
	}

	public double getPrice() {
		return price;
	}

	public Long getUpdateTime() {
		return updateTime;
	}

}
