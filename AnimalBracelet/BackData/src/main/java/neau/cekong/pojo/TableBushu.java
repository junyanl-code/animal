package neau.cekong.pojo;

import java.util.Date;

public class TableBushu {
    private Long id;

    private Date time;

    private Long bushu;

    private Long productId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Long getBushu() {
        return bushu;
    }

    public void setBushu(Long bushu) {
        this.bushu = bushu;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}