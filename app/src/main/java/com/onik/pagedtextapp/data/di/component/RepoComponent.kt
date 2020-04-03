package com.onik.pagedtextapp.data.di.component

import com.onik.pagedtextapp.data.repo.TextRepo

interface RepoComponent {
    val textRepo: TextRepo
}