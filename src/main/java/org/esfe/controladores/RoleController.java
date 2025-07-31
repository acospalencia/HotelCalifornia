package org.esfe.controladores;

import org.esfe.modelos.Role;
import org.esfe.servicios.interfaces.IRolesService;
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
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private IRolesService rolesService;

    @GetMapping
    public String Index(Model model, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size){
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
}
