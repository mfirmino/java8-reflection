package br.com.alura.reflection.aula6;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by marcelofirmino on 27/10/16.
 */
public class TesteErros {

    public static void main(String[] args)
		    throws NoSuchMethodException, IllegalAccessException {
        TesteErros obj = new TesteErros();
        Class clazz = obj.getClass();

        try{
            Method method = clazz.getMethod("metodo", String.class);
            method.invoke(obj, "teste");
        } catch (InvocationTargetException exc){
            exc.getTargetException().printStackTrace();
        }


    }

    public void metodo(String s){
        System.out.println("metodo pego com parâmetro: " + s);
    }

}
