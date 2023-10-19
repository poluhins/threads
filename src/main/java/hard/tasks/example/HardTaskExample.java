package hard.tasks.example;

    /*
    Задача 1
    Есть тяжелые задачи, нужно их запараллелить
     */

import lombok.*;

import java.util.*;
import java.util.concurrent.*;

public class HardTaskExample {

    private static final int POOL_SIZE = 15;

    static ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE);

    @SneakyThrows
    public static void main(String[] args) {


        List<HardTask> tasks = new ArrayList<>();

        int taskCount = 10_000_000;
        for (int i = 0; i < taskCount; i++) {
            tasks.add(new HardTask());
        }

        List<Future> futures = new ArrayList<>();
        long start = System.currentTimeMillis();

        for (HardTask task : tasks) {
            futures.add(executor.submit(task));
        }

        for (Future<?> future : futures) {
            future.get();
        }

        System.out.println((System.currentTimeMillis() - start) / 1000);
    }

}
