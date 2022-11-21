package counter;

public class CountApplication {

    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread thread1 = new Thread(counter, "thread-1");
        Thread thread2 = new Thread(counter, "thread-2");
        Thread thread3 = new Thread(counter, "thread-3");

        /**
         * thread-1, thread-2, thread-3 의 순서로 실행되지 않는다.
         */
        thread1.start();
        thread2.start();
        thread3.start();

        /**
         * multi thread 환경에서는 순서가 보장되지 않는다.
         * 이를 race condition 이라고 한다.
         * race condition 이란 여러 thread 가 동시에 같은 자원에 접근하여 값을 변경하려고 할 때 발생하는 문제이다.
         */
    }
}
