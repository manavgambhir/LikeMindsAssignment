package com.example.myapplication1.ui

import android.os.Bundle
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.lifecycle.lifecycleScope
import com.example.myapplication1.adapter.rvAdapter
import com.example.myapplication1.databinding.ActivityMainBinding
import com.example.myapplication1.model.ResponseItem
import com.example.myapplication1.viewModel.harryViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    val vm by lazy{
        ViewModelProvider(this)[harryViewModel::class.java]
    }

    private val list = arrayListOf<ResponseItem>()

    private lateinit var adapter:rvAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter =  rvAdapter(this,list)

        binding.rv.adapter = adapter

        lifecycleScope.launch(Dispatchers.IO) { getHarryData() }

    }

    private suspend fun getHarryData() {
        vm.getResponse()

        withContext(Dispatchers.Main) {
            vm.harryList.observe(this@MainActivity, Observer { marketList ->
                if (!marketList.isNullOrEmpty()) {
                    list.clear()
                    list.addAll(marketList)
                    adapter.notifyDataSetChanged()
                }
            })
        }
    }
}