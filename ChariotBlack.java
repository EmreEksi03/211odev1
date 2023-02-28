public class ChariotBlack extends AbstractItem{
    public ChariotBlack(String position, Board board) {
        this.type = Type.Black;
        this.position = position;
        this.board = board;
    }
    @Override
    public void move(String destination) {

    }
    private boolean emptyWay(String destination){
        if (position.charAt(0)>destination.charAt(0)){
            for (int i=Character.getNumericValue(destination.charAt(0));i<Character.getNumericValue(position.charAt(0));i++){
                if (board.getType(destination) != Type.Empty){
                    return false;
                }
            }
        }
        if (position.charAt(0)<destination.charAt(0)){
            for (int i=Character.getNumericValue(position.charAt(0));i<Character.getNumericValue(destination.charAt(0));i++){
                if (board.getType(destination) != Type.Empty){
                    return false;
                }
            }
        }
        if (position.charAt(1)>destination.charAt(1)){
            for (int i=Character.getNumericValue(destination.charAt(1));i<Character.getNumericValue(position.charAt(1));i++){
                if (board.getType(destination) != Type.Empty){
                    return false;
                }
            }
        }
        if (position.charAt(1)<destination.charAt(1)){
            for (int i=Character.getNumericValue(position.charAt(1));i<Character.getNumericValue(destination.charAt(1));i++){
                if (board.getType(destination) != Type.Empty){
                    return false;
                }
            }
        }
        return false;
    }
    @Override
    public boolean canMove(String destination) {
        if (!(Character.getNumericValue(destination.charAt(1))>=1 && Character.getNumericValue(destination.charAt(1))<=9) || !(Character.getNumericValue(destination.charAt(0))>=97 && Character.getNumericValue(destination.charAt(0))<=106))
            return false;
        if ((destination.charAt(0) == position.charAt(0) && destination.charAt(1) != position.charAt(1)) || (destination.charAt(1) == position.charAt(1) && destination.charAt(0) != position.charAt(0)))
            if (board.getType(destination) != type)
                if(emptyWay(destination))
                    return true;
        return false;
    }
}
