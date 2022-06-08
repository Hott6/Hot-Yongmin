package thesopt.assignment.hot_yongmin.data.remote.data.entity.auth

data class ResponseSignUp(
    val status:Int,
    val message:String,
    val data: Data
){
    data class Data(
        val id:Int
    )
}
