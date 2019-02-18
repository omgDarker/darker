package com.vip.darker.convert;


import com.vip.darker.constant.CommonConstant;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @Auther: Darker
 * @Date: 2018/7/30 14:07
 * @Description: 对象转换工具类
 */
public class ConvertObject {

    private static Logger logger = LoggerFactory.getLogger(ConvertObject.class);

    /**
     * 将map对象转化为bean
     *
     * @param map
     * @param cls
     * @return bean
     * @throws Exception
     */
    private static <T> T convertMapToBean(Map<String, Object> map, Class<T> cls) throws Exception {
        if (map == null || map.size() == 0) {
            return null;
        }
        // 获取map中所有的key值,全部更新成大写,添加到keys集合中,与mybatis中驼峰命名匹配
        Map<String, Object> newMap = new HashMap<>(CommonConstant.MAP_DEFAULT_INITIAL_CAPACITY);
        map.forEach((key, value) -> {
            if (key.contains(CommonConstant.CHARACTER_UNDERLINE)) {
                key = key.replaceAll(CommonConstant.CHARACTER_UNDERLINE, "");
            }
            newMap.put(key.toUpperCase(Locale.US), value);
        });
        BeanInfo beanInfo = Introspector.getBeanInfo(cls);
        T bean = cls.newInstance();
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor descriptor : propertyDescriptors) {

            String propertyName = descriptor.getName();
            String upperPropertyName = propertyName.toUpperCase();

            if (newMap.keySet().contains(upperPropertyName)) {
                Object value = newMap.get(upperPropertyName);
                //这个方法不会报参数类型不匹配的错误。
                BeanUtils.copyProperty(bean, propertyName, value);
            }
        }
        return bean;
    }

    /**
     * 将bean对象转化为map对象
     *
     * @param bean
     * @return map
     * @throws Exception
     */
    public static Map<String, Object> convertBeanToMap(Object bean) throws Exception {
        Class<?> type = bean.getClass();

        BeanInfo beanInfo = Introspector.getBeanInfo(type);

        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();

        Map<String, Object> returnMap = new HashMap<>((int) (propertyDescriptors.length / 0.75 + 1));

        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
            String propertyName = propertyDescriptor.getName();
            if (!"class".equals(propertyName)) {
                Method readMethod = propertyDescriptor.getReadMethod();
                Object result = readMethod.invoke(bean);
                if (result != null) {
                    returnMap.put(propertyName, result);
                } else {
                    returnMap.put(propertyName, null);
                }
            }
        }
        return returnMap;
    }

    /**
     * 将List<map>对象转化为List<bean>
     *
     * @param mapList
     * @param cls
     * @return List
     */
    public static <T> List<T> convertListMapToListBean(List<Map<String, Object>> mapList, Class<T> cls) {
        List<T> beanList = new ArrayList<>();
        if (mapList != null && !mapList.isEmpty()) {
            mapList.forEach(item -> {
                try {
                    T bean = convertMapToBean(item, cls);
                    beanList.add(bean);
                } catch (Exception e) {
                    logger.info("List<map>->List<bean>失败!");
                }
            });
        }
        return beanList;
    }

    /**
     * 将List<bean>对象转化为List<map>
     *
     * @param beanList
     * @param cls
     * @return List
     */
    public static <T> List<Map<String, Object>> convertListBeanToListMap(List<T> beanList, Class<T> cls) {
        List<Map<String, Object>> mapList = new ArrayList<>();
        if (beanList != null && beanList.isEmpty()) {
            beanList.forEach(bean -> {
                try {
                    Map<String, Object> map = convertBeanToMap(bean);
                    mapList.add(map);
                } catch (Exception e) {
                    logger.info("List<bean>->List<map>失败!");
                }
            });
        }
        return mapList;
    }
}