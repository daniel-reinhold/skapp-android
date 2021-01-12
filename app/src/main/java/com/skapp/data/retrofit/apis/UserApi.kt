package com.skapp.data.retrofit.apis

import com.skapp.data.retrofit.models.User
import retrofit2.Call
import retrofit2.http.*

interface UserApi {

    /**
     * Returns all Users
     * @return [List]<[User]>
    * */
    @GET("/users")
    fun getUsers(): Call<List<User>>

    /**
     * Creates a new User
     * @param displayName The Display Name of the new User
     * @param email The E-Mail Address of the new User
     * @param password The Password of the new User (Cleartext)
     * @return [User]
     * */
    @POST("/users/create")
    fun createUser(
        @Query("display_name") displayName: String,
        @Query("email") email: String,
        @Query("password") password: String
    ): Call<User>

    /**
     * Updates a User
     * @param userId The User-ID of the User which has to be updated
     * @param displayName The new Display Name of the User
     * @param email The new E-Mail Address of the User
     * @return [User]
     * */
    @PATCH("/users/user_id/update")
    fun updateUser(
        @Path("user_id") userId: Int,
        @Query("display_name") displayName: String?,
        @Query("email") email: String?
    ): Call<User>

    @PATCH("/users/{user_id}/changepassword")
    fun changeUserPassword(
        @Path("user_id") userId: Int,
        @Query("old_password") oldPassword: String,
        @Query("new_password") newPassword: String
    ): Call<Any>

    /**
     * Deletes a User
     * @param userId The User-ID of the User which has to be deleted
     * @return [Any]
     * */
    @DELETE("/users/user_id/delete")
    fun deleteUser(
        @Path("user_id") userId: Int
    ): Call<Any>

}