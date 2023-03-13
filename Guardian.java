public class Guardian extends Item{
    private final String palace;
    public Guardian(String position, Board board, String palace, Type type) {
        this.setPosition(position);
        this.board = board;
        this.type = type;
        this.palace = palace;
        point = 2F;
    }
    public Guardian(Guardian guardian) {
        this.setPosition(guardian.getPosition());
        this.board = guardian.board;
        this.type = guardian.type;
        this.palace = guardian.palace;
        point = 2F;
    }

    @Override
    public boolean canMove(String destination) {
        EmptyItem emptyItem = new EmptyItem(destination);
        if ((Math.abs((int)destination.charAt(0)-(int)getPosition().charAt(0))==1)&&(Math.abs((int)destination.charAt(1)-(int) getPosition().charAt(1))==1))
            if (palace.indexOf(emptyItem.returnY())!=-1 && (emptyItem.returnX() > 3 && emptyItem.returnX() < 7))
                if (board.getType(destination) != type)
                    return true;
        return false;
    }
    @Override
    public Item copyOf() {
        return new Guardian(this);
    }
    @Override
    public String getBytes() {
        String str = "" + type.getE() + "Gu" + getPosition();
        return str;
    }
    @Override
    public char getLetter() {
        if (type.equals(Type.Red))
            return 'v';
        else
            return 'V';
    }
}
