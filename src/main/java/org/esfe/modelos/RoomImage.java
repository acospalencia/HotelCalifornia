package org.esfe.modelos;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import javassist.bytecode.ByteArray;

@Entity
public class RoomImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private RoomImage room;

    @NotBlank(message = "El array de bytes de la imagen es requerido")
    private String bytesArrayImage;

    public RoomImage() {}


}
