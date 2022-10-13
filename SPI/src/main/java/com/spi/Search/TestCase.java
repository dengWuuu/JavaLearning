package com.spi.Search;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ServiceLoader;

public class TestCase {
    public static void main(String[] args) {
        ServiceLoader<Search> s = ServiceLoader.load(Search.class);
        for (Search search : s) {
            search.searchDoc("hello world");
        }
    }
}