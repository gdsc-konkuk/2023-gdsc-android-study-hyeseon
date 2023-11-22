package kr.ac.konkuk.gdsc.hyeseon.data.model.remote.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kr.ac.konkuk.gdsc.hyeseon.domain.entity.Img

@Serializable
data class ResponseGetRandomImgDto(

    @SerialName("id")
    val id: String?,

    @SerialName("slug")
    val slug: String?,

    @SerialName("created_at")
    val createdAt: String,

    @SerialName("updated_at")
    val updatedAt: String,

    @SerialName("promoted_at")
    val promotedAt: String,

    @SerialName("width")
    val width: Int,

    @SerialName("height")
    val height: Int,

    @SerialName("color")
    val color: String,

    @SerialName("blur_hash")
    val blurHash: String,

    @SerialName("description")
    val description: String?,

    @SerialName("alt_description")
    val altDescription: String,

    @SerialName("breadcrumbs")
    val breadcrumbs: List<String>,

    @SerialName("urls")
    val urls: Urls,

    @SerialName("links")
    val links: Links,

    @SerialName("likes")
    val likes: Int,

    @SerialName("liked_by_user")
    val likedByUser: Boolean,

    @SerialName("current_user_collections")
    val currentUserCollections: List<String>,

    @SerialName("sponsorship")
    val sponsorship: String?,


    @SerialName("user")
    val user: User,

    @SerialName("exif")
    val exif: Exif,

    @SerialName("location")
    val location: Location,

    @SerialName("views")
    val views: Int,

    @SerialName("downloads")
    val downloads: Int
) {
    @Serializable
    data class Urls(

        @SerialName("raw")
        val raw: String?,

        @SerialName("full")
        val full: String?,

        @SerialName("regular")
        val regular: String?,

        @SerialName("small")
        val small: String?,

        @SerialName("thumb")
        val thumb: String?,

        @SerialName("small_s3")
        val smallS3: String?
    )

    @Serializable
    data class Links(

        @SerialName("self")
        val self: String,

        @SerialName("html")
        val html: String,

        @SerialName("download")
        val download: String,

        @SerialName("download_location")
        val downloadLocation: String?
    )


    @Serializable
    data class User(

        @SerialName("id")
        val id: String,

        @SerialName("updated_at")
        val updatedAt: String,

        @SerialName("username")
        val username: String,

        @SerialName("name")
        val name: String,

        @SerialName("first_name")
        val firstName: String,

        @SerialName("last_name")
        val lastName: String,

        @SerialName("twitter_username")
        val twitterUsername: String?,

        @SerialName("portfolio_url")
        val portfolioUrl: String,

        @SerialName("bio")
        val bio: String?,

        @SerialName("location")
        val location: String?,

        @SerialName("links")
        val links: UserLinks?,

        @SerialName("profile_image")
        val profileImage: ProfileImage,

        @SerialName("instagram_username")
        val instagramUsername: String?,

        @SerialName("total_collections")
        val totalCollections: Int?,

        @SerialName("total_likes")
        val totalLikes: Int?,

        @SerialName("total_photos")
        val totalPhotos: Int?,

        @SerialName("total_promoted_photos")
        val totalPromotedPhotos: Int?,

        @SerialName("accepted_tos")
        val acceptedTos: Boolean,

        @SerialName("for_hire")
        val forHire: Boolean,

        @SerialName("social")
        val social: Social
    )

    @Serializable
    data class UserLinks(

        @SerialName("self")
        val self: String?,

        @SerialName("html")
        val html: String?,

        @SerialName("photos")
        val photos: String?,

        @SerialName("likes")
        val likes: String?,

        @SerialName("portfolio")
        val portfolio: String?,

        @SerialName("following")
        val following: String?,

        @SerialName("followers")
        val followers: String?
    )

    @Serializable
    data class ProfileImage(

        @SerialName("small")
        val small: String?,

        @SerialName("medium")
        val medium: String?,

        @SerialName("large")
        val large: String?
    )

    @Serializable
    data class Social(

        @SerialName("instagram_username")
        val instagramUsername: String?,

        @SerialName("portfolio_url")
        val portfolioUrl: String?,

        @SerialName("twitter_username")
        val twitterUsername: String?,

        @SerialName("paypal_email")
        val paypalEmail: String?
    )

    @Serializable
    data class Exif(

        @SerialName("make")
        val make: String?,

        @SerialName("model")
        val model: String?,

        @SerialName("exposure_time")
        val exposureTime: String?,

        @SerialName("aperture")
        val aperture: String?,

        @SerialName("focal_length")
        val focalLength: String?,

        @SerialName("iso")
        val iso: Int
    )

    @Serializable
    data class Location(

        @SerialName("name")
        val name: String?,

        @SerialName("city")
        val city: String?,

        @SerialName("country")
        val country: String?,

        @SerialName("position")
        val position: Position
    )

    @Serializable
    data class Position(

        @SerialName("latitude")
        val latitude: Double,

        @SerialName("longitude")
        val longitude: Double
    )

    fun toImg(): Img {
        return Img(url = urls.small!!)
    }

}




