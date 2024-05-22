package br.com.diisk.alurajavautils.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Transformator {

    public <S, T> T transform(S input) throws ClassNotFoundException, InstantiationException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        Class<?> source = input.getClass();
        Class<?> target = Class.forName(source.getName() + "DTO");

        T targetClass = (T) target.getDeclaredConstructor().newInstance();

        Field[] sourceFields = source.getDeclaredFields();
        Field[] targetFields = target.getDeclaredFields();

        Arrays.stream(sourceFields)
                .forEach(sourceField -> Arrays.stream(targetFields)
                        .forEach(targetField -> {
                            if (validate(sourceField, targetField)) {
                                sourceField.setAccessible(true);
                                targetField.setAccessible(true);
                                try {
                                    targetField.set(targetClass, sourceField.get(input));
                                } catch (IllegalArgumentException | IllegalAccessException e) {
                                    e.printStackTrace();
                                }
                            }
                        }));

        return targetClass;
    }

    private Boolean validate(Field sourceField, Field targetField) {
        return sourceField.getName().equals(targetField.getName())
                && sourceField.getType().equals(targetField.getType());
    }

}
