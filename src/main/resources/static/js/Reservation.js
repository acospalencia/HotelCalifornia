const tooltipTriggerList = document.querySelectorAll('[data-bs-toggle="tooltip"]')
const tooltipList = [...tooltipTriggerList].map(tooltipTriggerEl => new bootstrap.Tooltip(tooltipTriggerEl))

document.addEventListener("DOMContentLoaded", () => {
    const pisoImgs = document.querySelectorAll(".piso-img");
    const allRooms = document.querySelectorAll(".room-card");

    const txtTema = document.getElementById("txt-tema");

    allRooms.forEach(room => {
        room.style.display = "none";
        
    });

    pisoImgs.forEach(img => {
        img.addEventListener("click", () => {
            const piso = img.dataset.floor;
            txtTema.innerHTML = `Selecciona la habitación del piso ${piso}`;

            allRooms.forEach(room => {
                if (room.dataset.floor === piso) {
                    room.style.display = "block";
                } else {
                    room.style.display = "none";
                }
            });
        });
    });
});

document.addEventListener('DOMContentLoaded', () => {
  const buttons = document.querySelectorAll('.reserve-btn');

  buttons.forEach(btn => {
    btn.addEventListener('click', () => {
      const roomId = btn.dataset.roomId;
      const roomNumber = btn.dataset.roomNumber;
      const roomType = btn.dataset.roomType;
      const floor = btn.dataset.floor;
      const status = btn.dataset.status;
      const description = btn.dataset.description;

      // Actualizar título e info
      document.getElementById('roomModalLabel').textContent = `Habitación ${roomNumber}`;
      document.getElementById('modalInfo').innerHTML = `
        <p>Tipo: ${roomType}</p>
        <p>Piso: ${floor}</p>
        <p>Estado: ${status}</p>
        <p>Descripción: ${description}</p>
      `;

      // Asignar id al input hidden del form
      document.getElementById('formRoomId').value = roomId;

      // Llenar imágenes
      const imagesContainer = document.getElementById('modalImages');
      imagesContainer.innerHTML = ''; // limpiar
      // data-images es un array de strings Base64
    const images = JSON.parse(btn.dataset.images);
      images.forEach(base64 => {
        const imgEl = document.createElement('img');
        imgEl.src = `data:image/png;base64,${base64}`;
        imgEl.classList.add('img-fluid', 'me-2');
        imgEl.style.width = '150px';
        imagesContainer.appendChild(imgEl);
      });
    });
  });
});

