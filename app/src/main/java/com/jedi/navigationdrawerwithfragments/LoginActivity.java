package com.jedi.navigationdrawerwithfragments;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jedi.navigationdrawerwithfragments.fragments.Calculadora;
import com.jedi.navigationdrawerwithfragments.fragments.Game;

public class LoginActivity extends AppCompatActivity {

    TextInputEditText usuari, ps;
    Button button, buttonReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        button = (Button) findViewById(R.id.button6);
        buttonReg = (Button) findViewById(R.id.button7);
        final TextInputLayout usernameWrapper = (TextInputLayout) findViewById(R.id.textInputLayout);
        final TextInputLayout passwordWrapper = (TextInputLayout) findViewById(R.id.password);

        /*
            Retrieve data:
                String username = usernameWrapper.getEditText().getText().toString();
                String password = usernameWrapper.getEditText().getText().toString();
        */

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*User u = new User();
                boolean res = u.login(editTextUser.getText().toString(), editTextPassword.getText().toString());
                if(res)
                {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }*/
                /*Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);*/
                //else añadir notificacion toast
                //No se pueden usar intents de activity a fragment
                /*Intent intent = new Intent(getApplicationContext(), Calculadora.class);
                startActivity(intent);*/

                //DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                //drawer.closeDrawer(GravityCompat.START);
                Intent intent = new Intent(getApplicationContext(), DrawerActivity.class);
                startActivity(intent);
                //No podem passar d'una activity a un fragment. Hem de passar d'una activity al drawer activity
                //i d'alla en el on create cridar al fragment de la calculadora.
                //El fragment és com un button, no el podem instanciar si no el posem a sobre de l'activity
            }
        });

        buttonReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);*/
            }
        });
    }
}
