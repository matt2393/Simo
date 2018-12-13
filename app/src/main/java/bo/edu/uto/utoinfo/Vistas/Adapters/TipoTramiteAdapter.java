package bo.edu.uto.utoinfo.Vistas.Adapters;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import bo.edu.uto.utoinfo.Modelos.TiposTram;
import bo.edu.uto.utoinfo.Modelos.Tramite;
import bo.edu.uto.utoinfo.R;
import bo.edu.uto.utoinfo.Tools.Const;
import bo.edu.uto.utoinfo.Vistas.Fragments.FragmentTramites;
import bo.edu.uto.utoinfo.Vistas.ViewHolders.TipoTramiteViewHolder;

public class TipoTramiteAdapter extends RecyclerView.Adapter<TipoTramiteViewHolder> {

    private ArrayList<TiposTram> tipos;
    private ArrayList<Tramite> tramites;
    private int tipo_adapter;
    private FragmentActivity fragmentActivity;
    private int id_conten;

    public TipoTramiteAdapter(ArrayList<TiposTram> tipos, FragmentActivity fragmentActivity, int id_conten) {
        this.tipos = tipos;
        this.tipo_adapter = Const.TIPO;
        this.fragmentActivity=fragmentActivity;
        this.id_conten=id_conten;
    }

    public TipoTramiteAdapter(ArrayList<Tramite> tramites, int tipo_adapter, FragmentActivity fragmentActivity,int id_conten) {
        this.tramites = tramites;
        this.tipo_adapter = tipo_adapter;
        this.fragmentActivity=fragmentActivity;
        this.id_conten=id_conten;
    }

    @NonNull
    @Override
    public TipoTramiteViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.rec_tipos_y_tramites,viewGroup,false);

        return new TipoTramiteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TipoTramiteViewHolder tipoTramiteViewHolder, int i) {
        final TiposTram tipo=tipo_adapter==Const.TIPO?tipos.get(i):null;
        final Tramite tram=tipo_adapter==Const.TRAMITE?tramites.get(i):null;

        String aux=tipo_adapter==Const.TIPO?tipos.get(i).getUsuarios():tramites.get(i).getTramite();
        tipoTramiteViewHolder.tipo_tram.setText(aux);
        int aux2=tipo_adapter==Const.TIPO?R.drawable.tipos_t:R.drawable.tramite;
        tipoTramiteViewHolder.tipo_tram.setBackgroundResource(aux2);

        tipoTramiteViewHolder.tipo_tram.setOnClickListener(v -> {
            FragmentTramites fr;
            if(tipo_adapter==Const.TIPO){
                fr=FragmentTramites.newIntance(Const.TRAMITE,tipo.getUsuarios(),
                        tipo.getId_tipo_usuario(),id_conten);
            }
            else{
                fr=FragmentTramites.newIntance(Const.DETALLE,tram.getTramite(),
                        tram.getId_tramite(),id_conten);
            }
            addFrag(fr);
        });
    }

    @Override
    public int getItemCount() {
        return tipo_adapter==Const.TIPO?tipos.size():tramites.size();
    }

    private void addFrag(FragmentTramites fr){
        fragmentActivity.getSupportFragmentManager()
                .beginTransaction()
                .replace(id_conten,fr,FragmentTramites.TAG)
                .addToBackStack(null)
                .commit();
    }
}
