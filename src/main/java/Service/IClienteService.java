package Service;

import Entities.Cliente;

import java.util.List;

public interface IClienteService {
    void agregarCliente(Cliente cliente);
    void actualizarCliente(Cliente cliente);
    void eliminarCliente(Cliente cliente);

    List<Cliente> listarClientes();
    List<Cliente> listarClientesPorApellido();
}
