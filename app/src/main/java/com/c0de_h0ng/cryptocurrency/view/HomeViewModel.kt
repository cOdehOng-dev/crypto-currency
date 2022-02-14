package com.c0de_h0ng.cryptocurrency.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.c0de_h0ng.domain.usecase.GetCoinsRankUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by c0de_h0ng on 2022/02/14.
 */
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getCoinsRankUseCase: GetCoinsRankUseCase
) : ViewModel() {

    fun requestCoinRankList() = viewModelScope.launch {
        getCoinsRankUseCase()
    }

    fun requestTest() {
        getCoinsRankUseCase.requestRank(viewModelScope) {
            // LiveData
        }
    }

    fun requestTestV2() {
        getCoinsRankUseCase.requestRank2(viewModelScope)
    }
}