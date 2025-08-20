package org.esfe.modelos;

public class RoomImageDTO {

    private Integer id;
    private Room roomId;
    private String base64Image;

    public RoomImageDTO(Integer id, Room roomId, String base64Image) {
        this.id = id;
        this.roomId = roomId;
        this.base64Image = base64Image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Room getRoomId() {
        return roomId;
    }

    public void setRoomId(Room roomId) {
        this.roomId = roomId;
    }

    public String getBase64Image() {
        return base64Image;
    }

    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }
}
