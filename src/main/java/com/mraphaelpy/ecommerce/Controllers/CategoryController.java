package com.mraphaelpy.ecommerce.Controllers;

import com.mraphaelpy.ecommerce.Services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/addProduct")
    public void addProductToCategory(@RequestBody ProductCategoryDTO request) {
        categoryService.addProductToCategory(request.getProductId());
    }

    @PostMapping("/removeProduct")
    public void removeProductFromCategory(@RequestBody ProductCategoryDTO request) {
        categoryService.removeProductFromCategory(request.getProductId());
    }
}
