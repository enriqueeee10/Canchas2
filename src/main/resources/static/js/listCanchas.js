
const listCanchas = async () => {
    try {
        const response = await fetch("http://localhost:9898/cancha/vercanchas");
        const canchas = await response.json();
        console.log(canchas);
        let content = ``;
        canchas.forEach((cancha) => {
            console.log(cancha);
            content += `
                <tr class="text-center">
                    <td>${cancha.idcanchafutbol}</td>
                    <td>${cancha.codigo}</td>
                    <td>${cancha.nombre}</td>
                    <td>${cancha.direccion}</td>
                    <td>${cancha.precio}</td>
                    <td>
                        <a href="/actualizarcanchas?idCancha=${cancha.idcanchafutbol}" class="btn btn-success">
                            <i class="fas fa-sync-alt"></i>
                        </a>
                    </td>
                    <td>
                        <button type="button" class="btn btn-warning delete-btn" data-id="${cancha.idcanchafutbol}">
                            <i class="far fa-trash-alt"></i>
                        </button>
                    </td>
                </tr>`;
        });
        document.querySelector('tbody').innerHTML = content;

        // Añadir evento a los botones de eliminación
        document.querySelectorAll('.delete-btn').forEach(button => {
            button.addEventListener('click', async (event) => {
                const idcanchafutbol = event.currentTarget.getAttribute('data-id');
                const confirmed = await Swal.fire({
                    icon: 'warning',
                    title: 'Confirmación',
                    text: `¿Estás seguro de que deseas eliminar la cancha con ID ${idcanchafutbol}?`,
                    showCancelButton: true,
                    confirmButtonText: 'Sí',
                    cancelButtonText: 'Cancelar'
                });
                if (confirmed) {
                    try {
                        const deleteResponse = await fetch(`http://localhost:9898/cancha/eliminarcancha/${idcanchafutbol}`, {
                            method: 'DELETE'
                        });
                        if (!deleteResponse.ok) {
                            throw new Error('No se pudo eliminar la cancha');
                        }
                        Swal.fire({
                            icon: 'success',
                            title: 'Éxito',
                            text: 'Cancha eliminada correctamente'
                        });
                        
                        listCanchas();
                    } catch (error) {
                        console.error('Error al eliminar la cancha:', error);
                        Swal.fire({
                            icon: 'error',
                            title: 'Error',
                            text: 'Error al eliminar la cancha'
                        });
                    }
                }
            });
        });
    } catch (ex) {
        console.error('Error al obtener la lista de canchas:', ex);
        Swal.fire({
            icon: 'error',
            title: 'Error',
            text: 'Error al obtener la lista de canchas'
        });
    }
};

document.addEventListener('DOMContentLoaded', (event) => {
    listCanchas();
});


