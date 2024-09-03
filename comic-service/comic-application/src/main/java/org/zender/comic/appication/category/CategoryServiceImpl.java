package org.zender.comic.appication.category;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.zender.comic.appication.category.commands.CreateCategoryCommand;
import org.zender.comic.appication.category.commands.UpdateCategoryCommand;
import org.zender.comic.appication.category.mappers.CategoryDataMapper;
import org.zender.comic.domain.category.id.generator.CategoryIdGenerator;
import org.zender.comic.domain.category.models.Category;
import org.zender.comic.domain.category.exceptions.CategoryNotFoundException;
import org.zender.common.domain.valueobjects.category.CategoryId;

import java.util.List;

@Service
@Validated
@RequiredArgsConstructor
public class CategoryServiceImpl implements ICategoryService {
    private static final Logger log = LoggerFactory.getLogger(CategoryServiceImpl.class);
    private final ICategoryRepository categoryRepository;
    private final CategoryIdGenerator categoryIdGenerator;


    @Override
    @Transactional
    public Category save(CreateCategoryCommand command) {
        Category category = CategoryDataMapper.INSTANCE.createCategoryCommandToCategory(command);
        category.setId(categoryIdGenerator.invoke());
        return categoryRepository.save(category);
    }

    @Override
    @Transactional
    public Category update(CategoryId categoryId, UpdateCategoryCommand command) {
        Category category = categoryCheck(categoryId);
        CategoryDataMapper.INSTANCE.updateCategoryCommandToCategory(category, command);
        return categoryRepository.update(category);
    }

    @Override
    public Category findById(CategoryId categoryId) {
        return categoryCheck(categoryId);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void delete(CategoryId categoryId) {
        Category category = categoryCheck(categoryId);
        categoryRepository.delete(category.getId());
    }

    private Category categoryCheck(CategoryId categoryId) {
        return categoryRepository.findById(categoryId).orElseThrow(() -> {
            log.warn("Category {} not found", categoryId.getValue());
            return new CategoryNotFoundException("category not found", categoryId.getValue());
        });
    }
}
