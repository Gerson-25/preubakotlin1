package com.example.preubakotlin.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.preubakotlin.R
import com.example.preubakotlin.databinding.HomeFragmentBinding
import com.example.preubakotlin.util.API_KEY
import com.example.preubakotlin.viewmodel.HomeViewModel
import okhttp3.MediaType
import okhttp3.RequestBody
import org.json.JSONObject

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel
    private lateinit var binding: HomeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.home_fragment, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        val jsonObject = JSONObject()
        jsonObject.put("api_key","a534925a6a295361930b6b9fff675bd0")
        val requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jsonObject.toString())

        viewModel.getRandomDog(API_KEY)
        viewModel.platformsList.observe(viewLifecycleOwner, Observer { platformsList ->
            binding.platformsRecyclerview.layoutManager = LinearLayoutManager(context)
            binding.platformsRecyclerview.adapter = PlatformRvAdapter(platformsList)
        })

        /*viewModel.error.observe(viewLifecycleOwner, Observer {errorMessage ->
            binding.errorMessage.text = errorMessage
        })*/

        viewModel.loading.observe(viewLifecycleOwner, Observer {isLoading ->
            if (isLoading){
                binding.imageLoader.visibility = View.VISIBLE
            }
            else{
                binding.imageLoader.visibility = View.GONE
            }
        })
    }

}