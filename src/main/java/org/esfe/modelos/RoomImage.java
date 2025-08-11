package org.esfe.modelos;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import javassist.bytecode.ByteArray;

@Entity
public class RoomImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "El id de la habitacion es requerido")
    private Integer room_Id;

    @NotBlank(message = "El array de bytes de la imagen es requerido")
    private String bytesArrayImage;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoom_Id() {
        return room_Id;
    }

    public void setRoom_Id(Integer room_Id) {
        this.room_Id = room_Id;
    }

    public String getBytesArrayImage() {
        return bytesArrayImage;
    }

    public void setBytesArrayImage(String bytesArrayImage) {
        this.bytesArrayImage = bytesArrayImage;
    }
}
