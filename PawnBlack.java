public class PawnBlack extends Item{
    public PawnBlack(String position,Board board) {
        this.board = board;
        type = Type.Black;
        this.position = position;
    }
    @Override
    public void move(String destination) {
        if (canMove(destination))
        {
            position = destination;
            return;
        }
        throw new UnsupportedOperationException();
    }
    @Override
    public boolean canMove(String destination) {
        if (!(Character.getNumericValue(destination.charAt(1))>=1 && Character.getNumericValue(destination.charAt(1))<=9))
            return false;
        String secondHalf = "abcde";
        String firstHalf = "fghij";
        if (firstHalf.indexOf(position.charAt(0))!=-1)
        {
            if (board.getType(destination) != type)
                return position.charAt(1) == destination.charAt(1) && destination.charAt(0)-position.charAt(0) == -1;
        }
        else if(secondHalf.indexOf(position.charAt(0))!=-1)
        {
            if (board.getType(destination) != type)
                return (Math.abs(position.charAt(1)-destination.charAt(1)) == 1 && (destination.charAt(0)-position.charAt(0) == 0) || (destination.charAt(0)-position.charAt(0) == -1 && position.charAt(1)-destination.charAt(1) == 0));

        }
        return false;
    }
}
