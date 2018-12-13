package bo.edu.uto.utoinfo.Vistas.Dialogs;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import bo.edu.uto.utoinfo.R;
import bo.edu.uto.utoinfo.Tools.GlideApp;

public class DialogImagen extends DialogFragment {
    public final static String TAG="DialogImagen";
    private final static String URL_IMG="url_img";
    private String url;

    public static DialogImagen newInstance(String url){
        Bundle bn=new Bundle();
        bn.putString(URL_IMG,url);
        DialogImagen dd=new DialogImagen();
        dd.setArguments(bn);
        return dd;
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder alert=new AlertDialog.Builder(getActivity());
        View view=getActivity().getLayoutInflater()
                .inflate(R.layout.dialog_imagen,null);

        ImageView imagen=view.findViewById(R.id.imagen_grande);

        if(getArguments()!=null){
            url=getArguments().getString(URL_IMG);
            GlideApp.with(getActivity())
                    .load(url)
                    .into(imagen);
        }

        alert.setView(view);

        return alert.create();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(getDialog().getWindow()!=null){
            getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }

        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
