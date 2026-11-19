package com.example.oleholehjogja

import java.io.Serializable

data class Variant(
    val title: String,
    val desc: String
) : Serializable

data class Souvenir(
    val id: String,
    val name: String,
    val subtitle: String,
    val category: String, // "basah", "kering", "minuman", "kerajinan"
    val categoryLabel: String,
    val shelfLife: String,
    val priceRange: String,
    val imageResId: Int,
    val isPopular: Boolean,
    val description: String,
    val quote: String,
    val variants: List<Variant>,
    val packingTips: List<String>,
    val locations: List<String>
) : Serializable

val Souvenir.priceValue: Int
    get() {
        val clean = priceRange.replace(".", "").replace("Rp", "").trim()
        val firstNum = clean.split("-").firstOrNull()?.filter { it.isDigit() } ?: ""
        return firstNum.toIntOrNull() ?: 25000
    }

val Souvenir.estimatedWeightGrams: Int
    get() = when (id) {
        "bakpia-pathok" -> 450
        "gudeg-kendil" -> 600
        "wedang-uwuh" -> 150
        "yangko-kotagede" -> 350
        "geplak-bantul" -> 300
        "bakpia-kukus" -> 400
        "oseng-mercon" -> 500
        "peyek-tumpuk" -> 300
        "kopi-jos" -> 250
        "cokelat-monggo" -> 200
        "jadah-tempe" -> 500
        "tiwul-manis" -> 400
        "salak-pondoh" -> 1000
        else -> 350
    }

val Souvenir.mainCenterLocation: String
    get() = when (id) {
        "bakpia-pathok" -> "Sentra Industri Bakpia Pathuk, Jl. KS Tubun, Yogyakarta"
        "gudeg-kendil" -> "Sentra Gudeg Wijilan, Kraton, Yogyakarta"
        "wedang-uwuh" -> "Sentra Perajin Wedang Uwuh, Imogiri, Bantul, Yogyakarta"
        "yangko-kotagede" -> "Yangko Pak Paku, Jl. Mondorakan, Kotagede, Yogyakarta"
        "geplak-bantul" -> "Sentra Geplak Mbok Tumpuk, Jl. Wahid Hasyim, Bantul, Yogyakarta"
        "bakpia-kukus" -> "Bakpia Kukus Tugu Jogja, Stasiun Tugu, Yogyakarta"
        "oseng-mercon" -> "Warung Oseng Mercon Bu Narti, Jl. KH. Ahmad Dahlan, Yogyakarta"
        "peyek-tumpuk" -> "Mbok Tumpuk Peyek Tumpuk, Palbapang, Bantul, Yogyakarta"
        "kopi-jos" -> "Angkringan Kopi Jos Lik Man, Stasiun Tugu, Yogyakarta"
        "cokelat-monggo" -> "Museum & Pabrik Cokelat Monggo, Kotagede, Yogyakarta"
        "jadah-tempe" -> "Jadah Tempe Mbah Carik Pusat, Kaliurang, Sleman, Yogyakarta"
        "tiwul-manis" -> "Tiwul Yu Tum Pusat, Wonosari, Gunungkidul, Yogyakarta"
        "salak-pondoh" -> "Desa Wisata Salak Pondoh Turi, Sleman, Yogyakarta"
        else -> locations.firstOrNull() ?: "$name Yogyakarta"
    }
