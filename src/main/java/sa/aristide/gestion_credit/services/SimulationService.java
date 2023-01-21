package sa.aristide.gestion_credit.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import sa.aristide.gestion_credit.entities.Simulation;
import sa.aristide.gestion_credit.repositories.SimulationRepository;

@Service
@AllArgsConstructor
@Transactional
public class SimulationService {

	@Autowired
	SimulationRepository simulationRepository;

	public List<Simulation> getAll() {
		return simulationRepository.findAll();
	}

	public Simulation save(Simulation simulation) {
		return simulationRepository.save(simulation);
	}

	public Page<Simulation> getPage(int page, int size) {
		return simulationRepository.findAll(PageRequest.of(page, size));
	}

	public Page<Simulation> getPageByReference(String reference, int page, int size) {
		return simulationRepository.findByReferenceContains(reference, PageRequest.of(page, size));
	}

}
