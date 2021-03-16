package ussrfantom.com.example.focusstartandroid.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ussrfantom.com.example.focusstartandroid.R;
import ussrfantom.com.example.focusstartandroid.pojo.Valute;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder> {

    private List<Valute> valutes;

    public List<Valute> getValutes() {
        return valutes;
    }

    public void setValutes(List<Valute> valutes) {
        this.valutes = valutes;
        Log.i("12312312312312", String.valueOf(valutes.size()));
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.currency_item, parent, false);
        return new EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {
        Valute valute = valutes.get(position);
        holder.textViewPrevious.setText(valute.getPrevious().toString());
        holder.textViewNominal.setText(String.valueOf(valute.getNominal()));
        holder.textViewName.setText(valute.getName());
        holder.textViewValue.setText(valute.getValue().toString());
    }

    @Override

    public int getItemCount() {
        return valutes.size();

    }


    class EmployeeViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewPrevious;
        private TextView textViewNominal;
        private TextView textViewName;
        private TextView textViewValue;

        public EmployeeViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNominal = itemView.findViewById(R.id.textViewNominal);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewValue = itemView.findViewById(R.id.textViewValue);
            textViewPrevious = itemView.findViewById(R.id.textViewPrevious);
        }
    }
}
