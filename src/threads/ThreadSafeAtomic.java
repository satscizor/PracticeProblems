package threads;

import java.util.concurrent.atomic.AtomicInteger;

//Write a demo program to do atomic increment of a counter
public class ThreadSafeAtomic {
	private final AtomicInteger counter = new AtomicInteger(0);
    
    public int getValue() {
        return counter.get();
    }
    public void increment() {
        while(true) {
            int existingValue = getValue();
            int newValue = existingValue + 1;
            if(counter.compareAndSet(existingValue, newValue)) {
                return;
            }
        }
    }
}
