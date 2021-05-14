package com.example.preubakotlin.view

/*
import android.content.Context
import android.content.ContextWrapper
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.MainThread
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.example.udemyandroidexample.R
import com.example.udemyandroidexample.model.DogBreed
import com.example.udemyandroidexample.util.getProgressDrawable
import com.example.udemyandroidexample.util.loadImage
import kotlinx.android.synthetic.main.item_dog.view.*

class DogListAdapter(val dogList:ArrayList<DogBreed>):RecyclerView.Adapter<DogListAdapter.DogViewHolder>() {

    fun updateDogList(newDogList: List<DogBreed>){
        dogList.clear()
        dogList.addAll(newDogList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_dog, parent, false )
        return DogViewHolder(view)
    }

    override fun getItemCount() = dogList.size


    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        holder.view
        holder.view.text_title.text = dogList[position].breedId
        holder.view.text_description.text = dogList[position].lifeSpan
        holder.view.setOnClickListener {
            val action = ListFragmentDirections.actionDetailFragmentToDetailsFragment()
            action.dogId = position
            Navigation.findNavController(it).navigate(action)
        }
        holder.view.img_dog_picture.loadImage(dogList[position].imageUrl, getProgressDrawable(holder.view.img_dog_picture.context))
    }

    class DogViewHolder(var view: View): RecyclerView.ViewHolder(view)
}*/
