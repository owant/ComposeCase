package com.example.mycompose.case2

import android.graphics.Color.pack
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.*


@Preview
@Composable
fun ContactListItem(
    @PreviewParameter(ContactDefault::class) contact: Contact
) {
    Row(
        modifier = Modifier
            .height(60.dp)
            .fillMaxWidth()
            .background(Color.White)
            .clickable {

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


class ContactDefault : PreviewParameterProvider<Contact> {
    override val values = sequenceOf(Contact("zhongliuwang", "1662088888", "key@qq.com", Color.Red))
}


data class Contact(
    var userName: String,
    var phoneNumber: String = "",
    var email: String,
    var userIcon: Color
)

fun mockData(): List<Contact> {
    var contacts = mutableListOf<Contact>()
    for (index in 0..100) {
        contacts.add(
            Contact(
                "H${index}",
                "${10000 + index}",
                "${133343 + index}@qq.com",
                userIcon = randomColor()
            )
        )
    }
    return contacts
}

fun randomColor(): Color {
    var random = Random()
    return Color(random.nextInt(256), random.nextInt(256), random.nextInt(256), 0xFF)
}
