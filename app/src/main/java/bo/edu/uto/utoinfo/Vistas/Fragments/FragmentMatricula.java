package bo.edu.uto.utoinfo.Vistas.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import bo.edu.uto.utoinfo.Modelos.EstMatricula;
import bo.edu.uto.utoinfo.Modelos.Matricula;
import bo.edu.uto.utoinfo.Presentador.Interceptor.MatriculaInterceptor;
import bo.edu.uto.utoinfo.Presentador.Presenter.MatriculaPresenter;
import bo.edu.uto.utoinfo.R;
import bo.edu.uto.utoinfo.Vistas.Dialogs.DialogLoad;
import bo.edu.uto.utoinfo.Vistas.View.MatriculaView;

public class FragmentMatricula extends Fragment implements MatriculaView {
    public final static String TAG="FragmentMatricula";
    private final static String ID_P="id_p";
    private final static String ID_E="id_e";

    private TextView estado,tit_estado;
    private TextView obs,tip_obs;
    private String id_p,id_e;
    private MatriculaPresenter matriculaPresenter;
    private DialogLoad dialogLoad;

    public static FragmentMatricula newInstance(String id_p,String id_e){
        Bundle bn=new Bundle();
        bn.putString(ID_P,id_p);
        bn.putString(ID_E,id_e);
        FragmentMatricula fr=new FragmentMatricula();
        fr.setArguments(bn);
        return fr;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_matricula,container,false);

        estado=view.findViewById(R.id.estado);
        tit_estado=view.findViewById(R.id.tit_estado);
        obs=view.findViewById(R.id.observ);
        tip_obs=view.findViewById(R.id.tit_observ);

        dialogLoad=DialogLoad.newInstance();

        matriculaPresenter=new MatriculaPresenter(this,new MatriculaInterceptor());

        if(getArguments()!=null){
            id_p=getArguments().getString(ID_P);
            id_e=getArguments().getString(ID_E);
            matriculaPresenter.load(id_p,id_e);
        }

        return view;
    }


    @Override
    public void onLoadMatricula(Matricula m) {
        tit_estado.setText("Estado pago:");
        String est=m.getEsta_pagado().equals("t")?"Pagado":"Sin Pago registrado";
        String obss=m.getEsta_pagado().equals("t")?"Total Cancelado:":"Total a pagar:";
        estado.setText(est);
        tip_obs.setText(obss);
        obs.setText(m.getMonto());
    }

    @Override
    public void onLoadEstMatricula(EstMatricula est_m) {
        tit_estado.setText("Estado:");
        int tt=Integer.parseInt(est_m.getTotal());
        String es=tt>0?"Sin Observar":"Observado";
        estado.setText(es);
        String obss=tt>0?"Total a cancelar a la fecha en Bs:":"Observación";
        tip_obs.setText(obss);
        obs.setText(mensaje(est_m.getTotal()));


    }

    @Override
    public void onErrorMatricula(Throwable e) {
        Toast.makeText(getContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onErrorEstMat(Throwable e) {
        Toast.makeText(getContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoad() {
        if(dialogLoad!=null)
            dialogLoad.show(getActivity().getSupportFragmentManager(),DialogLoad.TAG);
    }

    @Override
    public void hideLoad() {
        if(dialogLoad!=null)
            dialogLoad.dismiss();
    }

    private String mensaje(String total){
        int tot=Integer.parseInt(total);
        String ms;
        switch (tot){
            case -5: ms="Matrícula no disponible\nplan no activo debe realizar " +
                    "actualizacion de plan";break;
            case -4: ms="Matrícula no disponible por aportes";break;
            case -3: ms="Matrícula no disponible";break;
            case -2: ms="No habilitado para pagar\ndebe realizar readmision";break;
            case -1: ms="Ya tiene pago confirmado";break;
            default: ms=String.valueOf(tot);
        }
        return ms;
    }
}
