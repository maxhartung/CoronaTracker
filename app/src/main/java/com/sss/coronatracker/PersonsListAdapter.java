package com.sss.coronatracker;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PersonsListAdapter extends RecyclerView.Adapter<PersonsListAdapter.MyViewHolder> {

    private List<PersonsClass> dataSet;

    public PersonsListAdapter(List<PersonsClass> data) {
        this.dataSet = data;
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.person_grid_item, parent, false);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {
        Resources res = holder.itemView.getContext().getResources();

        TextView nr_infectie = holder.nr_infectie;
        TextView judet = holder.judet;
        TextView varsta = holder.varsta;
        TextView sex = holder.sex;
        TextView wasIzloare = holder.wasIzloare;
        TextView wasCarantina = holder.wasCarantina;
        TextView fromCountry = holder.fromCountry;
        TextView asimptomatic = holder.asimptomatic;
        TextView virus_from_persoana = holder.virus_from_persoana;
        TextView grav = holder.grav;
        TextView decedat = holder.decedat;
        TextView vindecat = holder.vindecat;
        TextView alta_boala = holder.alta_boala;
        TextView data_infectiei = holder.data_infectiei;


        nr_infectie.setText(res.getString(R.string.numar_infectie, dataSet.get(listPosition).getNumar_infectie()));
        judet.setText(res.getString(R.string.judet, dataSet.get(listPosition).getJudet()));
        varsta.setText(res.getString(R.string.varsta, dataSet.get(listPosition).getVarsta()));
        sex.setText(res.getString(R.string.sex, dataSet.get(listPosition).getSex()));
        wasIzloare.setText(res.getString(R.string.izloare, dataSet.get(listPosition).getWas_izolare()));
        wasCarantina.setText(res.getString(R.string.carantina, dataSet.get(listPosition).getWas_carantina()));
        fromCountry.setText(res.getString(R.string.din_tara, dataSet.get(listPosition).getFrom_country()));
        asimptomatic.setText(res.getString(R.string.asimptomatic, dataSet.get(listPosition).getAsimptomatic()));
        virus_from_persoana.setText(res.getString(R.string.virus_de_la_alta_persoana, dataSet.get(listPosition).getVirus_from_persoana()));
        grav.setText(res.getString(R.string.grav, dataSet.get(listPosition).getGrav()));
        decedat.setText(res.getString(R.string.decedat, dataSet.get(listPosition).getDecedat()));
        vindecat.setText(res.getString(R.string.vindecat, dataSet.get(listPosition).getVindecat()));
        alta_boala.setText(res.getString(R.string.alta_boala, dataSet.get(listPosition).getAlta_boala()));
        data_infectiei.setText(res.getString(R.string.data_infectie, dataSet.get(listPosition).getData_infectiei()));

        holder.itemView.setOnClickListener((View v) -> {

        });
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView nr_infectie,
                judet,
                varsta,
                sex,
                wasIzloare,
                wasCarantina,
                fromCountry,
                asimptomatic,
                virus_from_persoana,
                grav,
                decedat,
                vindecat,
                alta_boala,
                data_infectiei;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.nr_infectie = itemView.findViewById(R.id.tw_nr_infectie);
            this.judet = itemView.findViewById(R.id.tw_judet);
            this.varsta = itemView.findViewById(R.id.tw_varsta);
            this.sex = itemView.findViewById(R.id.tw_sex);
            this.wasIzloare = itemView.findViewById(R.id.tw_wasIzolare);
            this.wasCarantina = itemView.findViewById(R.id.tw_wasCarantina);
            this.fromCountry = itemView.findViewById(R.id.tw_FromCountry);
            this.asimptomatic = itemView.findViewById(R.id.tw_asimptomatic);
            this.virus_from_persoana = itemView.findViewById(R.id.tw_virus_from_persoana);
            this.grav = itemView.findViewById(R.id.tw_grav);
            this.decedat = itemView.findViewById(R.id.tw_decedat);
            this.vindecat = itemView.findViewById(R.id.tw_vindecat);
            this.alta_boala = itemView.findViewById(R.id.tw_altaboala);
            this.data_infectiei = itemView.findViewById(R.id.tw_data_infectiei);
        }
    }
}