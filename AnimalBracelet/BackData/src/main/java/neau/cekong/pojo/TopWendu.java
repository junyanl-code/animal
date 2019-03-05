package neau.cekong.pojo;

import java.util.LinkedList;
import java.util.List;

public class TopWendu {
    private List<String> time = new LinkedList<>();

    private List<Double> wendu = new LinkedList<>();

    private List<Long> productId = new LinkedList<>();

	public List<String> getTime() {
		return time;
	}

	public void setTime(List<String> time) {
		this.time = time;
	}

	public List<Double> getWendu() {
		return wendu;
	}

	public void setWendu(List<Double> wendu) {
		this.wendu = wendu;
	}

	public List<Long> getProductId() {
		return productId;
	}

	public void setProductId(List<Long> productId) {
		this.productId = productId;
	}
}
