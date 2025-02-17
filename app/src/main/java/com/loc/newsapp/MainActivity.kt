package com.loc.newsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.loc.newsapp.ui.theme.NewsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val splashScreen = installSplashScreen()
        // 如果你需要定制启动屏的显示时间或动画效果
        splashScreen.setOnExitAnimationListener { splashScreenView ->
            // 用你自己的动画替代默认的退出动画
            splashScreenView.iconView.animate().alpha(0f).setDuration(500).withEndAction {
                splashScreenView.remove()
            }
        }

        // 延迟启动主界面，给启动屏一些时间显示
        setContent {
            NewsAppTheme {

            }
        }
    }
}
