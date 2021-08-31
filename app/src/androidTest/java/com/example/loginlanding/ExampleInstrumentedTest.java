package com.example.loginlanding;

import android.content.Context;
import android.content.Intent;

import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import com.example.loginlanding.db.AppDatabase;
import com.example.loginlanding.db.UserDAO;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.loginlanding", appContext.getPackageName());
    }




//    @Test
//    public void changeIntent(){
//        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
//
//        Intent intent = LandingActivity.getIntent(appContext.getApplicationContext(), "test");
//        appContext.startActivity(intent);
//    }

    @Test
    public void verifyUser(){
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        UserDAO userDAO = Room.databaseBuilder(appContext, AppDatabase.class, AppDatabase.DB_NAME)
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build()
                .getUserDAO();

        assertNotNull(userDAO.getUserByUsername("test"));
    }

    @Test
    public void verifyPassword(){
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        UserDAO userDAO = Room.databaseBuilder(appContext, AppDatabase.class, AppDatabase.DB_NAME)
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build()
                .getUserDAO();

        User user = userDAO.getUserByUsername("test");
        assertEquals(user.getPassword(), "test");
    }



}