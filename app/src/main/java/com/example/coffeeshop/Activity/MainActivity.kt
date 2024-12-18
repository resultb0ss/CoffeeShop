package com.example.coffeeshop.Activity

import android.R

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import com.example.coffeeshop.databinding.ActivityMainBinding
import eightbitlab.com.blurview.RenderScriptBlur

class MainActivity : BaseActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setBlurEffect()
        setVariable()
    }

    private fun setVariable(){
        binding.apply {
            btn1.setOnClickListener{ startListActivity(2, "Ice Drink")}
            btn2.setOnClickListener{ startListActivity(3, "Hot Drink")}
            btn3.setOnClickListener{ startListActivity(1, "Hot Coffee")}
            btn4.setOnClickListener{ startListActivity(4, "Ice Coffee")}
            btn5.setOnClickListener{ startListActivity(5, "Brewing Coffee")}
            btn6.setOnClickListener{ startListActivity(6, "Shake")}
            btn7.setOnClickListener{ startListActivity(7, "Restaurant")}
            btn8.setOnClickListener{ startListActivity(8, "Breakfast")}
            btn9.setOnClickListener{ startListActivity(9, "Cake")}
        }
    }

    private fun startListActivity(id: Int, title: String){
        val intent = Intent(this, ListActivity::class.java)
        intent.putExtra("id", id)
        intent.putExtra("title", title)
        startActivity(intent)
    }

    private fun setBlurEffect(){
        val radius = 10f
        val decorView = this.window.decorView
        val rootView = decorView.findViewById<View>(R.id.content) as ViewGroup
        val windowBackground = decorView.background
        binding.blurView.setupWith(
            rootView,
            RenderScriptBlur(this)
        )
            .setFrameClearDrawable(windowBackground)
            .setBlurRadius(radius)

        binding.blurView.setOutlineProvider(ViewOutlineProvider.BACKGROUND)
        binding.blurView.clipToOutline = true
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}