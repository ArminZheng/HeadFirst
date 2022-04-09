package com.arminzheng.factory.strategy;

/**
 * UserServiceImpl
 *
 * @author zy
 * @version 2022/4/9
 */
public class UserServiceImpl implements UserService {
    @Override
    public String getUserName() {
        return "UserServiceImpl.getUserName";
    }

    @Override
    public void getUserInfo() {
        System.out.println("UserServiceImpl.getUserInfo");
    }
}
