package app.android.mmauri.laboratorio_07_toolbar_tabs.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import app.android.mmauri.laboratorio_07_toolbar_tabs.Models.Country;

/**
 * Created by marc on 11/8/17.
 */

public class Util {

    static public List<Country> getCountries() {
        return new ArrayList<Country>() {{
            add(new Country("España", "ES"));
            add(new Country("Argentina", "AR"));
            add(new Country("Bolivia", "BO"));
            add(new Country("Chile", "CL"));
            add(new Country("Colombia", "CO"));
            add(new Country("Ecuador", "EC"));
            add(new Country("Mexico", "MX"));
            add(new Country("Perú", "PE"));
            add(new Country("Uruguay", "UY"));
            add(new Country("Venezuela", "VE"));
        }};
    }
}
