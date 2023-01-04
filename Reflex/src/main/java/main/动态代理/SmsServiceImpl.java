package main.动态代理;

public class SmsServiceImpl implements SmsService {
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }

    public String send2(String message){
        System.out.println(message);
        return message;
    }
}