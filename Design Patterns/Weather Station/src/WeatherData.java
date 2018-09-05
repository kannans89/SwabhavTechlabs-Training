import java.util.ArrayList;

public class WeatherData implements Subject {
	private ArrayList<Observer> observers = null;
	private float temprature, humidity, pressuare;

	public WeatherData() {
		this.observers = new ArrayList<>();
	}

	@Override
	public void registerObserver(Observer o) {
		this.observers.add(o);

	}

	@Override
	public void removeObserver(Observer o) {
		int index = observers.indexOf(o);
		this.observers.remove(index);

	}

	@Override
	public void notifyObserver() {
		for(Observer observer: observers) {
			observer.update(this.temprature, this.humidity, this.pressuare);
		}
	}
	
	public void messuarementChanged() {
		notifyObserver();
	}
	
	public void setMeasuarements(float temp, float humidity, float pressuare) {
		this.temprature = temp;
		this.humidity = humidity;
		this.pressuare = pressuare;
		messuarementChanged();
	}

}
