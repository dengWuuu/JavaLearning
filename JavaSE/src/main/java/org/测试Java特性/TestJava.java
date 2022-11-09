package org.测试Java特性;

/**
 * @author Wu
 * @date 2022年11月09日 11:56
 */
public class TestJava {

    public static void main(String[] args) {
        User user = new User(1, 1);
        test(user);
        System.out.println(user + "在main");
    }


    public static void test(User user) {
        user.setAge(2);
        System.out.println(user + "在test");
    }
}

