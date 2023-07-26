package com.example.presentacionEntregable2.Controladores;

import com.example.presentacionEntregable2.Entidades.Usuario;
import com.example.presentacionEntregable2.Repositorios.Interfaces.IRepositorio;
import com.example.presentacionEntregable2.Repositorios.UsuarioRepositorio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UsuarioController {
    private IRepositorio<Usuario> _usuarioRepositorio;
    UsuarioController(){
        _usuarioRepositorio = new UsuarioRepositorio();
    }

    @GetMapping("/usuarios")
    public String listar(Model model) {
        var usuarios = _usuarioRepositorio.Listar();
        model.addAttribute("usuarios", usuarios);
        return "usuario.lista";
    }
    @GetMapping("/crearUsuario")
    public String crearUsuario(Model model) {
        _usuarioRepositorio.Crear(new Usuario("cc301220032@gmail.com","jesus","contreras","918521619"));
        var usuarios = _usuarioRepositorio.Listar();
        model.addAttribute("usuarios", usuarios);
        return "usuario.lista";
    }

    @GetMapping("/editarUsuario")
    public String editarUsuario(@RequestParam int id, Model model) {
        Usuario usuario = _usuarioRepositorio.ObtenerPorId(id);
        model.addAttribute("usuario", usuario);
        return "usuario.editar";
    }

    @PostMapping("/eliminarUsuario")
    public String eliminarUsuario(@RequestParam int id, Model model) {
        Usuario usuario = _usuarioRepositorio.ObtenerPorId(id);
        _usuarioRepositorio.Eliminar(usuario);
        return "redirect:/usuarios";
    }

    @PostMapping("/actualizarUsuario")
    public String actualizarUsuario(@ModelAttribute Usuario usuario, Model model) {
        _usuarioRepositorio.Actualizar(usuario);
        return "redirect:/usuarios";
    }

    @GetMapping("/iniciosesion")
    public String obtenerPaginaInicioSesion(Model model){
        var usuario = new Usuario();
        model.addAttribute("usuario", usuario);
        return "index";
    }
}
