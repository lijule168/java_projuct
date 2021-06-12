package com.putao_seo.api.errors;

import java.util.UUID;

public class ApplicationError {
		private String id;
	    private String status;
	    private String code;


	    public ApplicationError(String status, String code) {
	        this.id = UUID.randomUUID().toString();
	        this.status = status;
	        this.code = code;
	    }


	    public String getId() {
	        return id;
	    }

	    public void setId(String id) {
	        this.id = id;
	    }

	    public String getStatus() {
	        return status;
	    }

	    public void setStatus(String status) {
	        this.status = status;
	    }

	    public String getCode() {
	        return code;
	    }

	    public void setCode(String code) {
	        this.code = code;
	    }
	}