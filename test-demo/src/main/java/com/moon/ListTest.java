package com.moon;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ListTest {
    public static void main(String[] args) {
//        List<String> list = new ArrayList<>(Arrays.asList("1111,2222","2222,3333","4444,5555"));
//        List<String> strings = new ArrayList<>(list);
//        for (String string : list) {
//            if (Objects.equals(string, "1111,2222")) {
//                strings.remove(string);
//            }
//        }
//        list.remove("1111,2222");
//        System.out.println(list.toArray());
//        System.out.println(strings.toArray());

        List<User> users = new ArrayList<>(Arrays.asList(new User("zs", 10), new User("ls", 11)));
//        List<User> users1 = new ArrayList<>(users);
////        users.get(0).setName("zsssssss");
//        users.remove(0);
//        System.out.println(users);
//        System.out.println(users1);

        String jsonString = JSON.toJSONString(users);
        //深度复制的原集合
        List<User> users2 = JSON.parseArray(jsonString,User.class);
        users.get(0).setName("zsssssss");
        System.out.println(users);
        System.out.println(users2);

    }
}
