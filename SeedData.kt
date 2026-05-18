package com.mindmatrix.rakta.data

/** Initial content loaded the first time the app is opened. */
object SeedData {

    private const val DAY = 24L * 60 * 60 * 1000

    /** The editable profile that belongs to the device owner. */
    fun myProfile(): Donor = Donor(
        name = "You",
        bloodGroup = BloodGroup.O_POS,
        phone = "",
        locationName = "Set your location",
        distanceKm = 0,
        lastDonationDate = null,
        readyToDonate = false,
        isMe = true
    )

    /**
     * A small demo directory. A few donors have donated recently on purpose,
     * so the Emergency Search can prove that it hides ineligible donors.
     */
    fun sampleDonors(): List<Donor> {
        val now = System.currentTimeMillis()
        return listOf(
            Donor(name = "Ravi Kumar", bloodGroup = BloodGroup.O_POS, phone = "9876500001",
                locationName = "Hubli General", distanceKm = 3, lastDonationDate = null),
            Donor(name = "Anita Desai", bloodGroup = BloodGroup.A_POS, phone = "9876500002",
                locationName = "Dharwad", distanceKm = 8, lastDonationDate = now - 130 * DAY),
            Donor(name = "Suresh Patil", bloodGroup = BloodGroup.B_POS, phone = "9876500003",
                locationName = "Hubli", distanceKm = 5, lastDonationDate = now - 25 * DAY),
            Donor(name = "Meena Joshi", bloodGroup = BloodGroup.O_NEG, phone = "9876500004",
                locationName = "Navanagar", distanceKm = 6, lastDonationDate = now - 200 * DAY),
            Donor(name = "Imran Shaikh", bloodGroup = BloodGroup.O_POS, phone = "9876500005",
                locationName = "Gokul Road", distanceKm = 12, lastDonationDate = now - 95 * DAY),
            Donor(name = "Priya Nair", bloodGroup = BloodGroup.AB_POS, phone = "9876500006",
                locationName = "Vidyanagar", distanceKm = 4, lastDonationDate = now - 40 * DAY),
            Donor(name = "Karthik Rao", bloodGroup = BloodGroup.A_NEG, phone = "9876500007",
                locationName = "Keshwapur", distanceKm = 9, lastDonationDate = null),
            Donor(name = "Fatima Bano", bloodGroup = BloodGroup.B_NEG, phone = "9876500008",
                locationName = "Old Hubli", distanceKm = 14, lastDonationDate = now - 150 * DAY),
            Donor(name = "Deepak Shetty", bloodGroup = BloodGroup.O_POS, phone = "9876500009",
                locationName = "Unkal", distanceKm = 7, lastDonationDate = now - 300 * DAY),
            Donor(name = "Lakshmi Iyer", bloodGroup = BloodGroup.A_POS, phone = "9876500010",
                locationName = "Dharwad", distanceKm = 18, lastDonationDate = null,
                readyToDonate = false),
            Donor(name = "Sanjay Gowda", bloodGroup = BloodGroup.O_NEG, phone = "9876500011",
                locationName = "Hubli", distanceKm = 2, lastDonationDate = now - 110 * DAY),
            Donor(name = "Neha Kulkarni", bloodGroup = BloodGroup.AB_NEG, phone = "9876500012",
                locationName = "Gokul Road", distanceKm = 11, lastDonationDate = now - 10 * DAY)
        )
    }
}
