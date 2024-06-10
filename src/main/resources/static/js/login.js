document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const formData = new FormData(event.target);
    const data = {
        correo: formData.get('correo'),
        pass: formData.get('pass')
    };

    fetch('http://localhost:9898/login/ingreso', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
    .then(response => {
        if (!response.ok) {
			alert('Correo o contraseña incorrectos');
        } else {
			window.location.href = '/inicio';
            
        }
    })
});
