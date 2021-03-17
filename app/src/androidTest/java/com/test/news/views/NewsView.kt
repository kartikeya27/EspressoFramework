package com.test.news.views

//import com.test.news.helpers.withListSize

import android.view.View

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*

import com.test.news.R
import com.test.news.helpers.CustomAssertions
import com.test.news.helpers.withIndex

import org.hamcrest.Matcher
import org.hamcrest.core.AllOf.allOf
import org.hamcrest.core.IsInstanceOf.instanceOf

object NewsView {

    // Elements from News Page

    private val listVisible =
            onView(allOf(instanceOf(RecyclerView::class.java), withParent(withId(R.id.recyclerViewNews))))

    private val newsLoadError =
            onView(withId(R.id.textViewError))

    /////////////
    // Actions //
    ////////////

    fun getImageVertical() {
        for (i in 0..2) {
            onView(allOf(withId(R.id.recyclerViewNews), isDisplayed())).perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(3,
                    ViewActions.swipeUp()))
        }
    }

    fun getImageClick() {
        onView(withIndex(withId(R.id.recyclerViewNews), 0) as Matcher<View>?).perform(ViewActions.click())
    }

    fun getImageHorizontal() {
        for (i in 0..3) {
            onView(withId(R.id.recyclerViewNews)).perform(ViewActions.swipeLeft())
        }
    }

    fun getImageCount() {
        onView(withId(R.id.recyclerViewNews))
            .check(CustomAssertions.hasItemCount(7))
    }

    fun getListVisible():ViewInteraction {
        Thread.sleep(1000)
        return listVisible
    }

    fun getNewsLoadError():ViewInteraction {
        return newsLoadError
    }
}