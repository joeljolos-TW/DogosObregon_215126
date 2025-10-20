package Service.impl;

import DAO.IClienteDAO;
import DAO.Impl.ClienteDAO;
import Entities.Cliente;
import Service.IClienteService;

import java.time.LocalDate;
import java.util.List;

public class ClienteService implements IClienteService {
    private IClienteDAO clienteDAO;
    public ClienteService() {
        clienteDAO = new ClienteDAO();
    }

    @Override
    public void agregarCliente(Cliente cliente) {
        if (cliente != null
                || (cliente.getNombre().length()>0 && cliente.getApPaterno().length()>0)
                || cliente.getFchNac().isBefore(LocalDate.now())) {
            clienteDAO.agregarCliente(cliente);
        }
    }

    @Override
    public void actualizarCliente(Cliente cliente) {
        if (cliente != null
                || (cliente.getNombre().length()>0 && cliente.getApPaterno().length()>0)
                || cliente.getFchNac().isBefore(LocalDate.now())) {
            clienteDAO.actualizarCliente(cliente);
        }
    }

    @Override
    public void eliminarCliente(Cliente cliente) {
        if(cliente != null){
            clienteDAO.eliminarCliente(cliente);
        }
    }

    @Override
    public List<Cliente> listarClientes() {
        return clienteDAO.listarClientes();
    }

    @Override
    public List<Cliente> listarClientesPorApellido() {
        return clienteDAO.listarClientesPorApellido();
    }
}
