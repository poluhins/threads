package hard.tasks.example;

import lombok.*;

import java.util.*;

import static java.lang.Thread.sleep;

public class HardTask implements Runnable {

    private Random random = new Random();

    @SneakyThrows
    @Override
    public void run() {
        Math.tan(random.nextDouble());
    }
}
