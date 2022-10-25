package br.edu.infnet.listadecompras.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import br.edu.infnet.listadecompras.R
import br.edu.infnet.listadecompras.databinding.FragmentCategoriasBinding
import br.edu.infnet.listadecompras.models.Categoria
import br.edu.infnet.listadecompras.viewmodel.MainViewModel
import kotlinx.coroutines.launch


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
                onSaveClick()
            }

            btnGetById.setOnClickListener {
                onGetByIdClick()
            }

            btnRemoveById.setOnClickListener {
                onRemoveByIdClick()
            }
        }
    }

    private fun onRemoveByIdClick() {
        val idInput = binding.inputNomeIdCategoria.text.toString().toLong()
        viewModel.deleteCategoriaById(idInput)
    }

    private fun onGetByIdClick() {
        val idInput = binding.inputNomeIdCategoria.text.toString().toLong()
        lifecycleScope.launch {
            val categoria = viewModel.getCategoriaById(idInput)
            binding.tvCategoria.text = categoria.nome
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
