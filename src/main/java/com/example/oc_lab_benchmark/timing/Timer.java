package com.example.oc_lab_benchmark.timing;

import javafx.animation.AnimationTimer;

public class Timer implements ITimer{
    private long time = 0;
    private long totalTime = 0;
    private AnimationTimer animationTimer;

    public Timer() {
        animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                time = now;
            }
        };
    }

    @Override
    public void start() {
        totalTime = 0;
        animationTimer.start();
    }

    @Override
    public long stop() {
        animationTimer.stop();
        totalTime += System.nanoTime() - time;
        return totalTime;
    }

    @Override
    public void resume() {
        animationTimer.start();
    }

    @Override
    public long pause() {
        animationTimer.stop();
        long tmp = System.nanoTime() - time;
        totalTime += tmp;
        return tmp;
    }
}
