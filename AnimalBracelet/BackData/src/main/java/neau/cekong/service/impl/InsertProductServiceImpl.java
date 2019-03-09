package neau.cekong.service.impl;

import neau.cekong.mapper.TableProductMapper;
import neau.cekong.pojo.TableProduct;
import neau.cekong.service.InsertProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class InsertProductServiceImpl implements InsertProductService {

    @Resource
    TableProductMapper tableProductMapper;

    @Override
    public Map<String, String> ins(TableProduct tableProduct) {
        try {
            int result = tableProductMapper.insert(tableProduct);
            if (result == 0) throw new Exception("插入失败");
            Map<String, String> rm = new HashMap<>();
            rm.put("stat", "OK");
            rm.put("msg", "写入成功");
            return rm;
        } catch (Exception e) {
            e.printStackTrace();
        }
        Map<String, String> rm = new HashMap<>();
        rm.put("stat", "ERR");
        return rm;
    }
}