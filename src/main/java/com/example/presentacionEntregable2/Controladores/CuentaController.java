package com.example.presentacionEntregable2.Controladores;

import com.example.presentacionEntregable2.Entidades.Cuenta;
import com.example.presentacionEntregable2.Repositorios.Interfaces.IRepositorio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
public class CuentaController {

    private final IRepositorio<Cuenta> cuentaRepositorio;

    public CuentaController(IRepositorio<Cuenta> cuentaRepositorio) {
        this.cuentaRepositorio = cuentaRepositorio;
    }

    @GetMapping("/cuentas")
    public String listar(Model model) {
        List<Cuenta> cuentas = cuentaRepositorio.Listar();

        model.addAttribute("cuentas", cuentas);
        return "cuenta.lista";
    }

    @GetMapping("/cuentas/nueva")
    public String mostrarFormularioNuevaCuenta() {
        return "cuenta.formulario";
    }

    @PostMapping("/cuentas/nueva")
    public String crearCuenta(@RequestParam String nombre) {
        Date fecha = new Date();
        if (nombre.trim().isEmpty()) {
            return "redirect:/cuentas/nueva?error=El nombre de la cuenta no puede estar vacío.";
        }
        Cuenta nuevaCuenta = new Cuenta(1, 1, nombre, "descripcion", 1,"" );
        cuentaRepositorio.Crear(nuevaCuenta);
        return "redirect:/cuentas";
    }
}
