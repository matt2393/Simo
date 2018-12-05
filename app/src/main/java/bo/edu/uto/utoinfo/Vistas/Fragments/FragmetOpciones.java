package bo.edu.uto.utoinfo.Vistas.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import bo.edu.uto.utoinfo.R;

public class FragmetOpciones extends Fragment implements View.OnClickListener {
    public final static String TAG="FragmentOpciones";
    private final static String ID_E="id_Est";
    private final static String ID_P="id_per";

    private String id_e,id_p;

    public static FragmetOpciones newInstence(String id_e,String id_p){
        Bundle bn=new Bundle();
        bn.putString(ID_E,id_e);
        bn.putString(ID_P,id_p);
        FragmetOpciones fr=new FragmetOpciones();
        fr.setArguments(bn);
        return fr;
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragmet_opciones,container,false);
        TextView datos_est,datos_per,matricula,tramites;
        datos_est=view.findViewById(R.id.datos_est);
        datos_per=view.findViewById(R.id.datos_per);
        matricula=view.findViewById(R.id.matricula);
        tramites=view.findViewById(R.id.tramites);

        datos_est.setOnClickListener(this);
        datos_per.setOnClickListener(this);
        matricula.setOnClickListener(this);
        tramites.setOnClickListener(this);

        if(getArguments()!=null){
            id_e=getArguments().getString(ID_E);
            id_p=getArguments().getString(ID_P);
        }

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.datos_est:
                addFr(FragmentDatosEst.newInstance(id_e),FragmentDatosEst.TAG);
                 break;
            case R.id.datos_per:
                addFr(FragmentDatosPer.newInstance(id_p),FragmentDatosPer.TAG);
                break;
            case R.id.matricula: break;
            case R.id.tramites: break;
        }
    }

    private void addFr(Fragment fr,String tag){
        getActivity().getSupportFragmentManager()
                .beginTransaction().replace(R.id.contenedor_main,
                fr,tag)
                .addToBackStack(FragmentDatosEst.TAG)
                .commit();
    }
}
