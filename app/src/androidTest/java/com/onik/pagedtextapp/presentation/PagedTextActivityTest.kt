package com.onik.pagedtextapp.presentation

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.nhaarman.mockito_kotlin.verify
import com.onik.pagedtextapp.R
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class PagedTextActivityTest {
    private lateinit var mockPresenter: PagedTextPresenter

    @get:Rule
    val activityRule = ActivityTestRule(PagedTextActivity::class.java)

    @Before
    fun setUp() {
        mockPresenter = activityRule.activity.presenter
    }

    @Test
    fun activity_onCreate_presenter_should_onViewCreated() {
        verify(mockPresenter).onViewCreated()
    }

    @Test
    fun on_buttonLast_click_presenter_should_onLastClicked() {
        onView(withId(R.id.buttonLast)).perform(click())

        verify(mockPresenter).onLastClicked()
    }

    @Test
    fun on_buttonNext_click_presenter_should_onNextClicked() {
        onView(withId(R.id.buttonNext)).perform(click())

        verify(mockPresenter).onNextClicked()
    }
}