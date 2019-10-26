package bonch.dev.school.ui.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RelativeLayout

import bonch.dev.school.R
import bonch.dev.school.ui.activities.MainAppActivity


class ChatFragment : Fragment() {

    private lateinit var messageET: EditText
    private lateinit var sendMessageButton: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_chat, container,false)
        initializeView(view)
        setListener()
        return view
    }

    private fun initializeView(view: View) {

        messageET = view.findViewById(R.id.message_et)
        sendMessageButton = view.findViewById(R.id.send_message_button)
    }

    private fun setListener(){
        sendMessageButton.setOnClickListener({
            (context as MainAppActivity).toProfileFragment()
        })
    }
}
