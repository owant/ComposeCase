package com.example.mycompose.case5

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycompose.case2.Contact
import com.example.mycompose.case2.ContactDefault

@Composable
fun MvvmScreen(viewModel: MvvmViewModel) {
    MvvmContent(contact = viewModel.contact!!, onNameChange = { viewModel.onChangeName(it) })
}

@Composable
fun MvvmContent(
    @PreviewParameter(ContactDefault::class) contact: Contact,
    onNameChange: (String) -> Unit
) {
    val context = LocalContext.current
    Row(
        modifier = Modifier
            .background(Color(0xFFF6F6F6))
            .padding(10.dp)
            .height(60.dp)
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(10.dp))
            .clickable {
                onNameChange(contact.userName)
            }
            .padding(6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = "",
            modifier = Modifier
                .size(40.dp, 40.dp)
                .background(color = contact.userIcon, shape = CircleShape),
        )

        Column(Modifier.padding(10.dp, 0.dp, 0.dp, 0.dp)) {
            Text(text = contact.userName, fontSize = 16.sp)
            Text(text = contact.email, fontSize = 10.sp, color = Color(0x52030303))
        }
    }
}