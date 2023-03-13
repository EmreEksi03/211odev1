public class Cannon extends Item{
    public Cannon(String position, Board board, Type type) {
        this.type = type;
        this.setPosition(position);
        this.board = board;
        point = 4.5F;
    }

    public Cannon(Cannon cannon) {
        this.type = cannon.type;
        this.setPosition(cannon.getPosition());
        this.board = cannon.board;
        point = 4.5F;
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
    private boolean emptyWayCapture(EmptyItem emptyItem){
        int x = 0;
        if (returnX()>emptyItem.returnX()){
            for (int i=emptyItem.returnX()+1;i<returnX();i++){
                String temp = "" + emptyItem.returnY() + i;
                if (board.getType(temp) != Type.Empty)
                    x++;
            }
        }
        if (returnYint()>emptyItem.returnYint()){
            for (int i=emptyItem.returnYint()+1;i<returnYint();i++){
                String temp = "" + (char)i + returnX();
                if (board.getType(temp) != Type.Empty)
                    x++;
            }
        }
        if (returnX()<emptyItem.returnX()){
            for (int i=returnX()+1;i<emptyItem.returnX();i++){
                String temp = "" + emptyItem.returnY() + i;
                if (board.getType(temp) != Type.Empty)
                    x++;
            }
        }
        if (returnYint()<emptyItem.returnYint()){
            for (int i=returnYint()+1;i<emptyItem.returnYint();i++){
                String temp = "" + (char)i + returnX();
                if (board.getType(temp) != Type.Empty)
                    x++;
            }
        }
        return x==1;
    }
    @Override
    public boolean canMove(String destination) {
        EmptyItem emptyItem = new EmptyItem(destination);
        String boardY = "abcdefghij";
        if (!(emptyItem.returnX()>=1 && emptyItem.returnX()<=9) || boardY.indexOf(emptyItem.returnY()) == -1)
            return false;
        if ((emptyItem.returnY() == returnY() && emptyItem.returnX() != returnX()) || (emptyItem.returnX() == returnX() && emptyItem.returnY() != returnY())) {
            if (board.getType(destination) == Type.Empty)
                if (emptyWay(emptyItem))
                    return true;
            if (board.getType(destination) == Type.getOpponent(type))
                return emptyWayCapture(emptyItem);
        }
        return false;
    }

    @Override
    public String getBytes() {
        String str = "" + type.getE() + "Ca" + getPosition();
        return str;
    }

    @Override
    public Item copyOf() {
        return new Cannon(this);
    }

    @Override
    public char getLetter() {
        if (type.equals(Type.Red))
            return 't';
        else
            return 'T';
    }


}
