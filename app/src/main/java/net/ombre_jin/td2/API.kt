package net.ombre_jin.td2

import android.R.string
import android.os.AsyncTask.execute
import kotlinx.io.IOException
import okhttp3.*


object API {
    const val BASE_URL_WORDS_HTTPS = "https://api.wordnik.com/v4/words.json/"
    const val BASE_URL_WORD_HTTPS = "https://api.wordnik.com/v4/word.json/"

    const val URL_WORDS = "randomWords?hasDictionaryDef=true&includePartOfSpeech=noun&maxCorpusCount=-1&minDictionaryCount=1&maxDictionaryCount=-1&minLength=4&maxLength=11&limit=2&api_key=nx3a57o9wakw0hk2n9yydks0zzw6a7ndjyw9r4hdcz4b6ctrh"
    const val URL_DEF = "/definitions?limit=2&includeRelated=false&sourceDictionaries=all&useCanonical=true&includeTags=false&api_key=nx3a57o9wakw0hk2n9yydks0zzw6a7ndjyw9r4hdcz4b6ctrh"

    private const val API_KEY = "nx3a57o9wakw0hk2n9yydks0zzw6a7ndjyw9r4hdcz4b6ctrh"

}

//https://api.wordnik.com/v4/word.json/banana/definitions?limit=1&includeRelated=false&useCanonical=false&includeTags=false&api_key=nx3a57o9wakw0hk2n9yydks0zzw6a7ndjyw9r4hdcz4b6ctrh
//https://api.wordnik.com/v4/word.json/banana/definitions?limit=1&includeRelated=false&sourceDictionaries=all&useCanonical=false&includeTags=false&api_key=nx3a57o9wakw0hk2n9yydks0zzw6a7ndjyw9r4hdcz4b6ctrh