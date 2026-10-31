
package com.aivision.aimtrainer

import android.app.Activity
import android.os.Bundle
import android.content.Intent
import android.net.Uri
import android.graphics.Color
import android.view.Gravity
import android.widget.*

class MainActivity : Activity() {

    private lateinit var status: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL
        layout.setPadding(32, 40, 32, 32)
        layout.setBackgroundColor(Color.rgb(18, 22, 32))

        val title = TextView(this)
        title.text = "AI VISION"
        title.textSize = 30f
        title.setTextColor(Color.WHITE)
        title.gravity = Gravity.CENTER
        layout.addView(title)

        val subtitle = TextView(this)
        subtitle.text = "AI 视觉瞄准训练器"
        subtitle.textSize = 18f
        subtitle.setTextColor(Color.LTGRAY)
        subtitle.gravity = Gravity.CENTER
        layout.addView(subtitle)

        status = TextView(this)
        status.text = "请选择训练图片"
        status.textSize = 16f
        status.setTextColor(Color.GREEN)
        status.gravity = Gravity.CENTER
        status.setPadding(0, 50, 0, 50)
        layout.addView(status)

        val selectButton = Button(this)
        selectButton.text = "选择训练图片"
        layout.addView(selectButton)

        selectButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"
            startActivityForResult(intent, 1001)
        }

        val info = TextView(this)
        info.text = "训练功能：\n\n" +
                "• 人物目标识别\n" +
                "• 头部区域定位\n" +
                "• 准星偏差分析\n" +
                "• 训练数据统计"
        info.textSize = 17f
        info.setTextColor(Color.WHITE)
        info.setPadding(10, 40, 10, 40)
        layout.addView(info)

        val analyzeButton = Button(this)
        analyzeButton.text = "开始训练分析"
        layout.addView(analyzeButton)

        analyzeButton.setOnClickListener {
            status.text = "当前为界面演示版，AI模型尚未接入"
        }

        setContentView(layout)
    }

    @Deprecated("Deprecated in Android")
    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1001 &&
            resultCode == RESULT_OK &&
            data?.data != null
        ) {
            status.text = "图片已选择，等待AI分析"
        }
    }
}
