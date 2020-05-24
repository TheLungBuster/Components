/*
 * Copyright 2019 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.material.materialthemebuilder.ui.component

/**
 * Enumeration of all components to be displayed by [ComponentAdapter].
 *
 * All components in this enum will be shown by [ComponentAdapter]. The order of the components
 * here will be the order they are displayed in by [ComponentAdapter].
 */
enum class Component {
  BUTTONS,
  CARD,
  TOP_APP_BAR,
  CHIP,
  DRAWER,
  TEXT_FIELD,
  BOTTOM_NAVIGATION,
  SWITCH,
  RADIO_BUTTON,
  CHECKBOX,
  BOTTOM_APP_BAR,
  TABS,
  SNACKBAR,
  DIALOG,
  BOTTOM_SHEET,
  BLOCK_DEVELOP_ERROR,
  BLOCK_ERROR,
  BLOCK_NETWORK_ERROR,
  BLOCK_OK,
  BLOCK_TITLE_DESCRIPTION,
  EVENT_CARD_SIGNED,
  EVENT_CARD_UNSIGNED,
  EVENT_ELEMENT,
  HOT_DIRECTION_ELEMENT,
  HOT_VACANCY_ELEMENT,
  MAINTENCE_ELEMENT,
  SETTINGS_ELEMENT,
  START_CARRIER_ELEMENT,
  EVENT_NOTIFICATION,
  MAINTENCE_NOTIFICATION,
  VACANCY_NOTIFICATION
}
