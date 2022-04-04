package com.example.aacbasic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.aacbasic.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // 리셋되는 카운터
//        var counter = 100
//        binding.textView.text = counter.toString()
//
//        binding.button.setOnClickListener {
//            counter += 1
//            binding.textView.text = counter.toString()
//        }

        // 뷰모델 적용
//        val myViewModel = ViewModelProvider(this).get(MyViewModel::class.java)
//        myViewModel.counter = 100
//        binding.textView.text = myViewModel.counter.toString()
//
//        binding.button.setOnClickListener {
//            myViewModel.counter += 1
//            binding.textView.text = myViewModel.counter.toString()
//        }

        // 팩토리 패턴을 통해 뷰모델에 초기값 적용
        val factory = MyViewModelFactory(100, this)
//        val myViewModel = ViewModelProvider(this, factory).get(MyViewModel::class.java)
        val myViewModel : MyViewModel by viewModels { factory }
        binding.textView.text = myViewModel.counter.toString()

        binding.button.setOnClickListener {
            myViewModel.counter += 1
            myViewModel.saveState()
            binding.textView.text = myViewModel.counter.toString()
        }
    }
}