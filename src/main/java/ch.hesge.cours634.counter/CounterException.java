package ch.hesge.cours634.counter;

public class CounterException extends Exception {
    public CounterException(String error) {
        System.out.println(error);
    }
}
