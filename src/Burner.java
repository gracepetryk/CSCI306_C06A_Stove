
public class Burner {
	private enum Temperature {
		COLD(0),
		WARM(1),
		HOT(2),
		BLAZING(3);
		
		public int temp;

		Temperature(int i) {
			temp = i;
		}
		
		public void decrease() {
			if (temp > 0) {
				temp--;
			}
		}
		
		public void increase() {
			if (temp < 3) {
				temp++;
			}
		}
	}
	private Temperature myTemperature;
	private Setting mySetting;
	private int timer;
	
	public static final int TIME_DURATION = 2;
	
	public Burner() {
		super();
		myTemperature = Temperature.COLD;
		timer = 0;
		mySetting = Setting.OFF;
	}

	public Temperature getMyTemperature() {
		return myTemperature;
	}
	
	public void plusButton() {
		switch (mySetting) {
		case OFF:
			mySetting = Setting.LOW;
			break;
		case LOW:
			mySetting = Setting.MEDIUM;
			break;
		case MEDIUM:
			mySetting = Setting.HIGH;
			break;
		default:
			break;
		}
		timer = TIME_DURATION;
	}
	
	public void minusButton() {
		switch (mySetting) {
		case HIGH:
			mySetting = Setting.MEDIUM;
			break;
		case MEDIUM:
			mySetting = Setting.LOW;
			break;
		case LOW:
			mySetting = Setting.OFF;
			break;
		default:
			break;
		}
		timer = TIME_DURATION;
	}
	
	public void updateTemperature() {
		if (timer == 0) {
			if (myTemperature.temp < Temperature.HOT.temp) {
				
			}
		}
	}
	
	
}
