
public class StatisticsDisplay implements Observer, DisplayElement {

	private float temprature;
	Subject weatherData;
	public StatisticsDisplay(Subject weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}
	@Override
	public void display() {
		System.out.println("Weather Statistics: Avg/Max/Min"+temprature+"/"+(temprature+5)+"/"+(temprature-10));
	}

	@Override
	public void update(float temp, float humidity, float pressuare) {
		this.temprature = temp;
		display();
	}

}
