package png.springframework.mngytdataapi.repositories;

import org.springframework.data.repository.CrudRepository;
import png.springframework.mngytdataapi.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
