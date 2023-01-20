package com.chetv.spacesxtestapp.utils

object ParserDate {
  fun getDate(str: String): String {
    //date data example 2010-06-04T18:45:00.000Z
    val regex = Regex("""(\d{4}).?(\d{2}).?(\d{2})""").find(str)
    return "${regex?.groupValues?.get(3)}" +
        "-${regex?.groupValues?.get(2)}" +
        "-${regex?.groupValues?.get(1)}"
  }

  fun getTime(str: String): String {
    val regex = Regex("""([T])(\d{2}.?\d{2}).?(\d{2}.+)""").find(str)
    return regex?.groupValues?.get(2).toString()
  }
}