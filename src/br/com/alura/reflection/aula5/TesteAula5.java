package br.com.alura.reflection.aula5;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by marcelofirmino on 24/10/16.
 */
public class TesteAula5 {

    public static void main(String[] args)
		    throws InvocationTargetException, IllegalAccessException {
        Usuario user = new Usuario();
        user.setEmail("teste@teste.com.br");
        user.setSenha("1234567");

        System.out.println(Validador.validaObjeto(user));
    }

}
