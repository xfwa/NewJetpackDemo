package com.android.ljm.gate.viewbinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.ljm.gate.viewbinding.databinding.ActivityMainBinding

/**
 * 什么是ViewBinding
 * 通过ViewBinding，我们可以更轻松地编写可与视图交互的代码。在模块中启用视图绑定之后，系统会为该模块中的每个 XML 布局文件生成一个绑定类。绑定类的实例包含对在相应布局中具有 ID 的所有视图的直接引用。
 * 在大多数情况下，ViewBinding会替代 findViewById。
 *
 * 视图绑定在 Android Studio 3.6 Canary 11 及更高版本中可用。
 *
 * 怎么使用？
 * 视图绑定功能可按模块启用。要在某个模块中启用视图绑定，请将 viewBinding 元素添加到其 build.gradle 文件中，如下例所示：
 * android {
*  ...
*   viewBinding {
*       enabled = true
*       }
*  }
 *
 *  如果您希望在生成绑定类时忽略某个布局文件，请将 tools:viewBindingIgnore="true" 属性添加到相应布局文件的根视图中：
 *
 * 与findViewById的区别
 * 与使用 findViewById 相比，视图绑定具有一些很显著的优点：
 * Null 安全：由于视图绑定会创建对视图的直接引用，因此不存在因视图 ID 无效而引发 Null 指针异常的风险。
 * 此外，如果视图仅出现在布局的某些配置中，则绑定类中包含其引用的字段会使用 @Nullable 标记。
 * 类型安全：每个绑定类中的字段均具有与它们在 XML 文件中引用的视图相匹配的类型。这意味着不存在发生类转换异常的风险。
 * 这些差异意味着布局和代码之间的不兼容将会导致构建在编译时（而非运行时）失败
 *
 * 与DataBinding的对比
 * 视图绑定旨在处理更简单的用例，与数据绑定相比，具有以下优势：
 * 更快的编译速度：视图绑定不需要处理注释，因此编译时间更短。
 * 易于使用：视图绑定不需要特别标记的 XML 布局文件，因此在应用中采用速度更快。在模块中启用视图绑定后，它会自动应用于该模块的所有布局。
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        val activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)
    }
}