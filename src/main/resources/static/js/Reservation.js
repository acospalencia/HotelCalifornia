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