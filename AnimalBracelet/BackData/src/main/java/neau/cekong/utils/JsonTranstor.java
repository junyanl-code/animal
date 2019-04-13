package neau.cekong.utils;

import com.google.gson.Gson;

import java.util.*;


public class JsonTranstor {
    public static void main(String[] args) {
        String message = "[{'productId':'01','step':'7000','temp':'31.5','posture':'1'},{'productId':'02','step':'8000','temp':'37.5','posture':'2'}]";
        String selfMess = "(pid-01/step-7000/temp-31.5/pos-1)(pid-02/step-8000/temp-37.5/pos-2)";
        JsonTranstor transtor = new JsonTranstor();
        message = transtor.selfToJson(selfMess);
        System.out.println(message);
        List<Map<String, String>> trans = transtor.transToList(message);
        System.out.println(trans.get(0).get("step"));
        System.out.println(trans);
    }

    public List<Map<String, String>> transToList(String json) {
        Gson gson = new Gson();

        ArrayList list = gson.fromJson(json, new ArrayList<HashMap<String, String>>().getClass());

        return list;
    }

    // 自定义格式：(pid-01/step-7000/temp-31.5/pos-1)(pid-02/step-8000/temp-37.5/pos-2)
    public String selfToJson(String self) {
        LinkedHashMap<String, String> paraMap = new LinkedHashMap<>();
        paraMap.put("pid-", "'productId':'");
        paraMap.put("step-", "'step':'");
        paraMap.put("temp-", "'temp':'");
        paraMap.put("pos-", "'posture':'");

        paraMap.put("/", "',");
        paraMap.put("(", "{");
        paraMap.put(")", "'},");

        String left = "[";
        String right = "]";

        Set<String> keySet = paraMap.keySet();

        for (String key : keySet) {
            self = self.replace(key, paraMap.get(key));
        }

        return left + self + right;
    }


}
//
//class Data {
//    private long productId;
//    private long step;
//    private double temp;
//    private int posture;
//
//    public long getProductId() {
//        return productId;
//    }
//
//    public void setProductId(long productId) {
//        this.productId = productId;
//    }
//
//    public long getStep() {
//        return step;
//    }
//
//    public void setStep(long step) {
//        this.step = step;
//    }
//
//    public double getTemp() {
//        return temp;
//    }
//
//    public void setTemp(double temp) {
//        this.temp = temp;
//    }
//
//    public int getPosture() {
//        return posture;
//    }
//
//    public void setPosture(int posture) {
//        this.posture = posture;
//    }
//
//    @Override
//    public String toString() {
//        return "Data [productId=" + productId + ", step=" + step + ", temp=" + temp + ", posture=" + posture + "]";
//    }
//
//}
