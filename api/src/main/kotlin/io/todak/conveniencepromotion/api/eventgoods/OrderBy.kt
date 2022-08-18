package io.todak.conveniencepromotion.api.eventgoods

enum class OrderBy(private val strValue: String) {
    ASC("ASC"),
    DESC("DESC");

    companion object {
        fun fromName(value: String?): OrderBy {
            if (value.isNullOrEmpty())
                return ASC
            return valueOf(value)
        }
    }
}
