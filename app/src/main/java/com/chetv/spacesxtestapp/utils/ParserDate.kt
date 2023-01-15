package com.chetv.spacesxtestapp.utils

object ParserDate {
  fun getDate(str: String): String {
    //2010-06-04T18:45:00.000Z
    val regex = Regex("""\d{4}.?\d{2}.?\d{2}""").find(str)
    return regex?.value.toString()
  }

  fun getTime(str: String): String {
    val regex = Regex("""([T])(\d{2}.?\d{2}.?\d{2})(.+)""").find(str)
    return regex?.groupValues?.get(2).toString()
  }
}