package bo.edu.uto.utoinfo.Vistas.ViewHolders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import bo.edu.uto.utoinfo.R;

public class DetalleViewHolder extends RecyclerView.ViewHolder {

    public TextView titulo,descripcion,buscar,lugar;
    public DetalleViewHolder(@NonNull View itemView) {
        super(itemView);
        titulo=itemView.findViewById(R.id.titulo_detalle);
        descripcion=itemView.findViewById(R.id.descripcion_detalle);
        buscar=itemView.findViewById(R.id.buscar_detalle);
        lugar=itemView.findViewById(R.id.lugar_detalle);
    }
}
