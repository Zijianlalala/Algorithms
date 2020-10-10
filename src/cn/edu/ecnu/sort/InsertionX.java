package cn.edu.ecnu.sort;

/**
 * 带哨兵的插入排序
 */
public class InsertionX {
    public static void sort(Comparable[] a) {
        int N = a.length;
        // 找到最小的元素（可以用冒泡排序
        int exchanges = 0;
        for (int i = N - 1; i > 0; i--) {
            if (less(a[i], a[i - 1])) {
                exch(a, i, i - 1);
                exchanges++;
            }
        }
        if (exchanges == 0) return;
        // 插入排序
        for (int i = 2; i < N; i++) {
            // 哨兵v
            Comparable v = a[i];
            int j = i;
            while (less(v, a[j-1])){
                // 后移
                a[j] = a[j-1];
                j--;
            }
            a[j] = v;
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
