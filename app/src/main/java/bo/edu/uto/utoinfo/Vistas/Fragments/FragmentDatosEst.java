package bo.edu.uto.utoinfo.Vistas.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import bo.edu.uto.utoinfo.Modelos.Estudiante;
import bo.edu.uto.utoinfo.Presentador.Interceptor.EstudianteInterceptor;
import bo.edu.uto.utoinfo.Presentador.Presenter.EstudiantePresenter;
import bo.edu.uto.utoinfo.R;
import bo.edu.uto.utoinfo.Vistas.Dialogs.DialogLoad;
import bo.edu.uto.utoinfo.Vistas.View.EstudianteView;

public class FragmentDatosEst extends Fragment implements EstudianteView {
    public final static String TAG="FragmentDatosEst";
    private final static String ID_E="ID_EST";

    private TextView facultad,carrera,programa,
            sede,matr,tipo_est,tipo_ad,ges_ac,ges_in;

    private EstudiantePresenter estudiantePresenter;
    private String id_e;
    private DialogLoad dialogLoad;

    public static FragmentDatosEst newInstance(String id_est){
        Bundle bn=new Bundle();
        bn.putString(ID_E,id_est);
        FragmentDatosEst fr=new FragmentDatosEst();
        fr.setArguments(bn);
        return fr;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_datos_est,container,false);

        facultad=view.findViewById(R.id.facultad);
        carrera=view.findViewById(R.id.carrera);
        programa=view.findViewById(R.id.programa);
        sede=view.findViewById(R.id.sede);
        matr=view.findViewById(R.id.tipo_matricula);
        tipo_est=view.findViewById(R.id.tipo_est);
        tipo_ad=view.findViewById(R.id.tipo_ad);
        ges_ac=view.findViewById(R.id.ges_ac);
        ges_in=view.findViewById(R.id.ges_in);

        dialogLoad=DialogLoad.newInstance();

        if(getArguments()!=null){
            id_e=getArguments().getString(ID_E);
            Log.e("MATT",id_e+"");
            if(!TextUtils.isEmpty(id_e)){
                estudiantePresenter=
                        new EstudiantePresenter(this,new EstudianteInterceptor());

                estudiantePresenter.loadEst(id_e);
            }
        }



        return view;
    }

    @Override
    public void onLoad(Estudiante es) {
        Log.e("Matt",es.getFacultad());
        facultad.setText(es.getFacultad());
        carrera.setText(es.getCarrera());
        programa.setText(es.getPrograma());
        sede.setText(es.getSede());
        matr.setText(es.getMatricula());
        tipo_est.setText(es.getTipo_estudiante());
        tipo_ad.setText(es.getTipo_admision());
        ges_ac.setText(es.get_gestion());
        ges_in.setText(es.getGesing());
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

    @Override
    public void error(Throwable e) {
        Log.e("MATT",e.toString());
    }
}
