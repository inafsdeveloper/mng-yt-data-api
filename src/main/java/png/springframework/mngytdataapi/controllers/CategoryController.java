package png.springframework.mngytdataapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import png.springframework.mngytdataapi.model.Category;
import png.springframework.mngytdataapi.services.CategoryService;

import java.util.List;


@RequestMapping("/api")
@RestController
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("categories")
    List<Category> getProfiles() {
        return categoryService.findAll();
    }
}
