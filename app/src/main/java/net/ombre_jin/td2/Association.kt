package layout


import android.os.Parcel
import android.os.Parcelable
import com.squareup.moshi.Json

data class Association(
    @field:Json(name = "id")
    var id: Int,
    @field:Json(name = "gender")
    var gender: String,
    @field:Json(name = "word1")
    var word1: String,
    @field:Json(name = "word2")
    var word2: String,
    @field:Json(name = "description")
    var description: String? = "") : Parcelable
{
     constructor(parcel: Parcel
     ) : this(
         parcel.readInt(),
         parcel.readString(),
         parcel.readString(),
         parcel.readString(),
         parcel.readString()
         )

     override fun writeToParcel(parcel: Parcel, flags: Int) {
         parcel.writeInt(id)
         parcel.writeString(gender)
         parcel.writeString(word1)
         parcel.writeString(word2)
         parcel.writeString(description)
     }

     override fun describeContents(): Int {
         return 0
     }

     companion object CREATOR : Parcelable.Creator<Association> {
         override fun createFromParcel(parcel: Parcel): Association {
             return Association(parcel)
         }

         override fun newArray(size: Int): Array<Association?> {
             return arrayOfNulls(size)
         }
     }
}