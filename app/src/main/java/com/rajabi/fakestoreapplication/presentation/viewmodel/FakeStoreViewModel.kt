package com.rajabi.fakestoreapplication.presentation.viewmodel

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.rajabi.divarapplication.data.util.Resource
import com.rajabi.fakestoreapplication.data.model.APIResponse
import com.rajabi.fakestoreapplication.domain.usecase.GetAllProductsUsecase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch


class FakeStoreViewModel
    (
    private val app: Application,
    private val getAllProductsUsecase: GetAllProductsUsecase
) : AndroidViewModel(app) {

    val products: MutableLiveData<Resource<APIResponse>> = MutableLiveData()
    fun getProducts() = viewModelScope.launch(Dispatchers.IO) {
        products.postValue(Resource.Loading())

        try {
            if (isNetworkAvailable(app)) {
                val apiResult = getAllProductsUsecase.execute()
                products.postValue(apiResult)
            } else {
                Toast.makeText(app, "دسترسی به اینترنت وجود  ندارد", Toast.LENGTH_LONG).show()
            }
        } catch (e: Exception) {
            products.postValue(Resource.Error(e.message.toString()))
        }

    }


    private fun isNetworkAvailable(context: Context?): Boolean {
        if (context == null) return false
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val capabilities =
                connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)

            if (capabilities != null) {

                when {
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> return true
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> return true
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> return true
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_BLUETOOTH) -> return true
                    else -> return false
                }
            }
        } else {
            val activeNetworkInfo = connectivityManager.activeNetworkInfo
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected)
                return true
        }
        return false
    }

//    //first state whether the search is happening or not
    private val _isSearching = MutableStateFlow(false)
    val isSearching = _isSearching.asStateFlow()

    //second state the text typed by the user
    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    //third state the list to be filtered
    private val _searchList = MutableStateFlow(products.value?.data)
    val searchList = searchText
        .combine(_searchList)
        { text, products ->//combine searchText with _contriesList
            if (text.isBlank()) { //return the entery list of countries if not is typed
                products
            }
            products?.filter { products ->// filter and return a list of countries based on the text the user typed
                products.title.uppercase().contains(text.trim().uppercase())
            }
        }.stateIn(//basically convert the Flow returned from combine operator to StateFlow
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),//it will allow the StateFlow survive 5 seconds before it been canceled
            initialValue = products.value
        )

    fun onSearchTextChange(text: String) {
        _searchText.value = text
    }

    fun onToogleSearch() {
        _isSearching.value = !_isSearching.value
        if (!_isSearching.value) {
            onSearchTextChange("")
        }
    }
}