package br.com.alura.reflection.aula3;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by marcelo.firmino on 09/08/16.
 */
public class Mapeador {

    private Map<Class<?>, Class<?>> mapa = new HashMap<>();

    public void load(String nomeArquivo)
		    throws IOException, ClassNotFoundException {
        Properties prop = new Properties();
        prop.load(new FileInputStream(nomeArquivo));

        for (Object key : prop.keySet()) {
            Class<?> interf = Class.forName(key.toString());
            Class<?> impl = Class.forName(prop.get(key).toString());

            if(!interf.isInterface()){
                throw new RuntimeException("O objeto " + interf.getName() + " não é uma interface.");
            }

            if (!interf.isAssignableFrom(impl)) {
                throw new RuntimeException("A classe " + impl.getName() + " não implementa a interface " + interf.getName());
            }

            mapa.put(interf, impl);
        }

    }

    public Class<?> getImplementacao(Class<?> interf) {
        return mapa.get(interf);
    }

    public <E> E getInstance(Class<E> interf)
                    throws Exception {
        Class<?> impl = mapa.get(interf);
        return (E) impl.newInstance();
    }

    public <E> E getInstance(Class<E> interf, Object... params) throws Exception {
        Class<?> impl = mapa.get(interf);

        Class<?>[] tiposConstrutor = new Class<?>[params.length];

        for (int i = 0; i<tiposConstrutor.length; i++) {
            tiposConstrutor[i] = params[i].getClass();
        }

        Constructor<?> constructor = impl.getConstructor(tiposConstrutor);

        return (E) constructor.newInstance(params);
    }

}
