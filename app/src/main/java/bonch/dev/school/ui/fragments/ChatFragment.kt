package bonch.dev.school.ui.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.recyclerview.widget.RecyclerView

import bonch.dev.school.R
import bonch.dev.school.ui.activities.MainAppActivity


class ChatFragment : Fragment() {

    private lateinit var sendMessageButton: ImageButton
    private lateinit var messageRecycle: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_chat, container, false)
        sendMessageButton = view.findViewById(R.id.send_message_button)
        sendMessageButton.setOnClickListener {
            fragmentManager!!.beginTransaction()
                .replace(R.id.fragment_container, ProfileFragment())
                .addToBackStack("profile")
                .commit()
        }
        return view
    }
}
