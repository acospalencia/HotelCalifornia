package org.esfe.modelos;

import jakarta.persistence.*;

@Entity
public class RoomImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private RoomImage room;

    @Lob
    private String bytesArrayImage;

    public RoomImage() {}


}
