package com.example.deyvis.exam02.Presentador;

import com.example.deyvis.exam02.Interface.SignUp;
import com.example.deyvis.exam02.Modelo.SigNupModel;

/**
 * Created by DEYVIS on 02/05/2018.
 */

public class SignUpPresenter implements SignUp.presenter,SignUp.TakListener {

private SignUp.Vista vista;
private SignUp.Model model;

    public SignUpPresenter(SignUp.Vista vista) {
        this.vista = vista;
        model= new SigNupModel(this);
    }

    @Override
    public void ondestroy() {
      vista= null;
    }

    @Override
    public void doSignup(String name, String apellido, String user, String Pass) {
          if(vista!=null){
              vista.disableInputs();
              vista.showProgress();
          }
          model.Signup(name,apellido,user,Pass);
    }

    @Override
    public void onSucess() {
        vista.enableInputs();
        vista.hideProgress();
        vista.onSignup();
    }

    @Override
    public void onError(String error) {
if(vista!=null){
    vista.enableInputs();
    vista.hideProgress();
    vista.onError(error);
}
    }
}
