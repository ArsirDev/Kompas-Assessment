object Version {
    const val gradle = "7.0.3"
    const val plugin = "1.6.10"
    const val splash = "1.0.0-beta01"
    const val core = "1.8.0"
    const val appCompat = "1.5.0"
    const val material = "1.6.1"
    const val constraintLayout = "2.1.4"
    const val extJunit = "1.1.3"
    const val espresso = "3.4.0"
    const val lifecycleExtension = "2.2.0"
    const val lifecycle = "2.5.1"
    const val viewPager = "1.0.0"
    const val dotViewPager = "4.3"
    const val dataStore = "1.0.0"
    const val lottie = "3.4.0"
    const val retrofit = "2.9.0"
    const val gson = "2.8.9"
    const val navigation = "2.5.1"
    const val legacy = "1.0.0"
    const val glide = "4.9.0"
    const val hilt = "2.38.1"
    const val hilt_vm = "1.0.0-alpha03"
    const val room = "2.4.3"
    const val swipe_refresh = "1.1.0"
    const val inteceptor = "4.10.0"
}

object KotlinLibraries {
    /**
     * @param type dependecies of type [gradle_dependecies]
     */
    const val gradle_dependecies = "com.android.tools.build:gradle:${Version.gradle}"
    /**
     * @param type dependecies of type [plugin_dependecies]
     */
    const val plugin_dependecies = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.plugin}"
    /**
     * @param type dependecies of type [hilt_gradle]
     */
    const val hilt_gradle = "com.google.dagger:hilt-android-gradle-plugin:${Version.hilt}"

    const val navigation_gradle = "androidx.navigation:navigation-safe-args-gradle-plugin:${Version.navigation}"


}

object AndroidLibraries {
    /**
     * @param type dependecies of type [core]
     */
    const val core = "androidx.core:core-ktx: ${Version.core}"
    /**
     * @param type dependecies of type [appCompat]
     */
    const val appCompat = "androidx.appcompat:appcompat:${Version.appCompat}"
    /**
     * @param type dependecies of type [material]
     */
    const val material = "com.google.android.material:material:${Version.material}"
    /**
     * @param type dependecies of type [constraintLayout]
     */
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Version.constraintLayout}"
    /**
     * @param type dependecies of type [lifecycleExtensions]
     */
    const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Version.lifecycleExtension}"
    /**
     * @param type dependecies of type [lifecycleViewModel]
     */
    const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.lifecycle}"
    /**
     * @param type dependecies of type [lifecycleCompiler]
     */
    const val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:${Version.lifecycle}"
    /**
     * @param type dependecies of type [lifecycleRuntime]
     */
    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.lifecycle}"
    /**
     * @param type dependecies of type [lifecycleLivedata]
     */
    const val lifecycleLivedata = "androidx.lifecycle:lifecycle-livedata-ktx:${Version.lifecycle}"
    /**
     * @param type dependecies of type [splash]
     */
    const val splash = "androidx.core:core-splashscreen:${Version.splash}"
    /**
     * @param type dependecies of type [viewPager]
     */
    const val viewPager = "androidx.viewpager2:viewpager2:${Version.viewPager}"
    /**
     * @param type dependecies of type [dataStore]
     */
    const val dataStore = "androidx.datastore:datastore-preferences:${Version.dataStore}"
    /**
     * @param type dependecies of type [navigation_fragment]
     */
    const val navigation_fragment = "androidx.navigation:navigation-fragment-ktx:${Version.navigation}"
    /**
     * @param type dependecies of type [navigation_ui]
     */
    const val navigation_ui = "androidx.navigation:navigation-ui-ktx:${Version.navigation}"
    /**
     * @param type dependecies of type [legacy]
     */
    const val legacy = "androidx.legacy:legacy-support-v4:${Version.legacy}"
    /**
     * @param type dependecies of type [hilt]
     */
    const val hilt = "com.google.dagger:hilt-android:${Version.hilt}"
    /**
     * @param type dependecies of type [hilt_viewmodel]
     */
    const val hilt_viewmodel = "androidx.hilt:hilt-lifecycle-viewmodel:${Version.hilt_vm}"
}

object KaptLibraries {
    /**
     * @param type dependecies of type [kaptGlide]
     */
    const val kaptGlide = "com.github.bumptech.glide:compiler:${Version.glide}"
    /**
     * @param type dependecies of type [hilt_compiler]
     */
    const val hilt_compiler = "com.google.dagger:hilt-compiler:${Version.hilt}"
    /**
     * @param type dependecies of type [room_compiler]
     */
    const val room_compiler = "androidx.room:room-compiler:${Version.room}"

}

object Libraries {
    /**
     * @param type dependecies of type [dotViewPager]
     */
    const val dotViewPager = "com.tbuonomo:dotsindicator:${Version.dotViewPager}"
    /**
     * @param type dependecies of type [lottie]
     */
    const val lottie = "com.airbnb.android:lottie:${Version.lottie}"
    /**
     * @param type dependecies of type [retrofit]
     */
    const val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofit}"
    /**
     * @param type dependecies of type [retrofit_converter]
     */
    const val retrofit_converter = "com.squareup.retrofit2:converter-gson:${Version.retrofit}"
    /**
     * @param type dependecies of type [gson]
     */
    const val gson = "com.google.code.gson:gson:${Version.gson}"
    /**
     * @param type dependecies of type [glide]
     */
    const val glide = "com.github.bumptech.glide:glide:${Version.glide}"
    /**
     * @param type dependecies of type [room]
     */
    const val room = "androidx.room:room-runtime:${Version.room}"
    /**
     * @param type dependecies of type [room_ktx]
     */
    const val room_ktx = "androidx.room:room-ktx:${Version.room}"
    /**
     * @param type dependecies of type [swipe_refresh]
     */
    const val swipe_refresh = "androidx.swiperefreshlayout:swiperefreshlayout:${Version.swipe_refresh}"

    const val inteceptor = "com.squareup.okhttp3:logging-interceptor:${Version.inteceptor}"
}

object TestLibraries {
    /**
     * @param type dependecies of type [junit]
     */
    const val junit = "junit:junit:"
    /**
     * @param type dependecies of type [extJunit]
     */
    const val extJunit = "androidx.test.ext:junit:${Version.extJunit}"
    /**
     * @param type dependecies of type [espresso]
     */
    const val espresso = "androidx.test.espresso:espresso-core:${Version.espresso}"
}