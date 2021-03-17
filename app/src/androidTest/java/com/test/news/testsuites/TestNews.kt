package com.test.news.testsuites

import com.test.news.annotations.ClearData
import com.test.news.helpers.ValidLogin
import com.test.news.views.LoginView
import com.test.news.views.NewsView

import org.junit.Test

class TestNews : BaseTest() {

    /**
     * Get the Recycler view is visible or not
     */
    @Test
    @ClearData
    fun testListVisible() {
        LoginView.tapLogin(ValidLogin.username, ValidLogin.password)
        NewsView.getListVisible()
    }

    /**
     * Find the index value then swipe the image vertical
     */
    @Test
    @ClearData
    fun testImageVertical() {
        LoginView.tapLogin(ValidLogin.username, ValidLogin.password)
        NewsView.getListVisible()
        NewsView.getImageVertical()
    }

    /**
     * Click on image
     */
    @Test
    @ClearData
    fun testImageClick() {
        LoginView.tapLogin(ValidLogin.username, ValidLogin.password)
        NewsView.getListVisible()
        NewsView.getImageClick()
    }

    /**
     * Swipe the image Horizontal
     */
    @Test
    @ClearData
    fun testImageHorizontal() {
        LoginView.tapLogin(ValidLogin.username, ValidLogin.password)
        NewsView.getListVisible()
        NewsView.getImageHorizontal()
    }

    /**
     * When network is down then get image load error message
     */
    @Test
    @ClearData
    fun testFailToLoadImage() {
        LoginView.tapLogin(ValidLogin.username, ValidLogin.password)
        NewsView.getListVisible()
        NewsView.getNewsLoadError()
    }

    /**
     * Find the number of image count from Recycler
     */
    @Test
    @ClearData
    fun testImageCount() {
        LoginView.tapLogin(ValidLogin.username, ValidLogin.password)
        NewsView.getListVisible()
        NewsView.getImageCount()
    }
}







