package bo.edu.uto.utoinfo.Vistas.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import bo.edu.uto.utoinfo.Modelos.DetalleTramite;
import bo.edu.uto.utoinfo.Modelos.TiposTram;
import bo.edu.uto.utoinfo.Modelos.Tramite;
import bo.edu.uto.utoinfo.Presentador.Interceptor.DetalleInterceptor;
import bo.edu.uto.utoinfo.Presentador.Interceptor.TipoInterceptor;
import bo.edu.uto.utoinfo.Presentador.Interceptor.TramiteInterceptor;
import bo.edu.uto.utoinfo.Presentador.Presenter.DetallePresenter;
import bo.edu.uto.utoinfo.Presentador.Presenter.TipoPresenter;
import bo.edu.uto.utoinfo.Presentador.Presenter.TramitePresenter;
import bo.edu.uto.utoinfo.R;
import bo.edu.uto.utoinfo.Tools.Const;
import bo.edu.uto.utoinfo.Vistas.Adapters.DetalleAdapter;
import bo.edu.uto.utoinfo.Vistas.Adapters.TipoTramiteAdapter;
import bo.edu.uto.utoinfo.Vistas.Dialogs.DialogLoad;
import bo.edu.uto.utoinfo.Vistas.View.DetalleView;
import bo.edu.uto.utoinfo.Vistas.View.TipoView;
import bo.edu.uto.utoinfo.Vistas.View.TramiteView;

public class FragmentTramites extends Fragment
        implements TipoView,TramiteView,DetalleView {

    public final static String TAG="FragmentTramite";
    private final static String TIPO_FRAG="tipo_frag";
    private final static String TITULO_FRAG="titulo_frag";
    private final static String ID="id";
    private final static String ID_CONTEN="id_content";
    private int tipo_frag;
    private String titulo;
    private String id;
    private int id_conten;
    private RecyclerView rec;
    private TextView tit;
    private DialogLoad dialogLoad;
    private RecyclerView.Adapter adapter;
    private TipoPresenter tipoPresenter;
    private TramitePresenter tramitePresenter;
    private DetallePresenter detallePresenter;

    public static FragmentTramites newIntance(int tipo_frag, String titulo, String id, int id_conten){
        Bundle bn=new Bundle();
        bn.putInt(TIPO_FRAG,tipo_frag);
        bn.putString(ID,id);
        bn.putString(TITULO_FRAG,titulo);
        bn.putInt(ID_CONTEN,id_conten);
        FragmentTramites fr=new FragmentTramites();
        fr.setArguments(bn);
        return fr;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_tramites,container,false);

        rec=view.findViewById(R.id.recycler_tramite);
        tit=view.findViewById(R.id.titulo_tramite);
        dialogLoad=DialogLoad.newInstance();

        rec.setLayoutManager(new LinearLayoutManager(getActivity()));

        if(getArguments()!=null){
            tipo_frag=getArguments().getInt(TIPO_FRAG,0);
            titulo=getArguments().getString(TITULO_FRAG);
            id=getArguments().getString(ID,"0");
            id_conten=getArguments().getInt(ID_CONTEN);

            tit.setText(titulo);
            if(tipo_frag==Const.TIPO){
                tipoPresenter=new TipoPresenter(this,new TipoInterceptor());
                tipoPresenter.loadTipo();
            }
            else if(tipo_frag==Const.TRAMITE){
                tramitePresenter=new TramitePresenter(this,new TramiteInterceptor());
                tramitePresenter.loadTramite(id);
            }
            else{
                detallePresenter=new DetallePresenter(this,new DetalleInterceptor());
                detallePresenter.loadDetalle(id);
            }
        }

        return view;
    }

    @Override
    public void loadDetalle(List<DetalleTramite> detalles) {
        rec.setAdapter(new DetalleAdapter(new ArrayList<>(detalles)));
    }

    @Override
    public void errorDetalle(Throwable e) {
        Toast.makeText(getActivity(),e.getMessage(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loadtipo(List<TiposTram> tipos) {
        rec.setAdapter(new TipoTramiteAdapter(
                new ArrayList<>(tipos),getActivity(),id_conten));
    }

    @Override
    public void errorTipo(Throwable e) {
        Toast.makeText(getActivity(),e.getMessage(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loadTramite(List<Tramite> tramites) {
        rec.setAdapter(new TipoTramiteAdapter(
                new ArrayList<>(tramites),
                Const.TRAMITE,
                getActivity(),
                id_conten
        ));
    }

    @Override
    public void errorTramite(Throwable e) {
        Toast.makeText(getActivity(),e.getMessage(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoad() {
        if(dialogLoad!=null)
            dialogLoad.show(getActivity().getSupportFragmentManager(),
                    DialogLoad.TAG);
    }

    @Override
    public void hideLoad() {
        if(dialogLoad!=null)
            dialogLoad.dismiss();
    }
}
