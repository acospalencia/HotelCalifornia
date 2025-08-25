package org.esfe.modelos;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import javassist.bytecode.ByteArray;

@Entity
public class RoomImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "room_Id", nullable = false)
    @NotNull(message = "El id de la habitación es requerido")
    private Room room_Id;

    @Lob
    @NotNull(message = "El array de bytes de la imagen es requerido")
    private byte[] bytesArrayImage;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Room getRoom_Id() {
        return room_Id;
    }

    public void setRoom_Id(Room room_Id) {
        this.room_Id = room_Id;
    }

    public byte[] getBytesArrayImage() {
        return bytesArrayImage;
    }

    public void setBytesArrayImage(byte[] bytesArrayImage) {
        this.bytesArrayImage = bytesArrayImage;
    }
}
