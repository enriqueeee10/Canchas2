document.addEventListener("DOMContentLoaded", function() {
	document.getElementById("btnAceptar").addEventListener("click", async (evento) => {
		evento.preventDefault();  // Evita que el formulario se envíe de forma predeterminada

		let cancha = {
			"codigo": document.getElementById("cancha_codigo").value,
			"nombre": document.getElementById("cancha_nombre").value,
			"direccion": document.getElementById("cancha_direccion").value,
			"precio": document.getElementById("cancha_precio").value
		};

		try {
			const responseRegistro = await fetch("http://localhost:9898/cancha/nuevacancha", {
				method: "POST",
				headers: {
					'Accept': 'application/json',
					'Content-Type': 'application/json'
				},
				body: JSON.stringify(cancha),
			});

			if (!responseRegistro.ok) {
				alert("No se pudo registrar la nueva cancha");
			} else {
				alert("Cancha registrada exitosamente");
				window.location.href = "/canchas";
			}
		} catch (error) {
			alert("No se pudo registrar la nueva cancha");
			console.error('Error durante el registro de nueva cancha:', error);
		}
	});
});
