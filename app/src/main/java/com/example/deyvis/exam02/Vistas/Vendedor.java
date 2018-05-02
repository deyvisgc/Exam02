package com.example.deyvis.exam02.Vistas;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.example.deyvis.exam02.Interface.SignUp;
import com.example.deyvis.exam02.Presentador.SignUpPresenter;
import com.example.deyvis.exam02.R;
import com.rengwuxian.materialedittext.MaterialEditText;

import mehdi.sakout.fancybuttons.FancyButton;

public class Vendedor extends AppCompatActivity implements SignUp.Vista {
    private MaterialEditText name,apellido,user,password;
    private FancyButton btn_regis;
    private MaterialDialog dialog;
    private SignUp.presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendedor);

        setView();

        btn_regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleSingup();
            }
        });

    }

    private void setView() {
        presenter= new SignUpPresenter(this);
        name=(MaterialEditText)findViewById(R.id.name);
        apellido=(MaterialEditText)findViewById(R.id.apellido);
        user=(MaterialEditText)findViewById(R.id.user);
        password=(MaterialEditText)findViewById(R.id.pass);
        btn_regis=(FancyButton)findViewById(R.id.btn_registrar);

        MaterialDialog.Builder builder = new MaterialDialog.Builder(this)
                .title("Cargando")
                .content("Espere, por favor...")
                .cancelable(false)
                .progress(true, 0);
        dialog = builder.build();
    }
    private void setEnable(boolean b) {
        name.setEnabled(b);
        apellido.setEnabled(b);
        user.setEnabled(b);
        password.setEnabled(b);
        btn_regis.setEnabled(b);
    }


    @Override
    public void disableInputs() {
     setEnable(false);

    }

    @Override
    public void enableInputs() {
        setEnable(true);
    }

    @Override
    public void showProgress() {
dialog.show();
    }

    @Override
    public void hideProgress() {
dialog.dismiss();
    }

    @Override
    public boolean ValidatioViws() {
        /** si el campo esta vacio bota error*/
     boolean valida= true;
      if(TextUtils.isEmpty(name.getText())){
          /**1*/
          name.setError("Campo Obligatorio");
          valida =false;
      } else
          if(name.getText().toString().length()<7){
              name.setError("Escriba minimo 5 caracteres");
              valida=false;
          }
        /**fin*/

        /**2*/
        if(TextUtils.isEmpty(apellido.getText())){
          apellido.setError("Campo Obligatorio");
          valida=false;

      }

      else
          if(apellido.getText().toString().length()<7){
              apellido.setError("Escriba minimo 5 caracteres");
              valida=false;


      }
        /**fin*/
        /**3*/
        if(TextUtils.isEmpty(user.getText())){
          user.setError("Campo Obligatorio");
          valida=false;

      }else if ( !  Patterns.EMAIL_ADDRESS.matcher(user.getText().toString()).matches() ){

            user.setError("No es un gmail valido");

        }

        /**fin*/

        /**4*/
        if (TextUtils.isEmpty(password.getText())){
          password.setError("Campo Obligatorio");
          valida=false;
        } else {
            if(password.getText().toString().length()<7){
                password.setError("Escriba minimo 5 caracteres");
                valida=false;
            }
        }
     return valida;
    }

    @Override
    public void handleSingup() {
        if(ValidatioViws()){
            presenter.doSignup(name.getText().toString(),apellido.getText().toString(),user.getText().toString().trim(),
                    password.getText().toString().trim()  );


        }

    }

    @Override
    public void onError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSignup() {
        Toast.makeText(this, "Has Registrado correctamente", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.ondestroy();
    }
}
