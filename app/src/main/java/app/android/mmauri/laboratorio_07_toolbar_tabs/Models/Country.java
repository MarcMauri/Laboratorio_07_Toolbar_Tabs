package app.android.mmauri.laboratorio_07_toolbar_tabs.Models;

import android.widget.Toast;

import app.android.mmauri.laboratorio_07_toolbar_tabs.Activities.MainActivity;

/**
 * Created by marc on 11/8/17.
 */

public class Country {

    private String name;
    private String countryCode;

    public Country(String name, String countryCode) {
        this.name = name;
        this.countryCode = countryCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getFlagURL() {
        return "http://www.geognos.com/api/en/countries/flag/" + this.countryCode + ".png";
    }

    @Override
    public String toString() {
        return this.countryCode + " - " + this.name;
    }
}
