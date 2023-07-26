package com.example.presentacionEntregable2.Controladores;

import com.example.presentacionEntregable2.Entidades.Categoria;
import com.example.presentacionEntregable2.Repositorios.CategoriaRepositorio;
import com.example.presentacionEntregable2.Repositorios.Interfaces.IRepositorio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CategoriaController {
    private IRepositorio<Categoria> _repositorio;

    public CategoriaController() {
        _repositorio = new CategoriaRepositorio();
    }

    @GetMapping("/categorias")
    public String listar(Model model) {
        List<Categoria> categorias = _repositorio.Listar();
        model.addAttribute("categorias", categorias);
        return "categoria.lista";
    }

    @GetMapping("/categorias/nueva")
    public String mostrarFormularioNuevaCategoria() {
        return "categoria.formulario";
    }

    @PostMapping("/categorias/nueva")
    public String crearCategoria(@RequestParam String nombre) {
        if (nombre.trim().isEmpty()) {
            return "redirect:/categorias/nueva?error=El nombre de la categoría no puede estar vacío.";
        }
        Categoria nuevaCategoria = new Categoria(1, 1, 1, nombre, "");
        _repositorio.Crear(nuevaCategoria);
        return "redirect:/categorias";
    }

    @PostMapping("/categorias/actualizar/{id}")
    public String actualizarCategoria(@PathVariable("id") int idCategoria, @ModelAttribute Categoria categoriaActualizada, Model model) {
        Categoria categoriaExistente = _repositorio.ObtenerPorId(idCategoria);
        if (categoriaExistente != null) {
            categoriaExistente.setNombre(categoriaActualizada.getNombre());
            _repositorio.Actualizar(categoriaExistente);
            return "redirect:/categorias";
        } else {
            model.addAttribute("error", "ID de categoría inválido");
            return "editar-categoria";
        }
    }



    @GetMapping ("/categorias/actualizar/{id}")
    public String actualizadaCategoria(@PathVariable("id") int idCategoria, Model model) {
        Categoria cat = _repositorio.ObtenerPorId(idCategoria);
        model.addAttribute("cat",cat);
        return "editar-categoria";
    }


    @GetMapping("/categorias/eliminar/{id}")
    public String eliminarCategoria(@PathVariable("id") int idCategoria) {
        Categoria categoria = _repositorio.ObtenerPorId(idCategoria);
        if (categoria != null) {
            _repositorio.Eliminar(categoria);
            return "redirect:/categorias";
        } else {
            return "redirect:/categorias?error=La categoría no existe";
        }
    }

}