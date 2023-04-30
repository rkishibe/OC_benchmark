package com.example.oc_lab_benchmark.benchTests;

public interface IBenchmark {
    void run();
    void initialize(Object... params);
    void clean();
    void cancel();
}
