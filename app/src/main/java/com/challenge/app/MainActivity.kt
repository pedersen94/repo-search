package com.challenge.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.createSavedStateHandle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.challenge.data.FakeRepositoryRemoteDataSource
import com.challenge.data.RepositoryRepositoryImpl
import com.challenge.domain.SearchRepositoriesUseCase

/**
 * Manual dependency injection is wired here for you. The graph is:
 *   FakeRemoteDataSource -> RepositoryRepositoryImpl -> UseCase -> ViewModel
 *
 * You should not need to change the wiring — swapping the fake for a real
 * data source should be possible here WITHOUT touching domain or presentation.
 */
class MainActivity : ComponentActivity() {

    private val viewModel: SearchViewModel by viewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
                val dataSource = FakeRepositoryRemoteDataSource()
                val repository = RepositoryRepositoryImpl(dataSource)
                val useCase = SearchRepositoriesUseCase(repository)
                @Suppress("UNCHECKED_CAST")
                return SearchViewModel(useCase, extras.createSavedStateHandle()) as T
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface { SearchScreen(viewModel) }
            }
        }
    }
}
