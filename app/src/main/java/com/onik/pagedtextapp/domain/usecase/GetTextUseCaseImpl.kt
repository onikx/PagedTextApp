package com.onik.pagedtextapp.domain.usecase

import com.onik.pagedtextapp.data.repo.TextRepo
import com.onik.pagedtextapp.entity.Data
import javax.inject.Inject

class GetTextUseCaseImpl @Inject constructor(
    private val repo: TextRepo
) : GetTextUseCase {

    override fun execute(): Data = repo.get()
}