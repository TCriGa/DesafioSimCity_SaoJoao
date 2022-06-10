package br.com.zup.simcity_saojoao.produto.fragmentsProduto

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.zup.simcity_saojoao.databinding.FragmentListaProdutoBinding

class ListaProdutoFragment : Fragment() {
    private lateinit var binding: FragmentListaProdutoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListaProdutoBinding.inflate(inflater, container, false)
        return binding.root
    }



}