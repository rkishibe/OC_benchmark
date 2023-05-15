package com.example.oc_lab_benchmark.benchTests;
import java.util.ArrayList;
import java.util.List;

    public class wPrime {

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

        public static List<Integer> wprime(int n) {
            List<Integer> primes = new ArrayList<>();
            int num = 2;
            while (primes.size() < n) {
                if (isPrime(num)) {
                    int reversed = Integer.parseInt(new StringBuilder(String.valueOf(num)).reverse().toString());
                    if (isPrime(reversed)) {
                        primes.add(num);
                    }
                }
                num++;
            }
            return primes;
        }

        public static void main(String[] args) {
            int n = 10;
            List<Integer> wprimeNumbers = wprime(n);
            System.out.println("The first " + n + " wprime numbers are: " + wprimeNumbers);
        }
    }


