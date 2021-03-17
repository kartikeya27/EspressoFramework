package com.test.news.views

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.RootMatchers.isPlatformPopup
import androidx.test.espresso.matcher.ViewMatchers.*

import com.test.news.R
import com.test.news.helpers.waitUntilDisplayed

object LoginView {

    // Elements from login page

    private val userName =
            onView(withId(R.id.editTextUserName))

    private val password =
            onView(withId((R.id.editTextPassword)))

    private val loginButton =
            onView(withId(R.id.buttonLogin))

    private val usernameErrorMessage =
            onView(withText("Wrong user name")).inRoot(isPlatformPopup())

    private val passwordErrorMessage =
            onView(withText("Wrong password")).inRoot(isPlatformPopup())

    private val newsText =
            onView(withText("News"))

    /**
     * Enter username
     */
    private fun enterUserName(username: String) {
        waitUntilDisplayed(userName)
        userName.perform(clearText())
        userName.perform(typeText(username), closeSoftKeyboard())
    }

    /**
     * Enter password
     */
    private fun enterPassword(Password: String) {
        waitUntilDisplayed(password)
        password.perform(clearText())
        password.perform(typeText(Password), closeSoftKeyboard())
    }

    /**
     * Perform a login with this username and password
     */
    fun tapLogin(username: String, password: String) {
        enterUserName(username)
        enterPassword(password)
        loginButton.perform(click())
    }

    /**
     * tap on user name field
     */
    fun tapUserName() {
        userName.perform(click())
    }

    /**
     * tap on password field
     */
    fun tapPassword() {
        password.perform(click())
    }

    /**
     * Tap on red error message
     */
    fun getUsernameErrorMessage():ViewInteraction {
        waitUntilDisplayed(usernameErrorMessage)
        return usernameErrorMessage
    }

    /**
     * Tap on red error message
     */
    fun getPasswordErrorMessage():ViewInteraction {
        waitUntilDisplayed(passwordErrorMessage)
        return passwordErrorMessage
    }

    /**
     * Gets the News text
     */
    fun getNews():ViewInteraction {
        waitUntilDisplayed(newsText)
        return newsText
    }
}