package org.esfe.controladores;

import org.esfe.modelos.RoomImage;
import org.esfe.servicios.interfaces.IRoomImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/roomimage")
public class RoomImageController {

    @Autowired
    private IRoomImageService imageService;

    @GetMapping
    public String Index(RoomImage roomImage, Model model, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1) - 1;
        int pageSize = size.orElse(5);
        Pageable pageable = PageRequest.of(currentPage, pageSize);

        Page<RoomImage> roomImages = imageService.buscarTodosPaginados(pageable);
        model.addAttribute("roomImage", roomImages);

        int totalPages = roomImages.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumber = IntStream.rangeClosed(1, totalPages)
                    .boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumber);
        }

        return "roomimage/Index";
    }
}

