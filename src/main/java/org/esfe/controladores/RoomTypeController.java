package org.esfe.controladores;


import org.esfe.modelos.RoomType;
import org.esfe.servicios.interfaces.IRoomTypeService;
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
@RequestMapping ("/roomtype")
public class RoomTypeController {

    @Autowired
    private IRoomTypeService roomTypeService;

    @GetMapping
    public String Index(RoomType roomType, Model model, @RequestParam("page") Optional<Integer> page, @RequestParam("size")Optional<Integer> size){
        int currentPage = page.orElse(1) -1;
        int pageSize  = size.orElse(5);
        Pageable pageable  = PageRequest.of(currentPage, pageSize);

        Page<RoomType> roomTypes = roomTypeService.buscarTodosPaginados(pageable);
        model.addAttribute("RoomType", roomTypes);


        int totalPages = roomTypes.getTotalPages();
        if (totalPages > 0){
            List<Integer> pageNumber = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers",pageNumber);
        }
        return "roomtype/Index";
    }


    @PostMapping("/save")
    public String save(RoomType roomType, BindingResult result, Model  model, RedirectAttributes attributes){
        if (result.hasErrors()){
            model.addAttribute(roomType);
            attributes.addFlashAttribute("error", "No se pudo guardar debido a un error.");
            return "redirect:/roomtype";
        }
        roomTypeService.createOrEditOne(roomType);
        attributes.addFlashAttribute("msg", "Grupo creado correctamente.");
        return "redirect:/roomtype";
    }

    @GetMapping("/removed/{id}")
    public String remove(@PathVariable("id") Integer id, RedirectAttributes attributes){
        roomTypeService.eliminarPorId(id);
        attributes.addFlashAttribute("msg", "Grupo eliminado corectamente");
        return "redirect:/roomtype";
    }
}
