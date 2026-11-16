/**
 * Textbook.java
 * Kelas yang merepresentasikan sebuah buku ajar dalam sistem peminjaman buku.
 * 
 * bookId: ID unik untuk buku
 * title: Judul buku
 * stock: Jumlah stok buku yang tersedia
 * subject: Bidang studi buku ajar
 */
public class Textbook extends Book implements interfaces.Borrowable, interfaces.Renewable {
    /**
     * Bidang studi buku ajar.
     */
    private final String subject;

    /**
     * Konstruktor untuk membuat buku ajar baru.
     *
     * @param bookId  ID unik untuk buku
     * @param title   Judul buku
     * @param stock   Jumlah stok buku yang tersedia
     * @param subject Bidang studi buku ajar
     */
    public Textbook(String bookId, String title, int stock, String subject) {
        super(bookId, title, stock);
        this.subject = subject;
    }

    /**
     * Mendapatkan bidang studi buku ajar.
     *
     * @return Bidang studi buku ajar
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Mendapatkan kategori buku.
     *
     * @return Kategori buku
     */
    @Override
    public String getCategory() {
        return "Buku Ajar";
    }

    /**
     * Mendapatkan jumlah hari peminjaman untuk buku ajar.
     *
     * @return Jumlah hari peminjaman
     */
    @Override
    public int getLoanDays() {
        return 14;
    }

    /**
     * Mendapatkan denda keterlambatan per hari untuk buku ajar.
     *
     * @return Denda keterlambatan per hari
     */
    @Override
    public int getLateFeePerDay() {
        return 2000;
    }

    /**
     * Mengembalikan representasi string dari buku ajar.
     *
     * @return Representasi string dari buku ajar
     */
    @Override
    public int getMaxRenewals() {
        return 1;
    }

    /**
     * Mendapatkan jumlah hari yang dapat diperpanjang untuk buku ajar.
     *
     * @return Periode perpanjangan dalam hari
     */
    @Override 
    public int getRenewalDays() {
        return 7;
    }

    /**
     * Memeriksa apakah buku ajar sesuai dengan kata kunci yang diberikan.
     *
     * @param keyword Kata kunci untuk pencarian
     * @return true jika buku ajar sesuai dengan kata kunci, false sebaliknya
     */
    @Override
    public boolean matches(String keyword) {
        return super.matches(keyword) || subject.toLowerCase().contains(keyword.toLowerCase());
    }

    /**
     * Mengembalikan representasi string dari buku ajar.
     *
     * @return Representasi string dari buku ajar
     */
    @Override
    public String toString() {
        return super.toString() + " - Bidang: " + subject;
    }
}
