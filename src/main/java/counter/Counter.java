package counter;

public class Counter implements Runnable {

    private int counte;

    public void increment() {
        counte++;
    }

    public void decrement() {
        counte--;
    }

    public int getValue() {
        return counte;
    }

    @Override
    public void run() {

        synchronized (this) {
            this.increment();
            System.out.println("increment +++ 된 후 현재 count = " + Thread.currentThread().getName() + " : " + this.getValue()); // 1
            this.decrement();
            System.out.println("decrement --- 된 후 현재 count = " + Thread.currentThread().getName() + " : " + this.getValue()); // 0
        }
    }
}
