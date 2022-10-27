package com.edocyundtx.assistant.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


public class ReflectUtil {
    private static final int MAX_INHERIT_DEPTH = 5;

    public static Field[] getAllFields(Class clazz) {
        List<Field> fieldList = new ArrayList<Field>();
        int inheritTimes = 0;
        while (clazz != null && clazz != Object.class) {
            Field[] fields = clazz.getDeclaredFields();
            for (Field f : fields) {
                if (!fieldList.contains(f)) {
                    fieldList.add(f);
                    f.setAccessible(true);
                }
            }
            clazz = clazz.getSuperclass();

            inheritTimes++;
            if (inheritTimes > 5) {
                break;
            }
        }
        Field[] fields = new Field[fieldList.size()];
        fieldList.toArray(fields);
        return fields;
    }
}
 