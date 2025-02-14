/*
 * Copyright 2024 Dev Bwaim team
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

package dev.bwaim.kustomalarm.core.extentions

import org.junit.Assert
import org.junit.Test
import kotlin.time.Duration.Companion.seconds

internal class DurationTest {
    @Test
    fun duration_to_minutes_seconds() {
        val duration = 65.seconds
        val expected = "01:05"

        val result = duration.toMinutesSeconds()

        Assert.assertEquals(
            expected,
            result,
        )
    }

    @Test
    fun duration_to_hours_minutes_seconds() {
        val duration = 3665.seconds
        val expected = "1:01:05"

        val result = duration.toHoursMinutesSeconds()

        Assert.assertEquals(
            expected,
            result,
        )
    }
}
