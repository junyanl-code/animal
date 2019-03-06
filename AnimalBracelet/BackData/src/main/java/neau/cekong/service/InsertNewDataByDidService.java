package neau.cekong.service;

import neau.cekong.pojo.TableBushu;
import neau.cekong.pojo.TableWendu;
import neau.cekong.pojo.TableZishi;

public interface InsertNewDataByDidService {
	public Object insertInto(TableBushu pro);

	public Object insertInto(TableWendu pro);

	public Object insertInto(TableZishi pro);
}
