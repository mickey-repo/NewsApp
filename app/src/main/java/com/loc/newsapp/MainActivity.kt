package com.loc.newsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import com.loc.newsapp.presentation.onboarding.OnBoardingScreen
import com.loc.newsapp.ui.theme.NewsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
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
                Box(modifier = Modifier.background(color = MaterialTheme.colorScheme.background))
                OnBoardingScreen()
            }
        }
    }
}
