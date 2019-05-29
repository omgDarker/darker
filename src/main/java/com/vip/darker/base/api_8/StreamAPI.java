package com.vip.darker.base.api_8;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @description: 集合讲的是数据，流讲的是计算
 * @author: WKB.WANGBINGAN
 * @date: 2019/5/29 15:13
 * @version: 1.0.
 * Stream的操作三个步骤
 * <p>
 * 1、创建 Stream
 * <p>
 * 一个数据源（如：集合、数组），获取一个流
 * <p>
 * 2、中间操作
 * <p>
 * 一个中间操作链，对数据源的数据进行处理
 * <p>
 * 3、终止操作（终端操作）
 * <p>
 * 一个终止操作，执行中间操作链，并产生结果
 * <p>
 * https://blog.csdn.net/Keith003/article/details/80252553
 */
public class StreamAPI {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>() {{
			add(2);
			add(1);
			add(3);
		}};
		// 1.流循环
		list.forEach(System.out::println); // list.stream().forEach(obj-> System.out.println(obj));
		// 2.集合转换
		Set<Integer> set = list.stream().limit(2).collect(Collectors.toSet());
		System.out.println(set);
		// 3.集合查找(若无元素,则默认为1)
		Integer integer = list.stream().findFirst().orElse(1);
		System.out.println(integer);
		// 4.集合求和(第一个参数表示起始值,即将0赋给x,列表的第一个元素赋给y,运算后将结果1赋给x,如此循环)
		Integer reduce = list.stream().reduce(0, (x, y) -> x + y);
		System.out.println(reduce);
	}
}