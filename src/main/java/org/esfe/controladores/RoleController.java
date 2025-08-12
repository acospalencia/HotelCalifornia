package org.esfe.controladores;

import org.esfe.modelos.Role;
import org.esfe.servicios.interfaces.IRolesService;
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
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRolesService rolesService;

    @GetMapping
    public String Index(Role role, Model model, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size){
        int currentPage = page.orElse(1) - 1 ;
        int pageSize = size.orElse(5);
        Pageable pageable = PageRequest.of(currentPage, pageSize);

        Page<Role> roles = rolesService.buscarTodosPaginados(pageable);
        model.addAttribute("roles", roles);

        int totalPAges = roles.getTotalPages();
        if (totalPAges > 0){
            List<Integer> pageNumber = IntStream.rangeClosed(1, totalPAges)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumber);

        }

        return  "role/Index";
    }
/*
    @GetMapping("/create")
    public String Create(Role role){
        return "role/create";
    }
*/

    @PostMapping("/save")
    public String save(Role role, BindingResult result, Model model, RedirectAttributes attributes){
        if (result.hasErrors()) {
            model.addAttribute(role);
            attributes.addFlashAttribute("error", "No se pudo guardar debido a un error.");
            return "redirect:/role";
        }
        rolesService.createOrEditOne(role);
        attributes.addFlashAttribute("msg", "Grupo creado correctamente.");
        return "redirect:/role";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Integer id, RedirectAttributes attributes) {
        rolesService.eliminarPorId(id);
        attributes.addFlashAttribute("msg", "Grupo eliminado correctamente.");
        return "redirect:/role";
    }

/*
    @PostMapping("/delete")
    public String delete(Role role, RedirectAttributes attributes){

        rolesService.eliminarPorId(role.getId());
        attributes.addFlashAttribute("msg", "Grupo eliminado correctamente.");
        return "redirect:/role";
    }
 */
}


