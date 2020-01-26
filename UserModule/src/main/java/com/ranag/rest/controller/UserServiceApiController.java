package com.ranag.rest.controller;

import com.ranag.exception.InternalErrorCodes;
import com.ranag.exception.InternalException;
import com.ranag.rest.bean.request.UserArticleRequestData;
import com.ranag.rest.bean.request.UserPostRequestData;
import com.ranag.rest.bean.request.UserRequestData;
import com.ranag.rest.bean.response.OrgResponseData;
import com.ranag.service.RequestValidationService;
import com.ranag.service.RestResponseService;
import com.ranag.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Calendar;

@RestController
@RequestMapping("/user")
public class UserServiceApiController {

    @Autowired
    RestResponseService restResponseService;

    @Autowired
    RequestValidationService requestValidationService;

    @Autowired
    UserService userService;

    @GetMapping("/ping")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public OrgResponseData getPing() {
        System.out.println("Ping Time stamp is : " + Calendar.getInstance().getTime());
        return restResponseService.createSuccessResponse();
    }

    @PostMapping("/createUser")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response createUser(@RequestBody UserRequestData requestData){
        Response response = null;
        OrgResponseData orgResponseData = null;
        try {

            System.out.println("-----------------USER DATA-------------------");
            if(!requestValidationService.validateUserId(requestData.getUserid())) {
                throw new InternalException("UserId is not valid,Please try again.", InternalErrorCodes.INVALID_USER_ID);
            }
            orgResponseData = userService.createUser(requestData);
            response = restResponseService.createSuccessResponse(orgResponseData);
            return response;
        } catch (Exception e) {
            response = restResponseService.createFailureResponse(e, orgResponseData);
            return response;
        }
    }

    @PutMapping("/updateUser")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response updateUser(@RequestBody UserRequestData requestData){
        Response response = null;
        OrgResponseData orgResponseData = null;
        try {
            if(requestData.getUserid() ==0){
                requestData.setUserid(requestData.getUserData().getUserId());
            }
            System.out.println("-----------------USER DATA-------------------");
            if(!requestValidationService.validateUserId(requestData.getUserid())) {
                throw new InternalException("UserId is not valid,Please try again.", InternalErrorCodes.INVALID_USER_ID);
            }
            orgResponseData = userService.updateUser(requestData);
            response = restResponseService.createSuccessResponse(orgResponseData);
            return response;
        } catch (Exception e) {
            response = restResponseService.createFailureResponse(e, orgResponseData);
            return response;
        }
    }

    @PostMapping("/submitUserPost")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response createUserPost(@RequestBody UserPostRequestData requestData){
        Response response = null;
        OrgResponseData orgResponseData = null;
        try {
            if(!requestValidationService.validateUserId(requestData.getUserid())) {
                throw new InternalException("UserId is not valid,Please try again.", InternalErrorCodes.INVALID_USER_ID);
            }
            orgResponseData = userService.createUserPost(requestData);
            response = restResponseService.createSuccessResponse(orgResponseData);
            return response;
        } catch (Exception e) {
            response = restResponseService.createFailureResponse(e, orgResponseData);
            return response;
        }
    }

    @PutMapping("/updateUserPost")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response updateUserPost(@RequestBody UserPostRequestData requestData){
        Response response = null;
        OrgResponseData orgResponseData = null;
        try {
            if(requestData.getUserPostData().getPostId() == 0){
                throw new InternalException("Invalid postId, please try again",InternalErrorCodes.INVALID_POST_ID);
            }
            System.out.println("-----------------USER DATA-------------------");
            if(!requestValidationService.validateUserId(requestData.getUserid())) {
                throw new InternalException("UserId is not valid,Please try again.", InternalErrorCodes.INVALID_USER_ID);
            }
            orgResponseData = userService.updateUserPost(requestData);
            response = restResponseService.createSuccessResponse(orgResponseData);
            return response;
        } catch (Exception e) {
            response = restResponseService.createFailureResponse(e, orgResponseData);
            return response;
        }
    }

