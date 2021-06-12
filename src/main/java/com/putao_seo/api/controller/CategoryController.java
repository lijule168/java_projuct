package com.putao_seo.api.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.putao_seo.api.entity.Category;
import com.putao_seo.api.service.CategoryService;
import com.putao_seo.api.utils.BaseBizResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static com.putao_seo.api.constants.CommonConstants.DEFAULT_CATEGORY_LEVEL;

/**
 * @author : tangtonglong
 * 2019/5/15 18:55
 * @return
 */
@Api("swaggerDemoController相关的api")
@CrossOrigin(origins = "*", maxAge = 3600) //支持跨域
@RestController
@RequestMapping(value = "/category", produces = {"application/json;charset=UTF-8"})
public class CategoryController {

    @Autowired
    CategoryService categoryService;


    @GetMapping(value = "/testpage")
    public PageInfo select(){
        PageHelper.startPage(1 , 3);
        List<Category> categoryList = categoryService.getCategoryByName("学习乐园");
        //得到分页的结果对象
        PageInfo<Category> personPageInfo = new PageInfo<>(categoryList);
        //得到分页中的person条目对象

        return personPageInfo;
    }

    /**
     * 根据分类id获取该分类下的子分类（不包含孙子，重孙子 分类）
     * @param categoryId 分类id
     * @param pageNum 页码
     * @param pageSize 页大小
     * @return
     */
    @ApiOperation(value = "根据分类id获取该分类下的子分类", notes = "根据分类id获取该分类下的子分类（不包含孙子，重孙子 分类）")
    @ApiImplicitParam(name = "categoryId", value = "分类id", paramType = "path", required = true, dataType = "int")
    @GetMapping(value = "/sublist/{categoryId}")
    public BaseBizResult<List<Category>> getCategoryList(@PathVariable(value = "categoryId")Integer categoryId,
                                                                 @RequestParam(name = "pageNum",required = false,defaultValue = "1")Integer pageNum,
                                                                 @RequestParam(name = "pageSize",required = false,defaultValue = "10")Integer pageSize){
        try {
            List<Category> categoryList = categoryService.getSubCategoryById(categoryId, false);
            return BaseBizResult.success(categoryList);
        }catch (Exception e){
            return BaseBizResult.error(e.getMessage());
        }
    }

    /**
     * TODO 当level为2 时，没有根据父类分类，需要修改
     * 根据分类级别获取该分类下的子分类（不包含孙子，重孙子 分类）
     * @param categoryLevel 分类级别
     * @return
     */
    @ApiOperation(value = "根据分类级别获取该分类下的子分类", notes = "（不包含孙子，重孙子 分类）")
    @ApiImplicitParam(name = "categoryLevel", value = "分类级别", required = false, dataType = "Integer")
    @GetMapping(value = "/list")
    public BaseBizResult<Map<String,Object>> getCategoryListV1(@RequestParam(value = "categoryLevel",required = false)Integer categoryLevel){
        try {
            Map<String,Object> map = new HashMap<>();
            List<Category> categoryList = new LinkedList<>();
            long count = 0;
            if (categoryLevel == null){
                categoryList = categoryService.getCategoryListByLevel(DEFAULT_CATEGORY_LEVEL);
                count = categoryService.countCategoryListByLevel(DEFAULT_CATEGORY_LEVEL);
            }else {
                categoryList = categoryService.getCategoryListByLevel(categoryLevel);
                count = categoryService.countCategoryListByLevel(categoryLevel);
            }
            for (Category ele:categoryList){
                List<Category> subCategoryList = categoryService.getSubCategoryById(ele.getId(), false);
//                if (subCategoryList == null || subCategoryList.size() == 0){
//                    categoryList.remove(ele);
//                }else {
                    ele.setSubCategory(subCategoryList);
//                }
            }
            map.put("list",categoryList);
            map.put("count",count);

            return BaseBizResult.success(map);
        }catch (Exception e){
            return BaseBizResult.error(e.getMessage());
        }
    }


}
