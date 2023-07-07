package com.orion.threads.data

import com.orion.threads.R
import com.orion.threads.models.Thread

class GenerateThreadData {
    //generate Thread data
    companion object {
        fun generate(): List<Thread> {
            return listOf(
                Thread(
                    profileImage = R.drawable.okkama,
                    name = "Okkama",
                    time = "2h",
                    message = "Prepare to Be Captivated: Unveiling Our Unforgettable New Song," +
                            " Embracing the Rhythm of Your Soul!",
                    messagePhoto = R.drawable.iyallah
                ),
                Thread(
                    profileImage = R.drawable.elon,
                    name = "Elon Musk",
                    time = "3h",
                    message = "Just tried the 'clone of a clone' app. Not impressed. " +
                            "Originality is key and innovation drives progress. Stick with the real deal, folks. #AuthenticityMatters #InnovationOverImitation",
                    messagePhoto = R.drawable.thr,
                    isVerified = true
                ),

                Thread(
                    profileImage = R.drawable.bruce,
                    name = "Bruce Melodie",
                    time = "13m",
                    message = "Get ready to embark on an exhilarating musical journey like never before! We are thrilled to announce " +
                            "that our highly anticipated new song is on the horizon, poised" ,
                    messagePhoto = null
                ),


            )
        }
    }


}