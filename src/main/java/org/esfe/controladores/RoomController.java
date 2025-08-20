package org.esfe.controladores;

import org.esfe.modelos.Role;
import org.esfe.modelos.Room;
import org.esfe.servicios.interfaces.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/room")

public class RoomController {
    @Autowired
    private IRoomService roomService;

    @GetMapping
    public String Index(Room room, Model model, @RequestParam("page")Optional<Integer> page, @RequestParam("size")Optional<Integer> size){

        int currentPage = page.orElse(1)-1;
        int pageSize = size.orElse(5);
        Pageable pageable = PageRequest.of(currentPage, pageSize);


        Page<Room> rooms = roomService.buscarTodosPaginados(pageable);
        model.addAttribute("rooms", rooms);

        int totalPages = rooms.getTotalPages();
        if (totalPages > 0){
            List<Integer> pageNumber = IntStream.rangeClosed(1,totalPages)
                    .boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers",pageNumber);
        }
        return "room/Index";
    }


    @PostMapping("/save")
    public String save(Room room, BindingResult result, Model model, RedirectAttributes attributes){
        if (result.hasErrors()) {
            model.addAttribute(room);
            attributes.addFlashAttribute("error", "No se pudo guardar debido a un error.");
            return "redirect:/room";
        }
        roomService.createOrEditOne(room);
        attributes.addFlashAttribute("msg", "Grupo creado correctamente.");
        return "redirect:/room";
    }

    @GetMapping("/remove/{roomNumber}")
    public String remove(@PathVariable("roomNumber") Integer roomNumber, RedirectAttributes attributes) {
        roomService.eliminarPorId(roomNumber);
        attributes.addFlashAttribute("msg", "Grupo eliminado correctamente.");
        return "redirect:/room";
    }


}
