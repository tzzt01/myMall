package com.myMall.service;

import com.myMall.common.ServerResponse;
import com.myMall.pojo.User;

public interface IUserService {
    ServerResponse<User> login(String username, String password);

    ServerResponse<String> register(User user);

    ServerResponse<String> checkValid(String value, String type);

    ServerResponse selectQuestion(String username);

    ServerResponse<String> checkAnswer(String username, String question, String answer);

    ServerResponse<String> forgetResetPassword(String username, String newPassword, String forgetToken);

    ServerResponse<String> resetPassword(String oldPassword, String newPassword,User user);

    ServerResponse<User> updateInfomation(User user);

    ServerResponse<User> getInfomation(int userId);

    ServerResponse checkAdminRole(User user);
}
