package org.esfe.controladores;

import org.esfe.modelos.Reservation;
import org.esfe.modelos.Room;
import org.esfe.servicios.interfaces.IReservationService;
import org.esfe.servicios.interfaces.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String Index (Reservation reservation, Model model){

        List<Room> roomList = roomService.obtenerTodos();

        model.addAttribute("rooms", roomList);

        return "reservation/Index";
    }
}
