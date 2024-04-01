package com.itheima.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Autowired
    public User user;
    @Test
    public void Get() {
        user.SetName("jack");
        System.out.println(user.GetName());
    }

    @Test
    public void GetSchoolName() {
        System.out.println(user.GetSchoolName());
    }

    @Test
    public void GetColl() {
        int[] arrList = new int[5];
        System.out.println(arrList);

        List<String> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        Set<String> hashSet = new HashSet<>();
        hashSet.add("hello");
        System.out.println(hashSet.contains("hello"));
        Set<Integer> treeSet = new TreeSet<>();
        treeSet.add(1);
        treeSet.add(10);
        treeSet.add(5);
        treeSet.add(15);
        // 遍历集合
        for (Integer num : treeSet) {
            System.out.println(num);
        }

        // 查找元素
        System.out.println(treeSet.contains(5)); // true
        System.out.println(treeSet.stream().findFirst()); // 5

        Queue<String> queue = new LinkedList<>();

        Stack<Integer> stack = new Stack<>();

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());


        LinkedList<String> sites = new LinkedList<String>();
        sites.add("Google");
        sites.add("Baidu");
        sites.add("TB");
        // 使用 addFirst() 在头部添加元素
        sites.addFirst("Wiki");
        System.out.println(sites);

        // 创建 HashMap 对象 Sites
        HashMap<String, String> Sites = new HashMap<String, String>();
        // 添加键值对
        Sites.put("one", "jack");
        Sites.put("two", "rose");
        System.out.println(Sites);
        System.out.println(Sites.get("one"));

        // 创建集合
        ArrayList<String> arrListS = new ArrayList<String>();
        arrListS.add("Google");
        arrListS.add("B");
        arrListS.add("A");
        arrListS.add("C");

        // 获取迭代器

        // 输出集合中的所有元素
        for (String list : arrListS) {
            System.out.println(list);
        }
    }
}