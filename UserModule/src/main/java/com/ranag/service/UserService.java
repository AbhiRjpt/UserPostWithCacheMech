package com.ranag.service;

import com.ranag.common.Helper;
import com.ranag.dao.impl.UserDaoImpl;
import com.ranag.exception.InternalErrorCodes;
import com.ranag.exception.InternalException;
import com.ranag.rest.bean.request.UserArticleRequestData;
import com.ranag.rest.bean.request.UserPostRequestData;
import com.ranag.rest.bean.request.UserRequestData;
import com.ranag.rest.bean.response.*;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class UserService {

    private UserDaoImpl userDao;

    public UserService() {
        this.userDao = new UserDaoImpl();
    }

    public OrgResponseData createUser(UserRequestData requestData) throws Exception {
        UserResponseData responseData = new UserResponseData();
        requestData.getUserData().setPassword(Helper.getMD5(requestData.getUserData().getPassword()));
        int userId = userDao.createUser(requestData.getUserData());
        if(userId>0) {
            responseData.setUserId(userId);
            responseData.setUserName(requestData.getUserData().getUser_name());
        }else {
            throw new InternalException("Error while creating user. Please try again", InternalErrorCodes.USER_CREATION_FAILED);
        }
        return responseData;
    }

    public OrgResponseData updateUser(UserRequestData requestData) throws Exception {
        UserResponseData responseData = new UserResponseData();
        if(requestData.getUserid()>0) {
            requestData.getUserData().setPassword(Helper.getMD5(requestData.getUserData().getPassword()));
            userDao.updateUser(requestData.getUserData());
            responseData.setUserId(requestData.getUserid());

        }else {
            throw new InternalException("UserId is not valid. Please try again with a vaild userId.",InternalErrorCodes.INVALID_USER_ID);
        }
        return responseData;
    }

    public OrgResponseData createUserPost(UserPostRequestData requestData) throws Exception {
        UserPostResponseData responseData = new UserPostResponseData();
        int postId = userDao.createUserPost(requestData.getUserPostData());
        if(postId>0) {
            responseData.setUserId(requestData.getUserid());
            responseData.setPostId(postId);
        }else {
            throw new InternalException("Error while creating user post. Please try again", InternalErrorCodes.POST_CREATION_FAILED);
        }
        return responseData;
    }

    public OrgResponseData updateUserPost(UserPostRequestData requestData) throws Exception {
        UserPostResponseData responseData = new UserPostResponseData();
        if(requestData.getUserid()>0 && requestData.getUserPostData().getPostId()>0) {
            userDao.updateUserPost(requestData.getUserPostData());
            responseData.setUserId(requestData.getUserid());
            responseData.setPostId(requestData.getUserPostData().getPostId());

        }else {
            throw new InternalException("User post updation request failed. Please try again.",InternalErrorCodes.POST_UPDATION_FAILED);
        }
        return responseData;
    }


    public OrgResponseData createUserArticle(UserArticleRequestData requestData) throws Exception {
        UserPostResponseData responseData = new UserPostResponseData();
        int articleId = userDao.createUserArticleData(requestData.getUserArticleData());
        if(articleId>0) {
            responseData.setUserId(requestData.getUserid());
            responseData.setPostId(articleId);
        }else {
            throw new InternalException("Error while creating user article. Please try again", InternalErrorCodes.ARTICLE_CREATION_FAILED);
        }
        return responseData;
    }

    public OrgResponseData updateUserArticle(UserArticleRequestData requestData) throws Exception {
        UserArticleResponseData responseData = new UserArticleResponseData();
        if(requestData.getUserid()>0 && requestData.getUserArticleData().getArticleId()>0) {
            userDao.updateUserArticleData(requestData.getUserArticleData());
            responseData.setUserId(requestData.getUserid());
            responseData.setArtileId(requestData.getUserArticleData().getArticleId());

        }else {
            throw new InternalException("User article updation request failed. Please try again.",InternalErrorCodes.ARTICLE_UPDATION_FAILED);
        }
        return responseData;
    }
}
