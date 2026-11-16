# Sistem Transaksi Perpustakaan (Java OOP)

Aplikasi simulasi transaksi perpustakaan berbasis konsol (CLI) yang dibangun menggunakan Java SE untuk mendemonstrasikan penerapan lengkap pilar **Pemrograman Berorientasi Objek (PBO)**: **Encapsulation**, **Inheritance**, **Abstract Class**, **Polymorphism**, dan **Interface**.

---

## Fitur & Aturan Bisnis

* **Manajemen Koleksi Buku (`Book`):**
  * **Novel (`Novel`):** Masa pinjam **7 hari**, denda keterlambatan **Rp1.000/hari**, tidak dapat diperpanjang.
  * **Buku Ajar (`Textbook`):** Masa pinjam **14 hari**, denda keterlambatan **Rp2.000/hari**, dapat diperpanjang maksimal **1 kali** (+7 hari).
  * **Majalah (`Magazine`):** Koleksi baca di tempat (*non-borrowable*), ditolak otomatis saat transaksi peminjaman.
* **Manajemen Keanggotaan (`Member`):**
  * **Anggota Umum (`Member`):** Batas maksimal peminjaman **2 buku**.
  * **Mahasiswa (`Student`):** Batas maksimal peminjaman **3 buku** (menyimpan atribut `nrp`).
  * **Dosen (`Lecturer`):** Batas maksimal peminjaman **5 buku** (menyimpan atribut `nidn`).
* **Validasi Transaksi & Riwayat (`Transaction` & `History`):**
  * Pencegahan stok negatif, pengecekan batas kuota anggota, validasi kapabilitas peminjaman, pencegahan pengembalian ganda, serta pencatatan seluruh riwayat transaksi (berhasil maupun ditolak).
* **Pencarian Katalog Terpadu (`Searchable`):**
  * Pencarian lintas hierarki kelas (`Book` dan `Member`) berdasarkan kata kunci seperti judul, kategori, penulis, bidang studi, nama, ID, maupun jenis anggota.

---

## Arsitektur & Penerapan Konsep OOP

### 1. Interface (Kontrak Perilaku)
Sistem memisahkan kapabilitas perilaku (*can-do*) dari hierarki pewarisan kelas (*is-a*) melalui tiga interface utama:
* **`Borrowable`**: Mendefinisikan kontrak `getLoanDays()`, `getLateFeePerDay()`, serta `default` method `calculateLateFee(int daysLate)`. Diimplementasikan oleh `Novel` dan `Textbook`.
* **`Renewable`**: Mendefinisikan kontrak `getMaxRenewals()` dan `getRenewalDays()`. Diimplementasikan oleh `Textbook` (*multiple interface implementation* bersama `Borrowable`).
* **`Searchable`**: Mendefinisikan kontrak `matches(String keyword)`. Diimplementasikan oleh `Book` dan `Member` untuk mendukung polimorfisme lintas hierarki.

### 2. Matriks Relasi Class & Interface

| Entitas | Jenis | Superclass | Interface | Keterangan |
| :--- | :--- | :--- | :--- | :--- |
| `Borrowable` | `interface` | - | - | Kontrak peminjaman & denda |
| `Renewable` | `interface` | - | - | Kontrak perpanjangan masa pinjam |
| `Searchable` | `interface` | - | - | Kontrak pencarian katalog |
| `Book` | `abstract class` | `Object` | `Searchable` | Induk seluruh koleksi buku |
| `Novel` | `class` | `Book` | `Borrowable` | Koleksi novel (`author`) |
| `Textbook` | `class` | `Book` | `Borrowable`, `Renewable` | Koleksi buku ajar (`subject`) |
| `Magazine` | `class` | `Book` | - | Koleksi majalah baca di tempat (`issue`) |
| `Member` | `class` | `Object` | `Searchable` | Anggota umum & induk anggota |
| `Student` | `class` | `Member` | - *(warisan)* | Anggota mahasiswa (`nrp`) |
| `Lecturer` | `class` | `Member` | - *(warisan)* | Anggota dosen (`nidn`) |
| `Transaction` | `class` | `Object` | - | Pemrosesan pinjam, perpanjang, & kembali |
| `History` | `class` | `Object` | - | Log riwayat transaksi |
| `Main` | `class` | `Object` | - | Kelas utama simulasi & pengujian |

---

## Struktur Direktori

```text
library-java/
├── src/
│   ├── Borrowable.java
│   ├── Renewable.java
│   ├── Searchable.java
│   ├── Book.java
│   ├── Novel.java
│   ├── Textbook.java
│   ├── Magazine.java
│   ├── Member.java
│   ├── Student.java
│   ├── Lecturer.java
│   ├── Transaction.java
│   ├── History.java
│   └── Main.java
└── README.md
```

---

## Cara Menjalankan Program

### Prasyarat
* **Java Development Kit (JDK) 17 atau lebih baru** (menggunakan fitur *Pattern Matching for `instanceof`*).

### Kompilasi & Eksekusi via Terminal
1. Clone repositori ini:
   ```bash
   git clone [https://github.com/mcDJIL/library-java.git](https://github.com/mcDJIL/library-java.git)
   cd library-java
   ```
2. Kompilasi seluruh file `.java` ke dalam folder `out`:
   ```bash
   javac -d out src/*.java
   ```
3. Jalankan kelas utama `Main`:
   ```bash
   java -cp out Main
   ```

---

## Skenario Pengujian pada `Main.java`

1. **Inspeksi Data Awal & Polimorfisme `Borrowable`:** Menampilkan detail setiap buku menggunakan pengecekan `b instanceof Borrowable` dan perhitungan simulasi denda 3 hari.
2. **Simulasi Peminjaman (`2 November 2026`):** Menguji peminjaman sukses, penolakan stok habis (`T002`), penolakan koleksi non-`Borrowable` pada majalah (`T003`), serta batas kuota masing-masing tipe anggota (`T006`, `T009`, `T010`).
3. **Demo Perpanjangan (`Renewable`):** Menguji penolakan perpanjangan pada `Novel` (`T001`), keberhasilan perpanjangan +7 hari pada `Textbook` (`T004` bergeser ke `23/11/2026`), dan penolakan perpanjangan kedua karena melebihi batas maksimal 1x.
4. **Simulasi Pengembalian & Denda:** Menguji pengembalian terlambat, pengembalian pasca-perpanjangan (`T004` terlambat 2 hari dengan denda Rp4.000), pengembalian tepat waktu, serta validasi pengembalian ganda.
5. **Demo Pencarian (`Searchable`):** Menggabungkan `List<Book>` dan `List<Member>` ke dalam `List<Searchable>` dan mencari kata kunci `"Informatika"`, `"Andrea"`, `"Lulu"`, dan `"Mahasiswa"`.

---

## Dokumentasi & Tautan

* **Dokumentasi Javadoc:** [javadoc-inheritance.vercel.app](https://javadoc-inheritance.vercel.app/)
* **Repositori GitHub:** [github.com/mcDJIL/library-java](https://github.com/mcDJIL/library-java)

---

## Tim Penyusun — Kelompok 2

**D4 Teknik Informatika C — Politeknik Elektronika Negeri Surabaya (PENS)**  
Dosen Pembimbing: **Yuliana Setiowati, S.Kom, M.Kom**

* **Moch Djauharil Ilmi** — `3125600063`
* **Lulu'atul Mahfudoh** — `3125600075`
* **Erlandio Bahy Atmajaya** — `3125600085`