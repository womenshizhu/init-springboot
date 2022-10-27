package com.edocyundtx.assistant.util;

import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class DtoMapper {
    private static final Logger log = LoggerFactory.getLogger(DtoMapper.class);


    public static <T> T convert(Object obj, Class<T> clas) {
        T t = (T) BeanUtils.instantiateClass(clas);
        BeanUtils.copyProperties(obj, t);
        return t;
    }

    public static <T> List<T> convertList(List list, Class<T> clas) {
        return (List) list.stream().map(t -> convert(t, clas)).collect(Collectors.toList());
    }


    public static Map<String, Object> convertMap(Object object) throws IllegalAccessException {
        Field[] fields = ReflectUtil.getAllFields(object.getClass());
        Map<String, Object> result = Maps.newHashMap();
        for (Field field : fields) {
            if (!field.isAnnotationPresent(MapperIgnore.class)) {
                String key = field.getName();
                Object value = field.get(object);
                result.put(key, value);
            }
        }
        return result;
    }


    public static <T> T convertObject(Map<String, Object> map, Class<T> claz) {

        Field[] fields = ReflectUtil.getAllFields(claz);

        T entity = (T) BeanUtils.instantiateClass(claz);

        for (Field field : fields) {

            if (!field.isAnnotationPresent(MapperIgnore.class)) {


                Object value = map.get(field.getName());

                if (value != null)
                    try {

                        field.set(entity, value);

                    } catch (Exception ex) {

                        log.info("field :{} parse error", field.toString());
                    }
            }
        }

        return entity;
    }
}
 