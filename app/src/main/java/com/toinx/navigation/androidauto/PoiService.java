package com.toinx.navigation.androidauto;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;

import androidx.annotation.NonNull;
import androidx.car.app.CarAppService;
import androidx.car.app.Screen;
import androidx.car.app.ScreenManager;
import androidx.car.app.Session;
import androidx.car.app.validation.HostValidator;

public class PoiService extends CarAppService {
    @NonNull
    @Override
    public HostValidator createHostValidator() {
        return HostValidator.ALLOW_ALL_HOSTS_VALIDATOR;
    }

    public Session onCreateSession() {
        return new Session() {
            @NonNull
            @Override
            public Screen onCreateScreen(@NonNull Intent intent) {
                if (getCarContext().checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                   return new PoiScreen(getCarContext(), 100);
                }

                // If we do not have the location permission, show the request permission screen.
                ScreenManager screenManager = getCarContext().getCarService(ScreenManager.class);
                screenManager.push(PoiScreen.create(getCarContext()));
                return new RequestPermissionScreen(getCarContext(), () -> screenManager.pop());
            }
        };
    }
}
