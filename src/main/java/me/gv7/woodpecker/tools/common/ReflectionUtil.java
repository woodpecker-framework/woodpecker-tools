package me.gv7.woodpecker.tools.common;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionUtil {
    /**
     * 循环获取对象属性值
     *
     * @param o 目标对象
     * @param s 属性名
     * @return 属性值
     * @throws IllegalAccessException
     * @throws NoSuchFieldException
     */
    private static synchronized Object getFV(final Object o, final String s) throws IllegalAccessException, NoSuchFieldException {
        Field declaredField = null;
        Class<?> clazz = o.getClass();
        while (clazz != Object.class) {
            try {
                declaredField = clazz.getDeclaredField(s);
                break;
            }
            catch (NoSuchFieldException ex) {
                clazz = clazz.getSuperclass();
            }
        }
        if (declaredField == null) {
            throw new NoSuchFieldException(s);
        }
        declaredField.setAccessible(true);
        return declaredField.get(o);
    }

    /**
     * 遍历获取函数
     *
     * @param obj 目标对象
     * @param methodName 函数名
     * @param paramClazz 函数参数
     * @return 函数
     * @throws NoSuchMethodException
     */
    private static synchronized Method getSuperMethod(final Object obj, final String methodName, Class<?>... paramClazz) throws NoSuchMethodException {
        Method method = null;
        Class<?> clazz = obj.getClass();
        while (clazz != Object.class){
            try {
                method = clazz.getDeclaredMethod(methodName,paramClazz);
                break;
            } catch (NoSuchMethodException e) {
                clazz = clazz.getSuperclass();
            }
        }

        if (method == null) {
            throw new NoSuchMethodException(methodName);
        }
        method.setAccessible(true);
        return method;
    }

    /**
     * 遍历调用函数
     *
     * @param obj 目标对象
     * @param methodName 函数名
     * @param paramClazz 参数
     * @param param 参数列表
     * @return 调用结果
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    private static synchronized Object invokeSuperMethod(final Object obj,final String methodName,Class[] paramClazz,Object[] param) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = null;
        Class<?> clazz = obj.getClass();
        while (clazz != Object.class){
            try {
                method = clazz.getDeclaredMethod(methodName,paramClazz);
                break;
            } catch (NoSuchMethodException e) {
                clazz = clazz.getSuperclass();
            }
        }

        if (method == null) {
            throw new NoSuchMethodException(methodName);
        }
        method.setAccessible(true);
        return method.invoke(obj,param);
    }
}
