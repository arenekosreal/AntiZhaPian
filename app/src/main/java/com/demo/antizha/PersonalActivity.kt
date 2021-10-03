package com.demo.antizha

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.demo.antizha.databinding.PersonalInfoBinding

class PersonalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        val infoBinding = PersonalInfoBinding.inflate(layoutInflater)
        setContentView(infoBinding.root)
        val settings: SharedPreferences = getSharedPreferences("setting", 0)

        infoBinding.name.text = settings.getString("name", "*三 ")
        infoBinding.id.text = settings.getString("id", "4****************8")
        infoBinding.region.text = settings.getString("region", "广东省.深圳市.龙岗区")
        infoBinding.address.text = settings.getString("address", "龙岗中心城福宁路113号")
        infoBinding.work.text = settings.getString("work", "电子设备制造")
        infoBinding.emergencyName.text = settings.getString("emergency_name","李四")
        infoBinding.emergencyPhone.text = settings.getString("emergency_phone","13000000000")
        infoBinding.qq.text = settings.getString("qq","10000")
        infoBinding.wechat.text = settings.getString("wechat","test_000")
        infoBinding.mail.text = settings.getString("mail","test@host.com")
    }
}