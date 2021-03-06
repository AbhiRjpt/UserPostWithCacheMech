package com.ranag.dao.impl;

import com.ranag.dao.template.impl.*;
import com.ranag.rest.bean.commons.UserArticleData;
import com.ranag.rest.bean.commons.UserData;
import com.ranag.rest.bean.commons.UserPostData;
import com.ranag.rest.bean.request.UserCreationRequestData;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class UserDaoImpl {

    public int getUserKey(int userId) {
        final int[] userid = {0};
        String sql = "Select userid from UserDataSet where userid = ?";
        QueryParameter queryParameter = new QueryParameter().setInt(userId);
        new SingleRowQueryTemplateImpl(sql, queryParameter) {
            @Override
            public void processResult() throws Exception {
                userid[0] = this.resultSet.getInt("userid");
            }
        };
        return userid[0];
    }

//    public List<UserData> fetchUserData() {
//        List<UserData> userDataList = new LinkedList<>();
//        String sql = "Select * from UserData WHERE isdeleted = ?";
//        QueryParameter queryParameter = new QueryParameter().setBoolean(false);
//        new QueryTemplateImpl(sql,queryParameter) {
//            @Override
//            public void processResult() throws Exception {
//                userDataList.add(new UserData()
//                        .setUserkey(this.resultSet.getString("userkey"))
//                        .setUserid(this.resultSet.getInt("userid"))
//                        .setPwd_hash(this.resultSet.getString("pwd_hash"))
//                        .setFname(this.resultSet.getString("fname"))
//                        .setLname(this.resultSet.getString("lname"))
//                        .setEmailid(this.resultSet.getString("emailid"))
//                        .setLocation(this.resultSet.getString("location"))
//                        .setDevicePlatformName(this.resultSet.getString("devicePlatformName"))
//                        .setDeviceIdentity(this.resultSet.getString("deviceIdentity"))
//                        .setAvatar(this.resultSet.getString("avatar"))
//                        .setRegisterDateTime(this.resultSet.getString("registerDateTime"))
//                        .setDeviceToken(this.resultSet.getString("deviceToken"))
//                        .setFcmToken(this.resultSet.getString("fcmToken"))
//                        .setPhone(this.resultSet.getString("phone"))
//                        .setGender(this.resultSet.getString("gender"))
//                        .setAge(this.resultSet.getInt("age"))
//                        .setBirthDate(this.resultSet.getString("birthDate"))
//                        .setUserLanguage(this.resultSet.getString("userLanguage"))
//                        .setArea(this.resultSet.getString("area"))
//                        .setCity(this.resultSet.getString("city"))
//                        .setState(this.resultSet.getString("state"))
//                        .setCountry(this.resultSet.getString("country"))
//                        .setAppVersion(this.resultSet.getString("appVersion"))
//                        .setIsdeleted(this.resultSet.getBoolean("isdeleted"))
//                        .setDeactivatedDate(this.resultSet.getString("deactivatedDate"))
//                        .setTestUser(this.resultSet.getBoolean("testUser"))
//                        .setOperator(this.resultSet.getBoolean("isOperator"))
//                );
//            }
//        };
//        return userDataList;
//    }


    public String getUserFcmToken(int userid){
        final String[] userFcmToken = {""};
        String sql = "Select userid,fcmToken from UserData WHERE userid = ?";
        QueryParameter queryParameter = new QueryParameter().setInt(userid);
        new SingleRowQueryTemplateImpl(sql,queryParameter) {
            @Override
            public void processResult() throws Exception {
                userFcmToken[0] = this.resultSet.getString("fcmToken");
            }
        };
        return userFcmToken[0];
    }

//    public int storeUserBillPaymentData(UserEventData eventData) {
//        final int[] billId = {0};
//        String sql = "INSERT INTO UserBillPaymentData(userid,noun,ts,latlong,verb,timespent,bank,merchantid,paymentValue,paymentMode) " +
//                "VALUES(?,?,?,?,?,?,?,?,?,?)";
//        QueryParameter queryParameter = new QueryParameter()
//                .setInt(eventData.getUserid())
//                .setString(eventData.getNoun().toString())
//                .setString(eventData.getTs())
//                .setString(eventData.getLatlong())
//                .setString(eventData.getVerb().toString())
//                .setInt(eventData.getTimespent())
//                .setString(eventData.getProperties().getBank())
//                .setInt(eventData.getProperties().getMerchantid())
//                .setDouble(eventData.getProperties().getValue())
//                .setString(eventData.getProperties().getMode().toString());
//
//        new InsertTemplateImpl(sql,queryParameter) {
//            @Override
//            public void processResult() throws Exception {
//                billId[0] = this.resultSet.getInt(1);
//            }
//        };
//        return billId[0];
//    }

//    public int storeUserFeedBackData(UserEventData eventData) {
//        final int[] feedBackId = {0};
//        String sql = "INSERT INTO UserPaymetFeedBackData(userid,userBillPaymentId,noun,ts,latlong,verb,timespent,userFeedbackText) " +
//                "VALUES(?,?,?,?,?,?,?,?)";
//        QueryParameter queryParameter = new QueryParameter()
//                .setInt(eventData.getUserid())
//                .setInt(eventData.getBillId())
//                .setString(eventData.getNoun().toString())
//                .setString(eventData.getTs())
//                .setString(eventData.getLatlong())
//                .setString(eventData.getVerb().toString())
//                .setInt(eventData.getTimespent())
//                .setString(eventData.getProperties().getText());
//
//        new InsertTemplateImpl(sql,queryParameter) {
//            @Override
//            public void processResult() throws Exception {
//                feedBackId[0] = this.resultSet.getInt(1);
//            }
//        };
//        return feedBackId[0];
//    }

    public boolean checkUserBillId(int billId,int userId) {
        final boolean[] validBillId = {false};
        String sql = "Select userid,userBillPaymentId FROM UserBillPaymentData WHERE userid = ? AND userBillPaymentId = ?";
        QueryParameter queryParameter = new QueryParameter().setInt(userId).setInt(billId);
        new SingleRowQueryTemplateImpl(sql,queryParameter) {
            @Override
            public void processResult() throws Exception {
                if(this.resultSet.getInt("userBillPaymentId") == billId){
                    validBillId[0] = true;
                }
            }
        };
        return validBillId[0];
    }

    public int getBillCountForUser(int userid) {
        final int[] billCount = {0};
        String sql = "Select COUNT(userBillPaymentId) as billCount from UserBillPaymentData where userid = ?";
        QueryParameter queryParameter = new QueryParameter().setInt(userid);
        new SingleRowQueryTemplateImpl(sql,queryParameter) {
            @Override
            public void processResult() throws Exception {
                billCount[0] = this.resultSet.getInt("billCount");
            }
        };
        return billCount[0];
    }

    public Map<Integer,Double> getUserPaymentAndTimeStampMap(int userid) {
        Map<Integer,Double> userPaymentAndTimeStampMap = new HashMap<>();
        String sql = "Select userBillPaymentId,paymentValue from UserBillPaymentData where userid = ?  ORDER BY userBillPaymentId  DESC";
        QueryParameter queryParameter = new QueryParameter().setInt(userid);
        new QueryTemplateImpl(sql,queryParameter) {
            @Override
            public void processResult() throws Exception {
                userPaymentAndTimeStampMap.put(this.resultSet.getInt("userBillPaymentId"),this.resultSet.getDouble("paymentValue"));
            }
        };
        return userPaymentAndTimeStampMap;
    }

    public List<Long> getUserPaymentTimeStamp(int userId,int first_billId,int last_BillId){
        List<Long> userPaymentTimeStamp = new LinkedList<>();
        String sql = "Select ts from UserBillPaymentData where userid = ? and  userBillPaymentId in (?,?) ORDER by userBillPaymentId DESC";
        QueryParameter queryParameter = new QueryParameter().setInt(userId).setInt(first_billId).setInt(last_BillId);
        new QueryTemplateImpl(sql, queryParameter) {
            @Override
            public void processResult() throws Exception {
                userPaymentTimeStamp.add(Long.parseLong(this.resultSet.getString("ts")));
            }
        };
        return userPaymentTimeStamp;
    }

//    public int createUser(UserCreationRequestData requestData) {
//        final int[] userId = {0};
//        String sql = "INSERT INTO UserData(userkey,pwd_hash,fname,lname,emailid,location,avatar,phone,gender," +
//                "age,birthDate,userLanguage,area,city,state,country,testUser,isOperator) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//        QueryParameter queryParameter = new QueryParameter()
//                .setString(requestData.getUserkey())
//                .setString(requestData.getPassword())
//                .setString(requestData.getFname())
//                .setString(requestData.getLname())
//                .setString(requestData.getEmailid())
//                .setString(requestData.getLocation())
//                .setString(requestData.getAvatar())
//                .setString(requestData.getPhone())
//                .setString(requestData.getGender())
//                .setInt(requestData.getAge())
//                .setString(requestData.getBirthDate())
//                .setString(requestData.getUserLanguage())
//                .setString(requestData.getArea())
//                .setString(requestData.getCity())
//                .setString(requestData.getState())
//                .setString(requestData.getCountry())
//                .setBoolean(requestData.isTestUser())
//                .setBoolean(requestData.isOperator());
//
//        new InsertTemplateImpl(sql,queryParameter) {
//            @Override
//            public void processResult() throws Exception {
//               userId[0] = this.resultSet.getInt(1);
//            }
//        };
//        return userId[0];
//    }

    public void updateUserFcmAndDeviceToken(int userid, String fcmToken, String deviceToken) {
        String sql = "Update UserData set fcmToken = ?, deviceToken = ? WHERE userid = ?";
        QueryParameter queryParameter = new QueryParameter().setString(fcmToken).setString(deviceToken).setInt(userid);
       new UpdateTemplateImpl(sql,queryParameter){};
    }

    public int createUser(UserData userData) {
        int[] userId = {0};
        String sql = "INSERT INTO UserDataSet(user_name,email,userPassword) VALUES(?,?,?)";
        //For any confusions regarding templates please check in commons dao template package.
        // These have been created so that you don't have to make open and close connection for every sql query.
        QueryParameter queryParameter = new QueryParameter().setString(userData.getUser_name()).setString(userData.getEmail()).setString(userData.getPassword());
        new InsertTemplateImpl(sql,queryParameter) {
            @Override
            public void processResult() throws Exception {
                userId[0] = this.resultSet.getInt(1);
            }
        };
        
        return userId[0];
    }

    public void updateUser(UserData userData) {
        String sql = "Update UserDataSet set user_name = ?,email=?,userPassword=?,updated_at = now() WHERE userId = ?";
        //For any confusions regarding templates please check in commons dao template package.
        // These have been created so that you don't have to make open and close connection for every sql query.
        QueryParameter queryParameter = new QueryParameter().setString(userData.getUser_name()).setString(userData.getEmail()).setString(userData.getPassword()).setInt(userData.getUserId());
        new UpdateTemplateImpl(sql,queryParameter){};
    }

    public int createUserPost(UserPostData userPostData) {
        int[] postId = {0};
        String sql = "INSERT INTO Posts(userId,userText,imageLink) VALUES(?,?,?)";
        //For any confusions regarding templates please check in commons dao template package.
        // These have been created so that you don't have to make open and close connection for every sql query.
        QueryParameter queryParameter = new QueryParameter()
                .setInt(userPostData.getUserId())
                .setString(userPostData.getUserText())
                .setString(userPostData.getImageLink());
        new InsertTemplateImpl(sql,queryParameter) {
            @Override
            public void processResult() throws Exception {
                postId[0] = this.resultSet.getInt(1);
            }
        };

        return postId[0];
    }

    public void updateUserPost(UserPostData userPostData) {
        String sql = "Update Posts set userText=?,imageLink=?,updated_at = now() WHERE userId = ? AND postId = ?";
        //For any confusions regarding templates please check in commons dao template package.
        // These have been created so that you don't have to make open and close connection for every sql query.
        QueryParameter queryParameter = new QueryParameter()
                .setString(userPostData.getUserText())
                .setString(userPostData.getImageLink())
                .setInt(userPostData.getUserId())
                .setInt(userPostData.getPostId());
        new UpdateTemplateImpl(sql,queryParameter){};
    }

    public int createUserArticleData(UserArticleData userArticleData) {
        int[] articleId = {0};
        String sql = "INSERT INTO Article(userId,article_title,article_text,article_image) VALUES(?,?,?,?)";
        //For any confusions regarding templates please check in commons dao template package.
        // These have been created so that you don't have to make open and close connection for every sql query.
        QueryParameter queryParameter = new QueryParameter()
                .setInt(userArticleData.getUserId())
                .setString(userArticleData.getArticle_title())
                .setString(userArticleData.getArticle_text())
                .setString(userArticleData.getArticle_image());
        new InsertTemplateImpl(sql,queryParameter) {
            @Override
            public void processResult() throws Exception {
                articleId[0] = this.resultSet.getInt(1);
            }
        };

        return articleId[0];
    }

    public void updateUserArticleData(UserArticleData userArticleData) {
        String sql = "Update Article set article_title = ?,article_text=?,article_image=?,updated_at = now() WHERE userId = ? And articleId = ?";
        //For any confusions regarding templates please check in commons dao template package.
        // These have been created so that you don't have to make open and close connection for every sql query.
        QueryParameter queryParameter = new QueryParameter()
                .setString(userArticleData.getArticle_title())
                .setString(userArticleData.getArticle_text())
                .setString(userArticleData.getArticle_image())
                .setInt(userArticleData.getUserId())
                .setInt(userArticleData.getArticleId());
        new UpdateTemplateImpl(sql,queryParameter){};
    }

    public UserData getUserDataFromDb(int userId) {
        UserData userData = new UserData();
        String sql = "Select * from UserDataSet where userId = ?";
        new SingleRowQueryTemplateImpl(sql, new QueryParameter().setInt(userId)) {
            @Override
            public void processResult() throws Exception {
                userData.setUserId(this.resultSet.getInt("userId"))
                        .setUser_name(this.resultSet.getString("user_name"))
                        .setPassword(this.resultSet.getString("userPassword"))
                        .setEmail(this.resultSet.getString("email"))
                        .setCreated_at(this.resultSet.getString("created_at"))
                        .setUpdated_at(this.resultSet.getString("updated_at"));
            }
        };
        return userData;
    }

    public UserPostData getUserPostDataFromDb(int userId, int postId) {
        UserPostData userPostData = new UserPostData();
        String sql = "Select * from Posts WHERE userId = ? AND postId = ?";
        new SingleRowQueryTemplateImpl(sql, new QueryParameter().setInt(userId).setInt(postId)) {
            @Override
            public void processResult() throws Exception {
                userPostData.setPostId(this.resultSet.getInt("postId"))
                        .setUserId(this.resultSet.getInt("userId"))
                        .setUserText(this.resultSet.getString("userText"))
                        .setImageLink(this.resultSet.getString("imageLink"))
                        .setCreated_at(this.resultSet.getString("created_at"))
                        .setUpdated_at(this.resultSet.getString("updated_at"));
            }
        };
        return userPostData;
    }

    public UserArticleData getUserArticleDataFromDb(int userId, int articleId) {
        UserArticleData userArticleData = new UserArticleData();
        String sql = "Select * from Article WHERE userId = ? AND articleId = ?";
        new SingleRowQueryTemplateImpl(sql, new QueryParameter().setInt(userId).setInt(articleId)) {
            @Override
            public void processResult() throws Exception {
                userArticleData.setArticleId(this.resultSet.getInt("articleId"))
                        .setUserId(this.resultSet.getInt("userId"))
                        .setArticle_title(this.resultSet.getString("article_title"))
                        .setArticle_text(this.resultSet.getString("article_text"))
                        .setArticle_image(this.resultSet.getString("article_image"))
                        .setCreated_at(this.resultSet.getString("created_at"))
                        .setUpdated_at(this.resultSet.getString("updated_at"));
            }
        };
        return userArticleData;
    }
}
