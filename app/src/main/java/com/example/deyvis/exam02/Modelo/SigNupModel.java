package com.example.deyvis.exam02.Modelo;

import android.support.annotation.NonNull;

import com.example.deyvis.exam02.Interface.SignUp;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

/**
 * Created by DEYVIS on 02/05/2018.
 */

public class SigNupModel implements SignUp.Model {

    private SignUp.TakListener listener;
    private FirebaseAuth auth;

    public SigNupModel(SignUp.TakListener listener) {
        this.listener = listener;
        auth=FirebaseAuth.getInstance();
    }

    @Override
    public void Signup(final String name, final String apellido, String user, String Pass) {
       auth.createUserWithEmailAndPassword(user,Pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
           @Override
           public void onComplete(@NonNull Task<AuthResult> task) {

               if(task.isSuccessful()){
                   UserProfileChangeRequest profile= new UserProfileChangeRequest.Builder()
                           .setDisplayName(name)
                           .setDisplayName(apellido)
                           .build();

                   FirebaseUser user= auth.getCurrentUser();
                   if (user!=null)
                   user.updateProfile(profile).addOnCompleteListener(new OnCompleteListener<Void>() {
                       @Override
                       public void onComplete(@NonNull Task<Void> task) {
                           if(task.isSuccessful()){
                               listener.onSucess();
                           }else if ((task.getException()!=null)){
                               listener.onError(task.getException().getMessage());
                           }

                       }
                   });
               } else if ((task.getException()!=null)){
                   listener.onError(task.getException().getMessage());
               }

           }
       });
    }
}
