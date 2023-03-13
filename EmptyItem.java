public class EmptyItem extends AbstractItem {
    public EmptyItem(String position) {
        this.setPosition(position);
    }
    @Override
    public boolean canMove(String destination) {
        return false;
    }

    @Override
    public String getBytes() {
        return null;
    }

    @Override
    public Item copyOf() {
        return null;
    }

    @Override
    public char getLetter() {
        return 0;
    }
}
