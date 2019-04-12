package neau.cekong.service;

import neau.cekong.pojo.TableZishi;

public interface InserZishiByParaService {
    // 1:站 2:侧 3:躺
    Object insertInto(TableZishi pro, int para);
}
