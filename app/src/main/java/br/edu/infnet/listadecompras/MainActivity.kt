package br.edu.infnet.listadecompras

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/*  Lista de Compras:
* Passo 01 - Entidade
* Passo 02 - DAO - Data Access Objects
* Passo 03 - DB (Banco de dados)
* Passo 04 - Repositorio
* Passo 05 - ViewModel
* Passo 06 - IU
*/

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
