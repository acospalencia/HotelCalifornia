package org.esfe.controladores;

import org.esfe.modelos.User;
import org.esfe.servicios.interfaces.IUserService;
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
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    // Listar con paginación
    @GetMapping
    public String index(User user, Model model,
                        @RequestParam("page") Optional<Integer> page,
                        @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1) - 1;
        int pageSize = size.orElse(5);
        Pageable pageable = PageRequest.of(currentPage, pageSize);

        Page<User> users = userService.buscarTodosPaginados(pageable);
        model.addAttribute("users", users);

        int totalPages = users.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "user/index"; // Vista de listado
    }

    // Mostrar formulario de creación
    @GetMapping("/create")
    public String create(User user) {
        return "user/create"; // Vista del formulario
    }

    // Guardar usuario (crear o actualizar)
    @PostMapping("/save")
    public String save(User user, BindingResult result, Model model, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            model.addAttribute(user);
            attributes.addFlashAttribute("error", "No se pudo guardar el usuario debido a un error.");
            return "redirect:/user";
        }
        userService.createOrEditOne(user);
        attributes.addFlashAttribute("msg", "Usuario guardado correctamente.");
        return "redirect:/user";
    }

    // Editar usuario
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model, RedirectAttributes attributes) {
        Optional<User> user = userService.bucarPorId(id);
        if (user.isPresent()) {
            model.addAttribute("user", user.get());
            return "user/edit"; // Vista de edición
        } else {
            attributes.addFlashAttribute("error", "Usuario no encontrado.");
            return "redirect:/user";
        }
    }

    // Eliminar usuario
    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Integer id, RedirectAttributes attributes) {
        userService.eliminarPorId(id);
        attributes.addFlashAttribute("msg", "Usuario eliminado correctamente.");
        return "redirect:/user";
    }
}
