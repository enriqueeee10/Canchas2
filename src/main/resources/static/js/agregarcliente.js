document.addEventListener("DOMContentLoaded", function() {
	document.getElementById("btnAceptar").addEventListener("click", async (evento) => {
		evento.preventDefault();  // Evita que el formulario se envíe de forma predeterminada

		let cliente = {
			"dni": document.getElementById("cliente_dni").value,
			"nombre": document.getElementById("cliente_nombre").value,
			"apellido": document.getElementById("cliente_apellido").value,
			"correo": document.getElementById("cliente_correo").value,
			"telefono": document.getElementById("cliente_telefono").value,
			"direccion": document.getElementById("cliente_direccion").value
		};

		try {
			const responseRegistro = await fetch("http://localhost:9898/cliente/nuevocliente", {
				method: "POST",
				headers: {
					'Accept': 'application/json',
					'Content-Type': 'application/json'
				},
				body: JSON.stringify(cliente),
			});

			if (!responseRegistro.ok) {
				alert("No se pudo registrar el nuevo usuario");
			} else {
				alert("Cliente registrado exitosamente");
				window.location.href = "/cliente";
			}
		} catch (error) {
			alert("No se pudo registrar el nuevo usuario");
			console.error('Error durante el registro de nuevo usuario:', error);
		}
	});
});
