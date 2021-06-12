package com.putao_seo.api.utils;

import org.springframework.util.Assert;

import java.io.Serializable;


@SuppressWarnings({ "unchecked", "rawtypes" })
public class BizResult<T> implements Serializable  {
    private static final long serialVersionUID = 1L;
    private ResultEnum result;
    private String message;
    private T data;
    private Long count;

    public BizResult() {
    }

    public BizResult(T data) {
        this(ResultEnum.SUCCESS, data, (String)null);
    }

    public BizResult(ResultEnum result) {
        this(result, null, (String)null);
    }

    public BizResult(ResultEnum result, String message) {
        this(result,null, message);
    }

    public BizResult(ResultEnum result, T data, String message) {
        Assert.notNull(result, "ResultEnum must not be null");
        this.result = result;
        this.data = data;
        this.message = message;
    }

    public BizResult(ResultEnum result, T data, String message, Long count) {
        Assert.notNull(result, "ResultEnum must not be null");
        this.result = result;
        this.data = data;
        this.message = message;
        this.count = count;
    }
    
    //	成功   
	public static <T> BizResult<T> success() {
        return new BizResult(ResultEnum.SUCCESS);
    }
    
    //	不分页数据
    public static <T> BizResult<T> success(T data) {
        return new BizResult(data);
    }
    
    //	分页数据
    public static <T> BizResult<T> success(T data, long count) {
        return new BizResult(ResultEnum.SUCCESS, data, (String)null, count);
    }
    
    //	失败
    public static <T> BizResult<T> error() {
        return new BizResult(ResultEnum.ERROR);
    }
    
    //	失败+message
    public static <T> BizResult<T> error(String msg) {
        return new BizResult(ResultEnum.ERROR, msg);
    }

    public int getResultCode() {
        return this.result.getCode();
    }

    public boolean isSuccess() {
        return ResultEnum.SUCCESS.equals(this.result);
    }

    public boolean hasData() {
        return this.data != null;
    }

    @Override
    public String toString() {
        return "BizResult [result=" + this.result + ", message=" + this.message + ", data=" + this.data + ", count=" + this.count + "]";
    }

	public ResultEnum getResult() {
		return result;
	}

	public void setResult(ResultEnum result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
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
