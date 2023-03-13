public class Board extends AbstractBoard{

	public Board() {
		PawnBlack pawnBlack = new PawnBlack("g1",this);
		PawnBlack pawnBlack2 = new PawnBlack("g3",this);
		PawnBlack pawnBlack3 = new PawnBlack("g5",this);
		PawnBlack pawnBlack4 = new PawnBlack("g7",this);
		PawnBlack pawnBlack5 = new PawnBlack("g9",this);

		PawnRed pawnRed = new PawnRed("d1",this);
		PawnRed pawnRed2 = new PawnRed("d3",this);
		PawnRed pawnRed3 = new PawnRed("d5",this);
		PawnRed pawnRed4 = new PawnRed("d7",this);
		PawnRed pawnRed5 = new PawnRed("d9",this);

		Cannon cannonRed = new Cannon("c2",this,Type.Red);
		Cannon cannonRed2 = new Cannon("c8",this,Type.Red);

		Cannon cannonBlack = new Cannon("h2",this,Type.Black);
		Cannon cannonBlack2 = new Cannon("h8",this,Type.Black);

		Chariot chariotRed = new Chariot("a1",this,Type.Red);
		Chariot chariotRed2 = new Chariot("a9",this,Type.Red);

		Chariot chariotBlack = new Chariot("j1",this,Type.Black);
		Chariot chariotBlack2 = new Chariot("j9",this,Type.Black);

		Horse horseRed = new Horse("a2",this,Type.Red);
		Horse horseRed2 = new Horse("a8",this,Type.Red);

		Horse horseBlack = new Horse("j2",this,Type.Black);
		Horse horseBlack2 = new Horse("j8",this,Type.Black);

		Elephant elephantRed = new Elephant("a3",this,Type.Red,Type.Red.getHalf());
		Elephant elephantRed2 = new Elephant("a7",this,Type.Red,Type.Red.getHalf());

		Elephant elephantBlack = new Elephant("j3",this,Type.Black,Type.Black.getHalf());
		Elephant elephantBlack2 = new Elephant("j7",this,Type.Black,Type.Black.getHalf());

		Guardian guardianRed = new Guardian("a4",this, Type.Red.getPalace(), Type.Red);
		Guardian guardianRed2 = new Guardian("a6",this, Type.Red.getPalace(), Type.Red);

		Guardian guardianBlack = new Guardian("j4",this,Type.Black.getPalace(), Type.Black);
		Guardian guardianBlack2 = new Guardian("j6",this,Type.Black.getPalace(), Type.Black);

		General generalRed = new General("a5",this,Type.Red.getPalace(), Type.Red);
		General generalBlack = new General("j5",this,Type.Black.getPalace(), Type.Black);


		items = new Item[]{pawnBlack,pawnBlack2,pawnBlack3,pawnBlack4,pawnBlack5,pawnRed,pawnRed2,pawnRed3,pawnRed4,pawnRed5,cannonBlack,cannonBlack2,cannonRed,cannonRed2,chariotRed,chariotRed2,chariotBlack,chariotBlack2,elephantRed,elephantRed2,elephantBlack,elephantBlack2,horseRed,horseRed2,horseBlack,horseBlack2,guardianBlack,guardianBlack2,guardianRed,guardianRed2,generalRed,generalBlack};
	}
	public Item[] createCopy(){
		Item[] copy = new Item[this.items.length];
		for (int i=0;i<this.items.length;i++){
			copy[i] = this.items[i].copyOf();
		}
		return copy;
	}

	@Override
	public void print() {
		char[][] boardArray = new char[21][29];
		String str1 = "j\t-------------------------";
		boardArray[0] = str1.toCharArray();
		String str2 = " \t|  |  |  |\\ | /|  |  |  |";
		boardArray[1] = str2.toCharArray();
		String str3 = "i\t-------------------------";
		boardArray[2] = str3.toCharArray();
		String str4 = "\t|  |  |  |/ | \\|  |  |  |";
		boardArray[3] = str4.toCharArray();
		String str5 = "h\t-------------------------";
		boardArray[4] = str5.toCharArray();
		String str6 = " \t|  |  |  |  |  |  |  |  |";
		boardArray[5] = str6.toCharArray();
		String str7 = "g\t-------------------------";
		boardArray[6] = str7.toCharArray();
		String str8 = " \t|  |  |  |  |  |  |  |  |";
		boardArray[7] = str8.toCharArray();
		String str9 = "f\t-------------------------";
		boardArray[8] = str9.toCharArray();
		String str10 = " \t|                       |";
		boardArray[9] = str10.toCharArray();
		String str11 = "e\t-------------------------";
		boardArray[10] = str11.toCharArray();
		String str12= " \t|  |  |  |  |  |  |  |  |";
		boardArray[11] = str12.toCharArray();
		String str13= "d\t-------------------------";
		boardArray[12] = str13.toCharArray();
		String str14= " \t|  |  |  |  |  |  |  |  |";
		boardArray[13] = str14.toCharArray();
		String str15= "c\t-------------------------";
		boardArray[14] = str15.toCharArray();
		String str16= " \t|  |  |  |/ | \\|  |  |  |";
		boardArray[15] = str16.toCharArray();
		String str17= "b\t-------------------------";
		boardArray[16] = str17.toCharArray();
		String str18= " \t|  |  |  |\\ | /|  |  |  |";
		boardArray[17] = str18.toCharArray();
		String str19= "a\t-------------------------";
		boardArray[18] = str19.toCharArray();
		String str20= " ";
		boardArray[19] = str20.toCharArray();
		String str21= " \t1--2--3--4--5--6--7--8--9";
		boardArray[20] = str21.toCharArray();
		for (int i=0;i<this.items.length;i++){
			Item temp = this.items[i];
			for (int j = 0; j < boardArray.length; j++) {
				char[] chars = boardArray[j];
				if (chars[0] == temp.getPosition().charAt(0)){
					chars[Character.getNumericValue(temp.getPosition().charAt(1))*3-1] = temp.getLetter();
				}
			}
		}
		for (int i = 0; i < boardArray.length; i++) {
			char[] chars = boardArray[i];
			for (int j = 0; j < chars.length; j++) {
				System.out.print(chars[j]);
			}
			System.out.println();
		}
	}
	Type getType(String destination){
		for (Item item : items) {
			if (item.getPosition().equals(destination))
				return item.type;
		}
		return Type.Empty;
	}
	private Item getRedGeneral() throws GameException {
		for (Item item : items) {
			if (item instanceof General) {
				if (item.type.equals(Type.Red)) {
					return item;
				}
			}
		}
		throw new GameException();
	}
	private Item getBlackGeneral() throws GameException {
		for (Item item : items) {
			if (item instanceof General) {
				if (item.type.equals(Type.Black)) {
					return item;
				}
			}
		}
		throw new GameException();
	}

	General getGeneral(Type type)throws GameException{
		if (type.equals(Type.Red))
			return (General) getRedGeneral();
		else if (type.equals(Type.Black))
			return (General) getBlackGeneral();
		throw new UnsupportedOperationException();
	}

}
