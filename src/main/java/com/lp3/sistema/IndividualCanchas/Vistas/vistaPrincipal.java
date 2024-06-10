package com.lp3.sistema.IndividualCanchas.Vistas;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class vistaPrincipal {

	@GetMapping("/inicio")
	public String goHome (Model model) {
		return "home.html";
	}

	@GetMapping("/login")
	public String login (Model model) {
		return "login.html";
	}
	
	@GetMapping("/registro")
	public String registro (Model model) {
		return "register.html";
	}
	
	@GetMapping("/cliente")
	public String cliente (Model model) {
		return "client-new.html";
	}
	
	@GetMapping("/listarcliente")
	public String listcliente (Model model) {
		return "client-list.html";
	}
	
	@GetMapping("/actualizarcliente")
	public String actualizarcliente (Model model) {
		return "client-update.html";
	}
	
	@GetMapping("/buscarcliente")
	public String buscarcliente (Model model) {
		return "client-search.html";
	}
	
	@GetMapping("/usuario")
	public String usuario (Model model) {
		return "user-new.html";
	}
	
	@GetMapping("/listarusuario")
	public String listarusuario (Model model) {
		return "user-list.html";
	}
	
	@GetMapping("/buscarusuario")
	public String buscarusuario (Model model) {
		return "user-search.html";
	}
	
	@GetMapping("/actualizarusuario")
	public String actualizarusuario (Model model) {
		return "user-update.html";
	}
	
	@GetMapping("/empresa")
	public String empresa (Model model) {
		return "company.html";
	}
	
	@GetMapping("/reservas")
	public String reservas (Model model) {
		return "reservation-new.html";
	}
	
	@GetMapping("/listarreservas")
	public String listarreservas (Model model) {
		return "reservation-list.html";
	}
	
	@GetMapping("/actualizarreservas")
	public String actualizarreservas (Model model) {
		return "reservation-update.html";
	}
	
	@GetMapping("/buscarreservas")
	public String buscarreservas (Model model) {
		return "reservation-search.html";
	}
	
	@GetMapping("/reservaspendientes")
	public String reservaspendientes (Model model) {
		return "reservation-pending.html";
	}
	
	@GetMapping("/canchas")
	public String canchas (Model model) {
		return "item-new.html";
	}
	
	@GetMapping("/listarcanchas")
	public String listarcanchas (Model model) {
		return "item-list.html";
	}
	
	@GetMapping("/actualizarcanchas")
	public String actualizarcanchas (Model model) {
		return "item-update.html";
	}
	
	@GetMapping("/buscarcanchas")
	public String buscarcanchas (Model model) {
		return "item-search.html";
	}
	
	@GetMapping("/pagos")
	public String pagos (Model model) {
		return "payment.html";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
