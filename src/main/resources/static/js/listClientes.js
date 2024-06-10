
const listClientes = async () => {
    try {
        const response = await fetch("http://localhost:9898/cliente/verclientes");
        const clientes = await response.json();
        console.log(clientes);
        let content = ``;
        clientes.forEach((cliente) => {
            console.log(cliente);
            content += `
                <tr class="text-center">
                    <td>${cliente.idcliente}</td>
                    <td>${cliente.dni}</td>
                    <td>${cliente.nombre}</td>
                    <td>${cliente.apellido}</td>
                    <td>${cliente.correo}</td>
                    <td>${cliente.telefono}</td>
                    <td>${cliente.direccion}</td>
                    <td>
                        <a href="/actualizarcliente?idCliente=${cliente.idcliente}" class="btn btn-success">
                            <i class="fas fa-sync-alt"></i>
                        </a>
                    </td>
                    <td>
                        <button type="button" class="btn btn-warning delete-btn" data-id="${cliente.idcliente}">
                            <i class="far fa-trash-alt"></i>
                        </button>
                    </td>
                </tr>`;
        });
        document.querySelector('tbody').innerHTML = content;

        // Añadir evento a los botones de eliminación
        document.querySelectorAll('.delete-btn').forEach(button => {
            button.addEventListener('click', async (event) => {
                const idcliente = event.currentTarget.getAttribute('data-id');
                const confirmed = await Swal.fire({
                    icon: 'warning',
                    title: 'Confirmación',
                    text: `¿Estás seguro de que deseas eliminar al usuario con ID ${idcliente}?`,
                    showCancelButton: true,
                    confirmButtonText: 'Sí',
                    cancelButtonText: 'Cancelar'
                });
                if (confirmed) {
                    try {
                        const deleteResponse = await fetch(`http://localhost:9898/cliente/eliminarcliente/${idcliente}`, {
                            method: 'DELETE'
                        });
                        if (!deleteResponse.ok) {
                            throw new Error('No se pudo eliminar el cliente');
                        }
                        Swal.fire({
                            icon: 'success',
                            title: 'Éxito',
                            text: 'Cliente eliminado correctamente'
                        });
                        // Recargar la lista de clientes después de eliminar
                        listClientes();
                    } catch (error) {
                        console.error('Error al eliminar el cliente:', error);
                        Swal.fire({
                            icon: 'error',
                            title: 'Error',
                            text: 'Error al eliminar el cliente'
                        });
                    }
                }
            });
        });
    } catch (ex) {
        console.error('Error al obtener la lista de clientes:', ex);
        Swal.fire({
            icon: 'error',
            title: 'Error',
            text: 'Error al obtener la lista de clientes'
        });
    }
};

document.addEventListener('DOMContentLoaded', (event) => {
    listClientes();
});


