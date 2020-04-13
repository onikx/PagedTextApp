package com.onik.pagedtextapp.presentation

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
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
    fun `on_buttonLast_click_presenter_should_onLastClicked`() {
        onView(withId(R.id.textViewContent)).check(matches(isDisplayed()))

        onView(withId(R.id.buttonLast)).perform(click())

        verify(mockPresenter).onLastClicked()
    }
}