package com.moon;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StreamTest {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("zhangsan", 12),
                new User("moon", 8));
        users.stream().map(item -> {
            if (Objects.equals(item.getName(), "mooon")) {
                item.setName("---");
            }
            return item;
        }).collect(Collectors.toList());


    }
}
