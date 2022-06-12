package br.com.zup.simcity_saojoao.produto

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import br.com.zup.simcity_saojoao.R
import br.com.zup.simcity_saojoao.databinding.ActivityProdutosBinding

class ProdutosActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProdutosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProdutosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mudarActionBar()

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun mudarActionBar(){
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
       supportActionBar?.setTitle(getString(R.string.titulo_produto))

    }

}