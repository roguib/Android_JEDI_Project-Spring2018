package com.jedi.navigationdrawerwithfragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

public class LoginActivity extends AppCompatActivity {

    TextInputEditText usuari, ps;
    Button buttonLogin, buttonReg;
    public Realm realm;
    public RealmResults<User> userResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        buttonLogin = (Button) findViewById(R.id.button6);
        buttonReg = (Button) findViewById(R.id.button7);
        final TextInputLayout usernameWrapper = (TextInputLayout) findViewById(R.id.usuariWrapper);
        final TextInputLayout passwordWrapper = (TextInputLayout) findViewById(R.id.passwordWrapper);

        initRealm();
        loadRealmData();

        SharedPreferences settings = getSharedPreferences("sp", MODE_PRIVATE);
        //To retrieve values from a shared preferences file, call methods such as getInt() and getString(), providing the key for the value you want, and optionally a default value to return if the key isn't present.
        boolean opeenSession = settings.getBoolean("open session", false);
        if(opeenSession)
        {
            Log.v("contrassenya", "està guardada la sessió");
            Intent intent = new Intent(getApplicationContext(), DrawerActivity.class);
            startActivity(intent);
        }

        /*
            Retrieve data:
                String username = usernameWrapper.getEditText().getText().toString();
                String password = usernameWrapper.getEditText().getText().toString();
        */

        buttonLogin.setOnClickListener(new View.OnClickListener() {
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
                String username = usernameWrapper.getEditText().getText().toString();
                String password = passwordWrapper.getEditText().getText().toString();
                User userResult = realm.where(User.class).equalTo("usuari", username).findFirst();
                if (existeix(username)) {
                    if(userResult.getContrasenya().toString().equals(password)) {
                        //name of the shared preferences db
                        Log.v("no hauria d'estar aquí", "noob");
                        Log.v("La contrasenya guardada era: ", userResult.getContrasenya().toString());
                        Log.v("La contrasenya introduida era: ", password);
                        SharedPreferences settings = getSharedPreferences("sp", 0);
                        SharedPreferences.Editor editor = settings.edit();
                        editor.putString("usuari", username);
                        editor.putString("contrasenya", password);
                        editor.putBoolean("open session", true);
                        editor.apply();
                        Intent intent = new Intent(getApplicationContext(), DrawerActivity.class);
                        startActivity(intent);
                    }
                    else {
                        Toast toast = Toast.makeText(getApplicationContext(), "Contrassenya incorrecta", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }
                else {
                    //Snackbar.make(v, "Usuari no registrat", Snackbar.LENGTH_LONG).show();
                    Snackbar.make(v, "Usuari no registrat", Snackbar.LENGTH_LONG).setAction("Registrarse", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            //Log.i("Snackbar", "Pulsada acción snackbar!");
                            Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                            startActivity(intent);

                        }
                    }).show();
                }
                /*Intent intent = new Intent(getApplicationContext(), DrawerActivity.class);
                startActivity(intent);*/
                //No podem passar d'una activity a un fragment. Hem de passar d'una activity al drawer activity
                //i d'alla en el on create cridar al fragment de la calculadora.
                //El fragment és com un button, no el podem instanciar si no el posem a sobre de l'activity
            }
        });

        buttonReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
    private boolean existeix(String n) {
        userResults = realm.where(User.class).equalTo("usuari", n).findAll();
        if(userResults.size() < 1) return false;
        else return true;
    }

    private void initRealm() {
        Realm.init(getApplicationContext());
        realm = Realm.getDefaultInstance();
    }

    private void loadRealmData() {
        userResults = realm.where(User.class).findAll();
    }
}
