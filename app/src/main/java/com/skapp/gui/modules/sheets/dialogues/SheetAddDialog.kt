package com.skapp.gui.modules.sheets.dialogues

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatDialog
import com.skapp.R
import com.skapp.gui.modules.sheets.listeners.SheetAddDialogYesButtonClickedListener
import kotlinx.android.synthetic.main.dialog_add_sheet.*

class SheetAddDialog(
    context: Context,
    private val yesButtonClickedListener: SheetAddDialogYesButtonClickedListener
) : AppCompatDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {

        // <editor-fold desc="Initial setup" defaultstate="collapsed">

        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_add_sheet)
        setTitle(R.string.sheet_title)

        // </editor-fold>

        // <editor-fold desc="Variables" defaultstate="collapsed">

        val etTitle: EditText = etTitleDialogAddSheet

        val btnYes: Button = btnYesDialogAddSheet
        val btnNo:  Button = btnNoDialogAddSheet

        // </editor-fold>

        // <editor-fold desc="Something" defaultstate="collapsed">

        btnYes.setOnClickListener {
            val title = etTitle.text

            if (title.isNotBlank()) {
                yesButtonClickedListener.onClick(title.toString())
                dismiss()
            }
        }

        btnNo.setOnClickListener {
            dismiss()
        }

        // </editor-fold>
    }

}