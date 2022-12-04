package 输入输出练习;

import java.util.*;

public class Test {
    public static void main(String[] args) {
//        test2();
//        test1();
//        test3();
//        test4();
//        test5();
//        test6();
        test7();
    }

    private static void test2() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        while (n-- > 0) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println(a + b);
        }
    }


    public static void test1() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if (a == 0 && b == 0) break;
            System.out.println(a + b);
        }
    }

    public static void test3() {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            if (n == 0) break;
            int ans = 0;
            for (int i = 0; i < n; i++) {
                ans += scanner.nextInt();
            }
            System.out.println(ans);
        }
    }

    public static void test4() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            if (num != 0) {
                int total = 0;
                for (int j = 0; j < num; j++) {
                    total += scanner.nextInt();
                }
                System.out.println(total);
            }
        }
    }

    public static void test5() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            String[] split = s.split(",");
            System.out.println(Arrays.toString(split));
        }
    }

    public static void test6() {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list1 = new ArrayList<>();
            String[] s = scanner.nextLine().split(" ");
            for (int j = 1; j < s.length; j++) {
                list1.add(Integer.parseInt(s[j]));
            }
            list.add(list1);
        }
        System.out.println(list);
    }

    public static void test7() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int top = scanner.nextInt();
            int[] arr = new int[top];
            for (int j = 0; j < top; j++) {
                arr[j] = scanner.nextInt();
            }
            System.out.println(Arrays.toString(arr));
        }
    }
}
