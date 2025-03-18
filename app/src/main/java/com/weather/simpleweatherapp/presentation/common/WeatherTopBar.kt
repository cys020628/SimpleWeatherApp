package com.weather.simpleweatherapp.presentation.common

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import kotlin.collections.forEach
import kotlin.let

/**
 * 사용 예시
@Composable
fun MyScreen() {
TopBar(
title = "My App",
navigationIconRes = R.drawable.ic_menu, // 네비게이션 아이콘 (예: 햄버거 메뉴)
onNavigationClick = { /* TODO: 네비게이션 버튼 클릭 처리 */ },
actions = listOf(
TopBarAction(R.drawable.ic_search, "Search") { /* TODO: 검색 버튼 클릭 */ },
TopBarAction(R.drawable.ic_settings, "Settings") { /* TODO: 설정 버튼 클릭 */ }
)
)
}
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherTopBar(
    title: String = "",
    navigationIconRes: Int? = null, // Drawable 리소스 ID
    onNavigationClick: (() -> Unit)? = null,
    actions: List<TopBarAction> = emptyList()
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = title,
                fontSize = 16.sp
            )
        },
        navigationIcon = {
            navigationIconRes?.let { resId ->
                IconButton(onClick = { onNavigationClick?.invoke() }) {
                    Icon(
                        painter = painterResource(id = resId),
                        contentDescription = "Navigation Icon"
                    )
                }
            }
        },
        actions = {
            Row {
                actions.forEach { action ->
                    IconButton(onClick = action.onClick) {
                        Icon(
                            painter = painterResource(id = action.iconRes),
                            contentDescription = action.contentDescription
                        )
                    }
                }
            }
        },
        modifier = Modifier.fillMaxWidth()
    )
}

data class TopBarAction(
    val iconRes: Int, // Drawable 리소스 ID
    val contentDescription: String,
    val onClick: () -> Unit
)