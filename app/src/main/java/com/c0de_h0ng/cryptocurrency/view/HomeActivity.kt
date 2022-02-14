package com.c0de_h0ng.cryptocurrency.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.c0de_h0ng.cryptocurrency.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private val viewModel by viewModels<HomeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        //viewModel.requestCoinRankList()
        //viewModel.requestTest()
        viewModel.requestTestV2()
    }

}