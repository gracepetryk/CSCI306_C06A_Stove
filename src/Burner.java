
public class Burner {
	public enum Temperature {
		COLD(0),
		WARM(1),
		HOT(2),
		BLAZING(3);
		
		private final int temp;

		Temperature(int i) {
			temp = i;
		}

		public int getTemp() {
			return temp;
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
		// adjust the temperature of each burner up or down a setting until set point reached
		--timer;
		if (timer == 0) {
			switch (mySetting) {
			case HIGH:
				if (myTemperature.getTemp() < Temperature.BLAZING.getTemp()) {
					increseTemperature();
				}
				break;
			case MEDIUM:
				if (myTemperature.getTemp() < Temperature.HOT.getTemp()) {
					increseTemperature();
				} else if (myTemperature.getTemp() > Temperature.HOT.getTemp()){
					decreaseTemperature();
				}
				break;
			case LOW:
				if (myTemperature.getTemp() < Temperature.WARM.getTemp()) {
					increseTemperature();
				} else if (myTemperature.getTemp() > Temperature.WARM.getTemp()){
					decreaseTemperature();
				}
				break;
			case OFF:
				if (myTemperature.getTemp() > Temperature.COLD.getTemp()) {
					decreaseTemperature();
				}
				break;
			}
			// reset timer
			timer = TIME_DURATION;
		}
		
	}
	
	private void increseTemperature() {
		switch (myTemperature) {
		case COLD:
			myTemperature = Temperature.WARM;
			break;
		case WARM:
			myTemperature = Temperature.HOT;
			break;
		case HOT:
			myTemperature = Temperature.BLAZING;
			break;
		default:
			break;
		}
	}
	
	private void decreaseTemperature() {
		switch (myTemperature) {
		case BLAZING:
			myTemperature = Temperature.HOT;
			break;
		case HOT:
			myTemperature = Temperature.WARM;
			break;
		case WARM:
			myTemperature = Temperature.COLD;
			break;
		default:
			break;
		}
	}
	
	public String display() {
		StringBuilder builder = new StringBuilder();
		
		
		// print setting representation
		builder.append('[');
		builder.append(mySetting.toString());
		builder.append(']');
		
		builder.append(".....");
		
		switch (myTemperature) {
		case BLAZING:
			builder.append("VERY HOT! DON'T TOUCH");
			break;
		case HOT:
			builder.append("CAREFUL");
			break;
		case WARM:
			builder.append("warm");
			break;
		case COLD:
			builder.append("cooool");
			break;
		}
		
		return builder.toString();
	}
	
	
}
