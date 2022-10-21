package br.edu.infnet.listadecompras.application

import android.app.Application
import br.edu.infnet.listadecompras.repositories.LojaRepository

class LojaApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        LojaRepository.initialize(this)
    }
}
