package br.com.diisk.alurajavautils.reflect;

import java.lang.reflect.InvocationTargetException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.diisk.alurajavautils.pessoa.Pessoa;
import br.com.diisk.alurajavautils.pessoa.PessoaDTO;

public class TransformatorTest {

    Pessoa pessoa = new Pessoa(1, "Joaõ", "204154154");

    @Test
    public void shouldTransform() throws ClassNotFoundException, InstantiationException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        var transformator = new Transformator();


        PessoaDTO pessoaDTO = transformator.transform(pessoa);


        Assertions.assertInstanceOf(PessoaDTO.class, pessoaDTO);
        Assertions.assertEquals(pessoaDTO.getNome(), pessoa.getNome());
        Assertions.assertEquals(pessoaDTO.getCpf(), pessoa.getCpf());

    }

}
