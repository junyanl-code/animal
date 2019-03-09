package neau.cekong.service;

import neau.cekong.pojo.TableProduct;

import java.util.Map;

public interface InsertProductService {
    Map<String, String> ins(TableProduct tableProduct);
}
