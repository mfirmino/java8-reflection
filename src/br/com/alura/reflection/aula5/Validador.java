package br.com.alura.reflection.aula5;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by marcelofirmino on 24/10/16.
 */
public class Validador {

    public static boolean validaObjeto(Object obj)
		    throws Throwable {
        boolean resultado = true;

        Class<?> clazz = obj.getClass();

        for (Method method: clazz.getMethods()){
            if (method.getName().startsWith("valida")
		            && method.getReturnType() == boolean.class
		            && method.getParameterTypes().length == 0){
                try{
                    resultado = (boolean) method.invoke(obj);
                } catch (InvocationTargetException exc){
                    throw exc.getTargetException();
                }

                if (!resultado)
                    break;
            }
        }

        return resultado;
    }

}
