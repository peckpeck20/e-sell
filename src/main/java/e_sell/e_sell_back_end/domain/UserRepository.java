package e_sell.e_sell_back_end.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

//CRUD adds JAP methods to retrieve ,create and delete entries
public interface UserRepository extends CrudRepository<User, Long> {
	List<User> findByLastName(String lastName);
}