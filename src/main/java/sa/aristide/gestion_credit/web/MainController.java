package sa.aristide.gestion_credit.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sa.aristide.gestion_credit.entities.Client;
import sa.aristide.gestion_credit.entities.Simulation;
import sa.aristide.gestion_credit.services.ClientService;
import sa.aristide.gestion_credit.services.SimulationService;

@Controller
@RequestMapping("/")
public class MainController {

	@Autowired
	ClientService clientService;

	@Autowired
	SimulationService simulationService;

	/* CLIENT */

	@GetMapping("admin/")
	public String getAll(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "4") int size,
			@RequestParam(name = "fname", defaultValue = "") String fname,
			@RequestParam(name = "lname", defaultValue = "") String lname) {

		Page<Client> clientsPage = clientService.getPageByFnameAndLname(fname, lname, page, size);
		model.addAttribute("clients", clientsPage);
		model.addAttribute("fname", fname);
		model.addAttribute("lname", lname);
		model.addAttribute("pages", new int[clientsPage.getTotalPages()]);
		return "admin";
	}

	@GetMapping("admin/delete")
	public String delete(long id) {
		clientService.delete(id);
		return "redirect:/admin/";
	}

	@GetMapping("admin/newclient/")
	public String newVisitor(Model model) {
		model.addAttribute("client", new Client());
		return "newclient";
	}

	@PostMapping("admin/save")
	public String saveClient(@Valid Client client, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "newclient";
		}

		Client savedClient = clientService.save(client);
		model.addAttribute("client", savedClient);
		return "confirm-save-client";
	}

	/* SIMULATION */
	@GetMapping("admin/simulation")
	public String getAll(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "4") int size,
			@RequestParam(name = "reference", defaultValue = "") String reference) {

		Page<Simulation> simulationsPage = simulationService.getPageByReference(reference, page, size);
		model.addAttribute("simulations", simulationsPage);
		model.addAttribute("reference", reference);
		model.addAttribute("pages", new int[simulationsPage.getTotalPages()]);
		return "admin-simulation";
	}

	@PostMapping("admin/simuation/save")
	public String saveSimulation(@Valid Simulation simulation, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "newsimuation";
		}

		Simulation savedSimulation = simulationService.save(simulation);
		model.addAttribute("simulation", savedSimulation);
		return "confirm-save-simulation";
	}

	/* INDEX */

	@GetMapping("/index")
	public String index() {

		return "index";
	}

}
