package com.commandiron.toprated10films.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.commandiron.toprated10films.data.mapper.toActor
import com.commandiron.toprated10films.data.model.movie_db_actor.MovieDbActorDto
import com.commandiron.toprated10films.data.remote.MovieApi
import com.commandiron.toprated10films.domain.model.Actor

class ActorPagingSource(
    private val api: MovieApi,
    private val query: String
) : PagingSource<Int, Actor>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Actor> {
        val currentPage = params.key ?: 1
        return try {
            val response: MovieDbActorDto = if(query.isEmpty()){
                api.getPopularActors(currentPage)
            }else {
                api.getActorsByQuery(currentPage,query)
            }
            val endOfPaginationReached = response.page == response.total_pages
            if (!endOfPaginationReached) {
                LoadResult.Page(
                    data = response.movieDbActors.map { it.toActor() },
                    prevKey = if (currentPage == 1) null else currentPage - 1,
                    nextKey = currentPage + 1
                )
            } else {
                LoadResult.Page(
                    data = emptyList(),
                    prevKey = null,
                    nextKey = null
                )
            }
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Actor>): Int? {
        return state.anchorPosition
    }

}