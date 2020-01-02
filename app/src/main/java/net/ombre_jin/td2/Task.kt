package layout


import android.os.Parcel
import android.os.Parcelable
import com.squareup.moshi.Json

data class Task(
    @field:Json(name = "id")
    var id: String,
    @field:Json(name = "title")
    var title: String,
    @field:Json(name = "description")
    var description: String? = "") : Parcelable
{
     constructor(parcel: Parcel
     ) : this(
         parcel.readString(),
         parcel.readString(),
         parcel.readString())

     override fun writeToParcel(parcel: Parcel, flags: Int) {
         parcel.writeString(id)
         parcel.writeString(title)
         parcel.writeString(description)
     }

     override fun describeContents(): Int {
         return 0
     }

     companion object CREATOR : Parcelable.Creator<Task> {
         override fun createFromParcel(parcel: Parcel): Task {
             return Task(parcel)
         }

         override fun newArray(size: Int): Array<Task?> {
             return arrayOfNulls(size)
         }
     }
}