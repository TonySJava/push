//package com.jjbike.utils.yu;
//
//import com.gexin.rp.sdk.base.IPushResult;
//import com.gexin.rp.sdk.base.impl.PushResult;
//import com.gexin.rp.sdk.http.IGtPush;
//import com.jjbike.utils.Constant;
//
//
//import java.util.*;
//
///**
// * Created by Administrator on 2017/7/13 0013.
// */
//public class PushResultByTaskidList {
//    public static PushResult getPushResultByTaskidList(List<String> taskList){
//        if(taskList!=null && taskList.size()>0){
//            try{
//                IGtPush push = new IGtPush(Constant.HOST, Constant.APPKEY, Constant.MASTER);
//                IPushResult result=push.getPushResultByTaskidList(taskList);
//                if(result==null || result.getResponse()==null || ! "ok".equals(result.getResponse().get("result"))){
//                    return null;
//                }
//                System.out.println(result.getResponse());
//                JsonMapper jsonMapper=JsonMapper.getInstance();
//                String ajson=jsonMapper.toJson(result.getResponse());
//                ajson=ajson.replace("\"{","{");
//                ajson=ajson.replace("}\"","}");
//                ajson=ajson.replace("\\\"","\"");
//                System.out.println(ajson);
//                PushResult pushResult = GsonTools.changeGsonToBean(ajson, PushResult.class);
//
//            return pushResult;
//            }catch(Exception e){
//                return null;
//            }
//        }else{
//            return null;
//        }
//    }
//    public static void updatePushResultInfo(List<String> taskList,TPushPlan pushPlan){
//        try{
//            PushResult pushResult=getPushResultByTaskidList(taskList);
//            System.out.println(pushResult);
//            Map<String,Integer> resultMap=new HashMap<>();
//            resultMap.put("gtClicked",0);
//            resultMap.put("getDisplayed",0);
//            resultMap.put("getFeedback",0);
//            resultMap.put("getSent",0);
//            resultMap.put("getMsgTotal",0);
//            resultMap.put("apngetSent",0);
//            resultMap.put("apngetFeedback",0);
//            resultMap.put("apngetDisplayed",0);
//            resultMap.put("apngetClicked",0);
//
//            if(pushResult==null || pushResult.getResultList()==null || pushResult.getResultList().size()<=0){return;}
//            for(int i=0;i<pushResult.getResultList().size();i++){
//                if(pushResult.getResultList().get(i).getGT()!=null && pushResult.getResultList().get(i).getGT().getResult()!=null
//                        &&"ok".equals(pushResult.getResultList().get(i).getGT().getResult())) {
//                    PushResult.ResultListBean.GTBean gtBean=pushResult.getResultList().get(i).getGT();
//
//                        resultMap.put("gtClicked",resultMap.get("gtClicked")+gtBean.getClicked());
//
//                        resultMap.put("getDisplayed",resultMap.get("getDisplayed")+gtBean.getDisplayed());
//
//                        resultMap.put("getFeedback",resultMap.get("getFeedback")+gtBean.getFeedback());
//
//                        resultMap.put("getSent",resultMap.get("getSent")+gtBean.getSent());
//
//                        resultMap.put("getMsgTotal",resultMap.get("getMsgTotal")+pushResult.getResultList().get(i).getMsgTotal());
//
//                    }
//                    //pushPlan.setResultClicked(pushResult.getResultList().get(i).getGT().getClicked() + "");
//                    //pushPlan.setResultDisplayed(pushResult.getResultList().get(i).getGT().getDisplayed() + "");
//                    //pushPlan.setResultFeedback(pushResult.getResultList().get(i).getGT().getFeedback() + "");
//                    //pushPlan.setResultSent(pushResult.getResultList().get(i).getGT().getSent() + "");
//                    //pushPlan.setResultMsgTotal(pushResult.getResultList().get(i).getMsgTotal() + "");
//
//                if(pushResult.getResultList().get(i).getAPN()!=null && pushResult.getResultList().get(i).getAPN().getResult()!=null
//                        &&"ok".equals(pushResult.getResultList().get(i).getAPN().getResult())){
//                        PushResult.ResultListBean.APNBean apnBean=pushResult.getResultList().get(i).getAPN();
//                        resultMap.put("apngetSent",resultMap.get("apngetSent")+apnBean.getSent());
//
//                        resultMap.put("apngetFeedback",resultMap.get("apngetFeedback")+apnBean.getFeedback());
//
//                        resultMap.put("apngetDisplayed",resultMap.get("apngetDisplayed")+apnBean.getDisplayed());
//
//                        resultMap.put("apngetClicked",resultMap.get("apngetClicked")+apnBean.getClicked());
//
//                    //stringBuilder.append(pushResult.getResultList().get(i).getAPN().getSent()).append("|");
//                    //stringBuilder.append(pushResult.getResultList().get(i).getAPN().getFeedback()).append("|");
//                    //stringBuilder.append(pushResult.getResultList().get(i).getAPN().getDisplayed()).append("|");
//                    //stringBuilder.append(pushResult.getResultList().get(i).getAPN().getClicked());
//                }
//            }
//            pushPlan.setResultClicked(resultMap.get("gtClicked")+"");
//            pushPlan.setResultDisplayed(resultMap.get("getDisplayed")+"");
//            pushPlan.setResultFeedback(resultMap.get("getFeedback")+"");
//            pushPlan.setResultSent(resultMap.get("getSent")+"");
//            pushPlan.setResultMsgTotal(resultMap.get("getMsgTotal")+"");
//
//            StringBuilder stringBuilder=new StringBuilder();
//            stringBuilder.append(resultMap.get("apngetSent")).append("|").append(resultMap.get("apngetFeedback")).append("|");
//            stringBuilder.append(resultMap.get("apngetDisplayed")).append("|").append(resultMap.get("apngetClicked"));
//            pushPlan.setAPNResult(stringBuilder.toString());
//            pushPlan.setResultSearchTime(new Date());
//            PushPlanUtils.save(pushPlan);
//        }catch (Exception e){
//            e.printStackTrace();
//            return;
//        }
//    }
////    public static void main(String[] args) {
////        IGtPush push = new IGtPush(Constant.HOST, Constant.APPKEY, Constant.MASTER);
////        //您要查询的taskIdList
////        List<String> taskIdList = new ArrayList<String>();
////        taskIdList.add("OSA-0906_7He1dYjvij6GDOWV1gAlL5");//IDOSA-0713_alsOWhU9Y49x8qNVd110k2
////        taskIdList.add("OSA-0906_bhhDdI7sqE6Ew4I82JMzS");
////        updatePushResultInfo(taskIdList,null);
////        /*IPushResult result=push.getPushResultByTaskidList(taskIdList);
////        System.out.println(result.getResponse());
////        JsonMapper jsonMapper=JsonMapper.getInstance();
////        String ajson=jsonMapper.toJson(result.getResponse());
////        ajson=ajson.replace("\"{","{");
////        ajson=ajson.replace("}\"","}");
////        ajson=ajson.replace("\\\"","\"");
////        System.out.println(ajson);
////        PushResult testEntity = GsonTools.changeGsonToBean(ajson, PushResult.class);
////        System.out.println(testEntity.getResultList().get(0).getMsgTotal());
////        PushResultEntity pushResultEntity=new PushResultEntity();*/
////
////    }
//    public static void stopTask(String taskid) {
//        IGtPush push = new IGtPush(Constant.HOST, Constant.APPKEY, Constant.MASTER);
//        boolean result = push.stop(taskid);
//        System.out.println(result);
//    }
//}
