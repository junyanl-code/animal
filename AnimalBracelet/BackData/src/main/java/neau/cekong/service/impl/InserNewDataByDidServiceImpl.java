package neau.cekong.service.impl;

import neau.cekong.mapper.TableBushuMapper;
import neau.cekong.mapper.TableWenduMapper;
import neau.cekong.mapper.TableZishiMapper;
import neau.cekong.pojo.TableBushu;
import neau.cekong.pojo.TableWendu;
import neau.cekong.pojo.TableZishi;
import neau.cekong.service.InserZishiByParaService;
import neau.cekong.service.InsertNewDataByDidService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class InserNewDataByDidServiceImpl implements InsertNewDataByDidService, InserZishiByParaService {
    @Resource
    TableBushuMapper tableBushuMapper;
    @Resource
    TableWenduMapper tableWenduMapper;
    @Resource
    TableZishiMapper tableZishiMapper;

    @Override
    public Object insertInto(TableBushu record) {
        // 获取最新数据
        List<TableBushu> topList = tableBushuMapper.getTopData(1, record.getProductId());
        TableBushu topData = null;
        if (topList != null && !topList.isEmpty()) topData = topList.get(0);//防空
        else return tableBushuMapper.insertSelective(record);// 直接插入

        // 检查是否是同一天 更新/插入
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String topDay = format.format(topData.getTime());
        String nowDay = format.format(record.getTime());
        if (nowDay.equals(topDay)) {
            record.setId(topData.getId());
            return tableBushuMapper.updateByPrimaryKey(record);
        } else
            return tableBushuMapper.insertSelective(record);
    }

    @Override
    public Object insertInto(TableWendu record) {
        System.out.println("Service:" + record.getProductId() + " " + record.getWendu());
        return tableWenduMapper.insertSelective(record);
    }

    @Override
    public Object insertInto(TableZishi record) {
        return tableZishiMapper.insertSelective(record);
    }


    @Override
    public Object insertInto(TableZishi record, int para) {
        // 检查时间
        if (record.getTime() == null) record.setTime(new Date());

        // 获取最新数据
        List<TableZishi> topList = tableZishiMapper.getTopData(1, record.getProductId());
        TableZishi topData = null;
        if (topList != null && !topList.isEmpty()) topData = topList.get(0);
        else topData = record;// 避免无数据

        // 检查是否是同一天 更新/插入
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String topDay = format.format(topData.getTime());
        String nowDay = format.format(record.getTime());
        if (topDay.equals(nowDay)) tableZishiMapper.deleteByPrimaryKey(topData.getId());
        else {
            topData = new TableZishi();
            try {
                Date date0 = format.parse(nowDay);
                topData.setTime(date0);// 00:00
            } catch (ParseException px) {
                px.printStackTrace();
            }
        }

        // 更新参数
        Double timeInc = (record.getTime().getTime() - topData.getTime().getTime()) / (60 * 60 * 1000.0);
        timeInc = Math.round(timeInc * 100) / 100.0;
        switch (para) {
            case 1:
                topData.setZhan(topData.getZhan() + timeInc);
                break;
            case 2:
                topData.setCe(topData.getCe() + timeInc);
                break;
            case 3:
                topData.setTang(topData.getTang() + timeInc);
                break;
        }

        // 复制参数
        record.setZhan(topData.getZhan());
        record.setCe(topData.getCe());
        record.setTang(topData.getTang());

        // 向数据库更新最新条
        return tableZishiMapper.insertSelective(record);
    }
}
