package org.esfe.controladores;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.esfe.modelos.Reservation;
import org.esfe.modelos.Room;
import org.esfe.servicios.interfaces.IReservationService;
import org.esfe.servicios.interfaces.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    private IReservationService reservationService;

    @Autowired
    private IRoomService roomService;

    @GetMapping
    public String Index(Reservation reservation, Model model) throws Exception {
        List<Room> roomList = roomService.obtenerTodosConImagenes();
        ObjectMapper mapper = new ObjectMapper();

        List<Map<String, Object>> roomsWithImages = roomList.stream().map(room -> {
            Map<String, Object> r = new HashMap<>();
            r.put("roomNumber", room.getRoomNumber());
            r.put("floor", room.getFloor());
            r.put("roomType", room.getRoomTypeId().getTypeName());
            r.put("status", room.getStatusId().getStatusName());
            r.put("description", room.getDescription());
            r.put("id", room.getRoomNumber());


            List<String> imagesBase64 = room.getImages().stream()
                    .map(img -> Base64.getEncoder().encodeToString(img.getBytesArrayImage()))
                    .collect(Collectors.toList());

            try {

                r.put("imagesJson", mapper.writeValueAsString(imagesBase64));
            } catch (Exception e) {
                r.put("imagesJson", "[]");
            }

            return r;
        }).collect(Collectors.toList());

        model.addAttribute("rooms", roomsWithImages);
        return "reservation/Index";
    }

}
