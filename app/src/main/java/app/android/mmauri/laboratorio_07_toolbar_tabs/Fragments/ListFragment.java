package app.android.mmauri.laboratorio_07_toolbar_tabs.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import app.android.mmauri.laboratorio_07_toolbar_tabs.Adapters.PersonAdapter;
import app.android.mmauri.laboratorio_07_toolbar_tabs.Models.Person;
import app.android.mmauri.laboratorio_07_toolbar_tabs.R;

public class ListFragment extends Fragment {

    private List<Person> people;
    private ListView listView;
    private PersonAdapter adapter;


    public ListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        people = new ArrayList<>();
        adapter = new PersonAdapter(getContext(), R.layout.list_view_item_person, people);
        listView = (ListView) view.findViewById(R.id.listViewPeople);
        listView.setAdapter(adapter);

        return view;
    }

    public void addPerson(Person person) {
        this.people.add(person);
        adapter.notifyDataSetChanged();
    }

}
