package com.jedi.navigationdrawerwithfragments.fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.jedi.navigationdrawerwithfragments.R;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 */
public class Calculadora extends Fragment {

    Button b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, beq, bsum, bsub, bmod, bdiv, bdelete, bsqrt, bpow, bmult, bsin, bcos, btan;
    Button bcall;
    Button opdec;
    Boolean equalPressed;
    Boolean opActive;
    Boolean numPressed;
    Boolean dec;
    TextView textViewResult;

    public Calculadora() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        super.onCreate(savedInstanceState);

        View v = inflater.inflate(R.layout.fragment_calculadora, container, false);
        textViewResult = (TextView) v.findViewById(R.id.textViewResult);

        equalPressed = false;
        opActive = false;
        numPressed = false;

        b0 = (Button) v.findViewById(R.id.button29);
        b1 = (Button) v.findViewById(R.id.button21);
        b2 = (Button) v.findViewById(R.id.button22);
        b3 = (Button) v.findViewById(R.id.button23);
        b4 = (Button) v.findViewById(R.id.button18);
        b5 = (Button) v.findViewById(R.id.button19);
        b6 = (Button) v.findViewById(R.id.button20);
        b7 = (Button) v.findViewById(R.id.button15);
        b8 = (Button) v.findViewById(R.id.button16);
        b9 = (Button) v.findViewById(R.id.button17);
        bsum = (Button) v.findViewById(R.id.button2);
        beq = (Button) v.findViewById(R.id.button);
        bsub = (Button) v.findViewById(R.id.button3);
        bdiv = (Button) v.findViewById(R.id.button5);
        bmod = (Button) v.findViewById(R.id.button4);
        bpow = (Button) v.findViewById(R.id.button32);
        bsqrt = (Button) v.findViewById(R.id.button33);
        bmult = (Button) v.findViewById(R.id.button11);
        bsin = (Button) v.findViewById(R.id.button8);
        bcos = (Button) v.findViewById(R.id.button9);
        btan = (Button) v.findViewById(R.id.button10);
        bdelete = (Button) v.findViewById(R.id.button34);
        bcall = (Button) v.findViewById(R.id.button36);
        opdec = (Button) v.findViewById(R.id.button30);
        textViewResult = (TextView) v.findViewById(R.id.textViewResult);

