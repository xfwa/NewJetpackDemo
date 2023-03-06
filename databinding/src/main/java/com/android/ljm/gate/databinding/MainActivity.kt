package com.android.ljm.gate.databinding

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.android.ljm.gate.databinding.databinding.ActivityMainBinding

/**
 * 什么是DataBinding?
 * DataBinding是Google在Jetpack中推出的一款数据绑定的框架，是Google为了实现MVVM在Android上的一种体现。
 * 也就是说DataBinding是基于MVVM思想实现数据和UI绑定的的框架，有了DataBinding，在Android中也可以很方便的实现MVVM。
 *
 * 使用DataBinding的好处
 * 1、跟ViewBinding一样，无需去写findViewById
 * 2、大量减少使用setText，setVisibility等代码的几率
 *
 * 怎么开启DataBinding?
 * android {
 *       ...
 *       dataBinding {
 *           enabled = true
 *       }
 *   }
 *
 * 怎么使用DataBinding?
 * 通常我们使用DataBinding也会使用到ViewBinding的功能，所以我们一般先改造setContentView
 * 我们可以通过DataBindingUtil.setContentView。需要注意的是我们也需要改造xml布局文件为dataBinding
 *
 * ok，我们已经使用上了DataBinding,但是这并不是DataBinding的核心功能，如果你单单想使用这个功能，那么还是推荐使用ViewBinding
 *
 * 数据绑定功能
 * 首先我们在xml文件导入要使用到的数据类
 * 然后我们可以拿到数据类进行数据的绑定
 *
 * 接着我们可以在DataBinding里面去设置数据
 * @{}
 *
 * 然后我们可以改造一下，结合我们之前了解的LiveData和ViewModel
 *
 *
 * ok,我们已经掌握了最简单的数据绑定。其实对于数据绑定我们远不止可以设置text属性，我们还有很多属性可以通过dataBinding设置，也有很多表达式
 * 参考文档：
 * https://developer.android.google.cn/topic/libraries/data-binding/expressions?hl=zh-cn#expression_language
 *
 * 挑几个讲一讲吧
 * +表达式
 *
 * ??表达式
 *
 * 避免Null指针异常
 * 生成的数据绑定代码会自动检查有没有 null 值并避免出现 Null 指针异常。
 * 例如，在表达式 @{user.name} 中，如果 user 为 Null，则为 user.name 分配默认值 null。
 * 如果您引用 user.age，其中 age 的类型为 int，则数据绑定使用默认值 0。
 *
 * 视图引用
 * 绑定类将 ID 转换为驼峰式大小写。
 *
 * 集合
 *
 * DataBinding 的方式处理点击事件
 *
 * 1、方法引用
 * 事件可以直接绑定到处理脚本方法，类似于为 Activity 中的方法指定 android:onClick 的方式。
 * 与 View onClick 特性相比，一个主要优点是表达式在编译时进行处理，因此，如果该方法不存在或其签名不正确，则会收到编译时错误。
 * android:onClick="@{handlers::onClickFriend}"
 *
 * 2、监听器绑定
 * android:onClick="@{(view)-> handlers.onClickFriend(view)}"
 *
 * BindingAdapter
 *
 *  注意：使用时type我们设置的参数是String，按照平常的习惯很容易就直接写了bind:type="中国"，这样是不对的，会导致找不到这个type，就算是直接设置值也要吧@{}加上
 *
 *
 */
class MainActivity : AppCompatActivity() {

    private val userInfoViewModel: UserInfoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val activityMainBinding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        activityMainBinding.handlers = MyHandlers()
        activityMainBinding.btnGetUserinfo.setOnClickListener {
            userInfoViewModel.setUserInfo(UserInfo("张三", 18, "男"))
        }

        userInfoViewModel.userInfoLiveData.observe(this) {
            activityMainBinding.userInfo = it
        }
    }
}