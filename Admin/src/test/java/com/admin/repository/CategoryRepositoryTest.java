package com.admin.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.admin.AdminApplicationTests;
import com.admin.model.entity.Category;
import com.admin.model.enumclass.CategoryTypeEnum;
import com.admin.model.enumclass.ItemTypeEnum;
import com.admin.repository.CategoryRepository;

public class CategoryRepositoryTest extends AdminApplicationTests {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Test
	public void create() {
		CategoryTypeEnum type = CategoryTypeEnum.CLOTHES;
		String title = "상의";
        LocalDateTime createdAt = LocalDateTime.now();

        Category category = new Category();
        category.setType(type);
        category.setTitle(title);
        category.setCreatedAt(createdAt);

        Category newCategory = categoryRepository.save(category);

        Assert.assertNotNull(newCategory);
        Assert.assertEquals(newCategory.getType(), type); // getType()과 type 두개가 동일해야된다.
        Assert.assertEquals(newCategory.getTitle(), title);
		
	}

}
