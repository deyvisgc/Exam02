package com.example.deyvis.exam02.Interface;

/**
 * Created by DEYVIS on 01/05/2018.
 */

public interface SignUp {
    interface Vista{
        void disableInputs();
        void enableInputs();
         void showProgress();
        void hideProgress();
        boolean ValidatioViws();
        void handleSingup();
        void onError(String error);
        void onSignup();

    }

    interface Model{
        void Signup(String name,String apellido,String user,String Pass);

    }
    interface presenter{

        void ondestroy();
        void doSignup(String name,String apellido,String user,String Pass);
    }

    interface TakListener{
        void onSucess();
        void onError(String error);
    }

}
