package com.sjt.jmq.core;

public class ScoredSortedItem {

    private long delayTime;

    private long delayQueueJobId; //uuid

    public ScoredSortedItem(long delayQueueJobId,long delayTime){
        this.delayQueueJobId =delayQueueJobId;
        this.delayTime =delayTime;
    }

    public ScoredSortedItem(){}

    public long getDelayTime() {return delayTime;}

    public void setDelayTime(long delayTime) {
        this.delayTime = delayTime;
    }

    public long getDelayQueueJobId() {
        return delayQueueJobId;
    }

    public void setDelayQueueJobId(long delayQueueJobId) {
        this.delayQueueJobId = delayQueueJobId;
    }

    @Override
    public String toString(){
        final StringBuilder sb = new StringBuilder("ScoredSortedItem{");
        sb.append("delayTime=").append(delayTime);
        sb.append(", delayQueueJodId=").append(delayQueueJobId);
        sb.append('}');
        return sb.toString();

    }

}
