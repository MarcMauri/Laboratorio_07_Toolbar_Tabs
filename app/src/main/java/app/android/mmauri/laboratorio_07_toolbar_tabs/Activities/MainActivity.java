package app.android.mmauri.laboratorio_07_toolbar_tabs.Activities;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import app.android.mmauri.laboratorio_07_toolbar_tabs.Adapters.PagerAdapter;
import app.android.mmauri.laboratorio_07_toolbar_tabs.Fragments.ListFragment;
import app.android.mmauri.laboratorio_07_toolbar_tabs.Interfaces.OnCreatedPerson;
import app.android.mmauri.laboratorio_07_toolbar_tabs.Models.Person;
import app.android.mmauri.laboratorio_07_toolbar_tabs.R;

public class MainActivity extends AppCompatActivity implements OnCreatedPerson {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private PagerAdapter adapter;

    public final static int FROM_FRAGMENT_POSITION = 0;
    public final static int LIST_FRAGMENT_POSITION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setToolbar();
        setTabLayout();
        setViewPager();
        setListenerTabLayout();

    }

    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void setTabLayout() {
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.form));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.list));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
    }

    private void setViewPager() {
        adapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }

    private void setListenerTabLayout() {
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void createPerson(Person person) {
        /* Obtenemos el Fragment deseado para poder acceder a su funct() de insertar persona */
        ListFragment fragment = (ListFragment) getSupportFragmentManager().getFragments().get(LIST_FRAGMENT_POSITION);

        /* Ya podemos acceder a la funct() deseada */
        fragment.addPerson(person);

        /* Llevamos al listFragment despues de insertar una persona */
        viewPager.setCurrentItem(LIST_FRAGMENT_POSITION);
    }
}
