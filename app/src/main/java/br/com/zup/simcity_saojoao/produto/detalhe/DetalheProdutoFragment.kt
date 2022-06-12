package br.com.zup.simcity_saojoao.produto.detalhe

import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.activity.addCallback
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.clearFragmentResult
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import br.com.zup.simcity_saojoao.CHAVE_PRODUTO
import br.com.zup.simcity_saojoao.R
import br.com.zup.simcity_saojoao.databinding.FragmentDetalheProdutoBinding
import br.com.zup.simcity_saojoao.model.Produto

class DetalheProdutoFragment : Fragment() {

    private lateinit var binding: FragmentDetalheProdutoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetalheProdutoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        verificarCamposNulos()
        botaoVoltar()

    }


    private fun botaoVoltar(){
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner){
            findNavController().navigateUp()


        }
    }
    private fun recuperarExibirDadosProduto() {
        val produto = arguments?.getParcelable<Produto>(CHAVE_PRODUTO)
        if (produto != null) {
            binding.textNomeProduto.text = "Nome Produto ${produto.getNomeProduto()}"
            binding.textQuantidade.text = "Quantidade : ${produto.getQuantidade()}"
            binding.textValorUnitario.text = "Valor unitário: ${produto.getValorProduto()}"
            binding.textReceita.text = "Receita: ${produto.getReceita()}"
        }
    }

    private fun verificarCamposNulos() {
        if (binding.textNomeProduto.text.isEmpty() &&
            binding.textValorUnitario.text.isEmpty() &&
            binding.textQuantidade.text.isEmpty() &&
            binding.textReceita.text.isEmpty()
        ) {

        } else {
            recuperarExibirDadosProduto()
        }
    }
}