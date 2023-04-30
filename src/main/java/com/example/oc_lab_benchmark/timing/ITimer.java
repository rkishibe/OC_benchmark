package com.example.oc_lab_benchmark.timing;

public interface ITimer {
    void start();

    long stop();

    void resume();

    long pause();
}
