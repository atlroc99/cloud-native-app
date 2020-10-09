package com.jeffry.springcloud.repository;

import com.jeffry.springcloud.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepostiory extends JpaRepository<Category, Integer> {
}
