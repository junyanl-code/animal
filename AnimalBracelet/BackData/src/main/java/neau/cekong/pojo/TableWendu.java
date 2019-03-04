package neau.cekong.pojo;

import java.util.Date;

public class TableWendu {
    private Integer id;

    private Date time;

    private Double wendu;

    private Long productId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Double getWendu() {
        return wendu;
    }

    public void setWendu(Double wendu) {
        this.wendu = wendu;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}