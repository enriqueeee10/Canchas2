//Actualizar canchas
document.getElementById("canchaForm").addEventListener("submit", async function(event) {
    event.preventDefault();

    const urlParams = new URLSearchParams(window.location.search);
    const idcanchafutbol = urlParams.get('idCancha');
    const codigo = document.getElementById("cancha_codigo").value;
    const nombre = document.getElementById("cancha_nombre").value;
    const direccion = document.getElementById("cancha_direccion").value;
    const precio = document.getElementById("cancha_precio").value;

    const request = {
		
        codigo,
        nombre,
        direccion,
        precio
    };

    try {
        const response = await fetch(`http://localhost:9898/cancha/actualizarcancha/${idcanchafutbol}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(request),
        });

        if (!response.ok) {
            throw new Error("No se pudo actualizar la cancha");
        }

        alert("Cancha actualizada correctamente");
        window.location.href = "/listarcanchas";
    } catch (error) {
        console.error('Error al actualizar la cancha:', error);
        alert("Error al actualizar la cancha");
    }
});



document.addEventListener("DOMContentLoaded", async function() {
    const urlParams = new URLSearchParams(window.location.search);
    const idcanchafutbol = urlParams.get('idCancha');
    try {
        const response = await fetch(`http://localhost:9898/cancha/vercancha/${idcanchafutbol}`);
        if (!response.ok) {
            const responseText = await response.text();
            console.error("Error en la respuesta del servidor:", responseText);
            throw new Error("No se pudo obtener la información de la cancha");
        }
        
        const contentType = response.headers.get("content-type");
        
         if (contentType && contentType.includes("application/json")) {
            const cancha = await response.json();

        document.getElementById("cancha_codigo").value = cancha.codigo;
        document.getElementById("cancha_nombre").value = cancha.nombre;
        document.getElementById("cancha_direccion").value = cancha.direccion;
        document.getElementById("cancha_precio").value = cancha.precio;
        } else {
            const responseText = await response.text();
            console.error("Respuesta no es JSON:", responseText);
            throw new Error("Respuesta no es JSON");
        }

    } catch (error) {
        console.error('Error al obtener la información de la cancha:', error);
        Swal.fire({
            icon: 'error',
            title: 'Error',
            text: 'Error al obtener la información de la cancha',
        });
    }
});

document.getElementById("btnActualizar").addEventListener("click", async function(event) {
    event.preventDefault();

    const urlParams = new URLSearchParams(window.location.search);
    const idcanchafutbol = urlParams.get('idCancha');
    const codigo = document.getElementById("cancha_codigo").value;
    const nombre = document.getElementById("cancha_nombre").value;
    const direccion = document.getElementById("cancha_direccion").value;
    const precio = document.getElementById("cancha_precio").value;

    const request = {
        codigo,
        nombre,
        direccion,
        precio
    };

    try {
        const response = await fetch(`http://localhost:9898/cancha/actualizarcancha/${idcanchafutbol}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(request),
        });

        if (!response.ok) {
            const responseText = await response.text();
            console.error("Error en la respuesta del servidor:", responseText);
            throw new Error("No se pudo actualizar la cancha");
        }

        Swal.fire({
            icon: 'success',
            title: 'Éxito',
            text: '¡Cancha actualizada correctamente!',
        }).then(() => {
            window.location.href = "/listarcanchas";
        });
    } catch (error) {
        console.error('Error al actualizar la cancha:', error);
        Swal.fire({
            icon: 'error',
            title: 'Error',
            text: 'Error al actualizar la cancha',
        });
    }
});



