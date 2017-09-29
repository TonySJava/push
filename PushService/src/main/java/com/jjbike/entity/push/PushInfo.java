package com.jjbike.entity.push;

import java.util.Date;


public class PushInfo {

    /**
     * 推送类
     */
    // 推送ID
    private String id;

    // 用户ID
    private String userId;

    // Android设备号
    private String deviceToken;

    // 添加时间
    private Date addtime;

    // 用户标签
    private String userTag;

    // 删除标签
    private Integer delFlag;

    //create_by创建者
    private String creator;

    //create_date创建时间
    private Date createDate;

    //update_by更新者
    private String updater;

    //update_date更新时间
    private Date updateDate;

    //组名
    private String groupName;

    //组标签
    private String groupTag;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":\"")
                .append(id).append('\"');
        sb.append(",\"userId\":\"")
                .append(userId).append('\"');
        sb.append(",\"deviceToken\":\"")
                .append(deviceToken).append('\"');
        sb.append(",\"addtime\":\"")
                .append(addtime).append('\"');
        sb.append(",\"userTag\":\"")
                .append(userTag).append('\"');
        sb.append(",\"delFlag\":")
                .append(delFlag);
        sb.append(",\"creator\":\"")
                .append(creator).append('\"');
        sb.append(",\"createDate\":\"")
                .append(createDate).append('\"');
        sb.append(",\"updater\":\"")
                .append(updater).append('\"');
        sb.append(",\"updateDate\":\"")
                .append(updateDate).append('\"');
        sb.append(",\"groupName\":\"")
                .append(groupName).append('\"');
        sb.append(",\"groupTag\":\"")
                .append(groupTag).append('\"');
        sb.append('}');
        return sb.toString();
    }

    public PushInfo(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupTag() {
        return groupTag;
    }

    public void setGroupTag(String groupTag) {
        this.groupTag = groupTag;
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    public String getUserTag() {
        return userTag;
    }

    public void setUserTag(String userTag) {
        this.userTag = userTag;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

}
