package com.skapp.data.retrofit.apis

import com.skapp.data.retrofit.models.Sheet
import retrofit2.Call
import retrofit2.http.*
import com.skapp.data.util.Constants.OK
import com.skapp.data.util.Constants.CREATED
import com.skapp.data.util.Constants.NO_CONTENT

interface SheetApi {

    /**
     * Returns all Sheet for a Specific user
     * @param userId The User-ID of the User whose Sheets should be returned
     * @return [List]<[Sheet]>
    */
    @GET("/users/{user_id}/sheets")
    fun getSheets(
        @Path("user_id") userId: Int
    ): Call<List<Sheet>>

    /**
     * Creates a Sheet for a specific User
     * @param userId The User-ID of the User for who the Sheet should be created
     * @param title The title of the Sheet
     * @return [Sheet]
     */
    @POST("/users/{user_id}/sheets/create")
    fun createSheet(
        @Path("user_id") userId: Int,
        @Query("title") title: String
    ): Call<Sheet>

    /**
     * Updates a Sheet of a specific User
     * @param userId The User-ID of the User for who the Sheet should be updated
     * @param sheetId The Sheet-ID of the sheet which has to be updated
     * @param title The new title of the Sheet
     * @return
     */
    @PATCH("/users/{user_id}/sheets/{sheet_id}/update")
    fun updateSheet(
        @Path("user_id") userId: Int,
        @Path("sheet_id") sheetId: Int,
        @Query("title") title: String
    ): Call<Sheet>

    /**
     * Deletes a Sheet of a specific User
     * @param userId The User-ID of the User for who the Sheet should be updated
     * @param sheetId The Sheet-ID of the sheet which has to be deleted
     * @return [Any]
     */
    @DELETE("/users/{user_id}/sheets/{sheet_id}/delete")
    fun deleteSheet(
        @Path("user_id") userId: Int,
        @Path("sheet_id") sheetId: Int
    ): Call<Any>

}