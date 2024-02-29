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
import com.rajabi.fakestoreapplication.data.model.ProductItem
import com.rajabi.fakestoreapplication.domain.usecase.GetAllProductsUsecase
import com.rajabi.fakestoreapplication.domain.usecase.GetProductByIDUsecase
import com.rajabi.fakestoreapplication.domain.usecase.SaveProductUsecase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class FakeStoreViewModel
    (
    private val app: Application,
    private val getAllProductsUsecase: GetAllProductsUsecase,
    private val saveProductUsecase: SaveProductUsecase,
    private val getProductByIDUsecase: GetProductByIDUsecase
) : AndroidViewModel(app) {

    val products: MutableLiveData<Resource<APIResponse>> = MutableLiveData()
    val product: MutableLiveData<ProductItem> = MutableLiveData()

    val searchProducts: MutableLiveData<List<ProductItem>?> = MutableLiveData()
    lateinit var apiResult: Resource<APIResponse>
    lateinit var localResult: ProductItem


    fun getProducts() = viewModelScope.launch(Dispatchers.IO) {
        products.postValue(Resource.Loading())

        try {
            if (isNetworkAvailable(app)) {
                apiResult = getAllProductsUsecase.execute()

                products.postValue(apiResult)
                searchProducts.postValue(apiResult.data)


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

    fun onSearchTextChange(text: String) {
        _searchText.value = text
        searchProducts.postValue(apiResult.data?.filter { product ->
            product.title.uppercase().contains(text.uppercase().trim())

        })
    }

    fun onToogleSearch() {
        _isSearching.value = !_isSearching.value
        if (!_isSearching.value) {
            onSearchTextChange("")
        }
    }

    fun saveProduct(productItem: ProductItem) {
        viewModelScope.launch(Dispatchers.IO) {
            product.postValue( productItem)
            saveProductUsecase.execute(productItem)
        }
    }


    fun getProductById(id: Int)  =
        viewModelScope.launch (Dispatchers.IO){
//            product.postValue(getProductByIDUsecase.execute(id))
            try {
                    localResult = getProductByIDUsecase.execute(id)

                    product.postValue(localResult)

            } catch (e: Exception) {
                products.postValue(Resource.Error(e.message.toString()))
            }

        }

}