package com.skapp.gui.modules.sheets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.skapp.R
import com.skapp.data.adapters.SheetsAdapter
import com.skapp.data.retrofit.RetrofitUtils
import com.skapp.data.retrofit.apis.SheetApi
import com.skapp.data.retrofit.models.Sheet
import com.skapp.gui.modules.sheets.dialogues.SheetAddDialog
import com.skapp.gui.modules.sheets.listeners.SheetAddDialogYesButtonClickedListener
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.awaitResponse
import kotlinx.android.synthetic.main.activity_sheets.*

class SheetActivity : AppCompatActivity() {

    // <editor-fold desc="Variables" defaultstate="collapsed">

    lateinit var adapter: SheetsAdapter
    private lateinit var layoutManager: LinearLayoutManager

    val sheetApi = RetrofitUtils.getRetrofit(SheetApi::class.java)

    // </editor-fold>

    override fun onCreate(savedInstanceState: Bundle?) {

        // <editor-fold desc="Initial setup" defaultstate="collapsed">

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sheets)

        // </editor-fold>

        // <editor-fold desc="Variables" defaultstate="collapsed">

        val adapter = SheetsAdapter(mutableListOf())
        val layoutManager = LinearLayoutManager(this)
        val recyclerView: RecyclerView = rvSheetsIndex

        recyclerView.adapter = adapter
        recyclerView.layoutManager = layoutManager

        val fabAddSheet: FloatingActionButton = fabAddSheet

        // </editor-fold>

        // <editor-fold desc="Add Sheet" defaultstate="collapsed">

        val onYesClickedListener = object : SheetAddDialogYesButtonClickedListener {
            override fun onClick(sheetTitle: String) {
                GlobalScope.launch(Dispatchers.Main) {
                    val response = sheetApi.createSheet(1, sheetTitle).awaitResponse()

                    if (response.isSuccessful) {
                        val sheet = response.body()!!

                        adapter.items.add(sheet)
                        adapter.notifyItemInserted(adapter.itemCount)
                    } else {
                        // TODO: Error message
                    }
                }
            }
        }

        fabAddSheet.setOnClickListener {
            SheetAddDialog(this, onYesClickedListener).show()
        }

        // </editor-fold>

        // <editor-fold desc="Load Sheets" defaultstate="collapsed">

        GlobalScope.launch(Dispatchers.Main) {
            val response = sheetApi.getSheets(1).awaitResponse()

            if (response.isSuccessful) {
                val sheets = response.body()!!

                adapter.items = sheets as MutableList<Sheet>
                adapter.notifyDataSetChanged()
            }
        }

        // </editor-fold>

    }
}