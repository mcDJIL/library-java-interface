/**
 * Book.java
 * Kelas yang merepresentasikan sebuah buku dalam sistem peminjaman buku.
 * 
 * bookId: ID unik untuk buku
 * title: Judul buku
 * stock: Jumlah stok buku yang tersedia
 */
public abstract class Book implements interfaces.Searchable {
    /**
     * ID unik untuk buku.
     */
    private String bookId;
    /**
     * Judul buku.
     */
    private String title;
    /**
     * Jumlah stok buku yang tersedia.
     */
    private int stock;

    /**
     * Konstruktor untuk membuat buku baru.
     *
     * @param bookId ID unik untuk buku
     * @param title  Judul buku
     * @param stock  Jumlah stok buku yang tersedia
     */
    public Book(String bookId, String title, int stock) {
        this.bookId = bookId;
        this.title = title;
        this.stock = Math.max(stock, 0);
    }

    /**
     * Mendapatkan ID unik buku.
     *
     * @return ID unik buku
     */
    public String getBookId() {
        return bookId;
    }

    /**
     * Mendapatkan judul buku.
     *
     * @return Judul buku
     */
    public String getTitle() {
        return title;
    }

    /**
     * Mendapatkan jumlah stok buku yang tersedia.
     *
     * @return Jumlah stok buku
     */
    public int getStock() {
        return stock;
    }

    /**
     * Mengurangi stok buku sebanyak 1 jika stok tersedia.
     *
     * @return true jika pengurangan stok berhasil, false jika stok habis
     */
    public boolean decreaseStock() {
        if (getStock() > 0) {
            stock--;
            return true;
        }

        return false;
    }

    /**
     * Menambahkan stok buku sebanyak 1.
     *
     * @return Jumlah stok buku setelah ditambahkan
     */
    public int increaseStock() {
        return ++stock;
    }

    /**
     * Mendapatkan kategori buku. Subclass harus mengimplementasikan metode ini.
     * 
     * @return Kategori buku
     */
    public abstract String getCategory();

    /**
     * Mengecek apakah buku cocok dengan kata kunci yang diberikan.
     *
     * @param keyword Kata kunci untuk pencarian
     * @return true jika buku cocok dengan kata kunci, false jika tidak
     */
    @Override
    public boolean matches(String keyword) {
        String key = keyword.toLowerCase();
        return bookId.toLowerCase().contains(key)
                || title.toLowerCase().contains(key)
                || getCategory().toLowerCase().contains(key);
    }

    /**
     * Mengembalikan representasi string dari objek Book.
     *
     * @return Representasi string dari objek Book
     */
    @Override
    public String toString() {
        return "[" + bookId + "] " + title + " (" + getCategory() + ", stok: " + stock + ")";
    }
}