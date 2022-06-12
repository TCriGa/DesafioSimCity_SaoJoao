package br.com.zup.simcity_saojoao.produto.fragmentsProduto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.zup.simcity_saojoao.R
import br.com.zup.simcity_saojoao.databinding.FragmentValorTotalProdutoBinding

class ValorTotalProdutoFragment : Fragment() {
    private lateinit var binding: FragmentValorTotalProdutoBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentValorTotalProdutoBinding.inflate(inflater,container, false )
        return binding.root
    }

}