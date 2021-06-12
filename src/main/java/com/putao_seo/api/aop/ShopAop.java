package com.putao_seo.api.aop;

import com.putao_seo.api.entity.ShopDetail;
import com.putao_seo.api.utils.BaseBizResult;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.Map;

import static com.putao_seo.api.constants.CommonConstants.ARTICLE_HOT_CLICK_PREFIX;
import static com.putao_seo.api.constants.CommonConstants.SHOP_HOT_CLICK_PREFIX;

/**
 * @author : tangtonglong
 * 2019/6/19 17:10
 * @return
 */
@Aspect
@Component
public class ShopAop {

    private static final Logger logger = LoggerFactory.getLogger(ShopAop.class);

    @Autowired
    @Qualifier("appStringRedisTemplate")
    StringRedisTemplate appRedis;

    /**
     * 用于区域店铺热门点击
     * 每次查询店铺详情成功后（该店铺的评论数要大于0）该店铺的点击数+1
     * eg: 2019年8月12日 查询了店铺id为 24846206 的店铺的详情，店铺region为：2_r17
     * 那么： redis中  hot:click:shop:2019:8:2, hot:click:shop:2019:8:2:r17  这两个zset中 24846206的分数 +1
     * @param result
     */
    @AfterReturning(value = "execution(* com.putao_seo.api.controller.ShopController.queryDetail(..))", returning = "result")
    public void afterReturning(Object result) {
        Map rvtMap = (Map) ((BaseBizResult) result).getData();
        ShopDetail shopDetail = (ShopDetail) rvtMap.get("shopdetail");
        if (shopDetail != null && shopDetail.getShopCommentCount() != null && Integer.valueOf(shopDetail.getShopCommentCount()) > 0){
            if ( !StringUtils.isEmpty(shopDetail.getShopRegion()) ){
                LocalDate localDate = LocalDate.now();
                String key_prefix = SHOP_HOT_CLICK_PREFIX + ":" + localDate.getYear()+":"+localDate.getMonthValue();

                String tmpRegion = shopDetail.getShopRegion().replace("_", ":") + ":";
                int index = tmpRegion.lastIndexOf(":");
                while (index > 0){
                    tmpRegion = tmpRegion.substring(0, index);
                    index = tmpRegion.lastIndexOf(":");
                    String key = key_prefix + ":" + tmpRegion;
                    appRedis.opsForZSet().incrementScore(key, String.valueOf(shopDetail.getShopId()),1);
                }
            }
        }

    }
}
