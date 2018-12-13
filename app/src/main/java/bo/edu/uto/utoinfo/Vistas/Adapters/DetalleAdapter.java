package bo.edu.uto.utoinfo.Vistas.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import bo.edu.uto.utoinfo.Modelos.DetalleTramite;
import bo.edu.uto.utoinfo.R;
import bo.edu.uto.utoinfo.Vistas.ViewHolders.DetalleViewHolder;

public class DetalleAdapter extends RecyclerView.Adapter<DetalleViewHolder> {

    public ArrayList<DetalleTramite> detalles;

    public DetalleAdapter(ArrayList<DetalleTramite> detalles) {
        this.detalles = detalles;
    }

    @NonNull
    @Override
    public DetalleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.rec_detalle, viewGroup,false);
        return new DetalleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DetalleViewHolder detalleViewHolder, int i) {
        DetalleTramite det=detalles.get(i);
        detalleViewHolder.titulo.setText(det.getSub_tramite());
        detalleViewHolder.descripcion.setText(det.getDescripcion());
        detalleViewHolder.buscar.setText(det.getNombre());
        detalleViewHolder.lugar.setText(det.getReferencia());
    }

    @Override
    public int getItemCount() {
        return detalles.size();
    }
}
