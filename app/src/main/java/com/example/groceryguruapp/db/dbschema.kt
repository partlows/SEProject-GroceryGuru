package com.example.groceryguruapp.db

import android.provider.BaseColumns

object dbschema {

    class UserEntry : BaseColumns {
        companion object {
            val TABLE_NAME = "users"
            val COLUMN_USER_ID = "userid"
            val COLUMN_USER_FIRST  = "userfirst"
            val COLUMN_USER_LAST = "userlast"
            val COLUMN_USER_LISTS = "userlists"
        }
    }

    class ListEntry : BaseColumns {
        companion object {
            val TABLE_NAME = "userlists"
            val COLUMN_LIST_ID = "listid"
            val COLUMN_LIST_NAME = "listname"
            val COLUMN_LIST = "list"
        }
    }

    class ItemEntry : BaseColumns {
        companion object {
            val TABLE_NAME = "items"
            val COLUMN_ITEM_ID = "itemid"
            val COLUMN_ITEM_NAME = "itemname"
            val COLUMN_ITEM_CATEGORY = "itemcategory"
        }
    }
}