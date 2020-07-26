public class Test_Deck {
    public static void main(String[] args) {
        Deck test = new Deck();
        test.createDeck();
        System.out.println(test);
        test.shuffle();
        System.out.println(test);
        for(int i = 0; i < 10; i++)
            System.out.println("Dealt " + test.deal());
        System.out.println(test);
    }
}

