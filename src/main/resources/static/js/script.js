document.getElementById('registro-form').addEventListener('submit', function(event) {
    var nombre = document.getElementById('nombre').value;
    var apellido = document.getElementById('apellido').value;
    var correo = document.getElementById('correo').value;
    var contrasena = document.getElementById('contrasena').value;
    var telefono = document.getElementById('telefono').value;
    
    if (!nombre || !apellido || !correo || !contrasena || !telefono) {
      event.preventDefault();
      alert('Por favor, complete todos los campos requeridos.');
    }
  });
  