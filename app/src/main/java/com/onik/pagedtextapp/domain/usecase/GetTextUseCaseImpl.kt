package com.onik.pagedtextapp.domain.usecase

import com.onik.pagedtextapp.data.repo.TextRepo
import javax.inject.Inject

class GetTextUseCaseImpl @Inject constructor(
    private val repo: TextRepo
) : GetTextUseCase {

    override fun execute(): String = repo.get()
}