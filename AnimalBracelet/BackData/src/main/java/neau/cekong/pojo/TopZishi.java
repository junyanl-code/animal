package neau.cekong.pojo;

import java.util.LinkedList;
import java.util.List;

public class TopZishi {
	private List<Long> id = new LinkedList<Long>();

	private List<String> time = new LinkedList<String>();

	private List<Double> zhan = new LinkedList<Double>();

	private List<Long> productId = new LinkedList<Long>();

	private List<Double> ce = new LinkedList<Double>();

	private List<Double> tang = new LinkedList<Double>();

	public List<Long> getId() {
		return id;
	}

	public void setId(List<Long> id) {
		this.id = id;
	}

	public List<String> getTime() {
		return time;
	}

	public void setTime(List<String> time) {
		this.time = time;
	}

	public List<Double> getZhan() {
		return zhan;
	}

	public void setZhan(List<Double> zhan) {
		this.zhan = zhan;
	}

	public List<Long> getProductId() {
		return productId;
	}

	public void setProductId(List<Long> productId) {
		this.productId = productId;
	}

	public List<Double> getCe() {
		return ce;
	}

	public void setCe(List<Double> ce) {
		this.ce = ce;
	}

	public List<Double> getTang() {
		return tang;
	}

	public void setTang(List<Double> tang) {
		this.tang = tang;
	}
}
