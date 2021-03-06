package com.framgia.wsm.test.screen.login;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import com.framgia.wsm.R;
import com.framgia.wsm.screen.login.LoginActivity;
import com.framgia.wsm.test.ErrorTextMatcher;
import cucumber.api.CucumberOptions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.Matcher;

/**
 * Created by framgia on 17/05/2017.
 */

@CucumberOptions(features = "features/login.feature")
public class ALoginScreenTest extends ActivityInstrumentationTestCase2<LoginActivity> {

    public ALoginScreenTest(LoginActivity loginActivity) {
        super(LoginActivity.class);
    }

    private static Matcher<? super View> hasErrorText(String expectedError) {
        return new ErrorTextMatcher(expectedError);
    }

    @Given("^I have a Login Screen")
    public void I_have_a_login_screen() {
        assertNotNull(getActivity());
    }

    @When("^I input email (\\S+)$")
    public void I_input_email(final String email) {
        Espresso.onView(ViewMatchers.withId(R.id.edit_username))
                .perform(ViewActions.typeText(email));
    }

    @When("^I input password (\\S+)$")
    public void I_input_password(final String password) {
        Espresso.onView(ViewMatchers.withId(R.id.edit_password))
                .perform(ViewActions.typeText(password));
    }

    @When("^I click login$")
    public void I_click_login() {
        Espresso.onView(ViewMatchers.withId(R.id.btn_login)).perform(ViewActions.click());
    }

    @Then("^I should see error when missing field (\\S+)$")
    public void I_should_see_error_when_only_click_login(final String view) {
        boolean isKeywordView = "email".equals(view);
        int viewId = isKeywordView ? R.id.txtInputLayoutEmail : R.id.txtInputLayoutPassword;
        int errorResourceId = isKeywordView ? R.string.is_empty : R.string.is_empty;

        Espresso.onView(ViewMatchers.withId(viewId))
                .check(ViewAssertions.matches(
                        ALoginScreenTest.hasErrorText(getActivity().getString(errorResourceId))));
    }

    @Then("^I should see error on the (\\S+)$")
    public void I_should_see_error_on_the_keyword(final String view) {
        boolean isKeywordView = "email".equals(view);
        int viewId = isKeywordView ? R.id.txtInputLayoutEmail : R.id.txtInputLayoutPassword;
        int errorResourceId = isKeywordView ? R.string.invalid_email_format : R.string.is_empty;

        Espresso.onView(ViewMatchers.withId(viewId))
                .check(ViewAssertions.matches(
                        ALoginScreenTest.hasErrorText(getActivity().getString(errorResourceId))));
    }

    @Then("^I can't see any error on the correct email (\\S+)$")
    public void I_can_not_see_error_on_the_keyword(final String view) {
        boolean isKeywordView = "email".equals(view);
        int viewId = isKeywordView ? R.id.txtInputLayoutEmail : R.id.txtInputLayoutPassword;
        int errorResourceId = isKeywordView ? R.string.none : R.string.is_empty;

        Espresso.onView(ViewMatchers.withId(viewId))
                .check(ViewAssertions.matches(
                        ALoginScreenTest.hasErrorText(getActivity().getString(errorResourceId))));
    }
}
