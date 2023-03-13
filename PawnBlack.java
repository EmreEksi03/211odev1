public class PawnBlack extends Item {
    public PawnBlack(String position, Board board) {
        this.board = board;
        type = Type.Black;
        this.setPosition(position);
        point = 1F;
    }

    public PawnBlack(PawnBlack pawnBlack) {
        this.board = pawnBlack.board;
        type = Type.Black;
        this.setPosition(pawnBlack.getPosition());
        point = 1F;
    }

    @Override
    public boolean canMove(String destination) {
        if (!(Character.getNumericValue(destination.charAt(1)) >= 1 && Character.getNumericValue(destination.charAt(1)) <= 9))
            return false;
        String secondHalf = "abcde";
        String firstHalf = "fghij";
        if (firstHalf.indexOf(getPosition().charAt(0)) != -1) {
            if (board.getType(destination) != type) {
                if (secondHalf.indexOf(destination.charAt(0)) != -1) {
                    point = 2F;
                }
                return getPosition().charAt(1) == destination.charAt(1) && destination.charAt(0) - getPosition().charAt(0) == -1;
            }
        } else if (secondHalf.indexOf(getPosition().charAt(0)) != -1) {
            if (board.getType(destination) != type)
                return (Math.abs(getPosition().charAt(1) - destination.charAt(1)) == 1 && (destination.charAt(0) - getPosition().charAt(0) == 0) || (destination.charAt(0) - getPosition().charAt(0) == -1 && getPosition().charAt(1) - destination.charAt(1) == 0));

        }
        return false;
    }

    @Override
    public Item copyOf() {
        return new PawnBlack(this);
    }
    @Override
    public String getBytes() {
        String str = "" + type.getE() + "Pb" + getPosition();
        return str;
    }
    @Override
    public char getLetter() {
        return 'E';
    }
}
