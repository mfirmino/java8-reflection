package br.com.alura.reflection.aula4;

import java.lang.reflect.Field;

/**
 * Created by marcelofirmino on 21/10/16.
 */
public class GeradorXML {

    public static String getXML(Object obj)
		    throws IllegalAccessException {
        StringBuilder stringBuilder = new StringBuilder();

        Class<?> classe = obj.getClass();
        stringBuilder.append("<" + classe.getSimpleName() + "> \n");

        for (Field field: classe.getDeclaredFields()){
            field.setAccessible(true);

            stringBuilder.append("<" + field.getName() + ">");
            stringBuilder.append(field.get(obj));
            stringBuilder.append("</" + field.getName() + "> \n");
        }

        stringBuilder.append("</" + classe.getSimpleName() + "> \n");

        return stringBuilder.toString();
    }

}
