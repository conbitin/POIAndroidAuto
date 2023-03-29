package com.toinx.navigation.androidauto;

import androidx.annotation.NonNull;
import androidx.car.app.CarContext;
import androidx.car.app.Screen;
import androidx.car.app.model.ItemList;
import androidx.car.app.model.ListTemplate;
import androidx.car.app.model.OnClickListener;
import androidx.car.app.model.Row;
import androidx.car.app.model.SectionedItemList;
import androidx.car.app.model.Template;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import com.toinx.navigation.androidauto.data.PoiData;

public class PoiScreen extends Screen {
    private static final String TAG = PoiScreen.class.getSimpleName();
    private static final int DEFAULT_SCREEN_REFRESH_VALUE = 100;
    private int init = 0;

    private int refresh_delay;

    static PoiScreen create(@NonNull CarContext carContext) {
        return new PoiScreen(carContext, DEFAULT_SCREEN_REFRESH_VALUE);
    }
    static PoiScreen create(@NonNull CarContext carContext, int refresh_delay) {
        return new PoiScreen(carContext, refresh_delay);
    }

    public PoiScreen(CarContext carContext, int refresh_delay) {
        super(carContext);

        this.refresh_delay = refresh_delay;
        Log.i(TAG, String.valueOf(refresh_delay));

        getLifecycle().addObserver(new Observer());
    }

    @NonNull
    @Override
    public Template onGetTemplate() {
        ListTemplate.Builder builder = new ListTemplate.Builder();

        ItemList.Builder itemBuilderList = new ItemList.Builder();
        for (PoiData poiData: Utils.mockPoiData) {
            Row row = new Row.Builder().setTitle(poiData.getTitle()).addText(poiData.getSubtitle())
                    .setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick() {
                            startNavigation(poiData.buildPoiNavigationIntent());
                        }
                    }).build();

            itemBuilderList.addItem(row);
        }

        builder.addSectionedList(SectionedItemList.create(itemBuilderList.build(), "Poi Screen"));
        builder.setTitle("Poi List");
        return builder.build();
    }

    private void startNavigation(String navigationIntent) {
        Uri gmmIntentUri = Uri.parse(navigationIntent);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        mapIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Log.i(TAG, "Starting navigation with navigationIntent = " + navigationIntent);
        getCarContext().startActivity(mapIntent);

    }
}
