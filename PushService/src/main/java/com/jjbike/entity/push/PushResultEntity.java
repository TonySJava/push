package com.jjbike.entity.push;

import java.util.List;

/**
 * Created by Administrator on 2017/7/13 0013.
 */
public class PushResultEntity {
    private String result;
    private List<PushResutObj> resultList;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<PushResutObj> getResultList() {
        return resultList;
    }

    public void setResultList(List<PushResutObj> resultList) {
        this.resultList = resultList;
    }

    @Override
    public String toString() {
        return "PushResultEntity{" +
                "result='" + result + '\'' +
                ", resultList=" + resultList +
                '}';
    }
}
