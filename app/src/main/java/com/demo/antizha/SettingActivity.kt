package com.demo.antizha

import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.demo.antizha.databinding.MineSettingInfoBinding

class SettingActivity : AppCompatActivity() {

    lateinit var settings: SharedPreferences
    lateinit var editor: SharedPreferences.Editor

    @SuppressLint("CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val settingBinding = MineSettingInfoBinding.inflate(layoutInflater)
        setContentView(settingBinding.root)
        var versionName=this.packageManager.getPackageInfo(this.packageName,PackageManager.GET_ACTIVITIES).versionName
        settingBinding.version.text="${settingBinding.version.text}${versionName}"
        settingBinding.setCommit.setOnClickListener {
            when {
                settingBinding.setName.text.toString() == "" -> {
                    Toast.makeText(this@SettingActivity, "名字不能为空。", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                settingBinding.setId.text.toString() == "" -> {
                    Toast.makeText(this@SettingActivity, "证件号不能为空。", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                !settingBinding.setId.text.toString().matches("^[0-6]*X|^[1-6][0-9]\$".toRegex()) -> {
                    Toast.makeText(this@SettingActivity, "证件号格式错误。", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                settingBinding.setRegion.text.toString() == "" -> {
                    Toast.makeText(this@SettingActivity, "地区不能为空。", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                settingBinding.setAddress.text.toString() == "" -> {
                    Toast.makeText(this@SettingActivity, "详细地址不能为空。", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                settingBinding.setWork.text.toString() == "" -> {
                    Toast.makeText(this@SettingActivity, "行业不能为空。", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                settingBinding.setEmergencyName.text.toString() == "" -> {
                    Toast.makeText(this@SettingActivity, "紧急联系人姓名不能为空", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                settingBinding.setEmergencyPhone.text.toString() == "" -> {
                    Toast.makeText(this@SettingActivity, "紧急联系人电话号码不能为空", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                settingBinding.setQq.text.toString() == "" -> {
                    Toast.makeText(this@SettingActivity, "QQ号码不能为空", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                settingBinding.setWechat.text.toString() == "" -> {
                    Toast.makeText(this@SettingActivity, "微信不能为空", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                settingBinding.setMail.text.toString().matches("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+\$".toRegex()) -> {
                    Toast.makeText(this@SettingActivity, "邮箱格式不对", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                else -> {
                    settings = getSharedPreferences("setting", 0)

                    editor = settings.edit()
                    editor.putString("name", "*${settingBinding.setName.text} ")

                    editor.putString(
                        "id",
                        settingBinding.setId.text.toString()[0]
                                + "****************"
                                + settingBinding.setId.text.toString()[1]
                    )

                    editor.putString("region", settingBinding.setRegion.text.toString())
                    editor.putString("address", settingBinding.setAddress.text.toString())
                    editor.putString("work", settingBinding.setWork.text.toString())
                    editor.putString("emergency_name",settingBinding.setEmergencyName.text.toString())
                    editor.putString("emergency_phone",settingBinding.setEmergencyPhone.text.toString())
                    editor.putString("qq",settingBinding.setQq.text.toString())
                    editor.putString("wechat",settingBinding.setWechat.text.toString())
                    editor.putString("mail",settingBinding.setMail.text.toString())
                    editor.apply()
                    Toast.makeText(this@SettingActivity, "成功", Toast.LENGTH_SHORT).show()
                    finish()
                }
            }
        }

        settingBinding.setClear.setOnClickListener {
            settingBinding.setName.text = null
            settingBinding.setId.text = null
            settingBinding.setRegion.text = null
            settingBinding.setAddress.text = null
            settingBinding.setWork.text = null
            settingBinding.setEmergencyName.text=null
            settingBinding.setEmergencyPhone.text=null
        }

        settingBinding.setReset.setOnClickListener {
            settings = getSharedPreferences("setting", 0)
            editor = settings.edit()
            editor.remove("name")
            editor.remove("id")
            editor.remove("region")
            editor.remove("address")
            editor.remove("work")
            editor.remove("emergency_name")
            editor.remove("emergency_phone")
            editor.remove("qq")
            editor.remove("wechat")
            editor.remove("mail")
            editor.commit()
            Toast.makeText(this@SettingActivity, "成功", Toast.LENGTH_SHORT).show()
            finish()
        }

        settingBinding.setLoadName.setOnClickListener {
            val seed = listOf<String>(
                "王", "李", "张", "刘", "陈", "杨", "黄", "赵", "吴", "周", "徐",
                "孙", "马", "朱", "胡", "郭", "何", "高", "林", "郑", "谢", "罗", "梁", "宋", "唐",
                "许", "韩", "冯", "邓", "曹", "彭", "曾", "蕭", "田", "董", "袁", "潘", "于", "蒋",
                "蔡", "余", "杜", "叶", "程", "苏", "魏", "吕", "丁", "任", "沈", "姚", "卢", "姜",
                "崔", "钟", "谭", "陆", "汪", "范", "金", "石", "廖", "贾", "夏", "韦", "付", "方",
                "白", "邹", "孟", "熊", "秦", "邱", "江", "尹", "薛", "闫", "段", "雷", "侯", "龙",
                "史", "陶", "黎", "贺", "顾", "毛", "郝", "龚", "邵", "万", "钱", "严", "覃", "武",
                "戴", "莫", "孔", "向", "汤"
            ).random()
            settingBinding.setName.setText(seed)
        }

        settingBinding.setLoadId.setOnClickListener {
            settingBinding.setId.setText("${(10..50).random()}")
        }

        settingBinding.setLoadWork.setOnClickListener {
            val seed = listOf<String>(
                "衣、林、牧、渔业", "金融、保险、投资", "房地产业", "教育、学生",
                "建筑业", "住宿和餐饮业", "采矿业", "旅游、购物、休闲", "工艺品、礼品",
                "党政机关、社会团体", "家具、生活用品、食品", "新闻、出版、科研", "机械设备、通用零部件",
                "广告、会展、商务办公、咨询", "公共管理、社会保障和社会组织", "卫生和社会工作", "制造业"
            )
                .random()
            settingBinding.setWork.setText(seed)
        }
        settingBinding.setEmergencyNameWork.setOnClickListener{
            val seed= listOf<String>(
                "张三","李四","王五","延颐真","荆蕴美","扈珑","敖怜双","表雨雪","让韶","类思烟","舒天禄",
                "以礼骞","苗越泽","水智美","晏初雪","考凝梦","牵谷芹","田亦巧","云良翰","乐映秋","接昌淼",
                "少弘懿","终芷珍","宰和豫","乔飞星","钟沛槐","栾宛亦","旷哲思","错瑜璟","邢惜萍","虞阳飇",
                "冀琇芬","邴悦可","上官夏青","童郁","恭宇","犹茗","东郭灵慧","彤修洁","碧鲁瑶","召嗣",
                "戊翎","空初蓝","苦涵忍","皇萧曼","謇清卓","司微澜","廖甲","潘玉成","邓又绿","左小萍"
            ).random()
            settingBinding.setEmergencyName.setText(seed)
        }
        settingBinding.setEmergencyPhoneWork.setOnClickListener{
            settingBinding.setEmergencyPhone.setText("${(13000000000..15999999999).random()}")
        }
        settingBinding.setQqWork.setOnClickListener {
            settingBinding.setQq.setText("${(10000..1999999999).random()}")
        }
        settingBinding.setWechatWork.setOnClickListener{
            val dictChars = mutableListOf<Char>().apply { "123456789zxcvbnmasdfghjklqwertyuiop".forEach { this.add(it) } }
            val randomStr = StringBuilder().apply { (1..((10..30).random())).onEach { append(dictChars.random()) } }
            settingBinding.setWechat.setText(randomStr)
        }
        settingBinding.setMailWork.setOnClickListener {
            val dictCharsAll = mutableListOf<Char>().apply { "123456789zxcvbnmasdfghjklqwertyuiop".forEach { this.add(it) } }
            val username = StringBuilder().apply { (1..((3..5).random())).onEach { append(dictCharsAll.random()) } }
            val server = StringBuilder().apply { (1..((2..5).random())).onEach { append(dictCharsAll.random()) } }
            val suffix = listOf<String>("com","net","cn","xyz","top").random()
            val finalString="${username}@${server}.${suffix}"
            settingBinding.setMail.setText(finalString)
        }
    }

}