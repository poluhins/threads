package user.card.example.service;

import lombok.*;
import user.card.example.model.*;
import user.card.example.service.*;

public class UserCardService {

    private CardService cardService = new CardService();
    private UserService userService = new UserService();

    public UserProfile getByCardId(int cardId) {
        val card = cardService.findCardById(cardId);
        if (card == null) {
            return null;
        }

        return userService.findByUserId(card.getUserProfileId());
    }

}
