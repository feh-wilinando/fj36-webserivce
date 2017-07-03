package br.com.caelum.fj36.webservice.service;

import br.com.caelum.fj36.webservice.modelo.ItemEstoque;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.ResponseWrapper;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by nando on 03/07/17.
 */
@WebService
public class EstoqueWS {

    private Map<String, ItemEstoque> repositorio = new HashMap<>();

    public EstoqueWS() {
        repositorio.put("SOA", new ItemEstoque("SOA", 5));
        repositorio.put("TDD", new ItemEstoque("TDD", 1));
        repositorio.put("RES", new ItemEstoque("RES", 2));
        repositorio.put("LOG", new ItemEstoque("LOG", 4));
        repositorio.put("WEB", new ItemEstoque("WEB", 1));
        repositorio.put("ARQ", new ItemEstoque("ARQ", 2));
    }


    @WebMethod(operationName = "itensPeloCodigo")
    @WebResult(name = "itemEstoque")
    @ResponseWrapper(localName = "itens")
    public List<ItemEstoque> getQuantidade(@WebParam(name = "codigo") List<String> codigos){
        if (codigos == null) return Collections.emptyList();

        return codigos.stream().map(codigo -> repositorio.get(codigo)).collect(Collectors.toList());
    }
}
