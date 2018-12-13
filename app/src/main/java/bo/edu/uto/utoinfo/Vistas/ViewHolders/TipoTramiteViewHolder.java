package bo.edu.uto.utoinfo.Vistas.ViewHolders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import bo.edu.uto.utoinfo.R;

public class TipoTramiteViewHolder extends RecyclerView.ViewHolder {
    public TextView tipo_tram;
    public TipoTramiteViewHolder(@NonNull View itemView) {
        super(itemView);
        tipo_tram=itemView.findViewById(R.id.tipo_tram);
    }
}
