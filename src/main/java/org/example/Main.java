package org.example;

import OOOPS.Inheritence.Human;
import OOOPS.Inheritence.Species;
import OOOPS.Inheritence.*;
import OOOPS.Inheritence.Threads.CallableInterFace;
import OOOPS.Inheritence.Threads.Thread1;
import OOOPS.Inheritence.Threads.Thread2;
import OOOPS.Inheritence.Threads.Work;
import StaticPackage.TestStatic;

import java.util.*;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

       int n = 5;
        Callable<Integer> sumTask = () -> {
            int i = n + 1;
            return i;
        };

        ExecutorService es =  Executors.newFixedThreadPool(100);
        var f = es.submit(sumTask);
        System.out.println(f.get());




    }

    public static long kthElement(int arr1[], int arr2[], int n, int m, int k) {
        if (n > m) return kthElement(arr2, arr1, m, n, k);

        int l = Math.max(0, k - m);
        int r = Math.min(n, k);

        while (l <= r) {
            int x = l + (r - l) / 2;
            int y = k - x;

            int l1 = x == 0 ? Integer.MIN_VALUE : arr1[x - 1];
            int l2 = y == 0 ? Integer.MIN_VALUE : arr2[y - 1];
            int r1 = x == n ? Integer.MAX_VALUE : arr1[x];
            int r2 = y == m ? Integer.MAX_VALUE : arr2[y];

            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            } else if (l1 > r2) {
                l = x + 1;
            } else {
                r = x - 1;
            }
        }
        return 1;


    }
}