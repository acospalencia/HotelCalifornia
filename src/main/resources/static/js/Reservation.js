const tooltipTriggerList = document.querySelectorAll('[data-bs-toggle="tooltip"]')
const tooltipList = [...tooltipTriggerList].map(tooltipTriggerEl => new bootstrap.Tooltip(tooltipTriggerEl))

let typePaid = 0;


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

      if (roomType === "Habitacion Individual") {
        typePaid = 40;
      } else {
        typePaid = 120;
      }

      document.getElementById('roomModalLabel').textContent = `Reservar Habitación ${roomNumber}`;
      document.getElementById('modalInfo').innerHTML = `
        <p>Tipo: ${roomType}</p>
        <p>Piso: ${floor}</p>
        <p>Estado: ${status}</p>
        <p>Descripción: ${description}</p>
      `;


      document.getElementById('formRoomId').value = roomId;

      const imagesContainer = document.getElementById('modalImages');
      imagesContainer.innerHTML = '';

      const images = JSON.parse(btn.dataset.images);
      images.forEach(base64 => {
        const imgEl = document.createElement('img');
        imgEl.src = `data:image/png;base64,${base64}`;
        imgEl.classList.add('img-fluid', 'me-2');
        imgEl.style.width = '18vw';
        imagesContainer.appendChild(imgEl);
      });
    });
  });
});

document.addEventListener("DOMContentLoaded", () => {
  const today = new Date().toISOString().split("T")[0];
  const tomorrow = new Date(Date.now() + 86400000).toISOString().split("T")[0];

  const checkIn = document.getElementById("checkInDate");
  const checkOut = document.getElementById("checkOutDate");

  if (checkIn) checkIn.setAttribute("min", today);
  if (checkOut) checkOut.setAttribute("min", tomorrow);
});


document.addEventListener("DOMContentLoaded", () => {
  const checkIn = document.getElementById("checkInDate");
  const checkOut = document.getElementById("checkOutDate");
  const nightsInput = document.getElementById("nightsCount");
  const amountpaidInput = document.getElementById("amountPaid");

  function calculateNights() {
    if (checkIn.value && checkOut.value) {
      const start = new Date(checkIn.value);
      const end = new Date(checkOut.value);

      const diffTime = end - start;
      const diffDays = diffTime / (1000 * 60 * 60 * 24);

      nightsInput.value = diffDays > 0 ? diffDays : 0;

      amountpaidInput.value = nightsInput.value * typePaid;
    }
  }

  checkIn.addEventListener("change", calculateNights);
  checkOut.addEventListener("change", calculateNights);
});
