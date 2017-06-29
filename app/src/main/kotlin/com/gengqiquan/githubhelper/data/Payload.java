package com.gengqiquan.githubhelper.data;

import java.util.List;

import javax.annotation.Generated;

import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Payload {

    @SerializedName("issue")
    private Issue issue;

    @SerializedName("before")
    private String before;

    @SerializedName("push_id")
    private int pushId;

    @SerializedName("description")
    private Object description;

    @SerializedName("distinct_size")
    private int distinctSize;

    @SerializedName("head")
    private String head;

    @SerializedName("ref")
    private String ref;

    @SerializedName("pusher_type")
    private String pusherType;

    @SerializedName("size")
    private int size;

    @SerializedName("action")
    private String action;

    @SerializedName("commits")
    private List<CommitsItem> commits;

    @SerializedName("comment")
    private Comment comment;

    @SerializedName("ref_type")
    private String refType;

    @SerializedName("master_branch")
    private String masterBranch;

    @SerializedName("forkee")
    private Forkee forkee;

    public void setIssue(Issue issue) {
        this.issue = issue;
    }

    public Issue getIssue() {
        return issue;
    }

    public void setBefore(String before) {
        this.before = before;
    }

    public String getBefore() {
        return before;
    }

    public void setPushId(int pushId) {
        this.pushId = pushId;
    }

    public int getPushId() {
        return pushId;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public Object getDescription() {
        return description;
    }

    public void setDistinctSize(int distinctSize) {
        this.distinctSize = distinctSize;
    }

    public int getDistinctSize() {
        return distinctSize;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getHead() {
        return head;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getRef() {
        return ref;
    }

    public void setPusherType(String pusherType) {
        this.pusherType = pusherType;
    }

    public String getPusherType() {
        return pusherType;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }

    public void setCommits(List<CommitsItem> commits) {
        this.commits = commits;
    }

    public List<CommitsItem> getCommits() {
        return commits;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public Comment getComment() {
        return comment;
    }

    public void setRefType(String refType) {
        this.refType = refType;
    }

    public String getRefType() {
        return refType;
    }

    public void setMasterBranch(String masterBranch) {
        this.masterBranch = masterBranch;
    }

    public String getMasterBranch() {
        return masterBranch;
    }

    public Forkee getForkee() {
        return forkee;
    }

    public void setForkee(Forkee forkee) {
        this.forkee = forkee;
    }

    @Override
    public String toString() {
        return
                "Payload{" +
                        "issue = '" + issue + '\'' +
                        ",before = '" + before + '\'' +
                        ",push_id = '" + pushId + '\'' +
                        ",description = '" + description + '\'' +
                        ",distinct_size = '" + distinctSize + '\'' +
                        ",head = '" + head + '\'' +
                        ",ref = '" + ref + '\'' +
                        ",pusher_type = '" + pusherType + '\'' +
                        ",size = '" + size + '\'' +
                        ",action = '" + action + '\'' +
                        ",commits = '" + commits + '\'' +
                        ",comment = '" + comment + '\'' +
                        ",ref_type = '" + refType + '\'' +
                        ",master_branch = '" + masterBranch + '\'' +
                        ",forkee = '" + forkee + '\'' +
                        "}";
    }
}