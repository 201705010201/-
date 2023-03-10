package com.moon;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListTest {
    public static void main(String[] args) {

        /**
         * 深度复制List A集合得到B集合，这样在修改集合A的时候 B集合中对象不会改变
         * @param sourceList 被复制的集合
         * @param <T> 集合中的对象（必须继承序列化接口）
         * @return （复制出来的新集合，修改原集合的话不会受原集合的影响）
         * @throws IOException
         * @throws ClassNotFoundException
         */
//        public static <T> List<T> deepCopy(List<T> sourceList) throws IOException, ClassNotFoundException{
//            ByteArrayOutputStream bo= new ByteArrayOutputStream();
//            ObjectOutputStream ous= new ObjectOutputStream(bo);
//            ous.writeObject(sourceList);
//            ByteArrayInputStream bi= new ByteArrayInputStream(bo.toByteArray());
//            ObjectInputStream ois=new ObjectInputStream(bi);
//            @SuppressWarnings("unchecked")
//            List<T> dest = (List<T>)ois.readObject();
//            return dest;
//        }

        //三个Users对象组成一个List集合
        List<Users> list = new ArrayList<>();
        list.add(new Users("11", 1));
        list.add(new Users("11", 2));
        list.add(new Users("33", 3));

        //将list转map，这里是出现重复key时，覆盖前一个
//        Map<String, Users> usersMap = list.stream()
//                .collect(Collectors.toMap(Users::getUserName, Function.identity(), (user1, user2) -> user2));

        Map<String, Integer> usersMap = list.stream()
                .collect(Collectors.toMap(Users::getUserName, Users::getUserId));

        System.out.println(usersMap.get("11"));

    }
}
