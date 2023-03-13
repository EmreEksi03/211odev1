public class Chariot extends Item{
    public Chariot(String position, Board board, Type type) {
        this.type = type;
        this.setPosition(position);
        this.board = board;
        point = 10F;
    }

    public Chariot(Chariot chariot) {
        this.type = chariot.type;
        this.setPosition(chariot.getPosition());
        this.board = chariot.board;
        point = 10F;
    }

    private boolean emptyWay(EmptyItem emptyItem){
        if (returnX()> emptyItem.returnX()){
            for (int i=emptyItem.returnX()+1;i<returnX();i++){
                String temp = "" + emptyItem.returnY() + i;
                if (board.getType(temp) != Type.Empty)
                    return false;
            }
        }
        if (returnYint()>emptyItem.returnYint()){
            for (int i=emptyItem.returnYint()+1;i<returnYint();i++){
                String temp = "" + (char)i + returnX();
                if (board.getType(temp) != Type.Empty)
                    return false;
            }
        }
        if (returnX()<emptyItem.returnX()){
            for (int i=returnX()+1;i<emptyItem.returnX();i++){
                String temp = "" + emptyItem.returnY() + i;
                if (board.getType(temp) != Type.Empty)
                    return false;
            }
        }
        if (returnYint()<emptyItem.returnYint()){
            for (int i=returnYint()+1;i<emptyItem.returnYint();i++){
                String temp = "" + (char)i + returnX();
                if (board.getType(temp) != Type.Empty)
                    return false;
            }
        }
        return true;
    }
    @Override
    public boolean canMove(String destination) {
        EmptyItem emptyItem = new EmptyItem(destination);
        String boardY = "abcdefghij";
        if (!(emptyItem.returnX()>=1 && (emptyItem.returnX())<=9) || (boardY.indexOf(emptyItem.returnY()) == -1))
            return false;
        if ((destination.charAt(0) == getPosition().charAt(0) && destination.charAt(1) != getPosition().charAt(1)) || (destination.charAt(1) == getPosition().charAt(1) && destination.charAt(0) != getPosition().charAt(0)))
            if (board.getType(destination) != type)
                if(emptyWay(emptyItem))
                    return true;
        return false;
    }
    @Override
    public Item copyOf() {
        return new Chariot(this);
    }
    @Override
    public String getBytes() {
        String str = "" + type.getE() + "Ch" + getPosition();
        return str;
    }
    @Override
    public char getLetter() {
        if (type.equals(Type.Red))
            return 'k';
        else
            return 'K';
    }
}
