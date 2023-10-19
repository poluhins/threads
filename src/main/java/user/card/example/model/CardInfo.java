package user.card.example.model;

import lombok.*;

@Data
@AllArgsConstructor
public class CardInfo {

    private int id;
    private String cardNum;
    private String cardLimit;
    private String historyId;
    private int userProfileId;

}
