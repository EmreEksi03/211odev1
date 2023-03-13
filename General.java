import java.util.ArrayList;
import java.util.List;

public class General extends Item{
    private final String palace;

    public General(General general) {
        this.setPosition(general.getPosition());
        this.board = general.board;
        this.type = general.type;
        this.palace = general.palace;
        point = 0;
    }

    public String[] getAllMoveableSpaces() throws GameException {
        String above = "" + (char)(returnYint()+1) + returnX() ;
        String below = "" + (char)(returnYint()-1) + returnX();
        String right = "" + returnY() + (returnX()+1);
        String left = "" + returnY() + (returnX()-1);

        List<String> moveableSpaces = new ArrayList<>();
        moveableSpaces.add(getPosition());

        if (canMove(above))
            moveableSpaces.add(above);
        if (canMove(below))
            moveableSpaces.add(below);
        if (canMove(right))
            moveableSpaces.add(right);
        if (canMove(left))
            moveableSpaces.add(left);

        return moveableSpaces.toArray(new String[0]);
    }

    public General(String position, Board board, String palace, Type type) {
        this.setPosition(position);
        this.board = board;
        this.type = type;
        this.palace = palace;
        point = 0;
    }
    private boolean emptyWay(String destination) throws GameException {
        EmptyItem emptyItem = new EmptyItem(destination);
        Item general = board.getGeneral(Type.getOpponent(type));
        for (int i=emptyItem.returnYint();i<general.returnYint();i++){
            String temp = "" + emptyItem.returnY() + i;
            if (board.getType(temp) != Type.Empty)
                return false;
        }
        return true;
    }

    @Override
    public boolean canMove(String destination) throws GameException {
        EmptyItem emptyItem = new EmptyItem(destination);
        if ((Math.abs(emptyItem.returnX()-returnX()) == 1 && Math.abs(emptyItem.returnYint()-returnYint()) == 0)|| (Math.abs(emptyItem.returnX()-returnX()) == 0 && Math.abs(emptyItem.returnYint()-returnYint()) == 1))
            if (palace.indexOf(emptyItem.returnY())!=-1 && (emptyItem.returnX() > 3 && emptyItem.returnX() < 7))
                if (board.getType(destination) != type) {
                    Type opponent = Type.getOpponent(type);
                    Item general = board.getGeneral(opponent);
                    if (general.returnX() != emptyItem.returnX())
                        return true;
                    if (general.returnX() == emptyItem.returnX())
                        return !emptyWay(destination);
                }

        return false;
    }
    @Override
    public Item copyOf() {
        return new General(this);
    }
    @Override
    public String getBytes() {
        String str = "" + type.getE() + "Ge" + getPosition();
        return str;
    }
    @Override
    public char getLetter() {
        if (type.equals(Type.Red))
            return 'ş';
        else
            return 'Ş';
    }


}
