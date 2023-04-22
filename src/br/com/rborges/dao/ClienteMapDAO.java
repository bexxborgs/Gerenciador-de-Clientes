package br.com.rborges.dao;

import br.com.rborges.domain.Cliente;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Rebeca
 */
public class ClienteMapDAO implements  IClienteDAO {

    private Map<Long, Cliente> map;
    public ClienteMapDAO() {
        this.map = new HashMap<>();

    }

    @Override
    public Boolean cadastrar(Cliente cliente) {
        if (this.map.containsKey(cliente.getCpf())) {
            return  false;
        }
        this.map.put(cliente.getCpf(), cliente);
        return true;
    }

    @Override
    public void excluir(Long cpf) {
        Cliente clienteCasdastrado = this.map.get(cpf);

        if (clienteCasdastrado != null) {
            this.map.remove(clienteCasdastrado.getCpf(), clienteCasdastrado);
        }

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
        return null;
    }

    @Override
    public Collection<Cliente> buscarTodos() {
        return null;
    }
}