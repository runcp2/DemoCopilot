/*
 * Copyright 2023 Google LLC
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

package com.google.samples.apps.sunflower.compose.dialog

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

/*
1. Add a new cancel button on left side of the dialog.
2. Add a new confirm button on right side of the dialog.
3. Add a new divider between the buttons.
4. Add a flag show and hide dialog as parameter
 */
@Composable
fun confirmDialog(
    isShow: Boolean,
    title: String,
    message: String,
    onOKBtnClick: () -> Unit,
    onCancelBtnClick: () -> Unit
) {
    if (isShow) {
        MyConfirmDialog(
            title = title,
            message = message,
            onOKBtnClick = { onOKBtnClick() },
            onCancelBtnClick = { onCancelBtnClick() }
        )
    } else return

}

@Preview
@Composable
fun MyConfirmDialog(
    title: String,
    message: String,
    onOKBtnClick: () -> Unit,
    onCancelBtnClick: () -> Unit
) {

    Dialog(onDismissRequest = { onCancelBtnClick() }) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(20.dp)
        ) {
            // Add a new cancel button on left side of the dialog.
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(200f)
                    .padding(20.dp)
            ) {
                Text(text = title, modifier = Modifier.padding(20.dp))
                Spacer(modifier = Modifier.width(20.dp))
                Text(text = message, modifier = Modifier.padding(20.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp),
                ) {
                    // Add a new divider between the buttons.
                    Spacer(modifier = Modifier.weight(1f))
                    Button(onClick = { onCancelBtnClick() }) {
                        Text("Cancel")
                    }
                    Spacer(modifier = Modifier.width(20.dp))
                    Button(onClick = { onOKBtnClick() }) {
                        Text("OK")
                    }
                }
            }
        }
    }

}
