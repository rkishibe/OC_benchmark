package com.example.oc_lab_benchmark.logging;


public interface ILogger {
    void write(long l);
    void write(String s);
    void write(Object ...objects);
    void close();
    void writeTime(long value, TimeUnit unit);
    void writeTime(String string, long value, TimeUnit unit);
}
