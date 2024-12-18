package com.example.coffeeshop.Activity

import android.content.Context
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.coffeeshop.Model.ItemsModel
import com.example.coffeeshop.databinding.ActivityDetailBinding
import com.example.coffeeshop.R

class DetailActivity : BaseActivity() {

    private var _binding: ActivityDetailBinding? = null
    private val binding get() = _binding!!

    private lateinit var item: ItemsModel
    private lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        context = this

        bundle()
    }

    private fun bundle() {
        binding.apply {
            item = intent.getParcelableExtra("object")!!
            titleText.text = item.title
            subtitleText.text = item.extra
            descriptionText.text = item.description
            priceText.text = "$${item.price}"

            Glide.with(context).load(item.picUrl[0]).apply(
                RequestOptions.bitmapTransform(
                    RoundedCorners(100)
                )
            ).into(binding.image)

            backButton.setOnClickListener{finish()}

            sizeButton1.setOnClickListener{
                sizeButton1.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.orange_stroke_bg))
                sizeButton2.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.dark_grey_bg2))
                sizeButton3.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.dark_grey_bg2))
                sizeButton1.setTextColor(getResources().getColor(R.color.orange))
                sizeButton2.setTextColor(getResources().getColor(R.color.white))
                sizeButton3.setTextColor(getResources().getColor(R.color.white))
            }

            sizeButton2.setOnClickListener{
                sizeButton1.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.dark_grey_bg2))
                sizeButton2.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.orange_stroke_bg))
                sizeButton3.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.dark_grey_bg2))
                sizeButton1.setTextColor(getResources().getColor(R.color.white))
                sizeButton2.setTextColor(getResources().getColor(R.color.orange))
                sizeButton3.setTextColor(getResources().getColor(R.color.white))
            }

            sizeButton3.setOnClickListener{
                sizeButton1.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.dark_grey_bg2))
                sizeButton2.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.dark_grey_bg2))
                sizeButton3.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.orange_stroke_bg))
                sizeButton1.setTextColor(getResources().getColor(R.color.white))
                sizeButton2.setTextColor(getResources().getColor(R.color.white))
                sizeButton3.setTextColor(getResources().getColor(R.color.orange))
            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}