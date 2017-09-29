package com.jjbike.entity.push;

public class PushGroupUserInfo {
    //推送组Id
    private String pushGroupId;
    //推送Id
    private String pushInfoId;
    //删除标签(0:整除，1:删除)
    private Integer delFlag;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"pushGroupId\":\"")
                .append(pushGroupId).append('\"');
        sb.append(",\"pushInfoId\":\"")
                .append(pushInfoId).append('\"');
        sb.append(",\"delFlag\":")
                .append(delFlag);
        sb.append('}');
        return sb.toString();
    }

    public String getPushGroupId() {
        return pushGroupId;
    }

    public void setPushGroupId(String pushGroupId) {
        this.pushGroupId = pushGroupId;
    }

    public String getPushInfoId() {
        return pushInfoId;
    }

    public void setPushInfoId(String pushInfoId) {
        this.pushInfoId = pushInfoId;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }
}
