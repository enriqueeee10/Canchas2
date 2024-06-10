const listUsuarios = async () => {
    try {
        const response = await fetch("http://localhost:9898/usuario/verusuarios");
        const usuarios = await response.json();
        console.log(usuarios);
        let content = ``;
        usuarios.forEach((usuario) => {
            console.log(usuario);
            content += `
                <tr class="text-center">
                    <td>${usuario.idusuario}</td>
                    <td>${usuario.dni}</td>
                    <td>${usuario.nombre}</td>
                    <td>${usuario.apellido}</td>
                    <td>${usuario.telefono}</td>
                    <td>${usuario.correo}</td>
                    <td>
                        <a href="/actualizarusuario?idUsuario=${usuario.idusuario}" class="btn btn-success">
                            <i class="fas fa-sync-alt"></i>
                        </a>
                    </td>
                    <td>
                        <button type="button" class="btn btn-warning delete-btn" data-id="${usuario.idusuario}">
                            <i class="far fa-trash-alt"></i>
                        </button>
                    </td>
                </tr>`;
        });
        document.querySelector('tbody').innerHTML = content;

        // Añadir evento a los botones de eliminación
        document.querySelectorAll('.delete-btn').forEach(button => {
            button.addEventListener('click', async (event) => {
                const idUsuario = event.currentTarget.getAttribute('data-id');
                const confirmed = await Swal.fire({
                    icon: 'warning',
                    title: 'Confirmación',
                    text: `¿Estás seguro de que deseas eliminar al usuario con ID ${idUsuario}?`,
                    showCancelButton: true,
                    confirmButtonText: 'Sí',
                    cancelButtonText: 'Cancelar'
                });
                if (confirmed) {
                    try {
                        const deleteResponse = await fetch(`/usuario/eliminarusuario/${idUsuario}`, {
                            method: 'DELETE'
                        });
                        if (!deleteResponse.ok) {
                            throw new Error('No se pudo eliminar el usuario');
                        }
                        Swal.fire({
                            icon: 'success',
                            title: 'Éxito',
                            text: 'Usuario eliminado correctamente'
                        });
                        // Recargar la lista de clientes después de eliminar
                        listUsuarios();
                    } catch (error) {
                        console.error('Error al eliminar el usuario:', error);
                        Swal.fire({
                            icon: 'error',
                            title: 'Error',
                            text: 'Error al eliminar el usuario'
                        });
                    }
                }
            });
        });
    } catch (ex) {
        console.error('Error al obtener la lista de usuarios:', ex);
        Swal.fire({
            icon: 'error',
            title: 'Error',
            text: 'Error al obtener la lista de usuarios'
        });
    }
};

document.addEventListener('DOMContentLoaded', (event) => {
    listUsuarios();
});
