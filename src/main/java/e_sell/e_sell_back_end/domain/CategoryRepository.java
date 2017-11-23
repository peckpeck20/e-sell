package e_sell.e_sell_back_end.domain;



import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
	//find by cat type
	Category findByType(String type);
	

	
	//List<Category>findByItem(String item);
	//Item findByCategory(String type);
	//show the items in the categories
	//List<Item>items(String type);
	//List<Category>findByItem(String item);
}	



