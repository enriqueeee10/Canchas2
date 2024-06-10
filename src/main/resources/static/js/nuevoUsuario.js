document.getElementById("btnAceptar").addEventListener("click", async (evento) => {
    evento.preventDefault();  // Evitar el envío del formulario

    // Obtener valores de los campos de entrada
    const dni = document.getElementById("usuario_dni").value;
    const nombre = document.getElementById("usuario_nombre").value;
    const apellido = document.getElementById("usuario_apellido").value;
    const correo = document.getElementById("usuario_email").value;
    const telefono = document.getElementById("usuario_telefono").value;
    const direccion = document.getElementById("usuario_direccion").value;
    const pass1 = document.getElementById("usuario_clave_1").value;
    const pass2 = document.getElementById("usuario_clave_2").value;

    // Verificar que las contraseñas coincidan
    if (pass1 !== pass2) {
        alert("Las contraseñas no coinciden");
        return;
    }

    // Crear el objeto usuario
    const usuario = {
        dni,
        nombre,
        apellido,
        correo,
        telefono,
        direccion,
        roles: 1,  // Asumiendo que el rol es 1
        pass: pass1,
    };

    // Enviar la solicitud POST al servidor
    try {
        const responseRegistro = await fetch("/usuario/nuevousuario", {
            method: "POST",
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(usuario),
        });

        // Manejar la respuesta del servidor
        if (!responseRegistro.ok) {
            const errorResponse = await responseRegistro.json();
            alert(`No se pudo registrar el nuevo usuario: ${errorResponse.message || responseRegistro.statusText}`);
        } else {
            alert("Usuario registrado exitosamente");
            window.location.href = "/usuario";
        }
    } catch (error) {
        alert("No se pudo registrar el nuevo usuario");
        console.error('Error durante el registro de nuevo usuario:', error);
    }
});
