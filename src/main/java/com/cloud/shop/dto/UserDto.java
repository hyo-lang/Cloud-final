package com.cloud.shop.dto;

public class UserDto {
    private int userNum;         // 사용자 고유번호 (PK)
    private String userName;     // 사용자 이름
    private String userPwd;      // 사용자 비밀번호
    private String userEmail;    // 사용자 이메일
    private String grade;        // 사용자 등급
    private String userGender;   // 사용자 성별
    private String userSignupDate; // 가입일 (timestamp, String으로 받을 수 있음)

    // Getter & Setter
    public int getUserNum() {
        return userNum;
    }
    public void setUserNum(int userNum) {
        this.userNum = userNum;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserPwd() {
        return userPwd;
    }
    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }
    public String getUserEmail() {
        return userEmail;
    }
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    public String getGrade() {
        return grade;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }
    public String getUserGender() {
        return userGender;
    }
    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }
    public String getUserSignupDate() {
        return userSignupDate;
    }
    public void setUserSignupDate(String userSignupDate) {
        this.userSignupDate = userSignupDate;
    }
}
