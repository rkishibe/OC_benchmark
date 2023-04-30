package com.example.oc_lab_benchmark.testbench;

import com.example.oc_lab_benchmark.benchTests.FastFourierTransform;
import com.example.oc_lab_benchmark.benchTests.IBenchmark;
import com.example.oc_lab_benchmark.benchTests.LeibnizPiCalculator;
import com.example.oc_lab_benchmark.timing.ITimer;
import com.example.oc_lab_benchmark.timing.Timer;

public class Testbench {

    public long run() {
        ITimer timer = new Timer();

        IBenchmark pi=new LeibnizPiCalculator();
        IBenchmark fft = new FastFourierTransform();

        int arraySize = 10000;
        int fftSize = 1048576;
        long time1, time2;

        timer.start();

        pi.initialize(arraySize);
        pi.run();
        time1 = timer.pause();

        timer.resume();
        fft.initialize(fftSize);
        fft.run();
        time2 = timer.pause();
        timer.resume();

        double score1 = Math.log(arraySize)*(1000000000.0/Math.log(time1));
        double score2 = Math.log(arraySize)*(1000000000.0/Math.log(time2));
        double score = ((score1*0.5 + score2*0.5)/4)/10000.0;

        return (long)score;
    }
}
