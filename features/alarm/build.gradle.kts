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
plugins {
    id("kustomalarm.android.library")
    id("kustomalarm.android.feature")
    id("kustomalarm.android.library.compose")
    id("kustomalarm.android.library.jacoco")
}

android {
    namespace = "dev.bwaim.kustomalarm.features.alarm"
}

dependencies {
    implementation(projects.common.alarm.alarm)
    implementation(projects.common.core.coreAndroid)

    implementation(libs.androidx.appcompat)
}
