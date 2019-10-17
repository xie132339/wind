package com.wind.user.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.wind.user.po.User;

public class Test {
	public static void main(String[] args) {
		User user = new User();
		user.setId(1L);
		user.setEmail("e1");
		User user2 = new User();
		user2.setId(2L);
		user2.setEmail("e2");
		User user3 = new User();
		user3.setId(3L);
		user3.setEmail("e3");
		User user4 = new User();
		user4.setId(4L);
		user4.setEmail("e4");
		List<User> list = new ArrayList<>();
		list.add(user);
		list.add(user2);
		list.add(user3);
		list.add(user4);

		Map<Long, User> map = list.stream().collect(Collectors.toMap(User::getId, a -> a, (k1, k2) -> k1));
	}
}
