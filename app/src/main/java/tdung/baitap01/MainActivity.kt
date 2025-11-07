package tdung.baitap01

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Khai báo View cho Bài 5
    private lateinit var edtInput: EditText
    private lateinit var btnReverse: Button
    private lateinit var tvResult: TextView

    // KHAI BÁO VIEW MỚI CHO BÀI 4
    private lateinit var tvSoChan: TextView
    private lateinit var tvSoLe: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // --- BÀI 4: ArrayList và Log ---

        tvSoChan = findViewById(R.id.tv_so_chan)
        tvSoLe = findViewById(R.id.tv_so_le)

        // Chạy logic Bài 4
        thucHienBai4()

        // --- BÀI 5: Đảo chuỗi và Button Click ---

        edtInput = findViewById(R.id.edt_input)
        btnReverse = findViewById(R.id.btn_reverse)
        tvResult = findViewById(R.id.tv_result)


        thucHienBai5()
    }

    /**
     * BÀI 4
     */
    private fun thucHienBai4() {
        val mangSo = arrayListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

        val soChan = StringBuilder("Số chẵn: ")
        val soLe = StringBuilder("Số lẻ: ")

        for (so in mangSo) {
            if (so % 2 == 0) {
                soChan.append(so).append(" ")
            } else {
                soLe.append(so).append(" ")
            }
        }

        // Vẫn in ra Logcat cho chắc
        Log.d("BaiTap4", soChan.toString())
        Log.d("BaiTap4", soLe.toString())
        tvSoChan.text = soChan.toString()
        tvSoLe.text = soLe.toString()
    }

    /**
     * BÀI 5:
     */
    private fun thucHienBai5() {
        btnReverse.setOnClickListener {
            val input = edtInput.text.toString()
            val words = input.split(" ")
            val reversedBuilder = StringBuilder()

            for (i in words.size - 1 downTo 0) {
                reversedBuilder.append(words[i])
                if (i > 0) {
                    reversedBuilder.append(" ")
                }
            }

            val finalResult = reversedBuilder.toString().uppercase()
            tvResult.text = finalResult
            Toast.makeText(this, finalResult, Toast.LENGTH_SHORT).show()
        }
    }
}