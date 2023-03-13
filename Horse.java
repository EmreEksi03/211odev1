public class Horse extends Item{
    public Horse(String posititon, Board board, Type type) {
        this.board = board;
        this.setPosition(posititon);
        this.type = type;
    }
    public Horse(Horse horse) {
        this.board = horse.board;
        this.setPosition(horse.getPosition());
        this.type = horse.type;
    }

    @Override
    public boolean canMove(String destination) throws GameException {
        EmptyItem emptyItem = new EmptyItem(destination);
        String boardY = "abcdefghij";
        if (!(emptyItem.returnX()>=1 && (emptyItem.returnX())<=9) || (boardY.indexOf(emptyItem.returnY()) == -1))
            return false;
        if ((Math.abs(emptyItem.returnX()-returnX()) == 2 && Math.abs(emptyItem.returnYint()-returnYint()) == 1) || (Math.abs(emptyItem.returnYint()-returnYint()) == 2 && Math.abs(emptyItem.returnX()-returnX()) == 1))
            if (!board.getType(destination).equals(type))
                if (emptyWay(destination))
                    return true;
        return false;
    }

    private boolean emptyWay(String destination) {
        EmptyItem emptyItem = new EmptyItem(destination);
        String midway;
        if (Math.abs(emptyItem.returnX()-returnX()) == 2){
            int x = (emptyItem.returnX()+returnX())/2;
            midway = "" + returnY() + x;
            return board.getType(midway).equals(Type.Empty);
        }
        else if (Math.abs(emptyItem.returnYint()-returnYint()) == 2){
            int y = (emptyItem.returnYint()+returnYint())/2;
            midway = "" + (char)y + returnX();
            return board.getType(midway).equals(Type.Empty);
        }
        return false;
    }
    @Override
    public Item copyOf() {
        return new Horse(this);
    }
    @Override
    public String getBytes() {
        String str = "" + type.getE() + "Ho" + getPosition();
        return str;
    }
    @Override
    public char getLetter() {
        if (type.equals(Type.Red))
            return 'a';
        else
            return 'A';
    }
}
