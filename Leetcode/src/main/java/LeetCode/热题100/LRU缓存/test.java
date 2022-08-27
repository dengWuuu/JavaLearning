package LeetCode.热题100.LRU缓存;

/**
 * @author Wu
 * @date 2022年08月27日 18:21
 */
public class test {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(2,1);
        cache.put(2,2);
        int i = cache.get(2);
        System.out.println(i);
    }
}
