package JavaSe.注解;

import java.lang.annotation.Annotation;

/**
 * @author Wu
 * @date 2022年07月11日 21:53
 */
@Mybook(name = "test", author = "wdw")
public class AnnotationDemo {
    public static void main(String[] args) {
        Class<BookStore> bookStoreClass = BookStore.class;
        if (bookStoreClass.isAnnotationPresent(Mybook.class)) {
            //获取注解
            Mybook declaredAnnotation = bookStoreClass.getDeclaredAnnotation(Mybook.class);
            System.out.println(declaredAnnotation.author());
        }
    }


}

@Mybook(name = "ss", author = "wdw")
class BookStore {
    @Mybook(name = "ss1", author = "wdw1")
    public void test() {

    }
}


