package app.android.mmauri.laboratorio_07_toolbar_tabs.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import app.android.mmauri.laboratorio_07_toolbar_tabs.Interfaces.OnCreatedPerson;
import app.android.mmauri.laboratorio_07_toolbar_tabs.Models.Country;
import app.android.mmauri.laboratorio_07_toolbar_tabs.Models.Person;
import app.android.mmauri.laboratorio_07_toolbar_tabs.R;
import app.android.mmauri.laboratorio_07_toolbar_tabs.Utils.Util;

public class FormFragment extends Fragment {

    private List<Country> countries;

    private EditText editTextFormPersonName;
    private Spinner spinnerCountry;
    private Button buttonCreatePerson;

    private OnCreatedPerson onCreatedPerson;


    public FormFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            onCreatedPerson = (OnCreatedPerson) context;
        } catch (Exception e) {
            throw new ClassCastException(context.toString() + " should implement DataListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        onCreatedPerson = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_form, container, false);

        editTextFormPersonName = (EditText) view.findViewById(R.id.editTextFormPersonName);
        spinnerCountry = (Spinner) view.findViewById(R.id.spinnerCountry);
        buttonCreatePerson = (Button) view.findViewById(R.id.buttonCreatePerson);
        buttonCreatePerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createPerson();
            }
        });

        // Obtenemos todos los paises
        countries = Util.getCountries();

        // Creamos un ArrayAdapter para ser pasado a nuestro Spinner
        // Con un layout integrado en Android para su uso directo, llamado
        // simple_spinner_dropdown_item
        //ArrayAdapter<Country> adapter = new ArrayAdapter<Country>(getContext(),R.layout.support_simple_spinner_dropdown_item,countries);
        ArrayAdapter<Country> adapter = new ArrayAdapter<Country>(getContext(), android.R.layout.simple_spinner_dropdown_item, countries);
        spinnerCountry.setAdapter(adapter);


        return view;
    }

    private void createPerson() {
        String name = editTextFormPersonName.getText().toString();
        if (!name.isEmpty()) {
            Country country = (Country) spinnerCountry.getSelectedItem();
            Person person = new Person(name, country);

            /* Borramos los datos introducidos para que no se muestren la proxima vez */
            editTextFormPersonName.setText(null);
            spinnerCountry.setSelection(0);

            /* Usamos la interfaz para comunicarnos con el MainActivity y éste con el otro fragment */
            onCreatedPerson.createPerson(person);
        } else {
            Toast.makeText(getContext(), "The name is required", Toast.LENGTH_SHORT).show();
        }
    }

}
