package com.jjbike.entity.push;

/**
 * Created by Administrator on 2017/7/13 0013.
 */
public class PushResultGT {
    /**
     * 到达数
     */
    private int feedback;
    /**
     * 展示数
     */
    private int displayed;
    /**
     * 返回结果
     */
    private String result;
    /**
     *  发送成功数
     */
    private int sent;
    /**
     * 点击数
     */
    private int clicked;

    public PushResultGT() {
    }

    public PushResultGT(int feedback, int displayed, String result, int sent, int clicked) {
        this.feedback = feedback;
        this.displayed = displayed;
        this.result = result;
        this.sent = sent;
        this.clicked = clicked;
    }

    @Override
    public String toString() {
        return "PushResultGT{" +
                "feedback=" + feedback +
                ", displayed=" + displayed +
                ", result='" + result + '\'' +
                ", sent=" + sent +
                ", clicked=" + clicked +
                '}';
    }
}
