//package com.jjbike.utils.yu;
//
//
//
///**
// * Created by admin on 2017-07-09.
// */
//public class PushUtils {
//    private static TPushGroupService tPushGroupService= SpringContextHolder.getBean(TPushGroupService.class);
//    private static TPushPlanService tPushPlanService= SpringContextHolder.getBean(TPushPlanService.class);
//    public  static final String CACHE_PUSH="zy_msg_push_";
//    public static final String CACHE_PUSH_GROUP_="zy_push_group_";
//    public static final  String CACHE_PUSH_PLAN_WAITTING="zy_push_plan_waitting";//等待更新的计划列表
//    public static final  String CACHE_PUSH_PLAN_REULTWATTING="zy_push_plan_result_waitting";//等待结果更新的计划列表
////    public static final String CACHE_CHILDREN_AREA_POINT_LIST_="childrenAreaPointList_";
//    /**
//     * 将推送组的条件拷贝到TUserInfo中
//     * @param tPushGroup
//     * @return
//     */
//    public  static TUsersInfo transPushGroupToUserInfo(TPushGroup tPushGroup){
//        TUsersInfo tUsersInfo=new TUsersInfo();
//        if("1".equals(tPushGroup.getIsSelectAll())){
//            return tUsersInfo;
//        }
//        tUsersInfo.setPhone(tPushGroup.getPhone());
//        tUsersInfo.setAccountStatus(tPushGroup.getPAccountStatus());
//        tUsersInfo.setMBorrowBicycle(tPushGroup.getMBorrowBicycle());
//        tUsersInfo.setMaxMBorrowBicycleDate(tPushGroup.getMaxMBorrowBicycleDate());
//        tUsersInfo.setMinMBorrowBicycleDate(tPushGroup.getMinMBorrowBicycleDate());
//        tUsersInfo.setMinAddTime(tPushGroup.getMinAddTime());
//        tUsersInfo.setMaxAddTime(tPushGroup.getMaxAddTime());
//        tUsersInfo.setMaxCreditScore(tPushGroup.getMaxCreditScore());
//        tUsersInfo.setMinCreditScore(tPushGroup.getMinCreditScore());
//        tUsersInfo.setMaxLuckyMoney(tPushGroup.getMaxLuckyMoney());
//        tUsersInfo.setMinLuckyMoney(tPushGroup.getMinLuckyMoney());
//        tUsersInfo.setMinTotalCalorie(tPushGroup.getMinTotalCalorie());
//        tUsersInfo.setMaxTotalCalorie(tPushGroup.getMaxTotalCalorie());
//        tUsersInfo.setMinTotalDuration(tPushGroup.getMinTotalDuration());
//        tUsersInfo.setMaxTotalDuration(tPushGroup.getMaxTotalDuration());
//        tUsersInfo.setMinTotalKilometers(tPushGroup.getMinTotalKilometers());
//        tUsersInfo.setMaxTotalKilometers(tPushGroup.getMaxTotalKilometers());
//        return tUsersInfo;
//    }
//
//    /**
//     * 返回推送组的列表
//     * @return
//     */
//    public static List<TPushGroup> getPushGroupList(){
//        List<TPushGroup> list= ( List<TPushGroup>)CacheUtils.get(CACHE_PUSH,CACHE_PUSH_GROUP_);
//        if(list==null){
//            TPushGroup tPushGroup=new TPushGroup();
//            list=tPushGroupService.findList(tPushGroup);
//            CacheUtils.put(CACHE_PUSH,CACHE_PUSH_GROUP_,list);
//        }
//        return list;
//    }
//
//    /**
//     * 清空推送组列表
//     */
//    public static void clearPushGroupList(){
//        CacheUtils.remove(CACHE_PUSH,CACHE_PUSH_GROUP_);
//    }
//    public static List<TPushPlan> getPushPlanWaitting(){
//        List<TPushPlan> list= ( List<TPushPlan>)CacheUtils.get(CACHE_PUSH,CACHE_PUSH_PLAN_WAITTING);
//        if(list==null){
//            TPushPlan tPushPlan=new TPushPlan();
//            tPushPlan.setPushState("0");
//            list=tPushPlanService.findList(tPushPlan);
//            if(list==null){
//                list=new ArrayList<TPushPlan>();
//            }
//            CacheUtils.put(CACHE_PUSH,CACHE_PUSH_PLAN_WAITTING,list);
//        }
//        return list;
//    }
//
//    /**
//     * 清空等待推送计划表
//     */
//    public static void clearPushPlanWaitting(){
//        CacheUtils.remove(CACHE_PUSH,CACHE_PUSH_PLAN_WAITTING);
//    }
//    public static List<TPushPlan> getPushPlanResultWaitting(){
//        List<TPushPlan> list= ( List<TPushPlan>)CacheUtils.get(CACHE_PUSH,CACHE_PUSH_PLAN_REULTWATTING);
//        if(list==null){
//            TPushPlan tPushPlan=new TPushPlan();
//            tPushPlan.setPushState("5");
//            list=tPushPlanService.findList(tPushPlan);
//            if(list==null){
//                list=new ArrayList<TPushPlan>();
//            }
//            CacheUtils.put(CACHE_PUSH,CACHE_PUSH_PLAN_REULTWATTING,list);
//        }
//        return list;
//    }
//    /**
//     * 清空等待推送计划表
//     */
//    public static void clearPushPlanResultWaitting(){
//        CacheUtils.remove(CACHE_PUSH,CACHE_PUSH_PLAN_REULTWATTING);
//    }
//}
