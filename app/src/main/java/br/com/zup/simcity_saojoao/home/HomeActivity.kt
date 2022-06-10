package br.com.zup.simcity_saojoao.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import br.com.zup.simcity_saojoao.R
import br.com.zup.simcity_saojoao.databinding.ActivityHomeBinding
import br.com.zup.simcity_saojoao.produto.ProdutosActivity


class HomeActivity : AppCompatActivity() {

    private lateinit var binding : ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mudarActionBar()


        binding.buttonIrParaProdutos.setOnClickListener {
            irParaProdutoActivity()
        }

    }

    private fun mudarActionBar(){

        supportActionBar?.setTitle(getString(R.string.tema_SimCity))
    }

    private fun irParaProdutoActivity(){
        val intent = Intent(this, ProdutosActivity :: class.java)
        startActivity(intent)
    }
}