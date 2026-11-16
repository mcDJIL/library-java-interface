package interfaces;

/**
 * Interface Searchable mendefinisikan kontrak untuk item yang dapat dicari.
 * Interface ini mencakup metode untuk memeriksa apakah item sesuai dengan kata kunci yang diberikan.
 */
public interface Searchable {
    
    /**
     * Memeriksa apakah item sesuai dengan kata kunci yang diberikan.
     * @param keyword kata kunci untuk pencarian
     * @return true jika item sesuai dengan kata kunci, false sebaliknya
     */
    boolean matches(String keyword);
}