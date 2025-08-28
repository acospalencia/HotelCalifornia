document.addEventListener('DOMContentLoaded', function() {
            // Activar tooltips de Bootstrap
            const tooltipTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="tooltip"]'));
            tooltipTriggerList.map(function (tooltipTriggerEl) {
                return new bootstrap.Tooltip(tooltipTriggerEl);
            });

            // Manejar clic en imágenes de pisos
            const floorImages = document.querySelectorAll('.piso-img');
            floorImages.forEach(img => {
                img.addEventListener('click', function() {
                    const floor = this.getAttribute('data-floor');

                    // Quitar clase activa de todos los pisos
                    floorImages.forEach(i => i.classList.remove('floor-active'));
                    // Agregar clase activa al piso seleccionado
                    this.classList.add('floor-active');

                    // Filtrar habitaciones por piso
                    filterRoomsByFloor(floor);

                    // Actualizar texto
                    document.getElementById('txt-tema').textContent = 'Habitaciones - Piso ' + floor;
                });
            });

            // Configurar modal de habitación
            const roomModal = document.getElementById('roomModal');
            roomModal.addEventListener('show.bs.modal', function (event) {
                const button = event.relatedTarget;
                const roomId = button.getAttribute('data-room-id');
                const roomNumber = button.getAttribute('data-room-number');
                const roomType = button.getAttribute('data-room-type');
                const floor = button.getAttribute('data-floor');
                const status = button.getAttribute('data-status');
                const description = button.getAttribute('data-description');
                const imagesJson = button.getAttribute('data-images');

                // Parsear imágenes si están disponibles
                let images = [];
                try {
                    images = JSON.parse(imagesJson);
                } catch (e) {
                    console.error('Error parsing images JSON:', e);
                    images = ['https://images.unsplash.com/photo-1582719478250-c89cae4dc85b?ixlib=rb-4.0.3&auto=format&fit=crop&w=500&h=300&q=80'];
                }

                // Actualizar contenido del modal
                document.getElementById('modalRoomTitle').textContent = 'Habitación ' + roomNumber;
                document.getElementById('modalRoomType').textContent = roomType;
                document.getElementById('modalRoomFloor').textContent = floor;
                document.getElementById('modalRoomNumber').textContent = roomNumber;
                document.getElementById('modalRoomDescription').textContent = description || 'Una confortable habitación para su estancia.';

                // Actualizar estado
                const statusBadge = document.getElementById('modalRoomStatus');
                if (status === 'Inactivo') {
                    statusBadge.textContent = 'Ocupada';
                    statusBadge.className = 'badge bg-danger';
                } else {
                    statusBadge.textContent = 'Disponible';
                    statusBadge.className = 'badge bg-success';
                }

                // Actualizar imágenes en el carrusel
                const carouselInner = document.getElementById('carousel-inner');
                carouselInner.innerHTML = '';

                images.forEach((img, index) => {
                    const item = document.createElement('div');
                    item.className = index === 0 ? 'carousel-item active' : 'carousel-item';
                    item.innerHTML = `<img src="${img}" class="d-block w-100" alt="Habitación ${roomNumber}" style="height: 300px; object-fit: cover;">`;
                    carouselInner.appendChild(item);
                });

                // Establecer roomId en el formulario
                document.getElementById('formRoomId').value = roomId;

                // Establecer fecha mínima como hoy
                const today = new Date().toISOString().split('T')[0];
                document.getElementById('checkInDate').min = today;
                document.getElementById('checkOutDate').min = today;

                // Reiniciar formulario
                document.getElementById('checkInDate').value = '';
                document.getElementById('checkOutDate').value = '';
                document.getElementById('amountPaid').value = '';
            });

            // Filtrar habitaciones por piso (inicialmente piso 4)
            filterRoomsByFloor(4);
        });

        function filterRoomsByFloor(floor) {
            const roomCards = document.querySelectorAll('.room-card');
            roomCards.forEach(card => {
                if (card.getAttribute('data-floor') === floor) {
                    card.style.display = 'block';
                } else {
                    card.style.display = 'none';
                }
            });
        }

        function calculateTotal() {
            const checkInDate = new Date(document.getElementById('checkInDate').value);
            const checkOutDate = new Date(document.getElementById('checkOutDate').value);

            if (checkInDate && checkOutDate && checkOutDate > checkInDate) {
                // Calcular diferencia en días
                const diffTime = Math.abs(checkOutDate - checkInDate);
                const diffDays = Math.ceil(diffTime / (1000 * 60 * 60 * 24));

                // Precio por noche (ejemplo: $100 por noche)
                const pricePerNight = 100;
                const total = diffDays * pricePerNight;

                document.getElementById('amountPaid').value = total;
            } else {
                document.getElementById('amountPaid').value = '';
            }
        }