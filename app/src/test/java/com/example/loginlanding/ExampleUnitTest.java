package com.example.loginlanding;

import org.junit.Test;

import static org.junit.Assert.*;

import android.app.Instrumentation;
import android.content.Context;

import androidx.room.Room;

import com.example.loginlanding.db.AppDatabase;
import com.example.loginlanding.db.UserDAO;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

}