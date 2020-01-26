package com.ranag.service;

import com.ranag.dao.impl.UserDaoImpl;

public class RequestValidationService {
    private UserDaoImpl userDao;

    public RequestValidationService() {
        this.userDao = new UserDaoImpl();
    }

    public boolean validateUserId(int userId){
        System.out.println("------Validating userId----");
        if(this.userDao.getUserKey(userId) > 0){
            return true;
        }
        return false;
    }

    public boolean validateId(int id){
        if(id > 0){
            return true;
        }
        return false;
    }

    public boolean validateBillId(int billId,int userId) {
       if(this.userDao.checkUserBillId(billId,userId)){
           return true;
       }
       return false;
    }
}
