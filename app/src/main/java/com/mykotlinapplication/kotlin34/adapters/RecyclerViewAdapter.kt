package com.mykotlinapplication.kotlin34.adapters

import android.content.ClipData
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mykotlinapplication.kotlin34.R
import kotlinx.android.synthetic.main.list_item.view.*

class RecyclerViewAdapter(var contacts: ArrayList<Triple<String, String, String>>, val context: Context): RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item, parent, false))
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = contacts[position].first
        holder.email.text = contacts[position].second
        holder.phone.text = contacts[position].third
    }

//    fun setData(data: ArrayList<HashMap<String, String>>) {
//        items = data
//    }
}

class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
    var name = view.textView_name
    var email = view.textView_email
    var phone = view.textView_phone
}