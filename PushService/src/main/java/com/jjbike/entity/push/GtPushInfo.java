package com.jjbike.entity.push;

import java.util.List;
import java.util.Map;

public class GtPushInfo {
    //cid
    private String cId;
    //个推appkey
    private String appKey;
    //个推appid
    private String appId;
    //个推masterSecret
    private String masterSecret;
    //跳转url
    private String url;
    //通知标题
    private String title;
    //通知内容
    private String text;
    //城市代码
    private List<String> areaNos;
    //自定义内容
    private Map<String,Object> customContent;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"cId\":\"")
                .append(cId).append('\"');
        sb.append(",\"appKey\":\"")
                .append(appKey).append('\"');
        sb.append(",\"appId\":\"")
                .append(appId).append('\"');
        sb.append(",\"masterSecret\":\"")
                .append(masterSecret).append('\"');
        sb.append(",\"url\":\"")
                .append(url).append('\"');
        sb.append(",\"title\":\"")
                .append(title).append('\"');
        sb.append(",\"text\":\"")
                .append(text).append('\"');
        sb.append(",\"areaNos\":")
                .append(areaNos);
        sb.append(",\"customContent\":")
                .append(customContent);
        sb.append('}');
        return sb.toString();
    }

    public Map<String, Object> getMap() {
        return customContent;
    }

    public void setMap(Map<String, Object> customContent) {
        this.customContent = customContent;
    }

    public List<String> getAreaNos() {
        return areaNos;
    }

    public void setAreaNos(List<String> areaNos) {
        this.areaNos = areaNos;
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getMasterSecret() {
        return masterSecret;
    }

    public void setMasterSecret(String masterSecret) {
        this.masterSecret = masterSecret;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
