package com.putao_seo.api.utils;

import java.text.NumberFormat;

public class CalculateProportionUtil {
	/**
     * 计算百分比 整数
     *
     * @param divisor
     * @param dividend
     * @return
     */
    public static String proportionInt(Integer divisor, Integer dividend) {
        if (dividend == null || divisor == null)
            return null;
        if(divisor == 0) {
        	return"0%";
        }
        NumberFormat numberFormat = NumberFormat.getInstance();
        // 设置精确到小数点后2位
        numberFormat.setMaximumFractionDigits(2);
        String result = numberFormat.format((float) divisor / (float) dividend * 100);
        return Math.round(Double.parseDouble(result)) + "%";
    }

}
