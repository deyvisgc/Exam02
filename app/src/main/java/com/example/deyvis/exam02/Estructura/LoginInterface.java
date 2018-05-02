package com.example.deyvis.exam02.Estructura;

/**
 * Created by DEYVIS on 01/05/2018.
 */

public interface LoginInterface {
    interface View {
        void disableInputs();
        void enableInputs();

        void showProgress();
        void hideProgress();

        void handleLogin();

        boolean isValidEmail();
        boolean isValidPassword();

        void onLogin();
        void onError(String error);
    }
    interface Presenter{
        void onDestoy();

        void toLogin(String email, String password);

    }
    interface Model{
        void doLogin(String email, String password);
    }
    interface TaskListener{
        void onSucess();
        void onError(String error);
    }

}
