package com.putao_seo.api.utils;

import com.putao_seo.api.conf.PutaoSeoProperties;
import com.putao_seo.api.controller.ShopController;
import org.lionsoul.ip2region.DataBlock;
import org.lionsoul.ip2region.DbConfig;
import org.lionsoul.ip2region.DbSearcher;
import org.lionsoul.ip2region.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Component
public class IPUtils {
	private static Logger logger = LoggerFactory.getLogger(IPUtils.class);
	public static DbSearcher searcher;

	@Autowired
	PutaoSeoProperties porperties;

	@PostConstruct
	public void init() {
		// path = porperties.getWx_officialaccount_appid();
		try {
			DbConfig config = new DbConfig();
			searcher = new DbSearcher(config, porperties.getIp_regin_db_path());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getCityFromIP(String ip) {
		try {
			DataBlock dataBlock = null;
			if (Util.isIpAddress(ip) == false) {
				System.out.println("Error: Invalid ip address");
			} else {
				dataBlock = searcher.btreeSearch(ip);
				logger.info(dataBlock.getRegion());
				return dataBlock.getRegion().split("\\|")[3];
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

}
