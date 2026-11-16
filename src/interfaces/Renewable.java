package interfaces;

/**
 * Interface Renewable mendefinisikan kontrak untuk item yang dapat diperpanjang.
 * Ini mencakup metode untuk mendapatkan jumlah maksimum perpanjangan dan jumlah hari perpanjangan.
 */
public interface Renewable {
    
    /**
     * Mendapatkan jumlah maksimum perpanjangan untuk item.
     * @return jumlah maksimum perpanjangan
     */
    int getMaxRenewals();
    
    /**
     * Mendapatkan jumlah hari yang dapat diperpanjang untuk item.
     * @return periode perpanjangan dalam hari
     */
    int getRenewalDays();
}