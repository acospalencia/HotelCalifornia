package org.esfe.modelos;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roomNumber;

    @ManyToOne
    @JoinColumn(name = "roomTypeId", nullable = false)
    @NotNull(message = "El id del tipo de habitacion es requerido")
    private RoomType roomTypeId ;

    @NotNull(message = "El numero de piso es requerido")
    private Integer floor;

    @ManyToOne
    @JoinColumn(name = "statusId", nullable = false)
    @NotNull(message = "El id de estado es requerido")
    private Status statusId;

    @NotBlank(message = "La descripcion de la habitacion es requerida")
    private String description;

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public RoomType getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(RoomType roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Status getStatusId() {
        return statusId;
    }

    public void setStatusId(Status statusId) {
        this.statusId = statusId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
