package png.springframework.mngytdataapi.services.datajpa;

import org.springframework.stereotype.Service;
import png.springframework.mngytdataapi.model.Category;
import png.springframework.mngytdataapi.repositories.CategoryRepository;
import png.springframework.mngytdataapi.services.CategoryService;


import java.util.ArrayList;
import java.util.List;

@Service
public class CategorySDJpaService implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategorySDJpaService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll() {
        List<Category> categories = new ArrayList<>();
        categoryRepository.findAll().forEach(categories::add);
        return categories;
    }

    @Override
    public Category findById(Long aLong) {
        return categoryRepository.findById(aLong).orElse(null);
    }

    @Override
    public Category save(Category object) {
        return categoryRepository.save(object);
    }

    @Override
    public void delete(Category object) {
        categoryRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        categoryRepository.deleteById(aLong);
    }
}
