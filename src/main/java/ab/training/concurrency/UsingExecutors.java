package ab.training.concurrency;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.*;

public class UsingExecutors {

    public static void usingSingleThreadExecutor() {
        System.out.println("=== SingleThreadExecutor ===");
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        singleThreadExecutor.execute(() -> System.out.println("Print this."));
        singleThreadExecutor.execute(() -> System.out.println("and this one to."));
        singleThreadExecutor.shutdown();
        try {
            singleThreadExecutor.awaitTermination(4, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\n\n");
    }

    public static void usingCachedThreadPool() {
        System.out.println("=== CachedThreadPool ===");
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        List<Future<UUID>> uuids = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            Future<UUID> submittedUUID = cachedThreadPool.submit(() -> {
                UUID randomUUID = UUID.randomUUID();
                System.out.println("UUID " + randomUUID + " from " + Thread.currentThread().getName());
                return randomUUID;
            });
            uuids.add(submittedUUID);
        }
        cachedThreadPool.execute(() -> uuids.forEach((f) -> {
            try {
                System.out.println("Result " + f.get() + " from thread " + Thread.currentThread().getName());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }));
        cachedThreadPool.shutdown();
        try {
            cachedThreadPool.awaitTermination(4, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\n\n");

    }

    public static void usingFixedThreadPool() {
        System.out.println("=== FixedThreadPool ===");
        ExecutorService fixedPool = Executors.newFixedThreadPool(4);
        List<Future<UUID>> uuids = new LinkedList<Future<UUID>>();
        for (int i = 0; i < 20; i++) {
            Future<UUID> submitted = fixedPool.submit(() -> {
                UUID randomUUID = UUID.randomUUID();
                System.out.println("UUID " + randomUUID + " from " + Thread.currentThread().getName());
                return randomUUID;
            });
            uuids.add(submitted);
        }
        fixedPool.execute(() -> uuids.forEach((f) -> {
            try {
                System.out.println("Result " + f.get() + " from " + Thread.currentThread().getName());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }));
        fixedPool.shutdown();
        try {
            fixedPool.awaitTermination(4, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\n\n");
    }

    public static void usingScheduledThreadPool() {
        System.out.println("=== ScheduledThreadPool ===");
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(4);
        scheduledThreadPool.scheduleAtFixedRate(() -> System.out.println("1) Print every 2s"), 0, 2, TimeUnit.SECONDS);
        scheduledThreadPool.scheduleAtFixedRate(() -> System.out.println("2) Print every 2s"), 0, 2, TimeUnit.SECONDS);
        scheduledThreadPool.scheduleWithFixedDelay(() -> System.out.println("3) Print every 2s delay"), 0, 2,
                TimeUnit.SECONDS);

        try {
            scheduledThreadPool.awaitTermination(6, TimeUnit.SECONDS);
            scheduledThreadPool.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\n\n");
    }

    public static void usingSingleTreadScheduledExecutor() {
        System.out.println("=== SingleThreadScheduledThreadPool ===");
        ScheduledExecutorService singleThreadScheduler = Executors.newSingleThreadScheduledExecutor();
        singleThreadScheduler.scheduleAtFixedRate(() -> System.out.println("1) Print every 2s"), 0, 2, TimeUnit.SECONDS);
        singleThreadScheduler.scheduleWithFixedDelay(() -> System.out.println("2) Print every 2s delay"), 0, 2,
                TimeUnit.SECONDS);

        try {
            singleThreadScheduler.awaitTermination(6, TimeUnit.SECONDS);
            singleThreadScheduler.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\n\n");

    }

    public static void usingWorkStealingThreadPool() {
        System.out.println("=== WorkStealingThreadPool ===");
        ExecutorService workStealingPool = Executors.newWorkStealingPool();

        workStealingPool.execute(() -> System.out.println("Prints normally"));

        Callable<UUID> generatesUUID = UUID::randomUUID;
        List<Callable<UUID>> severalUUIDsTasks = new LinkedList<Callable<UUID>>();
        for (int i = 0; i < 20; i++) {
            severalUUIDsTasks.add(generatesUUID);
        }

        try {
            List<Future<UUID>> futureUUIDs = workStealingPool.invokeAll(severalUUIDsTasks);
            for (Future<UUID> future : futureUUIDs) {
                if (future.isDone()) {
                    UUID uuid = future.get();
                    System.out.println("New UUID :" + uuid);
                }
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        try {
            workStealingPool.awaitTermination(6, TimeUnit.SECONDS);
            workStealingPool.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\n\n");
    }



    public static void main(String[] args) {
        usingSingleThreadExecutor();
        usingCachedThreadPool();
        usingFixedThreadPool();
        usingScheduledThreadPool();
        usingSingleTreadScheduledExecutor();
        usingWorkStealingThreadPool();
    }
}