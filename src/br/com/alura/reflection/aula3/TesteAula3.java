package br.com.alura.reflection.aula3;

import br.com.alura.reflection.aula3.Mapeador;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by marcelo.firmino on 09/08/16.
 */
public class TesteAula3 {

    public static void main(String[] args) throws Exception {

        Mapeador mapeador = new Mapeador();

        mapeador.load("classes.prop");

        List lista = mapeador.getInstance(List.class);

        System.out.println(lista.getClass());

    }
}
