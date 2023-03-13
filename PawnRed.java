public class PawnRed extends Item{
    public PawnRed(String position,Board board) {
        this.board = board;
        type = Type.Red;
        this.setPosition(position);
        point = 1F;
    }
    public PawnRed(PawnRed pawnRed) {
        this.board = pawnRed.board;
        type = Type.Red;
        this.setPosition(pawnRed.getPosition());
        point = 1F;
    }

    @Override
    public boolean canMove(String destination) {
        String firstHalf = "abcde";
        String secondHalf = "fghij";
        if (!(Character.getNumericValue(destination.charAt(1))>=1 && Character.getNumericValue(destination.charAt(1))<=9))
            return false;;
        if (firstHalf.indexOf(getPosition().charAt(0))!=-1)
        {
            if (board.getType(destination) != type) {
                if (secondHalf.indexOf(destination.charAt(0)) != -1) {
                    point = 2F;
                }
                return getPosition().charAt(1) == destination.charAt(1) && destination.charAt(0) - getPosition().charAt(0) == 1;
            }
        }
        else if(secondHalf.indexOf(getPosition().charAt(0))!=-1)
        {
            if (board.getType(destination) != type)
                return (Math.abs(getPosition().charAt(1) - destination.charAt(1)) == 1 && (destination.charAt(0) - getPosition().charAt(0) == 0) || (destination.charAt(0) - getPosition().charAt(0) == 1 && getPosition().charAt(1) - destination.charAt(1) == 0));
        }
        return false;
    }
    @Override
    public Item copyOf() {
        return new PawnRed(this);
    }
    @Override
    public String getBytes() {
        String str = "" + type.getE() + "Pr" + getPosition();
        return str;
    }
    @Override
    public char getLetter() {
        return 'e';
    }
}