    @PostMapping("/submitUserArticleData")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response createUserArticleData(@RequestBody UserArticleRequestData requestData){
        Response response = null;
        OrgResponseData orgResponseData = null;
        try {
            if(!requestValidationService.validateUserId(requestData.getUserid())) {
                throw new InternalException("UserId is not valid,Please try again.", InternalErrorCodes.INVALID_USER_ID);
            }
            orgResponseData = userService.createUserArticle(requestData);
            response = restResponseService.createSuccessResponse(orgResponseData);
            return response;
        } catch (Exception e) {
            response = restResponseService.createFailureResponse(e, orgResponseData);
            return response;
        }
    }

    @PutMapping("/updateUserArticleData")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response updateUserArticleData(@RequestBody UserArticleRequestData requestData){
        Response response = null;
        OrgResponseData orgResponseData = null;
        try {
            if(requestData.getUserArticleData().getArticleId() == 0){
                throw new InternalException("Invalid articleId, please try again",InternalErrorCodes.INVALID_ARTICLE_ID);
            }
            System.out.println("-----------------USER DATA-------------------");
            if(!requestValidationService.validateUserId(requestData.getUserid())) {
                throw new InternalException("UserId is not valid,Please try again.", InternalErrorCodes.INVALID_USER_ID);
            }
            orgResponseData = userService.updateUserArticle(requestData);
            response = restResponseService.createSuccessResponse(orgResponseData);
            return response;
        } catch (Exception e) {
            response = restResponseService.createFailureResponse(e, orgResponseData);
            return response;
        }
    }

    @GetMapping("/getUserData/{userId}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response getUserData(@PathVariable("userId") int userId){
        Response response = null;
        System.out.println("userId: "+userId);
        OrgResponseData orgResponseData = null;
        try{
            if(!requestValidationService.validateUserId(userId)) {
                throw new InternalException("UserId is not valid,Please try again.", InternalErrorCodes.INVALID_USER_ID);
            }
            orgResponseData = userService.getUserData(userId);
            response = restResponseService.createSuccessResponse(orgResponseData);

        }catch (Exception e){
            response = restResponseService.createFailureResponse(e, orgResponseData);
        }
        return response;
    }


    @GetMapping("/getUserPostData/{userId}/{postId}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response getUserPostData(@PathVariable("userId") int userId,@PathVariable("postId") int postId){
        Response response = null;
        OrgResponseData orgResponseData = null;
        try{
            if(!requestValidationService.validateUserId(userId)) {
                throw new InternalException("UserId is not valid,Please try again.", InternalErrorCodes.INVALID_USER_ID);
            }
            if(!requestValidationService.validateId(postId)){
                throw new InternalException("PostId is not valid, Please try again.",InternalErrorCodes.INVALID_POST_ID);
            }
            orgResponseData = userService.getUserPostData(userId,postId);
            response = restResponseService.createSuccessResponse(orgResponseData);

        }catch (Exception e){
            response = restResponseService.createFailureResponse(e, orgResponseData);
        }
        return response;
    }

    @GetMapping("/getUserArticleData/{userId}/{articleId}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response getUserArticleData(@PathVariable("userId") int userId,@PathVariable("articleId") int articleId){
        Response response = null;
        OrgResponseData orgResponseData = null;
        try{
            if(!requestValidationService.validateUserId(userId)) {
                throw new InternalException("UserId is not valid,Please try again.", InternalErrorCodes.INVALID_USER_ID);
            }
            if(!requestValidationService.validateId(articleId)){
                throw new InternalException("Article_Id is not valid, Please try again.",InternalErrorCodes.INVALID_ARTICLE_ID);
            }
            orgResponseData = userService.getUserArticleData(userId,articleId);
            response = restResponseService.createSuccessResponse(orgResponseData);

        }catch (Exception e){
            response = restResponseService.createFailureResponse(e, orgResponseData);
        }
        return response;
    }

}
