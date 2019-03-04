package neau.cekong.pojo;

import java.util.Date;

public class TableZishi {
    private Long id;

    private Date time;

    private Double zhan;

    private Long productId;

    private Double ce;

    private Double tang;

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

    public Double getZhan() {
        return zhan;
    }

    public void setZhan(Double zhan) {
        this.zhan = zhan;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Double getCe() {
        return ce;
    }

    public void setCe(Double ce) {
        this.ce = ce;
    }

    public Double getTang() {
        return tang;
    }

    public void setTang(Double tang) {
        this.tang = tang;
    }
}