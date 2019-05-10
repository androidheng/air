package entity;

import java.io.Serializable;
import java.util.List;

/**
 * 用于向页面传递信息的类
 * @author jt
 *
 */
public class Result implements Serializable{
	
	private boolean success;
	private String message;
	private List data;
	public Result(boolean success, String message) {
		super();
		this.success=success;
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public List getData() {
		return data;
	}
	public void setData(List data) {
		this.data = data;
	}
	public Result(boolean success, List data) {
		super();
		this.success = success;
		this.data = data;
	}
	
}
