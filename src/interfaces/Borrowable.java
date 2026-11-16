package interfaces;

/**
 * Interface Borrowable mendefinisikan kontrak untuk item yang dapat dipinjam.
 * Interface ini mencakup metode untuk mendapatkan periode peminjaman dan denda keterlambatan per hari.
 */
public interface Borrowable {
    
    /**
     * Mendapatkan jumlah hari peminjaman untuk item.
     * @return jumlah hari peminjaman
     */
    int getLoanDays();
    
    /**
     * Mendapatkan denda keterlambatan per hari untuk item.
     * @return denda keterlambatan per hari
     */
    int getLateFeePerDay();

    /**
     * Menghitung denda keterlambatan berdasarkan jumlah hari keterlambatan.
     * @param daysLate jumlah hari keterlambatan
     * @return total denda keterlambatan
     */
    default int calculateLateFee(int daysLate) {
        return Math.max(daysLate, 0) * getLateFeePerDay();
    }
}