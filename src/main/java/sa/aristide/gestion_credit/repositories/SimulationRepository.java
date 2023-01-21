package sa.aristide.gestion_credit.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import sa.aristide.gestion_credit.entities.Simulation;

public interface SimulationRepository extends JpaRepository<Simulation, Long> {
	public Page<Simulation> findByReferenceContains(String reference, Pageable pageable);

}
