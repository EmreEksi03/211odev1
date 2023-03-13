import java.util.Objects;

public abstract class AbstractItem implements ItemInterface {
	
	private String position;  // tahtadaki konumu gösterir. Örneğin, a1
	Type type;
	Board board;

	protected float point;

	protected int returnX(){
		return Character.getNumericValue(position.charAt(1));
	}
	protected int returnYint(){
		return position.charAt(0);
	}
	protected char returnY(){
		return position.charAt(0);
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "AbstractItem{" +
				"position='" + position + '\'' +
				", type=" + type +
				'}';
	}

	@Override
	public void move(String destination) throws GameException {
		if (position.equals("xx"))
			throw new GameException();
		if (canMove(destination)) {
			for (int i = 0; i < board.items.length; i++) {
				if (board.items[i].getPosition().equals(destination)) {
					board.items[i].setPosition("xx");
				}
			}
			position = destination;
		}
		else {
			throw new GameException();
		}
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		AbstractItem that = (AbstractItem) o;
		return position.equals(that.position) && type == that.type;
	}

	@Override
	public int hashCode() {
		return Objects.hash(position, type);
	}

	public boolean moveable() throws GameException {
		for (int i=97;i<107;i++){
			char a = (char) i;
			for (int j=1;j<10;j++){
				String temp = "" + a + j;
				if (canMove(temp)) {
					return true;
				}
			}
		}
		return false;
	}
}
