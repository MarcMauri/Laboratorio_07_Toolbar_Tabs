package app.android.mmauri.laboratorio_07_toolbar_tabs.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import app.android.mmauri.laboratorio_07_toolbar_tabs.Models.Person;
import app.android.mmauri.laboratorio_07_toolbar_tabs.R;

/**
 * Created by marc on 11/8/17.
 */

public class PersonAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Person> people;

    public PersonAdapter(Context context, int layout, List<Person> people) {
        this.context = context;
        this.layout = layout;
        this.people = people;
    }

    @Override
    public int getCount() {
        if (this.people == null)
            return 0;

        return this.people.size();
    }

    @Override
    public Object getItem(int position) {
        return this.people.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(this.context).inflate(this.layout, null);
            holder = new ViewHolder();
            holder.flag = (ImageView) convertView.findViewById(R.id.imageViewFlag);
            holder.personName = (TextView) convertView.findViewById(R.id.textViewListPersonName);
            holder.countryName = (TextView) convertView.findViewById(R.id.textViewListCountryName);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        /* Recuperamos la persona para pintar sus valores */
        Person currentPerson = people.get(position);
        /* Hacemos uso de Picasso para la bandera */
        Picasso.with(context).load(currentPerson.getCountry().getFlagURL()).fit().into(holder.flag);
        holder.personName.setText(currentPerson.getName());
        holder.countryName.setText(currentPerson.getCountry().getName());

        return convertView;
    }

    private class ViewHolder {
        private ImageView flag;
        private TextView personName;
        private TextView countryName;
    }
}
