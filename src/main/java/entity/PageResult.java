package entity;

import java.io.Serializable;
import java.util.List;

/**
 * 分页返回的实体类
 * @author jt
 *
 */
public class PageResult implements Serializable{
	private long total; // 总记录数
	private int code;
	private String msg;
	private long count;
	private List data; // 返回每页的数据的集合
	
	public PageResult(long total, List data) {
		super();
		this.total = total;
		this.data = data;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List getRows() {
		return data;
	}
	public void setRows(List rows) {
		this.data = rows;
	}
	public PageResult(int code, String msg, long count, List data) {
		super();
		this.code = code;
		this.msg = msg;
		this.count = count;
		this.data = data;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	public List getData() {
		return data;
	}
	public void setData(List data) {
		this.data = data;
	}
	public PageResult() {
		super();
	}
	
}
