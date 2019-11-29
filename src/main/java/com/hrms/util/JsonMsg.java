package com.hrms.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author GenshenWang.nomico
 * @date 2018/3/7.
 */
public class JsonMsg {

    private int code;
    private String msg;
    // map就是一个容器，主要调用put（）、get（）方法；
    private Map<String, Object> extendInfo = new HashMap<>();

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getExtendInfo() {
        return extendInfo;
    }

    public void setExtendInfo(Map<String, Object> extendInfo) {
        this.extendInfo = extendInfo;
    }
    
    // 静态方法，别人调用不需要声明
    public static JsonMsg success(){
        JsonMsg res = new JsonMsg();
        res.setCode(100);
        res.setMsg("操作成功！");
        return res;
    }

    public static JsonMsg fail(){
        JsonMsg res = new JsonMsg();
        res.setCode(200);
        res.setMsg("操作失败！");
        return res;
    }
    
    // 需要实例化才能调用
    public JsonMsg addInfo(String key, Object obj){
        this.extendInfo.put(key, obj);
        return this; 	// 返回JsonMsg
    }

}
