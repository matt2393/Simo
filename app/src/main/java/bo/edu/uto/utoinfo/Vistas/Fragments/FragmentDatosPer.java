package bo.edu.uto.utoinfo.Vistas.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import bo.edu.uto.utoinfo.Modelos.Persona;
import bo.edu.uto.utoinfo.Presentador.Interceptor.PersonaInterceptor;
import bo.edu.uto.utoinfo.Presentador.Presenter.PersonaPresenter;
import bo.edu.uto.utoinfo.R;
import bo.edu.uto.utoinfo.Vistas.Dialogs.DialogLoad;
import bo.edu.uto.utoinfo.Vistas.View.PersonaView;

public class FragmentDatosPer extends Fragment implements PersonaView {
    public final static String TAG="FragmentDatosPer";
    private final static String ID_P="ID_P";
    private TextView ap_p,ap_m,nom,ap_cas,pais,dep,prov;
    private TextView loc,fech_n,dir,tel,cel,correo,dep_co;
    private TextView dis_co,col,tip_doc,num_doc,exp,sex,est_ci;

    private PersonaPresenter personaPresenter;
    private String id_p;
    private DialogLoad dialogLoad;

    public static FragmentDatosPer newInstance(String id_p){
        Bundle bn=new Bundle();
        bn.putString(ID_P,id_p);
        FragmentDatosPer fr=new FragmentDatosPer();
        fr.setArguments(bn);
        return fr;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_datos_per,container,false);
        ap_p=view.findViewById(R.id.ape_pat);
        ap_m=view.findViewById(R.id.ape_mat);
        nom=view.findViewById(R.id.nomb);
        ap_cas=view.findViewById(R.id.apc);
        pais=view.findViewById(R.id.pais);
        dep=view.findViewById(R.id.depto_orig);
        prov=view.findViewById(R.id.prov);
        loc=view.findViewById(R.id.local);
        fech_n=view.findViewById(R.id.fech_nac);
        dir=view.findViewById(R.id.dir);
        tel=view.findViewById(R.id.telf);
        cel=view.findViewById(R.id.cel);
        correo=view.findViewById(R.id.correo);
        dep_co=view.findViewById(R.id.depto_col);
        dis_co=view.findViewById(R.id.distr_col);
        col=view.findViewById(R.id.cole);
        tip_doc=view.findViewById(R.id.tip_doc);
        num_doc=view.findViewById(R.id.num_doc);
        exp=view.findViewById(R.id.exped);
        sex=view.findViewById(R.id.sexo);
        est_ci=view.findViewById(R.id.est_civil);

        dialogLoad=DialogLoad.newInstance();

        personaPresenter=new PersonaPresenter(this,new PersonaInterceptor());

        if(getArguments()!=null){
            id_p=getArguments().getString(ID_P);
            personaPresenter.load(id_p);
        }

        return view;
    }

    @Override
    public void onLoadPersona(Persona p) {
        ap_p.setText(p.getPaterno());
        ap_m.setText(p.getMaterno());
        nom.setText(p.getNombres());
        ap_cas.setText(p.getAp_casada());
        pais.setText(p.getPais());
        dep.setText(p.getDepartamento());
        prov.setText(p.getProvincia());
        loc.setText(p.getLocalidad());
        fech_n.setText(p.getFec_nacimiento());
        dir.setText(p.getDireccion());
        tel.setText(p.getTelefono());
        cel.setText(p.getCelular());
        correo.setText(p.getCorreo());
        dep_co.setText(p.getDpto());
        dis_co.setText(p.getDistrito());
        col.setText(p.getColegio());
        tip_doc.setText(p.getTipo_documento());
        num_doc.setText(p.getDip());
        exp.setText(p.getTipo_exp());
        sex.setText(p.getTipo_sexo());
        est_ci.setText(p.getTipo_estado_civil());
    }

    @Override
    public void onError(Throwable e) {

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
}
