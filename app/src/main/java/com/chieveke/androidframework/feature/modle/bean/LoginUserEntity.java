package com.chieveke.androidframework.feature.modle.bean;

/**
 * @description: 登陆实体
 * @author: keqichun
 * @date: 2016/7/18 17:23
 * @version: V1.0
 */
public class LoginUserEntity {

    /**
     * userid : 1
     * usertype : 747b1c45
     * position_id : 1328
     * departid : 1
     * eid : 1
     * company_id : 1
     * jwt : eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyaWQiOiIxIiwiaWF0IjoxNDk5MTMyMjIyLCJleHAiOjE0OTkxNTc0MjJ9.GKaTQryaLFvEqy_y7Bv0HsosacCpJTu43s_YWJXrrnw
     * token_ttl : 25200
     */

    private int userid; //用户id
    private String usertype;   //用户类型 0总公司 1分公司 2小区 3部门 4责任人
    private String position_id;
    private String departid;
    private String eid;
    private String company_id;
    private String jwt;
    private int need_to_resetpassword;//是否需要强制修改密码，1：是，2：仅提示，不强制修改，0：不需要
    private int token_ttl;

    public int getUserid() {
        return userid;
    }


    public String getUsertype() {
        return usertype;
    }


    public String getPosition_id() {
        return position_id;
    }


    public String getDepartid() {
        return departid;
    }


    public String getEid() {
        return eid;
    }


    public String getCompany_id() {
        return company_id;
    }


    public String getJwt() {
        return jwt;
    }


    public int getToken_ttl() {
        return token_ttl;
    }

    public void setToken_ttl(int token_ttl) {
        this.token_ttl = token_ttl;
    }

    public int getNeed_to_resetpassword() {
        return need_to_resetpassword;
    }
}
