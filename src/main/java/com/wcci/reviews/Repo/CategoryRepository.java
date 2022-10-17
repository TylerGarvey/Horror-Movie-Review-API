package com.wcci.reviews.Repo;

import com.wcci.reviews.Model.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Map;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}