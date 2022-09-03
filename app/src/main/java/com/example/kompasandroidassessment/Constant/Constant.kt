
object EndPoint {
    const val SEARCH_EP = "/search/users"

    const val DETAIL_EP = "/users/{username}"

    const val DETAIL_REPO_EP = "/users/{username}/repos"
}

object Keys {
    const val AUTH_HEADER = "Authorization"
}

object Database {

    const val dbVersion = 2

    const val DATABASE_NAME = "db_github"
}

object Error {

    const val MESSAGE_ERROR = "error"

    const val MESSAGE_SUCCESS = "success"
}

object BundleKey {

    const val ARGUMENT = "username"
}