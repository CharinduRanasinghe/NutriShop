package com.example.nutrishop.activity

import android.os.Bundle

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nutrishop.Adapter.DetailsAdapter
import com.example.nutrishop.Model.ItemModel
import com.example.nutrishop.R
import com.example.nutrishop.databinding.ActivityDetailBinding
import com.example.project1762.Helper.ManagmentCart

class DetailActivity : BaseActivity() {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var item:ItemModel
    private var numberOrder=1
    private lateinit var managmentCart: ManagmentCart


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        managmentCart= ManagmentCart(this)

        getBundle()
        initLists()

    }

    private fun initLists() {

        binding.nutList.adapter = DetailsAdapter(item.nutrients)
        binding.nutList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
    }



    private fun getBundle() {
        item = intent.getParcelableExtra("object") ?: return // Safely unwrap the parcelable item

        binding.titleTxt.text = item.title
        binding.descriptionTxt.text = item.description
        binding.priceTxt.text = "$"+ item.price
        binding.ratingTxt.text = "${item.rating} Rating"
        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.addToCartBtn.setOnClickListener {
            item.numberInCart = numberOrder
            managmentCart.insertFood(item)
        }
        binding.backBtn.setOnClickListener { finish() }
        // Assuming there's functionality for cartBtn
        binding.cartBtn.setOnClickListener {
            // Handle cart button click
        }
    }
}