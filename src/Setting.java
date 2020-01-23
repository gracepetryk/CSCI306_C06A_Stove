
public enum Setting {
	OFF ("---"),
	LOW ("--+"),
	MEDIUM ("-++"),
	HIGH ("+++");
	
	private final String setting;
	
	Setting(String settingString) {
		this.setting = settingString;
	}
	
	@Override
	public String toString() {
		return setting;
	}
	

}
