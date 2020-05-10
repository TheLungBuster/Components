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

import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.button.MaterialButton
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import io.material.materialthemebuilder.R
import io.material.materialthemebuilder.ui.component.Component.*

/**
 * Sealed class to define all [RecyclerView.ViewHolder]s used to display [Component]s.
 */
sealed class ComponentViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

  open fun bind(component: Component) {
    // Override in subclass if needed.
  }

  class ButtonsComponentViewHolder(
    parent: ViewGroup
  ) : ComponentViewHolder(inflate(parent, R.layout.component_buttons))

  class ButtonComponentViewHolder(
          parent: ViewGroup
  ) : ComponentViewHolder(inflate(parent, R.layout.component_button))

  class CardComponentViewHolder(
    parent: ViewGroup
  ) : ComponentViewHolder(inflate(parent, R.layout.component_cards))

  class TopAppBarComponentViewHolder(
    parent: ViewGroup
  ) : ComponentViewHolder(inflate(parent, R.layout.component_top_app_bar))

  class ChipComponentViewHolder(
    parent: ViewGroup
  ) : ComponentViewHolder(inflate(parent, R.layout.component_chips))

  class DrawerComponentViewHolder(
    parent: ViewGroup
  ) : ComponentViewHolder(inflate(parent, R.layout.component_drawer)) {
    //private val drawerLayout: DrawerLayout = view.findViewById(R.id.drawer_layout)
    //private val navigationView: NavigationView = view.findViewById(R.id.nav_view)

    //override fun bind(component: Component) {
    //  drawerLayout.openDrawer(Gravity.LEFT)
    //  navigationView.setNavigationItemSelectedListener { true }
    //  navigationView.setCheckedItem(R.id.nav_item_one)
    //}
  }

  class TextFieldComponentViewHolder(
    parent: ViewGroup
  ) : ComponentViewHolder(inflate(parent, R.layout.component_text_field))

  class BottomNavigationComponentViewHolder(
    parent: ViewGroup
  ) : ComponentViewHolder(inflate(parent, R.layout.component_bottom_navigation))

  class SwitchComponentViewHolder(
    parent: ViewGroup
  ) : ComponentViewHolder(inflate(parent, R.layout.component_switch))

  class RadioButtonComponentViewHolder(
    parent: ViewGroup
  ) : ComponentViewHolder(inflate(parent, R.layout.component_radio_button))

  class CheckboxComponentViewHolder(
    parent: ViewGroup
  ) : ComponentViewHolder(inflate(parent, R.layout.component_checkbox))

  class BottomAppBarComponentViewHolder(
    parent: ViewGroup
  ) : ComponentViewHolder(inflate(parent, R.layout.component_bottom_app_bar)) {
    private val bottomAppBar: BottomAppBar = view.findViewById(R.id.bottom_app_bar)

    override fun bind(component: Component) {
      bottomAppBar.overflowIcon = ContextCompat.getDrawable(
        bottomAppBar.context,
        R.drawable.ic_more_vert_on_surface_24dp
      )
    }
  }

  class BlockDevelopEComponentViewHolder(
          parent: ViewGroup
  ) : ComponentViewHolder(inflate(parent, R.layout.team_ctf_block_develop_error))

  class BlockEComponentViewHolder(
          parent: ViewGroup
  ) : ComponentViewHolder(inflate(parent, R.layout.team_ctf_block_error))

  class BlockNetworkEComponentViewHolder(
          parent: ViewGroup
  ) : ComponentViewHolder(inflate(parent, R.layout.team_ctf_block_network_error))

  class BlockOkComponentViewHolder(
          parent: ViewGroup
  ) : ComponentViewHolder(inflate(parent, R.layout.team_ctf_block_ok))

  class BlockTDComponentViewHolder(
          parent: ViewGroup
  ) : ComponentViewHolder(inflate(parent, R.layout.team_ctf_block_title_description))

  class EventCardSComponentViewHolder(
    parent: ViewGroup
  ) : ComponentViewHolder(inflate(parent, R.layout.team_ctf_event_card_signed))

  class EventCardUnSComponentViewHolder(
          parent: ViewGroup
  ) : ComponentViewHolder(inflate(parent, R.layout.team_ctf_event_card_unsigned))

  class EventEComponentViewHolder(
          parent: ViewGroup
  ) : ComponentViewHolder(inflate(parent, R.layout.team_ctf_event_element))

  class EventNComponentViewHolder(
          parent: ViewGroup
  ) : ComponentViewHolder(inflate(parent, R.layout.team_ctf_event_notification))

  class HotDEComponentViewHolder(
          parent: ViewGroup
  ) : ComponentViewHolder(inflate(parent, R.layout.team_ctf_hot_direction_element))

  class HotVEComponentViewHolder(
          parent: ViewGroup
  ) : ComponentViewHolder(inflate(parent, R.layout.team_ctf_hot_vacancy_element))

  class MaintenceEComponentViewHolder(
          parent: ViewGroup
  ) : ComponentViewHolder(inflate(parent, R.layout.team_ctf_maintence_element))

  class MaintenceNComponentViewHolder(
          parent: ViewGroup
  ) : ComponentViewHolder(inflate(parent, R.layout.team_ctf_maintence_notification))

  class SettingsEComponentViewHolder(
          parent: ViewGroup
  ) : ComponentViewHolder(inflate(parent, R.layout.team_ctf_settings_element))

  class StartCEComponentViewHolder(
          parent: ViewGroup
  ) : ComponentViewHolder(inflate(parent, R.layout.team_ctf_start_carrier_element))

  class VacancyNComponentViewHolder(
          parent: ViewGroup
  ) : ComponentViewHolder(inflate(parent, R.layout.team_ctf_vacancy_notification))

  class SnackbarComponentViewHolder(
    parent: ViewGroup
  ) : ComponentViewHolder(inflate(parent, R.layout.component_snackbar)) {

    init {
      val container: FrameLayout = view.findViewById(R.id.snackbar_container)
      val snackbarView = Snackbar.make(
        container,
        R.string.snackbar_message_text,
        Snackbar.LENGTH_INDEFINITE
      )
        .setAction(R.string.snackbar_action_text) { }
        .view
      (snackbarView.layoutParams as FrameLayout.LayoutParams).gravity = Gravity.CENTER

      container.addView(snackbarView)
    }
  }

  class DialogComponentViewHolder(
    parent: ViewGroup
  ) : ComponentViewHolder(inflate(parent, R.layout.component_dialog)) {
    init {
      val button = view.findViewById<MaterialButton>(R.id.button)
      button.setOnClickListener {
        showDialog()
      }
    }

    private fun showDialog() {
      MaterialAlertDialogBuilder(view.context)
        .setTitle(R.string.text_headline_6)
        .setMessage(R.string.type_event)
        .setPositiveButton(R.string.text_button, null)
        .setNegativeButton(R.string.text_button, null)
        .show()
    }
  }

  class BottomSheetComponentViewHolder(
    parent: ViewGroup,
    listener: ComponentAdapter.ComponentAdapterListener
  ) : ComponentViewHolder(inflate(parent, R.layout.component_bottom_sheet)) {
    init {
      view.findViewById<MaterialButton>(R.id.button).setOnClickListener {
        listener.onShowBottomSheetClicked()
      }
    }
  }

  class TabsComponentViewHolder(
          parent: ViewGroup
  ) : ComponentViewHolder(inflate(parent, R.layout.component_tabs))

  companion object {
    fun create(
      parent: ViewGroup,
      viewType: Int,
      listener: ComponentAdapter.ComponentAdapterListener
    ): ComponentViewHolder {
      return when (Component.values()[viewType]) {
        CARD -> ComponentViewHolder.CardComponentViewHolder(parent)
        TOP_APP_BAR -> ComponentViewHolder.TopAppBarComponentViewHolder(parent)
        BUTTONS -> ComponentViewHolder.ButtonsComponentViewHolder(parent)
        CHIP -> ComponentViewHolder.ChipComponentViewHolder(parent)
        DRAWER -> ComponentViewHolder.DrawerComponentViewHolder(parent)
        TEXT_FIELD -> ComponentViewHolder.TextFieldComponentViewHolder(parent)
        BOTTOM_NAVIGATION -> ComponentViewHolder.BottomNavigationComponentViewHolder(parent)
        SWITCH -> ComponentViewHolder.SwitchComponentViewHolder(parent)
        RADIO_BUTTON -> ComponentViewHolder.RadioButtonComponentViewHolder(parent)
        CHECKBOX -> ComponentViewHolder.CheckboxComponentViewHolder(parent)
        BOTTOM_APP_BAR -> ComponentViewHolder.BottomAppBarComponentViewHolder(parent)
        TABS -> ComponentViewHolder.TabsComponentViewHolder(parent)
        SNACKBAR -> ComponentViewHolder.SnackbarComponentViewHolder(parent)
        DIALOG -> ComponentViewHolder.DialogComponentViewHolder(parent)
        BOTTOM_SHEET -> ComponentViewHolder.BottomSheetComponentViewHolder(parent, listener)
        BLOCK_DEVELOP_ERROR -> ComponentViewHolder.BlockDevelopEComponentViewHolder(parent)
        BLOCK_ERROR -> ComponentViewHolder.BlockEComponentViewHolder(parent)
        BLOCK_NETWORK_ERROR ->ComponentViewHolder.BlockNetworkEComponentViewHolder(parent)
        BLOCK_OK ->ComponentViewHolder.BlockOkComponentViewHolder(parent)
        BLOCK_TITLE_DESCRIPTION ->ComponentViewHolder.BlockTDComponentViewHolder(parent)
        EVENT_CARD_SIGNED -> ComponentViewHolder.EventCardSComponentViewHolder(parent)
        EVENT_CARD_UNSIGNED -> ComponentViewHolder.EventCardUnSComponentViewHolder(parent)
        EVENT_ELEMENT -> ComponentViewHolder.EventEComponentViewHolder(parent)
        EVENT_NOTIFICATION -> ComponentViewHolder.EventNComponentViewHolder(parent)
        HOT_DIRECTION_ELEMENT -> ComponentViewHolder.HotDEComponentViewHolder(parent)
        HOT_VACANCY_ELEMENT -> ComponentViewHolder.HotVEComponentViewHolder(parent)
        MAINTENCE_ELEMENT -> ComponentViewHolder.MaintenceEComponentViewHolder(parent)
        MAINTENCE_NOTIFICATION -> ComponentViewHolder.MaintenceNComponentViewHolder(parent)
        SETTINGS_ELEMENT -> ComponentViewHolder.SettingsEComponentViewHolder(parent)
        START_CARRIER_ELEMENT -> ComponentViewHolder.StartCEComponentViewHolder(parent)
        VACANCY_NOTIFICATION -> ComponentViewHolder.VacancyNComponentViewHolder(parent)
      }
    }

    private fun inflate(parent: ViewGroup, layout: Int): View {
      return LayoutInflater.from(parent.context).inflate(layout, parent, false)
    }
  }
}
