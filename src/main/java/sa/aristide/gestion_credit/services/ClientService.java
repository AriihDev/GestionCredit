package sa.aristide.gestion_credit.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import sa.aristide.gestion_credit.entities.Client;
import sa.aristide.gestion_credit.repositories.ClientRepository;

@Service
@AllArgsConstructor
@Transactional
public class ClientService {

	@Autowired
	ClientRepository clientRepository;

	public Client getById(long id) {
		return clientRepository.findById(id).orElse(null);
	}

	public List<Client> getAll() {
		return clientRepository.findAll();
	}

	public Client save(Client client) {
		return clientRepository.save(client);
	}

	public void delete(Client client) {
		clientRepository.deleteById(client.getId());
	}

	public void delete(long id) {
		clientRepository.deleteById(id);
	}

	public Page<Client> getPage(int page, int size) {
		return clientRepository.findAll(PageRequest.of(page, size));
	}

	public Page<Client> getPageByFnameAndLname(String fname, String lname, int page, int size) {
		return clientRepository.findByFnameContainsAndLnameContains(fname, lname, PageRequest.of(page, size));
	}
}
