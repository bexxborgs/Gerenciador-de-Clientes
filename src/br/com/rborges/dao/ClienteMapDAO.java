package br.com.rborges.dao;

import br.com.rborges.domain.Cliente;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Rebeca
 */
public class ClienteMapDAO implements  IClienteDAO {
    private Map<Long, Cliente> map;
    public ClienteMapDAO() {
        map =  new TreeMap<>();}


    @Override
    public Boolean cadastrar(Cliente cliente) {
        if (this.map.containsKey(cliente.getCpf())) {
            return  false;
        }

        map.put(cliente.getCpf(), cliente);
        return true;
    }

    @Override
    public void excluir(Long cpf) {
        Cliente clienteCasdastrado = map.get(cpf);
        map.remove(clienteCasdastrado.getCpf(), clienteCasdastrado);
    }

    @Override
    public void alterar(Cliente cliente) {
        Cliente clienteCadastrado = this.map.get(cliente.getCpf());
        if  (clienteCadastrado != null) {
         clienteCadastrado.setNome(cliente.getNome());
         clienteCadastrado.setTel(cliente.getTel());
         clienteCadastrado.setNumero(cliente.getNumero());
         clienteCadastrado.setEnd(cliente.getEnd());
         clienteCadastrado.setCidade(cliente.getCidade());
         clienteCadastrado.setEstado(cliente.getEstado());
        }
    }

    @Override
    public Cliente consultar(Long cpf) {
        return this.map.get(cpf);
    }

    @Override
    public Collection<Cliente> buscarTodos() {
        return this.map.values();
    }
}
