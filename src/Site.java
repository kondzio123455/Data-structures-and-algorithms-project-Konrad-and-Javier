public class Site{
	private char siteCode;
	private String siteName;
	private int xValue;
	private int yValue;
	private int distance;

	public Site(char siteCode, String siteName, int xValue, int Distance){
		this.siteCode = siteCode;
		this.siteName = siteName;
		this.xValue = xValue;
		this.yValue = yValue;
		this.distance = distance;
	}
	@Override
	public String toString(){
		return "\nSite Code: " + siteCode
		+ "\nSite Name: "	+ siteName
		+ "\nValue of x: " + xValue
		+ "\nValue of y: " + yValue
		+ "\nDistance: " + distance;
	}
}
