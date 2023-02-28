
public class Board extends AbstractBoard{

	@Override
	public void print() {
		// TODO Auto-generated method stub
		
	}
	Type getType(String destination){
		for (Item item : items) {
			if (item.position.equals(destination))
				return item.type;
		}
		return Type.Empty;
	}

}
