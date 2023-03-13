
public interface ItemInterface {
	
	void move(String destination) throws GameException; // Taşı belirtilen konuma götürür (eğer kural dışı bir durum yoksa)
	boolean canMove(String destination) throws GameException;


    String getBytes();

	Item copyOf();

	char getLetter();
}
