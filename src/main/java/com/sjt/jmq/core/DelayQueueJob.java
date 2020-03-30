package com.sjt.jmq.core;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

/**
 * @date 2020-03-30 10:56:48
 * @author sjt
 */
public class DelayQueueJob {

    @JsonSerialize(using = ToStringSerializer.class)
    private long id;            //uuid

    private String topic;

    /**
     * delay time of a job
     */
    private long delayTime;

    /**
     * ttr: time to run
     * time-out of a job
     */
    private long ttrTime;

    /**
     *specific content of a job
     */
    private String message;

    //------------------------- get set ------------------------
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public long getDelayTime() {
        return delayTime;
    }

    public void setDelayTime(long delayTime) {
        this.delayTime = delayTime;
    }

    public long getTtrTime() {
        return ttrTime;
    }

    public void setTtrTime(long ttrTime) {
        this.ttrTime = ttrTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    //-----------------------format--------

    @Override
    public String toString(){
        final StringBuilder sb = new StringBuilder("DelayQueueJob{");
        sb.append("id=").append(id);
        sb.append(", topic='").append(topic).append('\'');
        sb.append(", delayTime=").append(delayTime);
        sb.append(", ttrTime=").append(ttrTime);
        sb.append(", message='").append(message).append('\'');
        sb.append('}');
        return sb.toString();

    }



}