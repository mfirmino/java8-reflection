package br.com.alura.reflection.aula2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
            System.out.println("Teste de commit");
        }

    }

    public Class<?> getImplementacao(Class<?> interf) {
        return mapa.get(interf);
    }

}
