package br.com.diisk.alurajavautils.reflect;

import br.com.diisk.alurajavautils.pessoa.Pessoa;

public class ObjectToJsonTester {


    public static void main(String[] args) {
        var pessoa = new Pessoa(1, "Teste", "050");
        ObjectToJson objectToJson = new ObjectToJson();
        System.out.println(objectToJson.transform(pessoa));
    }

}
