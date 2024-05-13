# Design Pattern

<details>
  <summary>Strategy Pattern</summary>

  Pada proyek ini, saya menerapkan _strategy pattern_. Saya menerapkan _pattern_ tersebut karena saya merasa _pattern_ tersebut cocok untuk kebutuhan saya pada proyek ini. Saya membutuhkan sebuah _pattern_ yang dapat mengakomodasi kebutuhan untuk membagi algoritma suatu task ke dalam beberapa tipe sesuai kebutuhannya. Dalam proyek ini, saya mengerjakan bagian kupon. Kupon memiliki kebutuhan algoritma penggunaan (pemotongan terhadap harga) yang bermacam-macam sesuai jenis kuponnya. Sebagai contoh, terdapat kupon yang menerapkan diskon dalam bentuk persentase, ada juga yang menerapkannya dalma bentuk potongan harga. Oleh karena itu, penggunaan _pattern_ ini akan mempermudah pembagian algoritmanya. Hal ini dapat dilakukan dengan sesederhana memilih class algoritma yang mengimplementasikan abstraksi algoritmanya. Ketika perlu menambah jenis algoritma pun, saya hanya perlu menambahkan kelas baru ke dalam program.

  Referensi: https://refactoring.guru/design-patterns/strategy
  
</details>

