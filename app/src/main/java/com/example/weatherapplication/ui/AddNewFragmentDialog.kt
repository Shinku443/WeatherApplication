package com.example.weatherapplication.ui

import android.R.attr.button
import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.AdapterView.OnItemClickListener
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import com.example.weatherapplication.R
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber


@AndroidEntryPoint
class AddNewFragmentDialog: DialogFragment() {

    interface OnDialogClickedListener {
        fun onDialogClicked(position: Int)
    }

    fun setOnDialogClickedListener(l: OnDialogClickedListener) {
        callback = l
    }
    protected var callback: OnDialogClickedListener? = null


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(context).setTitle("Input lat/long")
            .setView(R.layout.input_city_dialog)
        //  .setView(latText)
        //   .setView(longText)
        
        builder.setPositiveButton(android.R.string.ok) { dialog, _ ->
            //   Timber.e("text:: ${latText.text}")
            val editName =
                (dialog as AlertDialog).findViewById<View>(com.example.weatherapplication.R.id.long_input) as EditText

            Timber.e("clicked:: ${editName.text}")
            dialog.dismiss()
        }
        builder.setNegativeButton(android.R.string.cancel) { dialog, _ -> dialog.cancel() }
        builder.create()
        Timber.e("add button clicked")

        return super.onCreateDialog(savedInstanceState)
    }




}

