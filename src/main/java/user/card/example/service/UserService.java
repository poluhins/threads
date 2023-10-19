package user.card.example.service;

import lombok.*;
import user.card.example.model.*;

import java.util.*;

import static java.lang.Thread.sleep;

public class UserService {

    private static final Random RANDOM = new Random();


    private static final Map<Integer, UserProfile> USERS = new HashMap<>() {{
        put(1, new UserProfile(1, "An", "Go", 1));
        put(2, new UserProfile(2, "Geo", "Far", 1));
        put(3, new UserProfile(3, "Tun", "Bon", 2));
        put(4, new UserProfile(4, "Clir", "Car", 3));
    }};

    @SneakyThrows
    public UserProfile findByUserId(int userId) {
        sleep(RANDOM.nextInt(10));
        if (RANDOM.nextBoolean()) {
            return null;
        }
        return USERS.get(userId);
    }



}
