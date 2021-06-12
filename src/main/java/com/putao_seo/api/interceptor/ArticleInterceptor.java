package com.putao_seo.api.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.time.LocalDate;

import static com.putao_seo.api.constants.CommonConstants.ARTICLE_HOT_CLICK_PREFIX;

/**
 * @author : tangtonglong
 * 2019/6/5 13:28
 * @return
 */
@Order(2)
public class ArticleInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(ArticleInterceptor.class);

    @Autowired
    @Qualifier("appStringRedisTemplate")
    StringRedisTemplate appRedis;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            String uri = request.getRequestURI();
            String[] pathArr = uri.split("/");
            String articleId = pathArr[pathArr.length-1];
            LocalDate localDate = LocalDate.now();
            String hot_click_key = ARTICLE_HOT_CLICK_PREFIX + ":" + localDate.getYear()+":"+localDate.getMonthValue();
            appRedis.opsForZSet().incrementScore(hot_click_key, articleId,1);
        }catch (Exception e){
            e.printStackTrace();
        }
        return true;
    }
}
