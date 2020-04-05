package com.onik.pagedtextapp.presentation.data

sealed class ViewState {
    data class Data(val data: String) : ViewState()
    data class Error(val message: String) : ViewState()
}