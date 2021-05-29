package com.example.placessearch.data

import com.google.gson.annotations.SerializedName

data class AutocompleteResponse (
    @SerializedName("predictions") val prediction: List<SearchResult>
)