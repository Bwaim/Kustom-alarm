/*
 * Copyright 2023 Dev Bwaim team
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.bwaim.kustomalarm.settings.impl.theme

import androidx.datastore.core.DataStore
import dev.bwaim.kustomalarm.settings.theme.ThemeRepository
import dev.bwaim.kustomalarm.settings.theme.domain.Theme
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import javax.inject.Inject

internal class ThemeRepositoryImpl @Inject constructor(
    private val dataStore: DataStore<ThemePreferences>,
) : ThemeRepository {
    override fun observeTheme(): Flow<Theme> =
        dataStore.data.distinctUntilChanged().map { prefs ->
            ThemeHelper.fromPreferences(prefs.theme)
        }

    override suspend fun setTheme(theme: Theme) {
        dataStore.updateData { it.copy { this@copy.theme = theme.value } }
    }
}
