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

import dev.bwaim.kustomalarm.core.android.BuildWrapper
import dev.bwaim.kustomalarm.settings.theme.domain.Theme

internal object ThemeHelper {
    private val defaultTheme: Theme
        get() =
            if (BuildWrapper.isAtLeastQ) {
                Theme.SYSTEM
            } else {
                Theme.BATTERY_SAVER
            }

    fun fromPreferences(value: String): Theme =
        when {
            value.isEmpty() -> defaultTheme
            value == Theme.SYSTEM.value && BuildWrapper.isAtLeastQ.not() -> Theme.BATTERY_SAVER
            value == Theme.BATTERY_SAVER.value && BuildWrapper.isAtLeastQ -> Theme.SYSTEM
            else -> Theme.from(value)
        }
}
