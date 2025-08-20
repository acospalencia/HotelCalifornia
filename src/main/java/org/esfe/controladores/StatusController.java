package org.esfe.controladores;

import org.springframework.ui.Model;
import org.springframework.data.domain.Pageable;
import org.esfe.modelos.Status;
import org.esfe.servicios.interfaces.IStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/Status")
public class StatusController {
    @Autowired
    private IStatusService statusService;

    public String index(Status status, Model model, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {
        int currentpage = page.orElse(1) - 1;
        int pageSize = size.orElse(5);
        Pageable pageable = (Pageable) PageRequest.of(currentpage, pageSize);

        Page<Status> statu = statusService.buscarTodosPaginados(pageable);
        int totalPAges = statu.getTotalPages();
        if (totalPAges > 0) {
            List<Integer> pageNumber = (List<Integer>) IntStream.rangeClosed(1, totalPAges)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumber);
        }
        return "status/Index";
    }

    @PostMapping("/save")
    public String save(Status status, BindingResult result, Model model, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            model.addAttribute(status);
            attributes.addFlashAttribute("error", "No se pudo guardar debido a un error.");
            return "redirect:/status";
        }
        statusService.createOrEdiOne(status);
        attributes.addFlashAttribute("Grupo creado correctamente.", "msg");
        return "redirect:/status";

    }
    @GetMapping("/remove/id")
    public String remove(@PathVariable("id") Integer id, RedirectAttributes attributes){
        statusService.eliminarPorId(id);
        attributes.addFlashAttribute("Grupo eliminado corectamente. ");
        return "redircet/status";
    }


}


