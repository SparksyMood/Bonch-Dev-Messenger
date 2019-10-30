package bonch.dev.school.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import bonch.dev.school.R
import bonch.dev.school.ui.models.MessageLab

    class MessageAdapter : RecyclerView.Adapter<MessageAdapter.MessageHolder>() {

    val messageList = MessageLab().messageList

    override fun OnCreatViewHolder(parent: ViewGroup, viewType: Int): MessageHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_chat, parent, false)
        return MessageHolder(view)
    }

    override fun getItemCount(): Int = messageList.size

    override fun onBindViewHolder(holder: MessageHolder, position: Int) {
        holder.bind(position)
    }

    inner class MessageHolder(view: View) : RecyclerView.ViewHolder(view){
        fun bind(position: Int) {
            val titleTextView = itemView.findViewById<TextView>(R.id.message_et)
            titleTextView.text = messageList[position].messageText
        }
    }
}