        //en vez de int es una variable click
        View.OnClickListener appendNumber = new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Button b = (Button) view;
                if(b == beq)
                {
                    String op = determinarOperacio(textViewResult.getText().toString());
                    String res = "";
                    if(op.contentEquals("sum")) res = calcularSuma(textViewResult.getText().toString());
                    else if(op.contentEquals("sub")) res = calcularResta(textViewResult.getText().toString());
                    else if(op.contentEquals("mult")) res = calcularMult(textViewResult.getText().toString());
                    else if(op.contentEquals("div")) res = calcularDiv(textViewResult.getText().toString());
                    else if(op.contentEquals("mod")) res = calcularMod(textViewResult.getText().toString());
                    else if(op.contentEquals("pow")) res = calcularPow(textViewResult.getText().toString());
                    else if(op.contentEquals("sqrt")) res = calcularSqrt(textViewResult.getText().toString());
                    else if(op.contentEquals("sin")) res = calcularSin(textViewResult.getText().toString());
                    else if(op.contentEquals("cos")) res = calcularCos(textViewResult.getText().toString());
                    else if(op.contentEquals("tan")) res = calcularTan(textViewResult.getText().toString());
                    textViewResult.setText(res);
                    opActive = false;
                    equalPressed = true;
                    dec = false;
                }
                else if(b == opdec && !dec)
                {
                    textViewResult.append(",");
                    dec = true;
                }
                else
                {
                    if(b == bdelete)
                    {
                        String aux = "";
                        textViewResult.setText(aux);
                        equalPressed = false;
                        opActive = false;
                        numPressed = false;
                        dec = false;
                    }
                    else
                    {
                        if ((b == bsum || b == bsub) && !opActive && numPressed)
                        {
                            textViewResult.append(b.getText());
                            opActive = true;
                        }
                        else if (b == bdiv && !opActive && numPressed)
                        {
                            textViewResult.append("/");
                            opActive = true;
                        }
                        else if (b == bmod && !opActive && numPressed)
                        {
                            textViewResult.append("%");
                            opActive = true;
                        }
                        else if (b == bpow && !opActive && numPressed)
                        {
                            textViewResult.append("^");
                            opActive = true;
                        }
                        else if (b == bmult && !opActive && numPressed)
                        {
                            textViewResult.append("*");
                            opActive = true;
                        }
                        else if (b == bsqrt && !opActive && numPressed)
                        {
                            textViewResult.append("SQRT:");
                            opActive = true;
                        }
                        else if (b == bsin && !opActive && !numPressed)
                        {
                            textViewResult.append("SIN:");
                            opActive = true;
                        }
                        else if (b == bcos && !opActive && !numPressed)
                        {
                            textViewResult.append("COS:");
                            opActive = true;
                        }
                        else if (b == btan && !opActive && !numPressed)
                        {
                            textViewResult.append("TAN:");
                            opActive = true;
                        }
                        else if(b == bcall) call(textViewResult.getText().toString());
                        else
                        {
                            if(equalPressed)
                            {
                                textViewResult.setText(b.getText().toString());
                                equalPressed = false;
                            }
                            else if(b == b0 || b == b0 || b == b1 || b == b2 || b == b3 || b == b4 ||
                                    b == b5 || b == b6 || b == b7 || b == b8 || b == b9)
                            {
                                numPressed = true;
                                textViewResult.append(b.getText().toString());
                            }
                        }
                    }
                }
            }
        };
        b0.setOnClickListener(appendNumber);
        b1.setOnClickListener(appendNumber);
        b2.setOnClickListener(appendNumber);
        b3.setOnClickListener(appendNumber);
        b4.setOnClickListener(appendNumber);
        b5.setOnClickListener(appendNumber);
        b6.setOnClickListener(appendNumber);
        b7.setOnClickListener(appendNumber);
        b8.setOnClickListener(appendNumber);
        b9.setOnClickListener(appendNumber);
        bsum.setOnClickListener(appendNumber);
        bsub.setOnClickListener(appendNumber);
        bmult.setOnClickListener(appendNumber);
        bdiv.setOnClickListener(appendNumber);
        bmod.setOnClickListener(appendNumber);
        bpow.setOnClickListener(appendNumber);
        bsqrt.setOnClickListener(appendNumber);
        beq.setOnClickListener(appendNumber);
        bdelete.setOnClickListener(appendNumber);
        bsin.setOnClickListener(appendNumber);
        bcos.setOnClickListener(appendNumber);
        btan.setOnClickListener(appendNumber);
        bcall.setOnClickListener(appendNumber);
        opdec.setOnClickListener(appendNumber);

        return v;
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        // Save UI state changes to the savedInstanceState.
        // This bundle will be passed to onCreate if the process is
        // killed and restarted.
        savedInstanceState.putBoolean("opActive", opActive);
        savedInstanceState.putBoolean("numPressed", numPressed);
        savedInstanceState.putBoolean("dec", dec);
        savedInstanceState.putString("textCalc", textViewResult.getText().toString());
        // etc.
    }

    String determinarOperacio(String text)
    {
        for(int i = 0; i < text.length(); ++i)
        {
            if(text.charAt(i) == '+') return "sum";
            else if(text.charAt(i) == '-') return "sub";
            else if(text.charAt(i) == '/') return "div";
            else if(text.charAt(i) == '*') return "mult";
            else if(text.charAt(i) == '%') return "mod";
            else if(text.charAt(i) == 'S' && text.charAt(i+1) == 'Q') return "sqrt";
            else if(text.charAt(i) == '^') return "pow";
            else if(text.charAt(i) == 'S' && text.charAt(i+1) == 'I') return "sin";
            else if(text.charAt(i) == 'C') return "cos";
            else if(text.charAt(i) == 'T') return "tan";
        }
        return "error";
    }

    String calcularSuma(String text)
    {
        String num1 = "", num2 = "";
        int res, i = 0;
        double resd;
        while(text.charAt(i) != '+')
        {
            num1 += text.charAt(i);
            ++i;
        }
        ++i;
        while(i < text.length())
        {
            num2 += text.charAt(i);
            ++i;
        }
        if(!dec)
        {
            res = Integer.parseInt(num1) + Integer.parseInt(num2);
            return String.valueOf(res);
        }
        else
        {
            resd = Double.parseDouble(num1) + Double.parseDouble(num2);
            dec = false;
            return String.valueOf(resd);
        }
    }

    String calcularResta(String text)
    {
        String num1 = "", num2 = "";
        int res, i = 0;
        double resd;
        while(text.charAt(i) != '-')
        {
            num1 += text.charAt(i);
            ++i;
        }
        ++i;
        while(i < text.length())
        {
            num2 += text.charAt(i);
            ++i;
        }
        if(!dec)
        {
            res = Integer.parseInt(num1) - Integer.parseInt(num2);
            return String.valueOf(res);
        }
        else
        {
            resd = Double.parseDouble(num1) - Double.parseDouble(num2);
            dec = false;
            return String.valueOf(resd);
        }
    }

    String calcularDiv(String text)
    {
        String num1 = "", num2 = "";
        int res, i = 0;
        double resd;
        while(text.charAt(i) != '/')
        {
            num1 += text.charAt(i);
            ++i;
        }
        ++i;
        while(i < text.length())
        {
            num2 += text.charAt(i);
            ++i;
        }
        if(!dec)
        {
            res = Integer.parseInt(num1) / Integer.parseInt(num2);
            return String.valueOf(res);
        }
        else
        {
            resd = Double.parseDouble(num1) / Double.parseDouble(num2);
            dec = false;
            return String.valueOf(resd);
        }
    }

    String calcularMod(String text)
    {
        String num1 = "", num2 = "";
        int res, i = 0;
        double resd;
        while(text.charAt(i) != '%')
        {
            num1 += text.charAt(i);
            ++i;
        }
        ++i;
        while(i < text.length())
        {
            num2 += text.charAt(i);
            ++i;
        }
        if(!dec)
        {
            res = Integer.parseInt(num1) % Integer.parseInt(num2);
            return String.valueOf(res);
        }
        else
        {
            resd = Double.parseDouble(num1) % Double.parseDouble(num2);
            dec = false;
            return String.valueOf(resd);
        }
    }

    String calcularPow(String text)
    {
        String num1 = "", num2 = "";
        int res, i = 0;
        double resd;
        while(text.charAt(i) != '^')
        {
            num1 += text.charAt(i);
            ++i;
        }
        ++i;
        while(i < text.length())
        {
            num2 += text.charAt(i);
            ++i;
        }
        if(!dec)
        {
            res = (int) Math.pow(Integer.parseInt(num1), Integer.parseInt(num2));
            return String.valueOf(res);
        }
        else
        {
            resd = Math.pow(Double.parseDouble(num1), Double.parseDouble(num2));
            dec = false;
            return String.valueOf(resd);
        }
    }

    String calcularSqrt(String text)
    {
        String num1 = "";
        int res, i = 0;
        while(text.charAt(i) == 'S' || text.charAt(i) == 'Q' || text.charAt(i) == 'R' || text.charAt(i) == 'T')
        {
            ++i;
        }
        ++i;
        while(i < text.length())
        {
            num1 += text.charAt(i);
            ++i;
        }
        res = (int)Math.sqrt(Double.parseDouble(num1));
        return String.valueOf(res);
    }

    String calcularMult(String text)
    {
        String num1 = "", num2 = "";
        int res, i = 0;
        while(text.charAt(i) != '*')
        {
            num1 += text.charAt(i);
            ++i;
        }
        ++i;
        while(i < text.length())
        {
            num2 += text.charAt(i);
            ++i;
        }
        res = Integer.parseInt(num1) * Integer.parseInt(num2);
        return String.valueOf(res);
    }

    String calcularSin(String text)
    {
        String num1 = "";
        double res;
        int i = 0;
        while(text.charAt(i) == 'S' || text.charAt(i) == 'I' || text.charAt(i) == 'N')
        {
            ++i;
        }
        ++i;
        while(i < text.length())
        {
            num1 += text.charAt(i);
            ++i;
        }
        res = Math.sin(Double.parseDouble(num1));
        return String.valueOf(res);
    }
    String calcularCos(String text)
    {
        String num1 = "";
        double res;
        int i = 0;
        while(text.charAt(i) == 'C' || text.charAt(i) == 'O' || text.charAt(i) == 'S')
        {
            ++i;
        }
        ++i;
        while(i < text.length())
        {
            num1 += text.charAt(i);
            ++i;
        }
        res = Math.cos(Double.parseDouble(num1));
        return String.valueOf(res);
    }

    String calcularTan(String text)
    {
        String num1 = "";
        double res;
        int i = 0;
        while(text.charAt(i) == 'T' || text.charAt(i) == 'A' || text.charAt(i) == 'N')
        {
            ++i;
        }
        ++i;
        while(i < text.length())
        {
            num1 += text.charAt(i);
            ++i;
        }
        res = Math.tan(Double.parseDouble(num1));
        return String.valueOf(res);
    }

    Boolean isNum(char c)
    {
        if(c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9' || c == '0') return true;
        return false;
    }

    void call(String text)
    {
        for(int i = 0; i < text.length(); ++i)
        {
            if(!isNum(text.charAt(i)))
            {
                textViewResult.setText("ERROR EN EL NÚMERO DE TELÈFON");
                return;
            }
        }
        String num = "tel:" + text;
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(num));
        startActivity(intent);
    }
}
