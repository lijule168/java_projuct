package com.putao_seo.api.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ConfigurationProperties(prefix = "putao-seo.conf", ignoreUnknownFields = false)
@Component
public class PutaoSeoProperties {
	

	
	private String ip_regin_db_path = "data/ip2region.db";

	private Integer machine;
	
	
	
	
	public Integer getMachine() {
		return machine;
	}

	public void setMachine(Integer machine) {
		this.machine = machine;
	}

	public String getHw_merchantName() {
		return "北京葡萄智学科技有限公司";
	}



	public String getIp_regin_db_path() {
		return ip_regin_db_path;
	}

	public void setIp_regin_db_path(String ip_regin_db_path) {
		this.ip_regin_db_path = ip_regin_db_path;
	}



	
}