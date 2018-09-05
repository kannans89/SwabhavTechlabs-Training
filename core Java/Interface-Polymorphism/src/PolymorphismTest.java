
public class PolymorphismTest {

	public static void main(String[] args) {
		PolymorphismTest test = new PolymorphismTest();
		test.atTheMovies(new Boy());
		test.atTheParty(new Man());
		test.atTheParty(new Boy());
		test.atTheMovies(new Boy());
	}

	public static void atTheMovies(IEmotional obj) {
		System.out.println("at the movie");
		obj.cry();
		obj.laugh();
	}
	
	public static void atTheParty(Imanuable obj) {
		System.out.println("at the party");
		obj.desire();
		obj.wish();
	}
}
