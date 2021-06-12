package com.putao_seo.api.service;

import com.putao_seo.api.entity.Category;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface CategoryService {

    @Cacheable(value = "Category",keyGenerator = "keyGenerator")
    Category getCategoryById(Integer categoryId);

    /**
     * 根据categoryID 获取该分类下的子分类列表
     * @param categoryId 分类id
     * @param includeGrandChild 是否获取孙子分类，true：获取儿子，孙子，重孙子。。。分类； false：不获取孙子，重孙子。。。分类
     * @return
     */
    @Cacheable(value = "Category",keyGenerator = "keyGenerator")
    List<Category> getSubCategoryById(Integer categoryId, boolean includeGrandChild);

    /**
     * 根据categoryID 获取该分类下的子分类的Id列表
     * @param categoryId 分类id
     * @param includeGrandChild 是否获取孙子分类，true：获取儿子，孙子，重孙子。。。分类； false：不获取孙子，重孙子。。。分类
     * @return
     */
    @Cacheable(value = "Category",keyGenerator = "keyGenerator")
    List<Integer> getSubCategoryIdListById(Integer categoryId, boolean includeGrandChild);

    /**
     * 获取获取级别为 categoryLevel 的分类
     * @param categoryLevel 分类级别
     * @return
     */
    @Cacheable(value = "Category",keyGenerator = "keyGenerator")
    List<Category> getCategoryListByLevel(Integer categoryLevel);


    /**
     * 获取获取级别为 categoryLevel 的分类 的数量
     * @param categoryLevel 分类级别
     * @return
     */
    @Cacheable(value = "Category",keyGenerator = "keyGenerator")
    long countCategoryListByLevel(Integer categoryLevel);

    /**
     * 根据 ID 列表获取 分类列表
     * @param idList ID列表
     * @return
     */
    @Cacheable(value = "Category",keyGenerator = "keyGenerator")
    List<Category> getCategoryByIdList(List<Integer> idList);

    /**
     * 根据 ID 列表获取 分类列表
     * @param categoryName 分类名
     * @return
     */
    @Cacheable(value = "Category",keyGenerator = "keyGenerator")
    List<Category> getCategoryByName(String categoryName);
}
