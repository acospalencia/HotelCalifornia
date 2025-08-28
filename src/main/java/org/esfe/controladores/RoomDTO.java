package org.esfe.controladores;

import java.math.BigDecimal;

public class RoomDTO {

    private Integer roomNumber;
    private String roomTypeName;
    private BigDecimal roomPrice;
    private Integer floor;
    private String statusName;
    private String description;

    // Constructor
    public RoomDTO(Integer roomNumber, String roomTypeName, BigDecimal roomPrice, Integer floor, String statusName, String description) {
        this.roomNumber = roomNumber;
        this.roomTypeName = roomTypeName;
        this.roomPrice = roomPrice;
        this.floor = floor;
        this.statusName = statusName;
        this.description = description;
    }

    // Getters y setters
    public Integer getRoomNumber() { return roomNumber; }
    public void setRoomNumber(Integer roomNumber) { this.roomNumber = roomNumber; }

    public String getRoomTypeName() { return roomTypeName; }
    public void setRoomTypeName(String roomTypeName) { this.roomTypeName = roomTypeName; }

    public BigDecimal getRoomPrice() { return roomPrice; }
    public void setRoomPrice(BigDecimal roomPrice) { this.roomPrice = roomPrice; }

    public Integer getFloor() { return floor; }
    public void setFloor(Integer floor) { this.floor = floor; }

    public String getStatusName() { return statusName; }
    public void setStatusName(String statusName) { this.statusName = statusName; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
