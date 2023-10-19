package user.card.example;

import hard.tasks.example.*;
import lombok.*;
import user.card.example.model.*;
import user.card.example.service.*;

import java.util.concurrent.*;

public class UserCardServiceExample {

    /*
    Задача 2
    Продукт — выгрузка данных по номеру карты — информация по карте и ее держателю
    Есть два сервиса — один отдает UserProfile, другой отдает CardInfo
    Иногда, UserService задерживается, и не может отдать инфу сразу, из-за этого иногда метод может падать
     */

    static ExecutorService executorService = Executors.newSingleThreadExecutor();
    static ScheduledExecutorService scheduledExecutor = Executors.newSingleThreadScheduledExecutor();


    public static void main(String[] args) {

        UserCardService service = new UserCardService();
        CompletableFuture<UserProfile> cf = new CompletableFuture<>();
        LoggingService ls = new LoggingService();

        CompletableFuture.supplyAsync(() -> {
                    UserProfile up = null;
                    while (up == null) {
                        up = service.getByCardId(1);
                    }
                    return up;
                }, new OwnThreadPool(10))
                .thenAccept(ls::logObj);


        System.out.println(service.getByCardId(1));

    }

}
