package org.esfe.modelos;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "reservations")

public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "El id del usuario es requerido")
    public Integer userId;

    @NotBlank(message = "El id de la habitación es requerido")
    public Integer roomId;

    @NotBlank(message = "La fecha de entrada es requerido")
    public LocalDate chekInDate;

    @NotBlank(message = "La fecha de salida es requerido")
    public LocalDate chekOutDate;

    @NotBlank(message = "El total del monto es requerido")
    public BigDecimal totalPurchase;

    @NotBlank(message = "El Id del pago es necesario")
    public Integer payId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public LocalDate getChekInDate() {
        return chekInDate;
    }

    public void setChekInDate(LocalDate chekInDate) {
        this.chekInDate = chekInDate;
    }

    public LocalDate getChekOutDate() {
        return chekOutDate;
    }

    public void setChekOutDate(LocalDate chekOutDate) {
        this.chekOutDate = chekOutDate;
    }

    public BigDecimal getTotalPurchase() {
        return totalPurchase;
    }

    public void setTotalPurchase(BigDecimal totalPurchase) {
        this.totalPurchase = totalPurchase;
    }

    public Integer getPayId() {
        return payId;
    }

    public void setPayId(Integer payId) {
        this.payId = payId;
    }
}
