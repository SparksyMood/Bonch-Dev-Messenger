package bonch.dev.school.ui.fragments

import android.content.ContentValues.TAG
import android.content.Context
import android.net.Uri
import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.DialogFragment

import bonch.dev.school.R


class PasswordFragment : DialogFragment() {

    private lateinit var acceptButton: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_password, container,false)
        initializeView(view)
        setListener()
        return view
    }

    private fun initializeView(view: View) {
        acceptButton = view.findViewById(R.id.change_password_button)
    }

    private fun setListener(){
        acceptButton.setOnClickListener(){
            Log.d(TAG, "onClick: closing dialog")
            dialog.dismiss()
        }
    }

}
