package ch.hesge.cours634.counter;

public class Counter implements ICounter {
    int value;

    public Counter(int value) {
        this.value = value;
    }

    public Counter() {
        this.value = 1;
    }

    public void inc() {
        this.value++;
    }

    public void add(int step) {
        this.value += step;
    }

    public int getValue(){
        return this.value;
    }
}
