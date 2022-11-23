package com.cloud.stream;

import com.cloud.pojo.User;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamGroupDemo {
    public static void main(String[] args) {

        List<User> userList = Arrays.asList(
                new User(1, "贾宝玉", "怡红公子", 14, 1, "怡红院"),
                new User(2, "林黛玉", "潇湘妃子", 13, 0, "潇湘馆"),
                new User(3, "薛宝钗", "蘅芜君", 15, 0, "蘅芜苑"),
                new User(4, "贾探春", "秋爽居士", 15, 0, "秋爽斋"),
                new User(6, "贾惜春", "藕榭", 14, 0, "藕香榭"),
                new User(7, "李纨", "稻香老农", 18, 0, "稻香村"));

        //将list根据条件分组，分组后为map
        Map<Integer, List<User>> map1 = userList.stream().collect(Collectors.groupingBy(User::getAge));
        Map<Integer, List<User>> map2 = userList.stream().collect(Collectors.groupingBy((user) -> buildkey(user)));
        Map<Integer, List<User>> map3 = userList.stream().collect(Collectors.groupingBy(StreamGroupDemo::buildkey));


        //过滤
        List<User> list1 = userList.stream().filter((user) -> user.getAge() > 14).collect(Collectors.toList());


        System.out.println("finish");
    }

    private static Integer buildkey(User user) {
        return user.getAge() + user.getSex();
    }
}
