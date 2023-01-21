package sa.aristide.gestion_credit.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import sa.aristide.gestion_credit.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

	public Page<Client> findByFnameContainsAndLnameContains(String fname,String lname, Pageable pageable);
}
