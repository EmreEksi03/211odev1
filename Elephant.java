public class Elephant extends Item{
    private final String half;

    public Elephant(String posititon, Board board, Type type, String half) {
        this.board = board;
        this.setPosition(posititon);
        this.type = type;
        this.half = half;
        point = 2.5F;
    }

    public Elephant(Elephant elephant) {
        this.board = elephant.board;
        this.setPosition(elephant.getPosition());
        this.type = elephant.type;
        this.half = elephant.half;
        point = 2.5F;
    }

    @Override
    public boolean canMove(String destination) {
        EmptyItem emptyItem = new EmptyItem(destination);
        int y = emptyItem.returnYint();
        int x = emptyItem.returnX();
        int y2 = returnYint();
        int x2 = returnX();
        char yMid = (char) ((y + y2)/2);
        int xMid =  ((x + x2)/2);
        
        
        String midvay = "" + yMid + xMid;
        if (!(emptyItem.returnX()>=1 && emptyItem.returnX()<=9))
            return false;
        if ((Math.abs(emptyItem.returnYint() -returnYint())==2)&&(Math.abs(emptyItem.returnX() -returnX())==2))
            if (half.indexOf(emptyItem.returnY())!=-1)
                if (board.getType(destination) != type && board.getType(midvay) == Type.Empty)
                    return true;
        return false;
    }
    @Override
    public Item copyOf() {
        return new Elephant(this);
    }
    @Override
    public String getBytes() {
        String str = "" + type.getE() + "El" + getPosition();
        return str;
    }
    @Override
    public char getLetter() {
        if (type.equals(Type.Red))
            return 'f';
        else
            return 'F';
    }
}
