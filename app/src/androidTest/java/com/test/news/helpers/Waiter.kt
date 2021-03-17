package com.test.news.helpers

import android.view.View

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed

import org.hamcrest.CoreMatchers
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher

/**
 *Polls this element every 1s until it either has the attribute 'isDisplayed' or 10 polling
 * attempts have failed.
 *
 * @param element element to check attribute of
 * @throws [Exception] if element is not found or does not match desired state
 */
fun waitUntilDisplayed(element: ViewInteraction) {
    var i = 0
    while (i++ <= TIMEOUT) {
        try {
            element.check(matches(isDisplayed()))
        } catch (e: Exception) {
            if (i == TIMEOUT) {
                throw e
            }
            Thread.sleep(1000)
        }
    }
}

/**
 * get the current index of matcher
 */

fun withIndex(matcher: Matcher<View?>, index: Int): Any {
    return object : TypeSafeMatcher<View?>() {
        var currentIndex = 0
        override fun describeTo(description: Description) {
            description.appendText("with index: ")
            description.appendValue(index)
            matcher.describeTo(description)
        }

        override fun matchesSafely(view: View?): Boolean {
            return matcher.matches(view) && currentIndex++ == index
        }
    }
}

/**
 * Assert the actual count from the adapter with expected count
 */
class CustomAssertions {
    companion object {
        fun hasItemCount(count: Int): ViewAssertion {
            return RecyclerViewItemCountAssertion(count)
        }
    }

    private class RecyclerViewItemCountAssertion(private val count: Int) : ViewAssertion {

        override fun check(view: View, noViewFoundException: NoMatchingViewException?) {
            if (noViewFoundException != null) {
                throw noViewFoundException
            }

            if (view !is RecyclerView) {
                throw IllegalStateException("The asserted view is not RecyclerView")
            }

            if (view.adapter == null) {
                throw IllegalStateException("No adapter is assigned to RecyclerView")
            }

            ViewMatchers.assertThat("RecyclerView item count", view.adapter!!.itemCount, CoreMatchers.equalTo(count))
        }
    }
}








