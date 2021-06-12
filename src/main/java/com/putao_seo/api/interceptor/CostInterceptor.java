package com.putao_seo.api.interceptor;

import com.putao_seo.api.utils.IPUtils;
import com.putao_seo.api.utils.PutaoObserverUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import static com.putao_seo.api.constants.CommonConstants.BEIJING_REGION_CODE;
import static com.putao_seo.api.constants.CommonConstants.DEFAULT_CITY;
import static com.putao_seo.api.constants.CommonConstants.SEO_REGION_MAP;

@Order(1)
public class CostInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(CostInterceptor.class);
    @Autowired
    IPUtils ipUtils;
    @Autowired
    @Qualifier("appStringRedisTemplate")
    StringRedisTemplate redis;

    // 1
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object arg2) throws IOException {
        //FIXME 放在这里么？
        String allParams = "";
        Map<String, String[]> paramsMap = req.getParameterMap();
        if (paramsMap != null) {
            for (Entry<String, String[]> entry : paramsMap.entrySet()) {
                allParams += entry.getKey() + ":";
                if (entry.getValue() != null) {
                    for (String value : entry.getValue()) {
                        allParams += value + "|";
                        if ("putaoid".equals(entry.getKey())) {
                            req.setAttribute("user_putao_id", value);
                        }
                    }
                }
                allParams += ";";
            }
        }
        logger.info("[URL]" + req.getRequestURI() + "[PARAMS]" + allParams);
        String city = ipUtils.getCityFromIP(req.getRemoteAddr());
        String regionCode = (String) redis.opsForHash().get(SEO_REGION_MAP, StringUtils.isEmpty(city) ? DEFAULT_CITY : city);
        req.setAttribute("regionCode", StringUtils.isEmpty(regionCode) ? BEIJING_REGION_CODE : regionCode);
        long begin_nao_time = System.nanoTime();
        req.setAttribute("begin_nao_time", begin_nao_time);
        req.setAttribute("req_uuid", UUID.randomUUID().toString());
        return true;
    }

    /*3*/
    @Override
    public void afterCompletion(HttpServletRequest req, HttpServletResponse resp, Object arg2, Exception arg3)
            throws Exception {
        long begin_nao_time = (Long) req.getAttribute("begin_nao_time");
        long interval = System.nanoTime() - begin_nao_time;
        Map<String, Object> logParams = new HashMap<>();
        logParams.put("cost", interval / 1000000);
        logParams.put("uri", req.getRequestURI());
//        logParams.put("putaoid", req.getAttribute("user_putao_id"));
        logParams.put("http_code", resp.getStatus());
        logParams.put("uuid", req.getAttribute("req_uuid"));
        logParams.put("ip", req.getRemoteAddr());
        logParams.put("city", ipUtils.getCityFromIP(req.getRemoteAddr()));

        logger.info(PutaoObserverUtils.genLog(logParams));
    }

    /* 2 */
    @Override
    public void postHandle(HttpServletRequest req, HttpServletResponse resp, Object arg2, ModelAndView arg3) throws Exception {
    }
}