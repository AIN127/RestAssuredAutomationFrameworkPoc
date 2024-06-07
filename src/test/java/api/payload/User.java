package api.payload;

public class User
{
	String IncludeCart;
	String IncludeExpiredData;
	
	public String getIncludeCart() {
		return IncludeCart;
	}
	public void setIncludeCart(String includeCart) {
		IncludeCart = includeCart;
	}
	public String getIncludeExpiredData() {
		return IncludeExpiredData;
	}
	public void setIncludeExpiredData(String includeExpiredData) {
		IncludeExpiredData = includeExpiredData;
	}
	
	
}
