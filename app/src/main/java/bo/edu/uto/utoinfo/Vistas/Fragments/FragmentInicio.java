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

public class FragmentInicio extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_inicio,container,false);
        TextView entrar=view.findViewById(R.id.entrar_inicio);
        entrar.setOnClickListener(v -> getActivity().getSupportFragmentManager()
            .beginTransaction().replace(R.id.contenedor_login,FragmentLogin.newInstance())
            .commit());

        return view;
    }
}
