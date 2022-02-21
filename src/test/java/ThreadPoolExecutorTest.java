import java.util.concurrent.*;

public class ThreadPoolExecutorTest {


    private static final int coreSize = Runtime.getRuntime().availableProcessors();

    /**
     * maximumPoolSize = NCPU/(1-B)
     */
    private static final int maximumPoolSize = (int) (coreSize / (1 - 0.9));

    /**
     * corePoolSize = maximumPoolSize*20%
     */
    private static final int corePoolSize = (int) (maximumPoolSize * 0.2);


    private static final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
            corePoolSize,
            maximumPoolSize,
            10L,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(880),
            Executors.defaultThreadFactory());


    public static void main(String[] args) {
        System.out.println(threadPoolExecutor.getCorePoolSize());
        System.out.println(threadPoolExecutor.getMaximumPoolSize());

        new Thread(() -> {
            while (true) {
                System.out.println(threadPoolExecutor);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        for (var i = 0; i < 1000; i++) {
            threadPoolExecutor.execute(() -> {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

    }
}
