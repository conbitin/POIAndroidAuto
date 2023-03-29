package com.toinx.navigation.androidauto;

import android.util.Log;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Observer implements DefaultLifecycleObserver {
    private static final String TAG = "Screen Status";

    @Override
    public void onCreate(LifecycleOwner owner) {
        Log.i(TAG, "onCreate");

    }

    @Override
    public void onStart(LifecycleOwner owner) {
        Log.i("Screen Status", "onStart");
    }

    @Override
    public void onResume(LifecycleOwner owner) {
        Log.i(TAG, "onResume");
    }

    @Override
    public void onPause(LifecycleOwner owner) {
        Log.i(TAG, "onPause");
    }

    @Override
    public void onStop(LifecycleOwner owner) {
        Log.i("Screen Status", "onStop");
    }

    @Override
    public void onDestroy(LifecycleOwner owner) {
        Log.i("Screen Status", "onDestroy");
    }
}
