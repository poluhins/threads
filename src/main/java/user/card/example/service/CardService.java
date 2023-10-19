package user.card.example.service;

import user.card.example.model.*;

import java.util.*;

public class CardService {

    private static final Map<Integer, CardInfo> CARDS = new HashMap<>() {{
        put(1, new CardInfo(1, "1234", "100", "134dfsfs", 1));
        put(2, new CardInfo(2, "1345", "0", "r2fccee", 1));
        put(3, new CardInfo(3, "5432", "100", "222ffvf", 2));
        put(4, new CardInfo(4, "2345", "800", "23kjkl", 3));
    }};

    public CardInfo findCardById(int cardId) {
        return CARDS.get(cardId);
    }

}
