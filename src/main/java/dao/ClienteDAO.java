/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import modelo.Cliente;

/**
 *
 * @author informatica
 */
public class ClienteDAO {
      private List<Cliente> clientes = new ArrayList<>();

    public void guardar(Cliente cliente) {
        clientes.add(cliente);

    }
    
    public void eliminar(Cliente cliente) {
        clientes.remove(verificaExistencia(cliente));
    }
    
     public void actualizar(Cliente cliente) {
        clientes.set(verificaExistencia(cliente),cliente);
    }

    public List<Cliente> listaTodos() {

        return clientes;

    }

    public int verificaExistencia(Cliente cliente) {
        int retorno = -1;
        for (int i = 0; i < this.clientes.size(); i++) {
            if (cliente.getId().equals(this.clientes.get(i).getId())) {
                retorno = i;
                break;
            }

        }
        return retorno;
    }
}
