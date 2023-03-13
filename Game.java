import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Game extends AbstractGame {
    int moveCount = 0;

    public Game(String playerRedName, String playerBlackName) {
        board = new Board();
        red = new Player(playerRedName);
        black = new Player(playerBlackName);
    }

    boolean isCheck(Type type) throws GameException {
        for (int i = 0; i < board.items.length; i++) {
            if (board.items[i].type.equals(Type.getOpponent(type)) && board.items[i].canMove(board.getGeneral(type).getPosition()))
                return true;
        }
        return false;
    }

    private boolean isCheck(Type type, String position) throws GameException {
        for (int i = 0; i < board.items.length; i++) {
            if (board.items[i].type.equals(Type.getOpponent(type)) && board.items[i].canMove(position))
                return true;
        }
        return false;
    }

    boolean isCheckMate(Type type) throws GameException {
        for (int j = 0; j < board.getGeneral(type).getAllMoveableSpaces().length; j++) {
            if (!isCheck(type, board.getGeneral(type).getAllMoveableSpaces()[j]))
                return false;
        }
        return true;
    }

    boolean isStalemate(Type type) throws GameException {
        for (int j = 1; j < board.getGeneral(type).getAllMoveableSpaces().length; j++) {
            if (!isCheck(type, board.getGeneral(type).getAllMoveableSpaces()[j])) {
                return false;
            }
        }
        for (int i = 0; i < board.items.length; i++) {
            if (board.items[i].getLetter()!='Ş' && board.items[i].getLetter()!='ş' &&  board.items[i].type.equals(type) && board.items[i].moveable())
                return false;
        }
        return true;
    }

    @Override
    void play(String from, String to) throws GameException {
        if (moveCount % 2 == 0) {
            playTyped(from, to, Type.Red, Type.Black);
        } else {
            playTyped(from, to, Type.Black, Type.Red);
        }
    }

    private void playTyped(String from, String to, Type player, Type opponent) throws GameException {
        Item[] previous = board.createCopy();
        for (int i = 0; i < board.items.length; i++) {
            if (board.items[i].getPosition().equals(from) && board.items[i].type.equals(player)) {
                if (!isCheck(player)) {
                    board.items[i].move(to);
                    if (isCheck(player)) {
                        board.items = previous;
                        throw new GameException();
                    }
                    moveCount++;
                    board.print();
                    if (isStalemate(opponent)){
                        System.out.println("PAT!");
                    }
                    if (isCheckMate(opponent)) {
                        for (int j = 0; j < board.items.length; j++) {
                            if (board.items[j].type.equals(Type.Red) && board.items[j].getPosition().equals("xx")) {
                                black.puan += board.items[j].point;
                            }
                            if (board.items[j].type.equals(Type.Black) && board.items[j].getPosition().equals("xx")) {
                                red.puan += board.items[j].point;
                            }
                        }
                        if (player.equals(Type.Red))
                            System.out.println("ŞAH MAT!" + red.name + " oyunu kazandı.");
                        if (player.equals(Type.Black))
                            System.out.println("ŞAH MAT!" + black.name + " oyunu kazandı.");
                        System.out.println(red.name + "'s points: " + red.puan + " " + black.name + "'s points: " + black.puan);
                    }
                    return;
                }
                else if (isCheck(player)) {
                    board.items[i].move(to);
                    if (isCheck(player)) {
                        board.items = previous;
                        throw new GameException();
                    }
                    moveCount++;
                    board.print();
                    if (isStalemate(opponent)){
                        System.out.println("PAT!");
                    }
                    if (isCheckMate(opponent)) {
                        for (int j = 0; j < board.items.length; j++) {
                            if (board.items[j].type.equals(Type.Red) && board.items[j].getPosition().equals("xx")) {
                                black.puan += board.items[j].point;
                            }
                            if (board.items[j].type.equals(Type.Black) && board.items[j].getPosition().equals("xx")) {
                                red.puan += board.items[j].point;
                            }
                        }
                        if (player.equals(Type.Red))
                            System.out.println("ŞAH MAT!" + red.name + " oyunu kazandı.");
                        if (player.equals(Type.Black))
                            System.out.println("ŞAH MAT!" + black.name + " oyunu kazandı.");
                        System.out.println(red.name + "'nın puanı: " + red.puan + " " + black.name + "'nın puanı: " + black.puan);
                    }
                    return;
                }
            }
        }
        throw new GameException();
    }

    private static void getBits(StringBuilder sb, byte b) {
        for (int i = 0; i < 8; i++) {
            sb.append((b & 128) == 0 ? 0 : 1);
            b <<= 1;
        }
        sb.append(' ');
    }

    public static String toBinary(String s) {
        byte[] bytes = s.getBytes();
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            getBits(sb, b);
        }
        return sb.toString().trim();
    }

    @Override
    void save_binary(String address) throws IOException {
        String str = new String();
        for (Item item : board.items) {
            str += item.getBytes();
        }
        Files.write(Path.of(address), toBinary(str).getBytes());
    }

    @Override
    void save_text(String address) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Item item : board.items) {
            stringBuilder.append(item);
        }
        try {
            Files.writeString(Path.of(address), stringBuilder.toString(),
                    StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    void load_text(String address) {
        try {
            String string = Files.readString(Paths.get(address));
            String[] itemsStrings = string.split("\n");
            Item[] arr = new Item[itemsStrings.length];
            for (int i = 0; i < itemsStrings.length; i++) {
                String itemsString = itemsStrings[i];
                String[] itemProps = itemsString.split("\\*");
                Item o = getItem(itemProps);
                arr[i] = o;
            }
            board.items = arr;
        } catch (IOException | GameException e) {
            System.out.println(e.getMessage());
        }
    }

    private Item getItem(String[] itemProps) throws GameException {
        Type type = Type.Empty;
        if (itemProps[1].equals("Red"))
            type = Type.Red;
        if (itemProps[1].equals("Black"))
            type = Type.Black;


        if (itemProps[0].equals("Chariot"))
            return new Chariot(itemProps[2], board, type);
        if (itemProps[0].equals("Cannon"))
            return new Cannon(itemProps[2], board, type);
        if (itemProps[0].equals("Elephant"))
            return new Elephant(itemProps[2], board, type, type.getHalf());
        if (itemProps[0].equals("General"))
            return new General(itemProps[2], board, type.getPalace(), type);
        if (itemProps[0].equals("Guardian"))
            return new Guardian(itemProps[2], board, type.getPalace(), type);
        if (itemProps[0].equals("PawnRed"))
            return new PawnRed(itemProps[2], board);
        if (itemProps[0].equals("PawnBlack"))
            return new PawnBlack(itemProps[2], board);
        throw new GameException();
    }

    private String binaryToString(String input) {
        //String input = "011100100100001101101000011000010011000101110010010001110110010101100001001101010110001001000111011001010110101000110101";
        String raw = Arrays.stream(input.split(" "))
                .map(binary -> Integer.parseInt(binary, 2))
                .map(Character::toString)
                .collect(Collectors.joining());
        System.out.println(raw);
        return raw;
    }

    @Override
    void load_binary(String address) {
        try {
            String string = Files.readString(Paths.get(address));
            String str = binaryToString(string);
            board.items = new Item[str.length()/5];
            for (int i = 0; i < str.length(); i += 5) {
                String temp = str.substring(i, i + 5);
                if (temp.substring(1, 3).equals("Ca")) {
                    if (temp.charAt(0) == 'r')
                        board.items[i/5] = new Cannon(temp.substring(3), board, Type.Red);
                    else if (temp.charAt(0) == 'b')
                        board.items[i/5] = new Cannon(temp.substring(3), board, Type.Black);
                }
                if (temp.substring(1, 3).equals("Ch")) {
                    if (temp.charAt(0) == 'r')
                        board.items[i/5] = new Chariot(temp.substring(3), board, Type.Red);
                    else if (temp.charAt(0) == 'b')
                        board.items[i/5] = new Chariot(temp.substring(3), board, Type.Black);
                }
                if (temp.substring(1, 3).equals("El")) {
                    if (temp.charAt(0) == 'r')
                        board.items[i/5] = new Elephant(temp.substring(3), board, Type.Red,Type.Red.getHalf());
                    else if (temp.charAt(0) == 'b')
                        board.items[i/5] = new Elephant(temp.substring(3), board, Type.Black,Type.Black.getHalf());
                }
                if (temp.substring(1, 3).equals("Ge")) {
                    if (temp.charAt(0) == 'r')
                        board.items[i/5] = new General(temp.substring(3), board,Type.Red.getPalace(), Type.Red);
                    else if (temp.charAt(0) == 'b')
                        board.items[i/5] = new General(temp.substring(3), board, Type.Black.getPalace(), Type.Black);
                }
                if (temp.substring(1, 3).equals("Gu")) {
                    if (temp.charAt(0) == 'r')
                        board.items[i/5] = new General(temp.substring(3), board,Type.Red.getPalace(), Type.Red);
                    else if (temp.charAt(0) == 'b')
                        board.items[i/5] = new General(temp.substring(3), board, Type.Black.getPalace(), Type.Black);
                }
                if (temp.substring(1, 3).equals("Ho")) {
                    if (temp.charAt(0) == 'r')
                        board.items[i/5] = new Horse(temp.substring(3), board, Type.Red);
                    else if (temp.charAt(0) == 'b')
                        board.items[i/5] = new Horse(temp.substring(3), board, Type.Black);
                }
                if (temp.substring(1, 3).equals("Pb")) {
                    board.items[i/5] = new PawnBlack(temp.substring(3), board);
                }
                if (temp.substring(1, 3).equals("Pr")) {
                    board.items[i/5] = new PawnRed(temp.substring(3),board);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
