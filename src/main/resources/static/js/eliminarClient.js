document.addEventListener('DOMContentLoaded', () => {
    const botonesEliminar = document.querySelectorAll('.btn.btn-warning');

    botonesEliminar.forEach(boton => {
        boton.addEventListener('click', async () => {
            try {
                const idCliente = obtenerIdCliente(boton);
                await eliminarCliente(idCliente);
            } catch (error) {
                console.error('Error al eliminar el cliente:', error);
            }
        });
    });
});

function obtenerIdCliente(boton) {
    // Buscar el elemento padre <tr> del botón
    const fila = boton.closest('tr');
    // Obtener el primer <td> de la fila que contiene el id del cliente
    const idCliente = fila.querySelector('td:first-child').textContent;
    return idCliente;
}

async function eliminarCliente(idCliente) {
    try {
        const response = await fetch(`http://localhost:9999/cliente/eliminarcliente/${idCliente}`, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        });
        if (response.ok) {
            alert('Cliente eliminado correctamente');
            // Actualizar la página para reflejar los cambios
            window.location.reload();
        } else {
            alert('No se pudo eliminar el cliente');
        }
    } catch (error) {
        alert('Error al eliminar el cliente');
        console.error('Error during delete:', error);
    }
}
