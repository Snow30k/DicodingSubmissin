package com.snow30k.dicodingsubmission.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.snow30k.dicodingsubmission.R

class GameDao {

    private val gameList = mutableListOf<Game>()
    private val games = MutableLiveData<List<Game>>()

    init {
        val names: Array<String> = arrayOf(
            "Death Stranding",
            "Ghost Recon Breakpoint",
            "Sekiro: Shadows Die Twice",
            "Borderlands 3",
            "Devil May Cry 5 (2019)",
            "Call of Duty: Modern Warfare",
            "Need For Speed Heat",
            "Far Cry: New Dawn",
            "Resident Evil 2 Remake",
            "Ancestors: The Humankind Odyssey"
        )

        val genres: Array<String> = arrayOf(
            "Adventure, Mystery",
            "3rd Person, Action, Shooter, War",
            "3rd Person, Action, RPG, Fantasy, Historic",
            "3rd Person, Action, Shooter, Sci fi",
            "Action, Adventure, Fantasy, Horror",
            "Shooter, Realism, War",
            "Action, Racing, Realism",
            "Action, Shooter, War",
            "Action, Horror, Survival",
            "Action, Adventure, Sandbox, Historic, Survival"
        )

        val authors: Array<String> = arrayOf(
            "Hitori Nojima",
            "mil Daubon dan David Gallaher",
            "Yuka Kitamura",
            "Danny Homan dan Sam Winkler",
            "Capcom",
            "Sarah Schachner",
            "Riley Cooper",
            "Rodolphe Recca",
            "Yoshiaki Hirabayashi dan Tsuyoshi Kanda",
            "Patrice Désilets"
        )

        val desc: Array<String> = arrayOf(
            "Kami dengan tanpa ragu akan merekomendasikan Death Stranding untuk Anda, terlepas dari apapun preferensi genre Anda atau apakah Anda mencintai produk Kojima atau tidak di masa lalu. Anda mungkin berakhir tidak menikmati semua proses antar-mengantar kargo yang ia usung, apalagi jika Anda datang dengan ekspektasi tertentu, namun sulit untuk menyangkal bahwa game ini akan menawarkan sesuatu yang baru, berbeda, dan unik hingga kami yakin Anda belum pernah bertemu dan mencicipi game seperti ini sebelumnya. - JagatPlay.com",
            "Tom Clancy’s Ghost Recon Breakpoint sekilas memang menjadi salah satu perubahan yang lebih baik dari Wildlands. Bahkan seharusnya inilah yang menjadi Wildlands dibanding harus menjadikannya sekuel. Tampilan visualnya yang indah dan realistis membuatmu betah berlama-lama menjelajahi misteri Auroa dengan segala eksotismenya. Sayang, konsep ceritanya yang menarik harus disampaikan dengan setengah-setengah. Membuat beberapa dari cerita utamanya terkesan naik-turun dan biasa saja. Sebuah potensi yang bisa dibilang kurang dimanfaatkan dengan baik. - gamebrott.com",
            "Sekiro: Shadows Die Twice adalah sebuah game yang memesona dengan kualitas yang di mata kami, cukup untuk membuatnya tampil sebagai kandidat kuat Game of the Year untuk tahun 2019 ini. From Software dan Hidetaka Miyazaki kembali membuktikan kemampuan mereka. Di satu sisi, ada DNA Souls yang kuat lewat tingkat kesulitan tanpa kompromi yang siap untuk menghabisi Anda jika Anda salah langkah. - JagatPlay.com",
            "Setelah penantian 5 tahun lamanya sejak Pre-Sequel, kini akhirnya Borderlands 3 telah  berada dalam genggaman dan mampu penuhi berbagai ekspetasi yang ada. Lebih dari itu ia bahkan menghadirkan beragam hal menarik yang membuat franchise ini terasa tetap segar. Mulai dari peningkatan gameplay yang lebih fluid, map yang lebih masif lengkap dengan beragam planet baru penuh pesona uniknya, hingga sistem co-op yang terasa lebih menyenangkan, kesemuanya berhasil tampil dengan begitu solid. - gamebrott.com/",
            "Kami dengan tidak ragu menyebutnya sebagai seri fantastis yang membuat proses menunggu belasan tahun terbayar manis. Seolah ingin membuktikan bahwa mereka kini kembali di bentuk terbaiknya, Capcom tahu betul apa yang diinginkan oleh fans untuk Devil May Cry 5 dan memastikan setiap elemen tersebut dipenuhi. Kita berbicara soal aksi gameplay yang masih penuh gaya, sensasi action yang intens, musik super keren, dan visualisasi berbasis RE Engine yang memesona. Semuanya dibalut dengan kesempatan untuk menikmati dan menguasainya di tingkat kesulitan lebih tinggi, mendapatkan reward sepadan, sembari menikmati cut-scene super keren yang siap memanjakan mata. Jangan lupa soal kehadiran Nico dan bagaimana karakter ini berujung tak sekedar menjual sensualitas. - jagatplay.com",
            "Kehadiran engine baru yang diklaim oleh Infinity Ward dan Activision memang membuat Call of Duty: Modern Warfare Reboot ini hadir dengan kualitas visualisasi yang memesona, dari sekedar efek cahaya hingga detail api dari molotov yang baru saja Anda lempar. Yang menarik adalah pendekatan baru dari sisi penyajian cerita yang kini tidak lagi sepenuhnya diambil dari kacamata orang pertama seperti halnya seri-seri Call of Duty Modern Warfare lawas. - JagatPlay.com",
            "With only a select few events, no discernible difference between each car's handling, and a simplistic driving model, Need for Speed Heat does stumble into repetition during its final few hours. It's not quite a rip-roaring return to form, then, but this latest entry puts the Need for Speed series back on the right track. The duality of its day and night events props up what would otherwise be a fairly run-of-the-mill racing game, but the renewed focus on hurtling around the track, racing wheel-to-wheel, and customizing each car in numerous ways, taps into the essence of what Need for Speed used to be about. Need for Speed Heat may not revolutionize racing games, but it's the best the series has been in a long, long time. - gamespot.com",
            "Far Cry New Dawn berujung jadi game post-apocalyptic yang menarik dengan cita rasa Far Cry yang tetap kuat, terlepas dari beragam hal baru yang mereka suntikkan seperti elemen RPG ringan dan ekstra misi membangun kembali Prosperity yang berujung jadi motivasi yang cukup kuat untuk mengeksplorasi Hope County “baru” yang indah. Pendekatan konsekuensi perang nuklir yang berada dalam batas rasional alih-alih seperti game kebanyakan yang biasanya mendorong temanya lebih ke arah sci-fi juga jadi sesuatu yang kami sambut dengan terbuka. - Jagatplay.com",
            "Resident Evil 2 Remake adalah sebuah buah cinta Capcom yang dieksekusi dengan matang dan penuh kehati-hatian. Seperti sebuah representasi dari rasa peduli dan pemahaman yang kuat soal alasan mengapa seri ini begitu melekat di hati para fans sekaligus mengerti potensinya untuk menarik gamer pendatang baru. Resident Evil 2 Remake adalah salah satu seri Resident Evil terbaik yang bisa Anda dapatkan di pasaran saat ini. - jagatplay.com",
            "Untuk ukuran game yang berhasil membawakan pengalaman baru, Ancestors: The Humankind Odyssey bisa jadi game yang wajib kalian coba. Sayangnya, kalau kalian mengharapkan aksi pukul-pukulan (atau saling buru) sesama binatang, siap-siap kecewa karena cuma kalian yang akan dimakan. - kincir.com"
        )

        val os: Array<String> = arrayOf(
            "Windows 7 64-bit",
            "Windows 7 64-bit",
            "Windows 7 64-bit",
            "Windows 7 64-bit (latest service pack)",
            "Windows 7 64-bit",
            "Windows 10 64 Bit (latest Service Pack)",
            "Windows 10 64 Bit",
            "Windows 7 SP1, Windows 8.1, Windows 10 (64bit versions only)",
            "Windows 7 64-bit",
            "Windows 10 64 Bit"
        )

        val processor: Array<String> = arrayOf(
            "Intel Core i7-6700K 4-Core 4.0GHz or AMD Ryzen R5 1600",
            "AMD Ryzen 5 1600 or Intel Core I7 6700K",
            "Intel Core i5-2500K or AMD Ryzen 5 1400",
            "AMD Ryzen™ 5 2600 or Intel i7-4770",
            "Intel® Core™ i7-3770, AMD FX™-9590, or better",
            "Intel Core i7 4770k or AMD equivalent",
            "(AMD): Ryzen 3 1300X or (Intel): Core i7-4790",
            "ntel Core i7-4790 @ 3.6 GHz or AMD Ryzen 5 1600 @ 3.2 GHz",
            "Intel® Core™ i7-3770 or AMD FX™-9590 or better",
            "ntel Core i7-4770K 4-Core 3.5GHz / AMD Ryzen R5 1600"
        )

        val vga: Array<String> = arrayOf(
            "AMD Radeon RX Vega 56 8GB or NVIDIA GeForce GTX 1070",
            "AMD Radeon RX 480 or Nvidia Geforce GTX 1060 (6 GB)",
            "NVIDIA GeForce GTX 970 or AMD Radeon RX 570",
            "AMD Radeon™ RX 590 or NVIDIA GeForce GTX 1060 6GB",
            "NVIDIA® GeForce® GTX 1060 with 6GB VRAM, AMD Radeon™ RX 480 with 8GB VRAM, or bette",
            "Nvidia GeForce GTX 970 4GB / GTX 1660 6GB or AMD Radeon R9 390 / AMD RX 580",
            "(AMD): Radeon RX 480 or GeForce GTX 1060",
            "NVIDIA GeForce GTX 970 (4GB) or AMD Radeon R9 290X (4GB)",
            "NVIDIA® GeForce® GTX 1060 or AMD Radeon™ RX 480 with 3GB VRAM",
            "AMD Radeon RX 480 8GB or NVIDIA GeForce GTX 980 4GB"
        )

        val ram: Array<String> = arrayOf(
            "16 GB RAM",
            "8 GB RAM",
            "8 GB RAM",
            "16 GB RAM",
            "8 GB RAM",
            "12 GB RAM",
            "16 GB RAM",
            "8 GB RAM",
            "8 GB RAM",
            "8 GB RAM"
        )

        val storage: Array<String> = arrayOf(
            "50 GB Hard drive space",
            "41.38 GB Hard drive space",
            "25 GB Hard drive space",
            "75 GB Hard drive space",
            "35 GB Hard drive space",
            "175 GB Hard drive space",
            "50 GB Hard drive space",
            "35 GB Hard drive space",
            "26 GB Hard drive space",
            "41.38 GB Hard drive space"
        )

        val imgs: IntArray = intArrayOf(
            R.drawable.deathstranding,
            R.drawable.ghostreconbreakpoin,
            R.drawable.sekiroshadowsdietwiceart,
            R.drawable.borderlands3,
            R.drawable.dmc5,
            R.drawable.cod,
            R.drawable.nfsheat,
            R.drawable.farcrynewdawn,
            R.drawable.residenevil2,
            R.drawable.ancester
        )

        for (idx in names.indices){
            val  game = Game()
            game.id = idx
            game.name = names[idx]
            game.author = authors[idx]
            game.genre = genres[idx]
            game.desc = desc[idx]
            game.os = os[idx]
            game.processor = processor[idx]
            game.vga = vga[idx]
            game.ram = ram[idx]
            game.storage = storage[idx]
            game.img = imgs[idx]
            gameList.add(game)
        }

        games.value = gameList
    }

    fun addGame(game: Game) {
        gameList.add(game)
        games.value = gameList
    }

    fun getGames() = games as LiveData<List<Game>>
}