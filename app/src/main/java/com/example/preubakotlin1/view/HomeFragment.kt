package com.example.preubakotlin1.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.preubakotlin1.R
import com.example.preubakotlin1.databinding.HomeFragmentBinding
import com.example.preubakotlin1.viewmodel.HomeViewModel

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

        binding.loadImageBtn.setOnClickListener {
            viewModel.getRandomDog()
        }

        viewModel.getRandomDog()
        viewModel.dog.observe(viewLifecycleOwner, Observer { dog ->
            binding.dogPicture.apply {
                Glide.with(this)
                    .load(dog.image)
                    .centerCrop()
                    .into(this)
            }
        })

        viewModel.error.observe(viewLifecycleOwner, Observer {errorMessage ->
            binding.errorMessage.text = errorMessage
        })

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