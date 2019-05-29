package com.vip.darker.base.api_8;

import java.util.*;

/**
 * @description: TODO
 * @author: WKB.WANGBINGAN
 * @date: 2019/5/29 16:28
 * @version: 1.0.0
 */
public class LambdaAPI {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>() {{
			add(1);
			add(2);
			add(3);
			add(4);
		}};
		// 1.集合排序
		list.sort(Comparator.reverseOrder());
		list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
		System.out.println(list);
		// 2.Optional filter
		Optional<String> opt = Optional.of("darker"); // Optional.ofNullable() Optional.empty()
		System.out.println(opt.orElse("darker2008"));
		System.out.println(opt.filter(e -> e.length() > 10).orElse("darker2009"));
		// 3.Optional map 对象不为空则执行map表达式
		System.out.println(opt.map(String::toUpperCase).orElse("操作失败"));
		// 4.Optional ifPresent 处理对象无返回值
		opt.ifPresent(e -> System.out.println(e.toUpperCase()));
		// 5.数值可以用下划线分割(JDK7)
		System.out.println(1_2_3);
	}

	public class Person {
		/**
		 * 姓名
		 */
		public String name;
		/**
		 * 地址
		 */
		public String address;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}
	}
}
