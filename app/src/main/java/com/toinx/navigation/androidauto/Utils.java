package com.toinx.navigation.androidauto;

import com.toinx.navigation.androidauto.data.PoiData;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by toinx on 29/03/2023.
 */
public class Utils {
    public static final List<PoiData> mockPoiData = Arrays.asList(
            new PoiData("Burj Khalifa", 25.19743592616538, 55.27438073304927),
            new PoiData("Sheikh Zayed Grand Mosque", 24.412999467060825, 54.47498612694363),
            new PoiData("Burj Khalifa Lake", 25.1928238599453, 55.27468900577666)
    );
}
