package com.putao_seo.api.constants;

import org.springframework.data.elasticsearch.annotations.Document;

import java.time.format.DateTimeFormatter;

/**
 * @author : tangtonglong
 * 2019/5/16 17:25
 * @return
 */
public class CommonConstants {

    //TODO 改成 枚举

    /**
     * 文章热门点击 hot:click:article:月份
     */
    public static final String ARTICLE_HOT_CLICK_PREFIX = "hot:click:article";

    /**
     * 店铺热门点击 hot:click:shop:月份
     */
    public static final String SHOP_HOT_CLICK_PREFIX = "hot:click:shop";

    /**
     * 默认页码
     */
    public static final Integer DEFAULT_PAGE_NUM = 1;

    
    /**
     * 默认页大小
     */
    public static final Integer DEFAULT_PAGE_SIZE = 10;

    
    /**
     * 默认推荐页大小
     */
    public static final Integer RECOMMEND_ARTICLE_SIZE = 5;

    
    /**
     * 默认分类级别
     */
    public static final Integer DEFAULT_CATEGORY_LEVEL = 1;


    /**
     *     城市:code
     *     例如 北京市:2
     */
    public static final String SEO_REGION_MAP = "seo:region";

    
    /**
     * 城市转换失败时，默认城市
     */
    public static final String DEFAULT_CITY = "北京市";

    
    /**
     * 北京的regionCode
     */
    public static final String BEIJING_REGION_CODE = "2";

    
    /**
     * 地区级别1
     */
    public static final Integer REGION_LEVEL_ONE = 1;

    //评论类别

     
    /**
     * 所有评论，默认的
     */
    public static final String COMMENT_TYPE_ALL = "all";

     
    /**
     * 带图片的评论
     */
    public static final String COMMENT_TYPE_PIC = "pic";


    
    /**
     * 好评
     */
    public static final String COMMENT_TYPE_GOOD = "good";
    
     
    /**
     * 大于40个星算是好评
     */
    public static final Integer COMMENT_GOOD_STAR = 40;

    /**
     * 中评
     */
    public static final String COMMENT_TYPE_MIDDLE = "middle";
     
    /**
     * 大于20星，小于40星算是中评
     */
    public static final Integer COMMENT_MIDDLE_STAR = 20;

     
    /**
     * 差评
     */
    public static final String COMMENT_TYPE_BAD = "bad";

    
    /**
     *  redis缓存默认的ttl（秒）
     */
    public static final int REDIS_CACHE_TTL = 600;

    /**
     * 热门资料 hotMaterial
     */
    public static final String HOTMATERIAL = "学习乐园";

    /**
     * 热门问答 hotQuestion
     */
    public static final String HOTQUESTION = "热门问答";

    /**
     * es中artilce表的index
     */
    public static final String ARTICLE_INDEX = "mysqlsearch-article";

    /**
     * es中artilce表的type
     */
    public static final String ARTICLE_TYPE = "mysqlsearch";

}
