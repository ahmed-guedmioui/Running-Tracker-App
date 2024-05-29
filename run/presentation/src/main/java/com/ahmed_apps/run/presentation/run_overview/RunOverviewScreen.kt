package com.ahmed_apps.run.presentation.run_overview

import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ahmed_apps.core.presentation.designsystem.AnalyticsIcon
import com.ahmed_apps.core.presentation.designsystem.LogoIcon
import com.ahmed_apps.core.presentation.designsystem.LogoutIcon
import com.ahmed_apps.core.presentation.designsystem.RunIcon
import com.ahmed_apps.core.presentation.designsystem.RunningTrackerTheme
import com.ahmed_apps.core.presentation.designsystem.components.RunningTrackerFloatingActionButton
import com.ahmed_apps.core.presentation.designsystem.components.RunningTrackerScaffold
import com.ahmed_apps.core.presentation.designsystem.components.RunningTrackerToolbar
import com.ahmed_apps.core.presentation.designsystem.components.util.DropDownMenuItem
import com.ahmed_apps.run.presentation.R
import org.koin.androidx.compose.koinViewModel

/**
 * @author Ahmed Guedmioui
 */
@Composable

fun RunOverviewScreenCore(
    onStartRunClick: () -> Unit,
    viewModel: RunOverviewViewModel = koinViewModel()
) {
    RunOverviewScreen(
        onAction = { action ->
            when (action) {
                RunOverviewAction.OnStartRun -> onStartRunClick()
                else -> Unit
            }
            viewModel.onAction(action)
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun RunOverviewScreen(
    onAction: (RunOverviewAction) -> Unit
) {

    val tooAppBarState = rememberTopAppBarState()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(
        state = tooAppBarState
    )

    RunningTrackerScaffold(
        topAppBar = {
            RunningTrackerToolbar(
                showBackButton = false,
                title = stringResource(R.string.running_tracker),
                scrollBehavior = scrollBehavior,
                menuItems = listOf(
                    DropDownMenuItem(
                        icon = AnalyticsIcon,
                        stringResource(R.string.analytics),
                    ),
                    DropDownMenuItem(
                        icon = LogoutIcon,
                        stringResource(R.string.logout),
                    )
                ),
                onMenuItemClick = { index ->
                    when (index) {
                        0 -> onAction(RunOverviewAction.OnAnalyticsClick)
                        1 -> onAction(RunOverviewAction.OnLogoutClick)
                    }
                },
                startContent = {
                    Icon(
                        imageVector = LogoIcon,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(30.dp)
                    )
                },
            )
        },
        floatingActionButton = {
            RunningTrackerFloatingActionButton(
                icon = RunIcon,
                onClick = {
                    onAction(RunOverviewAction.OnStartRun)
                }
            )
        }
    ) { paddingValues ->
    }

}

@Preview
@Composable
private fun RunOverviewScreenPreview() {
    RunningTrackerTheme {
        RunOverviewScreen(
            onAction = {}
        )
    }
}







