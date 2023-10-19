package user.card.example.model;

import lombok.*;

@Data
@AllArgsConstructor
public class UserProfile {

    private int id;
    private String firstName;
    private String lastName;
    private int cardId;

}
