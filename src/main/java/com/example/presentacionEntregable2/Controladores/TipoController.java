package com.example.presentacionEntregable2.Controladores;

import com.example.presentacionEntregable2.Entidades.Tipo;
import com.example.presentacionEntregable2.Repositorios.TipoRepositorio;
import com.example.presentacionEntregable2.Repositorios.Interfaces.IRepositorio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TipoController {
    private IRepositorio<Tipo> _repositorio;

    public TipoController() {
        _repositorio = new TipoRepositorio();
    }

    @GetMapping("/tipos")
    public String listar(Model model) {
        var tipos = _repositorio.Listar();
        model.addAttribute("tipos", tipos);
        return "tipo.lista";
    }

    @GetMapping("/editarTipo")
    public String editarTipo(@RequestParam int id, Model model) {
        Tipo tipo = _repositorio.ObtenerPorId(id);
        model.addAttribute("tipo", tipo);
        return "tipo.editar";
    }

    @PostMapping("/actualizarTipo")
    public String actualizarTipo(@ModelAttribute Tipo tipo, Model model) {
        _repositorio.Actualizar(tipo);
        return "redirect:/tipos";
    }

    @PostMapping("/eliminarTipo")
    public String eliminarTipo(@RequestParam int id, Model model) {
        Tipo tipo = _repositorio.ObtenerPorId(id);
        _repositorio.Eliminar(tipo);
        return "redirect:/tipos";
    }
}
