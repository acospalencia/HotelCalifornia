package org.esfe.controladores;

import org.esfe.modelos.Role;
import org.esfe.modelos.Room;
import org.esfe.modelos.RoomImage;
import org.esfe.modelos.RoomImageDTO;
import org.esfe.servicios.interfaces.IRoomImageService;
import org.esfe.servicios.interfaces.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/roomimage")
public class RoomImageController {

    @Autowired
    private IRoomImageService imageService;
    @Autowired
    private IRoomService roomService;

    @GetMapping
    public String Index(RoomImage roomImage, Model model, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {

        int currentPage = page.orElse(1) - 1;
        int pageSize = size.orElse(36);
        Pageable pageable = PageRequest.of(currentPage, pageSize);

        Page<RoomImage> roomImages = imageService.buscarTodosPaginados(pageable);

        // Convertir las imágenes a Base64
        Page<RoomImageDTO> roomImagesDto = roomImages.map(img -> {
            String base64Image = null;
            if (img.getBytesArrayImage() != null) {
                base64Image = Base64.getEncoder().encodeToString(img.getBytesArrayImage());
            }
            return new RoomImageDTO(img.getId(), img.getRoom_Id(), base64Image);
        });

        model.addAttribute("roomimages", roomImagesDto);

        int totalPages = roomImages.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumber = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumber);
        }

        List<Room> listaRooms = roomService.obtenerTodos();
        model.addAttribute("ListadoRooms", listaRooms);

        return "roomimage/Index";
    }

//guardar imagen
@PostMapping("/save")
public String save(@ModelAttribute RoomImage roomImage, @RequestParam("imagenFile") MultipartFile imagenFile, BindingResult result, Model model, RedirectAttributes attributes) {

    if (result.hasErrors()) {
        model.addAttribute("roomImage", roomImage);
        attributes.addFlashAttribute("error", "No se pudo guardar debido a un error.");
        return "redirect:/roomimage";
    }

    try {
        if (!imagenFile.isEmpty()) {
            roomImage.setBytesArrayImage(imagenFile.getBytes());
        }
    } catch (IOException e) {
        attributes.addFlashAttribute("error", "Error al procesar la imagen.");
        return "redirect:/roomimage";
    }

    imageService.createOrEditOne(roomImage);
    attributes.addFlashAttribute("msg", "Imagen de habitación creada correctamente.");
    return "redirect:/roomimage";
}


    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Integer id, RedirectAttributes attributes) {
        imageService.eliminarPorId(id);
        attributes.addFlashAttribute("msg", "imagen eliminada correctamente.");
        return "redirect:/roomimage";
    }
}

