package com.example.presentacionEntregable2.Controladores;

import com.example.presentacionEntregable2.Entidades.Categoria;
import com.example.presentacionEntregable2.Entidades.Movimiento;
import com.example.presentacionEntregable2.Repositorios.CategoriaRepositorio;
import com.example.presentacionEntregable2.Repositorios.Interfaces.IRepositorio;
import com.example.presentacionEntregable2.Repositorios.MovimientoRepositorio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MovimientoController {
    private IRepositorio<Movimiento> _repositorio;

    public MovimientoController(){
        _repositorio = new MovimientoRepositorio();
    }

    @GetMapping("/movimientos")
    public String listar(Model model){
        var categorias = _repositorio.Listar();
        model.addAttribute("movimientos", categorias);
        return "movimiento.lista";
    }

    @GetMapping("/editarMovimiento")
    public String editarMovimiento(@RequestParam int id, Model model) {
        Movimiento movimiento = _repositorio.ObtenerPorId(id);
        model.addAttribute("movimiento", movimiento);
        return "movimiento.editar";
    }

    @PostMapping("/actualizarMovimiento")
    public String actualizarMovimiento(@ModelAttribute Movimiento movimiento, Model model) {
        _repositorio.Actualizar(movimiento);
        return "redirect:/movimientos";
    }

    @PostMapping("/eliminarMovimiento")
    public String eliminarMovimiento(@RequestParam int id, Model model) {
        Movimiento movimiento = _repositorio.ObtenerPorId(id);
        _repositorio.Eliminar(movimiento);
        return "redirect:/movimientos";
    }
}
