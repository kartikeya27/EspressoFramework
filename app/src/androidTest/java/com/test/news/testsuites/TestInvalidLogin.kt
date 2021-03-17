package com.test.news.testsuites

import com.test.news.annotations.ClearData
import com.test.news.helpers.*
import com.test.news.views.LoginView

import org.junit.Test

class TestInvalidLogin : BaseTest() {

    /**
     * Login with invalid username
     */
    @Test
    @ClearData
    fun testInvalidUsername() {
        LoginView.tapLogin(InvalidUsername.username,InvalidUsername.password)
        LoginView.tapUserName()
        assertTextEquals(LoginView.getUsernameErrorMessage(), InvalidUsername.usernameErrorMessage)
    }

    /**
     * Login with invalid password
     */
    @Test
    @ClearData
    fun testInvalidPassword() {
        LoginView.tapLogin(InvalidPassword.username,InvalidPassword.password)
        LoginView.tapPassword()
        assertTextEquals(LoginView.getPasswordErrorMessage(), InvalidPassword.passwordErrorMessage)
    }

    /**
     * Login with valid username & password
     */
    @Test
    @ClearData
    fun testValidLogin() {
        LoginView.tapLogin(ValidLogin.username, ValidLogin.password)
        assertTextEquals(LoginView.getNews(), ValidLogin.newsText)
    }
}