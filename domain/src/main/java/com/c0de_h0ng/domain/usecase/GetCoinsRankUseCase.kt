package com.c0de_h0ng.domain.usecase

import com.c0de_h0ng.domain.model.CoinTicker
import com.c0de_h0ng.domain.repository.CoinRepository
import kotlinx.coroutines.*
import javax.inject.Inject

/**
 * Created by c0de_h0ng on 2022/02/13.
 */
class GetCoinsRankUseCase @Inject constructor(
    private val repository: CoinRepository
) {

//    suspend operator fun invoke(): List<CoinTicker> {
//        return repository.getCoinTickerList()
//    }

    suspend operator fun invoke() = withContext(Dispatchers.IO) {
        return@withContext repository.getCoinTickerList()
    }

    fun requestRank(
        scope: CoroutineScope,
        onResult: (List<CoinTicker>) -> Unit
    ) {
        scope.launch(Dispatchers.Main) {
            val deferred = async(Dispatchers.IO) {
                repository.getCoinTickerList()
            }
            onResult(deferred.await())
        }
    }

    fun requestRank2(scope: CoroutineScope): List<CoinTicker> {
        var result = emptyList<CoinTicker>()
        scope.launch(Dispatchers.Main) {
            return@launch withContext(Dispatchers.IO) {
                result = repository.getCoinTickerList()
            }
        }
        return result
    }

//    operator fun invoke(
//        scope: CoroutineScope,
//        onResult: (LiveData<List<CoinTicker>>) -> Unit = {}
//    ) {
//        scope.launch(Dispatchers.Main) {
//            val deferred = async(Dispatchers.IO) {
//                repository.getCoinTickerList()
//            }
//            onResult(deferred.await())
//        }
//    }

//    operator fun invoke(scope: CoroutineScope): List<CoinTicker> {
//        scope.launch(Dispatchers.Main) {
//            val deferred = async(Dispatchers.IO) {
//                repository.getCoinTickerList()
//            }
//            return deferred.await()
//        }
//
//    }

//    operator fun invoke(searchUser: String): Flow<CallResult<List<User>>> = flow {
//        try {
//            val userList = repository.getUserList(searchUser).toUserList()
//            emit(CallResult.Success(userList))
//        } catch (e: HttpException) {
//            emit(CallResult.Error(e.localizedMessage ?: "An unexpected error occured", 400))
//        } catch (e: IOException) {
//            emit(CallResult.Error("Couldn't reach server. Check your internet", 400))
//        } finally {
//            emit(CallResult.Loading(isLoading = false))
//        }
//    }
}