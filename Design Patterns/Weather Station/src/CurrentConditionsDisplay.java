
public class CurrentConditionsDisplay implements Observer, DisplayElement {

	private float temprature;
	private float humidity;
	private Subject weatherData;
	
	public CurrentConditionsDisplay(Subject weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}
	@Override
	public void display() {
		System.out.println("Current conditions: "+temprature+" F degress "+humidity+" % humidity");
	}

	@Override
	public void update(float temp, float humidity, float pressuare) {
		this.temprature = temp;
		this.humidity = humidity;
		display();
	}

}
