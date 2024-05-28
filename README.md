# Design Pattern

<details>
  <summary>Strategy Pattern</summary>

  Pada proyek ini, saya menerapkan _strategy pattern_. Saya menerapkan _pattern_ tersebut karena saya merasa _pattern_ tersebut sesuai untuk kebutuhan saya pada proyek ini. Saya membutuhkan sebuah _pattern_ yang dapat mengakomodasi kebutuhan untuk membagi algoritma suatu task ke dalam beberapa tipe sesuai kebutuhannya. Dalam proyek ini, saya mengerjakan bagian kupon. Kupon memiliki kebutuhan algoritma penggunaan (pemotongan terhadap harga) yang bermacam-macam sesuai jenis kuponnya. Sebagai contoh, terdapat kupon yang menerapkan diskon dalam bentuk persentase, ada juga yang menerapkannya dalma bentuk potongan harga. Oleh karena itu, penggunaan _pattern_ ini akan mempermudah pembagian algoritmanya. Hal ini dapat dilakukan dengan sesederhana memilih class algoritma yang mengimplementasikan abstraksi algoritmanya. Ketika perlu menambah jenis algoritma pun, saya hanya perlu menambahkan kelas baru ke dalam program.

  Referensi: https://refactoring.guru/design-patterns/strategy
  
</details>

# Software Architecture

<details>
  <summary>Microservices</summary>

  _software architecture_ adalah perencanaan struktur, konsep, interaksi, serta berbagai hal lain yang berhubungan dalam pengembangan _software_. Dalam pemilihan jenis arsitekturnya, terdapat banyak aspek yang harus diperhatikan. Aspek-aspek tersebut dapat berupa aspek yang bersifat teknis maupun non-teknis. Contoh aspek yang bersifat teknis adalah fungsionalitas program, kompleksitas aplikasi, skalabilitas, dan keamanan. Di sisi lain, aspek nonteknis di antaranya adalah kemampuan tim dan ketersediaany sumber daya, baik dalam bentuk waktu, anggaran, dan sumber daya lainnya. Dengan demikian, dapat dikatakan bahwa pemilihan arsitektur tersebut sangat bergantung pada kondisi proyek yang dijalankan.
  
  Dalam proyek ini, terdapat setidaknya beberapa aspek yang perlu diperhatikan dalam memilih tipe arsitekturnya. Beberapa aspek tersebut di antaranya adalah sebagai berikut.

  1. Kewajiban tugas untuk menerapkan pemisahan aplikasi menjadi aplikasi-aplikasi yang lebih kecil
  2. Kemampuan tim yang terbatas dan berbeda-beda setiap individunya
  3. Kesibukan antar anggota tim yang berbeda

  Melihat setidaknya tiga hal di atas, dapat diambil kesimpulan bahwa diperlukan aristektur perangkat lunak yang dapat membagi aplikasi menjadi aplikasi-aplikasi yang lebih kecil dan dapat berdiri sendiri. Hal ini diperlukan agar jika salah satu bagian (mungkin karena ada anggota tim yang tidak mampu menyelesaikan bagiannya atau ada faktor lainnya) tidak berjalan, bagian lain masih mampu berjalan sendiri. Selain itu, diperlukan cara agar dalam pembagiannya terdapat seminimal mungkin dependensi antar bagian. Hal ini diperlukan, selain untuk memastikan bagian lain bekerja (jika ada yang tidak), juga untuk memberikan ruang berkembang untuk bagian aplikasi yang sudah mapan terlebih dahulu (misalnya sudah ada anggota yang bagiannya cukup baik, ia dapat mengembangkan bagiannya sendiri). Melihat kebutuhan-kebutuhan di atas, akhirnya dipilihlah **_MICROSERVICES ARCHITECTURE_** sebagai _software architecture_ pada proyek ini. 

  _Microservices architecture_ adalah pendekatan di mana aplikasi dikembangkan sebagai layanan-layanan kecil yang dapat berdiri sendiri. Setiap layanan tersebut, nantinya akan berkomunikasi melalui protokol komunikasi seperti REST API dan gRPC. Hal ini memberikan keuntungan seperti skalabilitas yang dapat diatur secara independe sesuai kebutuhan, pengembangan yang cepat karena tim dapat bekerja secara terpisah, tiap layanan dapat dikembangkan dengan teknologi sesuai kebutuhan, serta toleransi terhadap kegagalan yang lebih baik (jika satu layanan gagal, layanan lain masih bisa berdiri sendiri).

  Dalam menerapkan _Microservices architecture_, kami membagi aplikasi kami ke dalam beberapa bagian sebagai berikut. 
  - Dasboard admin + kelola (Fathan)
  - Keranjang, checkout + riwayat (Ilham)
  - Lihat daftar buku + melihat detail buku (Bimo)
  - Authentication + profile (Fadhil)
  - Landing page + kupon (Zaidan)
    
  Dengan demikian, tiap anggota memiliki pembagian tugas yang seimbang dan dapat dikerjakan secara terpisah. Meskipun demikian, tetap diperlukan komunikasi antar anggota kelompok, misalnya ketika integrasi tiap layanan menjadi sebuat aplikasi yang utuh.
  
</details>

