package com.example.oc_lab_benchmark.benchTests;

import java.util.Random;

public class LeibnizPiCalculator implements IBenchmark {

    private double[] values;

    @Override
    public void run() {
        double pi = 0.0;
        double sign = 1.0;

        Random rd = new Random();
        for (int i = 0; i < values.length; i++) {
            values[i] = rd.nextInt();
        }

        for (long i = 0; i < values.length; i++) {
            double term = 1.0 / (2.0 * i + 1.0);
            pi += sign * term;
            sign = -sign;
            values[(int)i] = 4.0 * pi;
        }
    }


    @Override
    public void initialize(Object... params) {
        values = new double[(Integer)params[0]];
    }

    @Override
    public void clean() {

    }

    @Override
    public void cancel() {

    }

}

