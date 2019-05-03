/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Gnanod-PC
 */
@Entity
public class UserEntity {
    @Id
    private String userId;
    private String userName;
    private String userType;
    private String userGender;
    private String userPassword;
    private String userContac;
    private String userAddress;

    public UserEntity() {
    }

    public UserEntity(String userId, String userName, String userType, String userGender, String userPassword, String userContac, String userAddress) {
        this.userId = userId;
        this.userName = userName;
        this.userType = userType;
        this.userGender = userGender;
        this.userPassword = userPassword;
        this.userContac = userContac;
        this.userAddress = userAddress;
    }

    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the userType
     */
    public String getUserType() {
        return userType;
    }

    /**
     * @param userType the userType to set
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }

    /**
     * @return the userGender
     */
    public String getUserGender() {
        return userGender;
    }

    /**
     * @param userGender the userGender to set
     */
    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    /**
     * @return the userPassword
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * @param userPassword the userPassword to set
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     * @return the userContac
     */
    public String getUserContac() {
        return userContac;
    }

    /**
     * @param userContac the userContac to set
     */
    public void setUserContac(String userContac) {
        this.userContac = userContac;
    }

    /**
     * @return the userAddress
     */
    public String getUserAddress() {
        return userAddress;
    }

    /**
     * @param userAddress the userAddress to set
     */
    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    @Override
    public String toString() {
        return "UserEntity{" + "userId=" + userId + ", userName=" + userName + ", userType=" + userType + ", userGender=" + userGender + ", userPassword=" + userPassword + ", userContac=" + userContac + ", userAddress=" + userAddress + '}';
    }
    
}
