package com.example.oc_lab_benchmark.benchTests;
import java.util.ArrayList;
import java.util.List;

    public class wPrime implements IBenchmark {
        List<Integer> primes;
        int num;
        int n = 10;
        public static boolean isPrime(int n) {
            if (n <= 1) {
                return false;
            }
            if (n <= 3) {
                return true;
            }
            if (n % 2 == 0 || n % 3 == 0) {
                return false;
            }
            int i = 5;
            while (i * i <= n) {
                if (n % i == 0 || n % (i + 2) == 0) {
                    return false;
                }
                i += 6;
            }
            return true;
        }


        @Override
        public void run() {
            initialize();
            for (long i=0; i<primes.size();i++){
                if (isPrime(num)) {
                    int reversed = Integer.parseInt(new StringBuilder(String.valueOf(num)).reverse().toString());
                    if (isPrime(reversed)) {
                        primes.add(num);
                    }
                }
                num++;
            }

        }

        @Override
        public void initialize(Object... params) {
             primes = new ArrayList<>();
             num = 2;
        }

        @Override
        public void clean() {

        }

        @Override
        public void cancel() {

        }
    }


