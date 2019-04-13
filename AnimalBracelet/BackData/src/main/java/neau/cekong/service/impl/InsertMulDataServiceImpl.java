package neau.cekong.service.impl;

import jdk.nashorn.internal.ir.ContinueNode;
import neau.cekong.pojo.TableBushu;
import neau.cekong.pojo.TableWendu;
import neau.cekong.pojo.TableZishi;
import neau.cekong.service.InserZishiByParaService;
import neau.cekong.service.InsertMulDataService;
import neau.cekong.service.InsertNewDataByDidService;
import neau.cekong.utils.JsonTranstor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InsertMulDataServiceImpl implements InsertMulDataService {

    private JsonTranstor json = new JsonTranstor();

    @Resource
    private InsertNewDataByDidService insertNewDataByDidService;

    @Resource
    private InserZishiByParaService inserZishiByParaService;

    @Override
    // 参数示例： [{'productId':'01','step':'7000','temp':'31.5','posture':'1'},{'productId':'02','step':'8000','temp':'37.5','posture':'2'}]
    // 5段特殊字符 需要URLencode
    // %5b%7b%27productId%27%3a%2701%27%2c%27step%27%3a%277000%27%2c%27temp%27%3a%2731.5%27%2c%27posture%27%3a%271%27%7d%2c%7b%27productId%27%3a%2702%27%2c%27step%27%3a%278000%27%2c%27temp%27%3a%2737.5%27%2c%27posture%27%3a%272%27%7d%5d
    public Map<String, String> insData(String dataArr) {
        // 各数据缓存对象
        TableWendu temp = new TableWendu();
        TableBushu step = new TableBushu();
        TableZishi posture = new TableZishi();

        Map<String, String> result = new HashMap<>();

        // 设置时间
        Date date = new Date();
        temp.setTime(date);
        step.setTime(date);
        posture.setTime(date);

        // 将json字符串传化为Map列表
        dataArr = json.selfToJson(dataArr);
        List<Map<String, String>> dataList = json.transToList(dataArr);

        // 遍历List
        for (Map<String, String> data : dataList) {

            if (data == null) continue;

            // 设置产品id
            Long productId = Long.parseLong(data.get("productId"));
            temp.setProductId(productId);
            step.setProductId(productId);
            posture.setProductId(productId);

            // 将数据存入对象以便插入
            temp.setWendu(Double.parseDouble(data.get("temp")));
            step.setBushu(Long.parseLong(data.get("step")));
            // -- 姿态的处理在InserZishiByParaService中进行

            // 插入数据
            insertNewDataByDidService.insertInto(temp);
            insertNewDataByDidService.insertInto(step);
            inserZishiByParaService.insertInto(posture, Integer.parseInt(data.get("posture")));
        }

        // 返回值
        result.put("stat", "200");
        result.put("msg", "插入成功");

        return result;
    }
}
