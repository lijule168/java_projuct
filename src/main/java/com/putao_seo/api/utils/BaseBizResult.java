package com.putao_seo.api.utils;

import java.io.Serializable;


@SuppressWarnings({ "unchecked", "rawtypes" })
public class BaseBizResult<T> implements Serializable {

    private static final long serialVersionUID = -3205807195727928530L;
    private Integer code;
    private String msg;
    private T data;
    private Long count;

    public BaseBizResult() {
    }

    public BaseBizResult(T data) {
        this(BaseResultCode.SUCCESS, data, (String)null);
    }

    public BaseBizResult(Integer code) {
        this(code, null, (String)null);
    }

    public BaseBizResult(Integer code, String msg) {
        this(code,null, msg);
    }

    public BaseBizResult(Integer code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public BaseBizResult(Integer code, T data, String msg, Long count) {
        this.code = code;
        this.data = data;
        this.msg = msg;
        this.count = count;
    }
    
    //	成功   
	public static <T> BaseBizResult<T> success() {
        return new BaseBizResult(BaseResultCode.SUCCESS);
    }
    
    //	不分页数据
    public static <T> BaseBizResult<T> success(T data) {
        return new BaseBizResult(data);
    }
    
    //	分页数据
    public static <T> BaseBizResult<T> success(T data, long count) {
        return new BaseBizResult(BaseResultCode.SUCCESS, data, (String)null, count);
    }
    
    //	失败
    public static <T> BaseBizResult<T> error() {
        return new BaseBizResult(BaseResultCode.ERROR);
    }
    
    //	失败+message
    public static <T> BaseBizResult<T> error(String msg) {
        return new BaseBizResult(BaseResultCode.ERROR, msg);
    }
    //	失败+message
    public static <T> BaseBizResult<T> error(Integer code ,String msg) {
        return new BaseBizResult(code, msg);
    }

   

    public boolean hasData() {
        return this.data != null;
    }

    @Override
    public String toString() {
        return "BizResult [code=" + this.code + ", msg=" + this.msg + ", data=" + this.data + ", count=" + this.count + "]";
    }

	

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}
    
}
