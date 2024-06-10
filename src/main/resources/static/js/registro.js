document.getElementById('registroForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const formData = new FormData(event.target);
    const pass = formData.get('pass');
    const passre = formData.get('passre');

    if (pass !== passre) {
        alert('Las contraseñas no coinciden.');
        return;
    }

    const data = {
        roles: 1, // Assuming roles is fixed to 1 as in the example JSON
        dni: formData.get('dni'),
        nombre: formData.get('nombre'),
        apellido: formData.get('apellido'),
        correo: formData.get('correo'),
        pass: pass,
        telefono: formData.get('telefono'),
        direccion: formData.get('direccion')
    };
    
        console.log(data)

    fetch('http://localhost:9898/usuario/nuevousuario', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Error en la respuesta del servidor');
            alert("No se pudo registrar");
        }
        else {
			alert("Si se pudo registrar");
		}
        return response.json();
    })
});
