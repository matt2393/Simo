package bo.edu.uto.utoinfo.Presentador.Presenter;

import bo.edu.uto.utoinfo.Modelos.EstMatricula;
import bo.edu.uto.utoinfo.Modelos.Matricula;
import bo.edu.uto.utoinfo.Presentador.Interceptor.MatriculaInterceptor;
import bo.edu.uto.utoinfo.Vistas.View.MatriculaView;

public class MatriculaPresenter extends MatriculaInterceptor.OnFinishMatricula {
    private MatriculaView matriculaView;
    private MatriculaInterceptor matriculaInterceptor;
    private String id_e,id_p;

    public MatriculaPresenter(MatriculaView matriculaView, MatriculaInterceptor matriculaInterceptor) {
        this.matriculaView = matriculaView;
        this.matriculaInterceptor = matriculaInterceptor;
    }

    public void load(String id_p,String id_e){
        this.id_p=id_p;
        this.id_e=id_e;
        matriculaView.showLoad();
        matriculaInterceptor.loadMat(id_p,id_e,this);
    }

    private void loadEstM(String id_p,String id_e){
        matriculaInterceptor.loadEstMat(id_p,id_e,this);
    }

    @Override
    protected void onLoadMatricula(Matricula mt) {
        if(mt.getEsta_pagado().equals("t")){
            matriculaView.hideLoad();
            matriculaView.onLoadMatricula(mt);
        }
        else{
            loadEstM(id_p,id_e);
        }
    }

    @Override
    protected void onLoadEstMat(EstMatricula estMat) {
        matriculaView.hideLoad();
        matriculaView.onLoadEstMatricula(estMat);
    }

    @Override
    protected void onErrorMat(Throwable e) {
        matriculaView.hideLoad();
        matriculaView.onErrorMatricula(e);
    }

    @Override
    protected void onErrorEstMat(Throwable e) {
        matriculaView.hideLoad();
        matriculaView.onErrorEstMat(e);
    }
}
