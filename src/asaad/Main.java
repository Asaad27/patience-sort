package asaad;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Card> cards = new ArrayList<>();

        cards.add(new Card(10));
        cards.add(new Card(9));
        cards.add(new Card(2));
        cards.add(new Card(5));
        cards.add(new Card(3));
        cards.add(new Card(7));
        cards.add(new Card(101));
        cards.add(new Card(18));

        PatienceSorting patienceSorting = new PatienceSorting(cards);

        System.out.println("sorted list : " + patienceSorting.sort());
        System.out.println("longest increasing subsequence list : " + patienceSorting.lis());
    }
}

