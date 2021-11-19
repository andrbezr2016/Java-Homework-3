package com.andrbezr2016.tasks3.mytimers;

public final class MyTimer {
    private long timeStart;
    private long timeEnd;

    public MyTimer() {
    }

    public void start() {
        timeStart = System.nanoTime();
    }

    public long end() {
        timeEnd = System.nanoTime();
        return timeEnd - timeStart;
    }

    public long end(String message) {
        timeEnd = System.nanoTime();
        System.out.println(message + (timeEnd - timeStart) + "ns");
        return timeEnd - timeStart;
    }
}
