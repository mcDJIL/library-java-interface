/**
 * Magazine.java
 * Kelas yang merepresentasikan sebuah majalah dalam sistem peminjaman buku.
 * 
 * bookId: ID unik untuk buku
 * title: Judul buku
 * stock: Jumlah stok buku yang tersedia
 * issue: Nomor edisi majalah
 */
public class Magazine extends Book {
    /**
     * Nomor edisi majalah.
     */
    private final String issue;

    /**
     * Konstruktor untuk membuat majalah baru.
     *
     * @param bookId ID unik untuk buku
     * @param title  Judul buku
     * @param stock  Jumlah stok buku yang tersedia
     * @param issue  Nomor edisi majalah
     */
    public Magazine(String bookId, String title, int stock, String issue) {
        super(bookId, title, stock);
        this.issue = issue;
    }

    /**
     * Mendapatkan nomor edisi majalah.
     *
     * @return Nomor edisi majalah
     */
    public String getIssue() {
        return issue;
    }

    /**
     * Mendapatkan kategori buku.
     *
     * @return Kategori buku
     */
    @Override
    public String getCategory() {
        return "Majalah";
    }

    /**
     * Mengembalikan representasi string dari objek Magazine.
     *
     * @return Representasi string dari objek Magazine
     */
    @Override
    public String toString() {
        return super.toString() + " - " + issue;
    }
}
