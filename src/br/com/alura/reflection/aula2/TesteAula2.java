package br.com.alura.reflection.aula2;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by marcelo.firmino on 09/08/16.
 */
public class TesteAula2 {

    public static void main(String[] args)
		    throws IOException, ClassNotFoundException {

        Mapeador mapeador = new Mapeador();

        mapeador.load("classes.prop");

        System.out.println(mapeador.getImplementacao(List.class));
        System.out.println(mapeador.getImplementacao(Map.class));
    }
}
