package br.com.zup.simcity_saojoao.produto.detalhe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.zup.simcity_saojoao.CHAVE_PRODUTO
import br.com.zup.simcity_saojoao.R
import br.com.zup.simcity_saojoao.databinding.FragmentDetalheProdutoBinding
import br.com.zup.simcity_saojoao.model.Produto
import kotlinx.coroutines.internal.artificialFrame

class DetalheProdutoFragment : Fragment() {

private lateinit var binding: FragmentDetalheProdutoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetalheProdutoBinding.inflate(inflater,container, false )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recuperarDadosProduto()
    }

    private fun recuperarDadosProduto(){
        val produto = arguments?.getParcelable<Produto>(CHAVE_PRODUTO)
        if (produto != null){
            binding.textNomeProduto.text = produto.getNomeProduto()
            binding.textValorUnitario.text = produto.getValorProduto().toString()
            binding.textQuantidade.text = produto.getQuantidade().toString()
            binding.textReceita.text = produto.getReceita()
        }
    }

}