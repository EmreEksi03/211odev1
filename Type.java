public enum Type {
    Black('b',"jighf", "jih"),Red('r',"abcde", "abc"),Empty('e',"", "");

    public char getE() {
        return e;
    }

    private char e;
    private String half;
    private String palace;

    Type(char e, String half, String palace) {
        this.e = e;
        this.half = half;
        this.palace = palace;
    }

    public String getHalf() {
        return half;
    }

    public static Type getOpponent(Type type) {
        if (type.equals(Type.Red))
            return Type.Black;
        else
            return Type.Red;
    }

    public static Type getType(String itemProp) {
        if (itemProp.equals("Red"))
            return Type.Red;
        return Type.Black;
    }

    public String getPalace() {
        return palace;
    }
}
