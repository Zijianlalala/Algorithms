package cn.edu.ecnu.sort;

/**
 * 利用归并排序求数组的逆序数
 */
public class Inversions {

    private static long merge(int a[], int aux[], int lo, int mid, int hi) {
        long inversions = 0;
        for (int i = lo; i <= hi; i++) {
            aux[i] = a[i];
        }
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (aux[j] < aux[i]) {
                inversions += mid - i + 1;
                a[k] = aux[j++];
            } else a[k] = aux[i++];
        }
        return inversions;
    }

    private static long count(int[] a, int[] aux, int lo, int hi) {
        long inversions = 0;
        if (hi <= lo) return 0;
        int mid = lo + (hi - lo) / 2;
        inversions += count(a, aux, lo, mid);
        inversions += count(a, aux, mid + 1, hi);
        inversions += merge(a, aux, lo, mid, hi);
        return inversions;
    }

    public static long count(int[] a) {
        int[] aux = new int[a.length];
        long inversions = count(a, aux, 0, a.length - 1);
        return inversions;
    }

    public static void main(String[] args) {
        int a[] = {3, 1, 4, 2};
        System.out.println(count(a));
        for (int v : a
        ) {
            System.out.print(v + ",");
        }
    }
}
