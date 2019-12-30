package layout


import android.os.Parcel
import android.os.Parcelable
import com.squareup.moshi.Json

data class Word(
    @field:Json(name = "id")
    var id: Int,
    @field:Json(name = "word")
    var word: String,
    @field:Json(name = "description")
    var description: String? = "") : Parcelable
{
     constructor(parcel: Parcel
     ) : this(
         parcel.readInt(),
         parcel.readString(),
         parcel.readString()
         )

     override fun writeToParcel(parcel: Parcel, flags: Int) {
         parcel.writeInt(id)
         parcel.writeString(word)
         parcel.writeString(description)
     }

     override fun describeContents(): Int {
         return 0
     }

     companion object CREATOR : Parcelable.Creator<Word> {
         override fun createFromParcel(parcel: Parcel): Word {
             return Word(parcel)
         }

         override fun newArray(size: Int): Array<Word?> {
             return arrayOfNulls(size)
         }
     }
}