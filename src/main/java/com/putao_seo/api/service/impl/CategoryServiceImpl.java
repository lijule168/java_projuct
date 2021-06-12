package com.putao_seo.api.service.impl;

import com.putao_seo.api.entity.Category;
import com.putao_seo.api.entity.CategoryExample;
import com.putao_seo.api.mapper.CategoryMapper;
import com.putao_seo.api.service.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;


@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    CategoryMapper categoryMapper;

    @Override
    public Category getCategoryById(Integer categoryId) {

        return categoryMapper.selectByPrimaryKey(categoryId);
    }

    /**
     * 根据categoryID 获取该分类下的子分类列表
     * @param categoryId 分类id
     * @param includeGrandChild 是否获取孙子分类，true：获取儿子，孙子，重孙子。。。分类； false：只获取儿子分类，不获取孙子，重孙子。。。分类
     * @return
     */
    @Override
    public List<Category> getSubCategoryById(Integer categoryId, boolean includeGrandChild) {

        Category category = getCategoryById(categoryId);
        String pathPrefix = "";
        if (StringUtils.isEmpty(category.getPidPath())){
            //该 category的pidPath为空，说明他是一级分类，没有父类
            pathPrefix = String.valueOf(category.getId());
        }else {
            pathPrefix = category.getPidPath() + "_" +category.getId();
        }

        CategoryExample categoryExample = new CategoryExample();
        if (includeGrandChild){
            categoryExample.createCriteria().andPidPathLike(pathPrefix+"%");
        }else {
            categoryExample.createCriteria().andPidPathEqualTo(pathPrefix);
        }

        List<Category> categoryList = categoryMapper.selectByExample(categoryExample);
        return categoryList;
    }

    /**
     * 根据categoryID 获取该分类下的子分类的Id列表
     * @param categoryId 分类id
     * @param includeGrandChild 是否获取孙子分类，true：获取儿子，孙子，重孙子。。。分类； false：只获取儿子分类，不获取孙子，重孙子。。。分类
     * @return
     */
    @Override
    public List<Integer> getSubCategoryIdListById(Integer categoryId, boolean includeGrandChild) {

        List<Category> categoryList = getSubCategoryById(categoryId, includeGrandChild);
        List<Integer> categoryIdList = new LinkedList<>();
        for (Category ele :
                categoryList) {
            categoryIdList.add(ele.getId());
        }
        return categoryIdList;
    }

    /**
     * 获取获取级别为 categoryLevel 的分类
     * @param categoryLevel 分类级别
     * @return
     */
    @Override
    public List<Category> getCategoryListByLevel(Integer categoryLevel) {

        CategoryExample categoryExample = new CategoryExample();
        categoryExample.createCriteria().andCategoryLevelEqualTo(categoryLevel);
        return categoryMapper.selectByExample(categoryExample);
    }

    /**
     * 获取获取级别为 categoryLevel 的分类 的数量
     *
     * @param categoryLevel 分类级别
     * @return
     */
    @Override
    public long countCategoryListByLevel(Integer categoryLevel) {

        CategoryExample categoryExample = new CategoryExample();
        categoryExample.createCriteria().andCategoryLevelEqualTo(categoryLevel);
        return categoryMapper.countByExample(categoryExample);
    }

    /**
     * 根据 ID 列表获取 分类列表
     *
     * @param idList ID列表
     * @return
     */
    @Override
    public List<Category> getCategoryByIdList(List<Integer> idList) {

        if( idList != null && idList.size() > 0 ){

            CategoryExample example = new CategoryExample();
            example.createCriteria().andIdIn(idList);
            return categoryMapper.selectByExample(example);
        }else {
            return null;
        }
    }

    /**
     * 根据 分类名 获取 分类列表
     *
     * @param categoryName 分类名
     * @return
     */
    @Override
    public List<Category> getCategoryByName(String categoryName) {

        CategoryExample categoryExample = new CategoryExample();
        categoryExample.createCriteria().andCategoryNameLike("%" + categoryName + "%");
        return categoryMapper.selectByExample(categoryExample);
    }
}
