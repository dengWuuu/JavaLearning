package main.动态代理;

/**
 * @author Wu
 * @date 2023年01月04日 17:00
 */
public class Main {
    public static void main(String[] args) {
        SmsService proxy = (SmsService) JdkProxyFactory.getProxy(new SmsServiceImpl());
        proxy.send("试试");
        proxy.send2("试试2");

    }
}
