package hard.tasks.example;

import java.util.*;
import java.util.concurrent.*;

public class OwnThreadPool implements Executor {

    private final Queue<Runnable> workQueue = new ConcurrentLinkedQueue<>();
    private volatile boolean isRunning = true;

    private final class HardTaskWorker implements Runnable {

        @Override
        public void run() {
            while (isRunning) {
                Runnable nextTask = workQueue.poll();
                if (nextTask != null) {
                    nextTask.run();
                }
            }
        }
    }

    public OwnThreadPool(int n) {
        for (int i = 0; i < n; i++) {
            new Thread(new HardTaskWorker()).start();
        }
    }

    @Override
    public void execute(Runnable command) {
        if (isRunning) {
            workQueue.offer(command);
        }
    }

    public void shutdown() {
        isRunning = false;
    }
}
