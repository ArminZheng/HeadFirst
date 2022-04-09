package com.arminzheng.factory.strategy;

/**
 * UserController
 *
 * @author zy
 * @version 2022/4/9
 */
public class UserController {

    /**
     * final 更适合没有get/set方法的属性（可设为public仅供访问）
     */
    private final UserService userService = BeanFactory.getUserService();

    public String queryUser() {
        userService.getUserInfo();
        return userService.getUserName();
    }

    public void getUserInfo() {
        UserService userService = BeanFactory.getBean("userService");
        userService.getUserInfo();
    }

    public static void main(String[] args) {
        UserController controller = new UserController();
        String username = controller.queryUser();
        System.out.println("username = " + username);
        controller.getUserInfo();
    }
}
