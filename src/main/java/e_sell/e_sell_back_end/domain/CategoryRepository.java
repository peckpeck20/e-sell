package e_sell.e_sell_back_end.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
	//Category is the object of category and Long its ID
	List<Category> findByType(String type);

}
