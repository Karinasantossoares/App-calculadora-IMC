package com.example.appcaulcularimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_calc.setOnClickListener {
            val pesoDig = et_peso.text.toString()
            val alturaDig: String = et_altura.text.toString()
            val validaCampos = validarCampos(pesoDig , alturaDig)
            if(validaCampos){
                calcularImc(pesoDig, alturaDig)
            }else{
                tv_result.setText(getString(R.string.data_invalids))
            }
        }
    }

    fun calcularImc(pesoDig: String, alturaDig: String) {
        val pesoConv = pesoDig.toDouble()
        val altuConv = alturaDig.toDouble()
        val resultado = pesoConv / (altuConv * 2)
        if (resultado <= 18.5) {
            tv_result.setText(getString(R.string.mensagem_peso1))
        };if (resultado > 18.5 || resultado <= 30.0) {
            tv_result.setText(getString(R.string.mensagem_peso2))
        };if(resultado >= 31 || resultado <=34.9){
            tv_result.setText(getString(R.string.mensagem_peso3))
        }
    }

    fun validarCampos(pesoDig: String , alturaDig: String) : Boolean{
        var camposValidados : Boolean = true
        if(pesoDig.isEmpty() || alturaDig.isEmpty()){
            camposValidados = false
        }
        return camposValidados



    }
}