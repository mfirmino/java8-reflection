package br.com.alura.reflection.aula1;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by marcelo.firmino on 02/08/16.
 */
public class Aula1 {

    public static List<String> buscaStringEmAtributos(Object o, String buscada){
	try {
	    List<String> lista = new ArrayList<>();
	    Class<?> c = o.getClass();
	    for(Field f : c.getFields()){
		Object value = f.get(o);
		if(value != null){
		    String strValue = value.toString();
		    if(strValue.contains(buscada)){
			lista.add(f.getName());
		    }
		}
	    }
	    return lista;
	} catch (Exception e) {
	    e.printStackTrace();
	    throw new RuntimeException(e);
	}
    }

}
