package me.gv7.woodpecker.tools.common;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionUtil {
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
