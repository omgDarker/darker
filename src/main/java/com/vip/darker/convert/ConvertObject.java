package com.vip.darker.convert;


import org.apache.commons.beanutils.BeanUtils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @Auther: Darker
 * @Date: 2018/7/30 14:07
 * @Description: 对象转换工具类
 */
public class ConvertObject {

    public ConvertObject() {
    }

    /**
     * 将Map对象转化为JavaBean
     *
     * @param map
     * @param T
     * @return
     * @throws Exception
     */
    private static <T> T convertMapToBean(Map<String, Object> map, Class<T> T) throws Exception {
        if (map == null || map.size() == 0) {
            return null;
        }
        //获取map中所有的key值，全部更新成大写，添加到keys集合中,与mybatis中驼峰命名匹配
        Map<String, Object> newMap = new HashMap<>();
        for (Map.Entry<String, Object> stringObjectEntry : map.entrySet()) {
            String key = stringObjectEntry.getKey();
            Object mvalue = map.get(key);
            String characterConstant = "_";
            if (key.contains(characterConstant)) {
                key = key.replaceAll(characterConstant, "");
            }
            newMap.put(key.toUpperCase(Locale.US), mvalue);
        }
        BeanInfo beanInfo = Introspector.getBeanInfo(T);
        T bean = T.newInstance();
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
     * 将JavaBean对象转化为Map对象
     *
     * @param bean
     * @return
     * @throws IntrospectionException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    public static Map<String, Object> convertBeanToMap(Object bean) throws IntrospectionException, IllegalAccessException, InvocationTargetException {
        Class<?> type = bean.getClass();
        Map<String, Object> returnMap = new HashMap<>();
        BeanInfo beanInfo = Introspector.getBeanInfo(type);

        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
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
     * 将List<Map>对象转化为List<JavaBean>
     *
     * @param listMap
     * @param T
     * @return List
     * @throws Exception
     */
    public static <T> List<T> convertListMapToListBean(List<Map<String, Object>> listMap, Class<T> T) throws Exception {
        List<T> beanList = new ArrayList<>();
        if (listMap != null && !listMap.isEmpty()) {
            for (Map<String, Object> map : listMap) {
                T bean = convertMapToBean(map, T);
                beanList.add(bean);
            }
            return beanList;
        }
        return beanList;
    }

    /**
     * 将List<JavaBean>对象转化为List<Map>
     *
     * @param beanList
     * @return
     * @throws Exception
     */
    public static <T> List<Map<String, Object>> convertListBeanToListMap(List<T> beanList, Class<T> T) throws Exception {
        List<Map<String, Object>> mapList = new ArrayList<>();
        for (T bean : beanList) {
            Map<String, Object> map = convertBeanToMap(bean);
            mapList.add(map);
        }
        return mapList;
    }
}