
public abstract class Item extends AbstractItem{

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "*" + type.name() + "*" +  getPosition() + "\n";
	}

}
