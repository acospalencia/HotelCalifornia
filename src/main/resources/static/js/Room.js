

let estadoRoom = document.querySelectorAll(".estado")


estadoRoom.forEach((celda) => {
    if (celda.textContent === "Activo") {
        celda.className += "text-success"
    }
    else {
        celda.className += "text-danger"
    }
})

