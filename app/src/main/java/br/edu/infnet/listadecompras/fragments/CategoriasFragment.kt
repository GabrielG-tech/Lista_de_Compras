package br.edu.infnet.listadecompras.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import br.edu.infnet.listadecompras.R
import br.edu.infnet.listadecompras.databinding.FragmentCategoriasBinding
import br.edu.infnet.listadecompras.models.Categoria
import br.edu.infnet.listadecompras.viewmodel.MainViewModel


class CategoriasFragment : Fragment() {

    val viewModel : MainViewModel by viewModels()

    private var _binding: FragmentCategoriasBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCategoriasBinding.inflate(inflater, container, false)
        val view = binding.root

        setup()
        return view
    }

    private fun setup() {
        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.apply{
            btnSave.setOnClickListener {

            }
        }
    }

    fun onSaveClick() {
        val nomeInput = binding.inputNomeCategoria.text.toString()
        viewModel.insertCategoria(Categoria(nome = nomeInput))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}