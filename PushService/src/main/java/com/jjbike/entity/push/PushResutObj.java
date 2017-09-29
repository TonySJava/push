package com.jjbike.entity.push;

/**
 * Created by Administrator on 2017/7/13 0013.
 */
public class PushResutObj {
    /**
     * 信息总数
     */
    private String msgTotal;
    /**
     * 该taskId对应的结果
     */
    private String result;
    /**
     * 总点击数
     */
    private int clickNum;
    /**
     * 推送数量
     */
    private int pushNum;
    /**
     * 个推下发列表
     */
    private PushResultGT GT;
    private String taskId;
    private int msgProcess;

    public PushResutObj() {
    }

    public PushResutObj(String msgTotal, String result, int clickNum, int pushNum, PushResultGT GT, String taskId, int msgProcess) {
        this.msgTotal = msgTotal;
        this.result = result;
        this.clickNum = clickNum;
        this.pushNum = pushNum;
        this.GT = GT;
        this.taskId = taskId;
        this.msgProcess = msgProcess;
    }

    public String getMagTotal() {
        return msgTotal;
    }

    public void setMagTotal(String magTotal) {
        this.msgTotal = magTotal;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getClickNum() {
        return clickNum;
    }

    public void setClickNum(int clickNum) {
        this.clickNum = clickNum;
    }

    public int getPushNum() {
        return pushNum;
    }

    public void setPushNum(int pushNum) {
        this.pushNum = pushNum;
    }

    public PushResultGT getGT() {
        return GT;
    }

    public void setGT(PushResultGT GT) {
        this.GT = GT;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public int getMsgProcess() {
        return msgProcess;
    }

    public void setMsgProcess(int msgProcess) {
        this.msgProcess = msgProcess;
    }

    @Override
    public String toString() {
        return "PushResutObj{" +
                "msgTotal='" + msgTotal + '\'' +
                ", result='" + result + '\'' +
                ", clickNum=" + clickNum +
                ", pushNum=" + pushNum +
                ", GT=" + GT +
                ", taskId='" + taskId + '\'' +
                ", msgProcess=" + msgProcess +
                '}';
    }
}
