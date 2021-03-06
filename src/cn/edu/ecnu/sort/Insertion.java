package cn.edu.ecnu.sort;

import edu.princeton.cs.algs4.StdOut;

/**
 * 插入排序
 * 平均情况下需要N^2/4次比较，N^2/4次交换
 * 最好情况下（有序）：N-1次比较，0次交换
 * 最坏情况下（无序）：N^2/2次比较，N^2/2次排序
 */
public class Insertion {
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j-1);
            }
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (!less(a[i], a[i + 1]))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Integer[] a = {3, 1, 2, 5, 4};
        sort(a);
        assert isSorted(a);
        show(a);
     }

}
