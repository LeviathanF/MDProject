package com.example.msi_.mdproject.activity

import android.graphics.Bitmap
import android.graphics.pdf.PdfRenderer
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import com.example.msi_.mdproject.BaseActivity.BaseActivity
import com.example.msi_.mdproject.R

/**
 *@Author：ZC
 *@Time： 2018/7/27 10:27
 *@Description：pdf转化页面
 **/
class PdfActivity:BaseActivity(){
    private lateinit var pdfRenderer:PdfRenderer
    private lateinit var btnPrevious:Button
    private lateinit var btnNext:Button
    private lateinit var ivContent:ImageView
    private var index = 0
    private lateinit var mCurrentPage:PdfRenderer.Page
    private lateinit var bitmap: Bitmap

    override fun getLayoutId(): Int= R.layout.activity_pdf

    override fun initView() {
        btnPrevious = findViewById(R.id.btn_previous)
        btnNext = findViewById(R.id.btn_next)
        ivContent = findViewById(R.id.iv_content)
    }

    override fun init() {
        try {
            val assetFileDescriptor = assets.openFd("test.pdf")
            pdfRenderer = PdfRenderer(assetFileDescriptor.parcelFileDescriptor)
            showPage()
        } catch (e:Exception){
        }finally {
            val files = assets.list("")
            for (file in files)
            Log.d("pdf",file)
        }

        btnPrevious.setOnClickListener {
            if (index>0){
                index--
            }
            showPage()
        }
        btnNext.setOnClickListener {
            if (index < pdfRenderer.pageCount-1){
                index++
            }
            showPage()
        }
    }

    override fun initToolsbar() {
        title="pdf展示"
    }

    private fun showPage(){
        mCurrentPage = pdfRenderer.openPage(index)
        bitmap = Bitmap.createBitmap(mCurrentPage.width,mCurrentPage.height,Bitmap.Config.ARGB_8888)
        mCurrentPage.render(bitmap,null,null,PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY)
        ivContent.setImageBitmap(bitmap)
    }

}