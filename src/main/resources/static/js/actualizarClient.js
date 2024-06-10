//Actualizar cliente
document.getElementById("clienteForm").addEventListener("submit", async function(event) {
    event.preventDefault();

    const urlParams = new URLSearchParams(window.location.search);
    const idCliente = urlParams.get('idCliente');
    const dni = document.getElementById("cliente_dni").value;
    const nombre = document.getElementById("cliente_nombre").value;
    const apellido = document.getElementById("cliente_apellido").value;
    const correo = document.getElementById("cliente_correo").value;
    const telefono = document.getElementById("cliente_telefono").value;
    const direccion = document.getElementById("cliente_direccion").value;

    const request = {
        dni,
        nombre,
        apellido,
        correo,
        telefono,
        direccion
    };

    try {
        const response = await fetch(`http://localhost:9898/cliente/actualizarcliente/${idCliente}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(request),
        });

        if (!response.ok) {
            throw new Error("No se pudo actualizar el cliente");
        }

        alert("Cliente actualizado correctamente");
        window.location.href = "/listarcliente";
    } catch (error) {
        console.error('Error al actualizar el cliente:', error);
        alert("Error al actualizar el cliente");
    }
});




document.addEventListener("DOMContentLoaded", async function() {
    const urlParams = new URLSearchParams(window.location.search);
    const idcliente = urlParams.get('idCliente');

    try {
        const response = await fetch(`http://localhost:9898/cliente/vercliente/${idcliente}`);
        if (!response.ok) {
            const responseText = await response.text();
            console.error("Error en la respuesta del servidor:", responseText);
            throw new Error("No se pudo obtener la información del cliente");
        }

        const contentType = response.headers.get("content-type");
        if (contentType && contentType.includes("application/json")) {
            const cliente = await response.json();

            document.getElementById("cliente_dni").value = cliente.dni;
            document.getElementById("cliente_nombre").value = cliente.nombre;
            document.getElementById("cliente_apellido").value = cliente.apellido;
            document.getElementById("cliente_correo").value = cliente.correo;
            document.getElementById("cliente_telefono").value = cliente.telefono;
            document.getElementById("cliente_direccion").value = cliente.direccion;
        } else {
            const responseText = await response.text();
            console.error("Respuesta no es JSON:", responseText);
            throw new Error("Respuesta no es JSON");
        }
    } catch (error) {
        console.error('Error al obtener la información del cliente:', error);
        Swal.fire({
            icon: 'error',
            title: 'Error',
            text: 'Error al obtener la información del cliente',
        });
    }
});

document.getElementById("btnActualizar").addEventListener("click", async function(event) {
    event.preventDefault();

    const urlParams = new URLSearchParams(window.location.search);
    const idcliente = urlParams.get('idCliente'); 
    const dni = document.getElementById("cliente_dni").value;
    const nombre = document.getElementById("cliente_nombre").value;
    const apellido = document.getElementById("cliente_apellido").value;
    const correo = document.getElementById("cliente_correo").value;
    const telefono = document.getElementById("cliente_telefono").value;
    const direccion = document.getElementById("cliente_direccion").value;

    const request = {
        dni,
        nombre,
        apellido,
        correo,
        telefono,
        direccion
    };

    try {
        const response = await fetch(`http://localhost:9898/cliente/actualizarcliente/${idcliente}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(request),
        });

        console.log('Respuesta del servidor:', response);

        if (!response.ok) {
            const responseText = await response.text();
            console.error("Error en la respuesta del servidor:", responseText);
            throw new Error("No se pudo actualizar el cliente");
        }

        const contentType = response.headers.get("content-type");
        if (contentType && contentType.includes("application/json")) {
            const responseData = await response.json();
            console.log('Respuesta de actualización:', responseData);
        } else {
            const responseText = await response.text();
            console.log('Respuesta de actualización no JSON:', responseText);
        }

        Swal.fire({
            icon: 'success',
            title: 'Éxito',
            text: '¡Cliente actualizado correctamente!',
        }).then(() => {
            window.location.href = "/listarcliente";
        });

    } catch (error) {
        console.error('Error al actualizar el cliente:', error);
        Swal.fire({
            icon: 'error',
            title: 'Error',
            text: 'Error al actualizar el cliente',
        });
    }
});

