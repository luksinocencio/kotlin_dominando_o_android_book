package com.devmeist3r.bottomsheet

import android.annotation.SuppressLint
import android.app.Dialog
import android.view.LayoutInflater
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.layout_dialog.view.*

class BottomDialog: BottomSheetDialogFragment() {
    @SuppressLint("RestrictedApi")
    override fun setupDialog(dialog: Dialog, style: Int) {
        super.setupDialog(dialog, style)

        val view = LayoutInflater.from(requireContext())
            .inflate(R.layout.layout_dialog, null)
        view.btnConfirm.setOnClickListener { dialog.dismiss() }
        view.btnCancel.setOnClickListener { dialog.dismiss() }
        dialog.setContentView(view)
    }
}