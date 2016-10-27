package br.com.alura.reflection.aula4;

/**
 * Created by marcelofirmino on 21/10/16.
 */
public class TesteAula4 {

    public static void main(String[] args)
		    throws IllegalAccessException {
        Usuario user = new Usuario();
        user.setLogin("testeLogin");
        user.setSenha("testeSenha");
        user.setPapel("testePapel");
        user.setEmail("teste@teste.com.br");
        user.setAtivo(true);

        System.out.println(GeradorXML.getXML(user));

    }

}
