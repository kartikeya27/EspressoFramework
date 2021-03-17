package com.test.news.testsuites

import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility
import androidx.test.espresso.matcher.ViewMatchers.Visibility.VISIBLE
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.rule.*

import com.test.news.features.login.presentation.LoginActivity
import com.test.news.helpers.TIMEOUT

import org.junit.Rule

open class BaseTest {

    @get:Rule
    var activityTestRule = ActivityTestRule<LoginActivity>(LoginActivity::class.java)

    /**
     * Verifies that this element contains the expected test.
     *
     * @param element element to verify text for
     * @param expected expected text for the element
     */
    fun assertTextEquals(element: ViewInteraction, expected: String) {
        try {
            element.check(matches(withText(expected)))
        } catch (e: Throwable) {
            throw e
        }
    }

    /**
     * Verifies that this element is visible
     *
     * @param element element to verify visibility for
     */
    fun assertIsVisible(element: ViewInteraction) {
        var i = 0
        while (i++ < TIMEOUT) {
            try {
                element.check(matches(withEffectiveVisibility(VISIBLE)))
            } catch (e: Throwable) {
                if (i == TIMEOUT) {
                    throw e
                }
                Thread.sleep(1000)
            }
        }
    }

    /**
     * Verifies that this element is not visible.
     *
     * @param element element to verify invisibility for
     */
    fun assertIsNotVisible(element: ViewInteraction) {
        var i = 0
        while (i++ < TIMEOUT) {
            try {
                element.check(matches(withEffectiveVisibility(VISIBLE)))
            } catch (e: Throwable) {
                if (i == TIMEOUT) {
                    throw e
                }
                Thread.sleep(1000)
            }
        }
    }

    /**
     * Verifies that this element does not exist in the DOM.
     *
     * @param element element to verify non-existence for
     */
    fun assertDoesNotExist(element: ViewInteraction) {
        var i = 0
        while (i++ < TIMEOUT) {
            try {
                element.check(doesNotExist())
            } catch (e: Throwable) {
                if (i == TIMEOUT) {
                    throw e
                }
                Thread.sleep(1000)
            }
        }
    }
}