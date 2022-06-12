package br.com.zup.simcity_saojoao.produto.fragmentsProduto

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.zup.simcity_saojoao.CHAVE_PRODUTO
import br.com.zup.simcity_saojoao.databinding.FragmentValorTotalProdutoBinding
import br.com.zup.simcity_saojoao.model.Produto


class ValorTotalProdutoFragment : Fragment() {
    private lateinit var binding: FragmentValorTotalProdutoBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentValorTotalProdutoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        receberExibirDadosProdutos()
    }

    private fun receberExibirDadosProdutos() {
        var valorTotal = 0.0
        arguments?.getParcelableArrayList<Produto>(CHAVE_PRODUTO)?.forEach {
            valorTotal += it.getValorProduto() * it.getQuantidade()

            binding.textValorTotal.text = valorTotal.toString()
        }


    }
}