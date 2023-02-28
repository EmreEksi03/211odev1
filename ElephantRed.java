public class ElephantRed extends Item{
    public ElephantRed(String posititon,Board board) {
        this.board = board;
        this.position = posititon;
        type = Type.Red;
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
        char y = destination.charAt(0);
        char x = destination.charAt(1);
        String midvay = "" + y + x;
        if (!(Character.getNumericValue(destination.charAt(1))>=1 && Character.getNumericValue(destination.charAt(1))<=9))
            return false;
        String firstHalf = "abcde";
        if ((Math.abs((int)destination.charAt(0)-(int)position.charAt(0))==2)&&(Math.abs((int)destination.charAt(1)-(int)position.charAt(1))==2))
            if (firstHalf.indexOf(destination.charAt(0))!=-1)
                if (board.getType(destination) != type && board.getType(midvay) == Type.Empty)
                    return true;
        return false;
    }
}
