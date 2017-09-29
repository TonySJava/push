package com.jjbike.entity.push;

import java.util.List;

/**
 * Created by Administrator on 2017/7/13 0013.
 */

public class PushResult {


    /**
     * result : ok
     * resultList : [{"msgTotal":247614,"result":"ok","clickNum":2212,"pushNum":11737,"GT":{"feedback":11366,"displayed":11166,"result":"ok","sent":11737,"clicked":2212},"taskId":"OSA-0713_jsizkN8MPg8OPiaqUPt43","msgProcess":11366,"APN":{"displayed":0,"feedback":0,"result":"ok","clicked":0,"sent":0}}]
     */

    private String result;
    private List<ResultListBean> resultList;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<ResultListBean> getResultList() {
        return resultList;
    }

    public void setResultList(List<ResultListBean> resultList) {
        this.resultList = resultList;
    }

    public static class ResultListBean {
        /**
         * msgTotal : 247614
         * result : ok
         * clickNum : 2212
         * pushNum : 11737
         * GT : {"feedback":11366,"displayed":11166,"result":"ok","sent":11737,"clicked":2212}
         * taskId : OSA-0713_jsizkN8MPg8OPiaqUPt43
         * msgProcess : 11366
         * APN : {"displayed":0,"feedback":0,"result":"ok","clicked":0,"sent":0}
         */

        private int msgTotal;
        private String result;
        private int clickNum;
        private int pushNum;
        private GTBean GT;
        private String taskId;
        private int msgProcess;
        private APNBean APN;

        public int getMsgTotal() {
            return msgTotal;
        }

        public void setMsgTotal(int msgTotal) {
            this.msgTotal = msgTotal;
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

        public GTBean getGT() {
            return GT;
        }

        public void setGT(GTBean GT) {
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

        public APNBean getAPN() {
            return APN;
        }

        public void setAPN(APNBean APN) {
            this.APN = APN;
        }

        public static class GTBean {
            /**
             * feedback : 11366
             * displayed : 11166
             * result : ok
             * sent : 11737
             * clicked : 2212
             */

            private int feedback;
            private int displayed;
            private String result;
            private int sent;
            private int clicked;

            public int getFeedback() {
                return feedback;
            }

            public void setFeedback(int feedback) {
                this.feedback = feedback;
            }

            public int getDisplayed() {
                return displayed;
            }

            public void setDisplayed(int displayed) {
                this.displayed = displayed;
            }

            public String getResult() {
                return result;
            }

            public void setResult(String result) {
                this.result = result;
            }

            public int getSent() {
                return sent;
            }

            public void setSent(int sent) {
                this.sent = sent;
            }

            public int getClicked() {
                return clicked;
            }

            public void setClicked(int clicked) {
                this.clicked = clicked;
            }
        }

        public static class APNBean {
            /**
             * displayed : 0
             * feedback : 0
             * result : ok
             * clicked : 0
             * sent : 0
             */

            private int displayed;
            private int feedback;
            private String result;
            private int clicked;
            private int sent;

            public int getDisplayed() {
                return displayed;
            }

            public void setDisplayed(int displayed) {
                this.displayed = displayed;
            }

            public int getFeedback() {
                return feedback;
            }

            public void setFeedback(int feedback) {
                this.feedback = feedback;
            }

            public String getResult() {
                return result;
            }

            public void setResult(String result) {
                this.result = result;
            }

            public int getClicked() {
                return clicked;
            }

            public void setClicked(int clicked) {
                this.clicked = clicked;
            }

            public int getSent() {
                return sent;
            }

            public void setSent(int sent) {
                this.sent = sent;
            }
        }
    }
}
