package com.udacity.gradle.testing;

import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.AndroidTestCase;
import android.text.TextUtils;

import com.javajokes.JokeTeller;
import com.udacity.gradle.builditbigger.EndpointsAsyncTask;
import com.udacity.gradle.builditbigger.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;


@RunWith(AndroidJUnit4.class)
public class MainActivityAndroidTest extends AndroidTestCase{

    private JokeTeller jokeTeller = new JokeTeller();
    private String joke = jokeTeller.tellJoke();
    private String result = null;

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule =
            new ActivityTestRule<>(MainActivity.class);


    @Test
    public void testVerifyJokeIsNotNull(){
        assertFalse(TextUtils.isEmpty(joke));
    }

    @Test
    public void testVerifyAsyncTaskTakesNonEmptyString(){

        try{
            EndpointsAsyncTask jokeTask = new EndpointsAsyncTask();
            jokeTask.execute(InstrumentationRegistry.getTargetContext());
            result = jokeTask.get(30, TimeUnit.SECONDS);
        } catch (Exception e){
            e.printStackTrace();
            fail("Timed out");
        }

        assertFalse(TextUtils.isEmpty(result));
        assertFalse(result.contains("error"));
    }
}