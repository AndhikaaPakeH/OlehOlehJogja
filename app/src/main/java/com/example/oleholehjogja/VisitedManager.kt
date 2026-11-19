package com.example.oleholehjogja

import android.content.Context
import android.content.SharedPreferences

object VisitedManager {
    private const val PREF_NAME = "jogja_visited_pref"
    private const val KEY_VISITED = "visited_souvenirs"

    private fun getPrefs(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }

    fun getVisitedIds(context: Context): Set<String> {
        return getPrefs(context).getStringSet(KEY_VISITED, emptySet()) ?: emptySet()
    }

    fun addVisited(context: Context, id: String) {
        val current = getVisitedIds(context).toMutableSet()
        if (!current.contains(id)) {
            current.add(id)
            getPrefs(context).edit().putStringSet(KEY_VISITED, current).apply()
        }
    }

    fun getCount(context: Context): Int {
        return getVisitedIds(context).size
    }

    fun clear(context: Context) {
        getPrefs(context).edit().remove(KEY_VISITED).apply()
    }
}
