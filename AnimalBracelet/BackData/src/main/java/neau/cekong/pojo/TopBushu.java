package neau.cekong.pojo;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class TopBushu {
	// {"categories":["2019/3/1","2019/2/25","2019/2/27","2019/2/26","2019/2/2","2019/2/25","2019/2/25","2019/3/1","2019/2/23","2019/2/23"],"data":[7296,7896,15236,9796,8296,7896,7896,8888,10253,66666]}
	List<String> categories = new LinkedList<String>();
	List<Long> data = new LinkedList<Long>();;

	public List<String> getCategories() {
		return categories;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}

	public List<Long> getData() {
		return data;
	}

	public void setData(List<Long> data) {
		this.data = data;
	}
}
