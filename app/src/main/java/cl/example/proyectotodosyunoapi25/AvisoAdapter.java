package cl.example.proyectotodosyunoapi25;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AvisoAdapter extends RecyclerView.Adapter<AvisoAdapter.AvisoViewHolder> {

    private List<Avisos> avisosList;

    public AvisoAdapter(List<Avisos> avisoList) {
        this.avisosList = avisoList;
    }

    @NonNull
    @Override
    public AvisoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_aviso, parent, false);
        return new AvisoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AvisoViewHolder holder, int position) {
        Avisos avisos = avisosList.get(position);
        holder.tvFecha.setText(avisos.getFecha());
        holder.tvMensaje.setText(avisos.getDescripcion());
        holder.tvNivel.setText("Nivel de alerta: " + avisos.getNivel());
    }

    @Override
    public int getItemCount() {
        return avisosList.size();
    }

    static class AvisoViewHolder extends RecyclerView.ViewHolder {
        TextView tvFecha, tvMensaje, tvNivel;

        public AvisoViewHolder(@NonNull View itemView) {
            super(itemView);
            tvFecha = itemView.findViewById(R.id.tvFecha);
            tvMensaje = itemView.findViewById(R.id.tvMensaje);
            tvNivel = itemView.findViewById(R.id.tvNivel);
        }
    }
}
