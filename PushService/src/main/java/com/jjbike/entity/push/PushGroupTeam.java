package com.jjbike.entity.push;

import java.util.Date;

public class PushGroupTeam {
    //id
    private Integer id;
    //推送组id
    private String groupId;
    //create_by创建者
    private String creator;

    //create_date创建时间
    private Date createDate;

    //update_by更新者
    private String updater;

    //update_date更新时间
    private Date updateDate;

    //del_flag删除标志
    private Integer delFlag;

    //group_name组名
    private String groupName;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":")
                .append(id);
        sb.append(",\"groupId\":\"")
                .append(groupId).append('\"');
        sb.append(",\"creator\":\"")
                .append(creator).append('\"');
        sb.append(",\"createDate\":\"")
                .append(createDate).append('\"');
        sb.append(",\"updater\":\"")
                .append(updater).append('\"');
        sb.append(",\"updateDate\":\"")
                .append(updateDate).append('\"');
        sb.append(",\"delFlag\":")
                .append(delFlag);
        sb.append(",\"groupName\":\"")
                .append(groupName).append('\"');
        sb.append('}');
        return sb.toString();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
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

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
