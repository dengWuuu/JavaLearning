import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import shape.Circle;
import user.User;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Wu
 * @date 2022年06月01日 9:42
 */
public class Reflect {
    @Test
    public void classTest() {
        System.out.println(User.class);
    }

    @Test
    public void shapeTest() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {

        Class clazz = Class.forName("shape.Circle");

        //根据参数获取public的Method,包含继承自父类的方法
        Method method = clazz.getMethod("draw", int.class, String.class);

        System.out.println("method:" + method);
        //获取所有public的方法:
        Method[] methods = clazz.getMethods();
        for (Method m : methods) {
            System.out.println("m::" + m);
        }

        System.out.println("=========================================");

        //获取当前类的方法包含private,该方法无法获取继承自父类的method
        Method method1 = clazz.getDeclaredMethod("drawCircle");
        System.out.println("method1::" + method1);
        //获取当前类的所有方法包含private,该方法无法获取继承自父类的method
        Method[] methods1 = clazz.getDeclaredMethods();
        for (Method m : methods1) {
            System.out.println("m1::" + m);
        }


        System.out.println("=========================================");

//创建对象
        Circle circle = (Circle) clazz.newInstance();

//获取指定参数的方法对象Method
        // Method method = clazz.getMethod("draw",int.class,String.class);

//通过Method对象的invoke(Object obj,Object... args)方法调用
        method.invoke(circle, 15, "圈圈");

//对私有无参方法的操作
//修改私有方法的访问标识
        method1.setAccessible(true);
        method1.invoke(circle);

//对有返回值得方法操作
        Method method2 = clazz.getDeclaredMethod("getAllCount");
        Integer count = (Integer) method2.invoke(circle);
        System.out.println("count:" + count);

    }
}
