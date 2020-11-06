/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import dao.ClienteDAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import modelo.Cliente;

/**
 *
 * @author informatica
 */


    @Named(value = "clienteBean")
@SessionScoped
public class ClienteBean implements Serializable {

    ClienteDAO clienteDAO = new ClienteDAO();

    Cliente cliente = new Cliente();

    List<Cliente> clientes = new ArrayList<>();

    @PostConstruct
    public void init() {

        clientes = clienteDAO.listaTodos();
    }

    public ClienteBean() {
    }

    public String guardar() {
        clienteDAO.guardar(cliente);
        cliente = new Cliente();
        return null;
    }
    
    
     public String eliminar() {
        clienteDAO.eliminar(cliente);
        cliente = new Cliente();
        return null;
    }
     
      public String chamarFormEditar() {
      
       return "editar-cliente";
    }
           
      
      public String finishEditar(){
     clienteDAO.actualizar(cliente);
    
    //Clear the Cache Products
    cliente = null;
    return "index";
    
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

}

    
