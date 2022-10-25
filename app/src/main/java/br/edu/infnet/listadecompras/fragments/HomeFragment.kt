package br.edu.infnet.listadecompras.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import br.edu.infnet.listadecompras.R
import br.edu.infnet.listadecompras.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root

        setuo()
        return view
    }

    private fun setuo() {
        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.apply{
            btnCategorias.setOnClickListener {
                nav(R.id.action_homeFragment_to_categoriasFragment)
            }

            btnProdutos.setOnClickListener {
                nav(R.id.action_homeFragment_to_produtosFragment)
            }

        }
    }

    fun nav(id: Int){
        findNavController().navigate(id)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    
}